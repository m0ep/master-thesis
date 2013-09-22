/*
 * The MIT License (MIT) Copyright © 2013 "Florian Mueller"
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.m0ep.socc.core.connector.canvaslms;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.Syntax;
import org.ontoware.rdf2go.model.node.Resource;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.util.RDFTool;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.Thing;
import org.rdfs.sioc.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

import de.m0ep.canvas.CanvasLmsClient;
import de.m0ep.canvas.exceptions.AuthorizationException;
import de.m0ep.canvas.exceptions.CanvasLmsException;
import de.m0ep.canvas.exceptions.NetworkException;
import de.m0ep.canvas.model.Entry;
import de.m0ep.socc.core.connector.DefaultConnectorIOComponent;
import de.m0ep.socc.core.connector.IConnector.IPostWriter;
import de.m0ep.socc.core.exceptions.AuthenticationException;
import de.m0ep.socc.core.exceptions.NotFoundException;
import de.m0ep.socc.core.utils.RdfUtils;
import de.m0ep.socc.core.utils.SoccUtils;
import de.m0ep.socc.core.utils.UserAccountUtils;

/**
 * Class to write post to a Canvas LMS instance through a
 * {@link CanvasLmsConnector}.
 * 
 * @author "Florian Mueller"
 */
public class CanvasLmsPostWriter extends
        DefaultConnectorIOComponent<CanvasLmsConnector> implements
        IPostWriter<CanvasLmsConnector> {
    private static final Logger LOG = LoggerFactory
            .getLogger(CanvasLmsPostWriter.class);

    /**
     * Constructor to create a new instance for a {@link CanvasLmsConnector}.
     * 
     * @param connector
     *            Instance of a {@link CanvasLmsConnector}.
     */
    public CanvasLmsPostWriter(final CanvasLmsConnector connector) {
        super(connector);
    }

    @Override
    public void writePost(URI targetUri, String rdfString, Syntax syntax)
            throws NotFoundException,
            AuthenticationException,
            IOException {
        Model tmpModel = RDFTool.stringToModel(rdfString, syntax);

        boolean isDiscussionTopicUri = CanvasLmsSiocUtils.isDiscussionTopicUri(
                targetUri,
                getServiceEndpoint());

        boolean isInitialEntryUri = CanvasLmsSiocUtils.isInitialEntryUri(
                targetUri,
                getServiceEndpoint());

        boolean isEntryUri = CanvasLmsSiocUtils.isEntryUri(
                targetUri,
                getServiceEndpoint());

        Thing targetResource = null;
        if (isDiscussionTopicUri || isInitialEntryUri) {
            targetResource = getConnector().getStructureReader().getContainer(
                    targetUri);
        } else if (isEntryUri) {
            targetResource = getConnector().getPostReader().getPost(targetUri);
        } else {
            throw new IOException(
                    "Failed to write post to target uri "
                            + targetUri
                            + ", it's neither a conainer nor a post od comment");
        }

        ClosableIterator<Resource> postIter = Post.getAllInstances(tmpModel);
        try {
            while (postIter.hasNext()) {
                Resource resource = postIter.next();
                Post post = Post.getInstance(tmpModel, resource);

                // skip all posts that are already forwarded from this site
                if (SoccUtils.hasContentWatermark(
                        getConnector().getStructureReader().getSite(),
                        post.getContent())) {
                    LOG.info("Skip this post, posted already at this site");
                    continue;
                }

                if (post.hasReplyOf()) {
                    Post reply = Post.getInstance(
                            post.getModel(),
                            post.getReplyOf().getResource());
                    Post sibling = SoccUtils.findSibling(
                            getModel(),
                            reply,
                            getConnector().getStructureReader().getSite());

                    if (null != sibling) {
                        LOG.debug("Write {} as reply to {}.", post, sibling);
                        writeReplyToPost(sibling, post);
                        return;
                    }
                }

                if (isDiscussionTopicUri || isInitialEntryUri) {
                    writePostToContainer((Container) targetResource, post);
                } else if (isEntryUri) {
                    writeReplyToPost((Post) targetResource, post);
                }
            }
        } finally {
            postIter.close();
            tmpModel.close();
        }
    }

    /**
     * Write a {@link Post} to a Discussion Topic of a Canvas LMS Course.
     * 
     * @param targetUri
     *            Target URI of the discussion topic
     * @param post
     *            The post to write
     * @throws AuthenticationException
     *             Thrown if there are some issues with authentication to Canvas
     *             LMS.
     * @throws IOException
     *             Thrown if there are errors writing the post.
     */
    private void writePostToContainer(Container targetContainer, Post post)
            throws AuthenticationException,
            IOException {
        Pattern pattern = Pattern.compile(getServiceEndpoint()
                + CanvasLmsSiocUtils.REGEX_DISCUSSION_TOPIC_URI);
        Matcher matcher = pattern.matcher(targetContainer.toString());

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));

            UserAccount creatorAccount = UserAccount.getInstance(
                    getModel(),
                    post.getCreator().getResource());

            if (!SoccUtils.haveWriteAccess(getConnector(), creatorAccount,
                    targetContainer)) {
                LOG.info(
                        "Have no permission to write Post for this UserAccount='{}'",
                        post.getCreator());
                return;
            }

            CanvasLmsClient client = null;
            String content = post.getContent();
            if (null != creatorAccount) {
                try {
                    UserAccount serviceAccount = UserAccountUtils
                            .findUserAccountOfService(
                                    getModel(),
                                    creatorAccount,
                                    getConnector().getService());

                    client = getConnector().getClientManager().get(
                            serviceAccount);
                } catch (Exception e) {
                    LOG.debug(
                            "No client found for UserAccount {}: exception -> {}\n{}",
                            creatorAccount,
                            e.getMessage(),
                            Throwables.getStackTraceAsString(e));
                    client = null;
                }
            }

            if (null == client) {
                LOG.debug("Using default client");
                client = getConnector().getClientManager().getDefaultClient();
                content = SoccUtils.formatUnknownMessage(
                        getConnector(),
                        post);
            }

            if (!SoccUtils.hasAnyContentWatermark(content)) {
                // add watermark for 'already forwarded' check
                content = SoccUtils.addContentWatermark(post.getIsPartOf(),
                        content);
            }

            try {
                Entry resultEntry = client.courses()
                        .discussionTopics(courseId)
                        .entries(topicId)
                        .post(content)
                        .execute();

                Post resultPost = CanvasLmsSiocUtils.createSiocPost(
                        getConnector(),
                        resultEntry,
                        targetContainer,
                        null);

                resultPost.hasSibling(post);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("Writing successful, result post:\n{}",
                            RdfUtils.resourceToString(
                                    resultPost,
                                    Syntax.Turtle));
                } else {
                    LOG.info("Writing successful, result post:\n{}",
                            resultPost);
                }

                return;
            } catch (CanvasLmsException e) {
                if (e instanceof NetworkException) {
                    throw new IOException(e);
                } else if (e instanceof AuthorizationException) {
                    throw new AuthenticationException(e);
                }

                throw Throwables.propagate(e);
            }
        }

        LOG.warn("Failed to write post(s) to uri " + targetContainer);
    }

    /**
     * Write a {@link Post} as a reply to a other entry of a Canvas LMS course
     * discussion topic.
     * 
     * @param targetUri
     *            Target URI of the entry
     * @param post
     *            The post to write
     * @throws AuthenticationException
     *             Thrown if there are some issues with authentication to Canvas
     *             LMS.
     * @throws IOException
     *             Thrown if there are errors writing the post.
     */
    private void writeReplyToPost(Post targetPost, Post post)
            throws AuthenticationException,
            IOException {
        Pattern pattern = Pattern.compile(
                getServiceEndpoint()
                        + CanvasLmsSiocUtils.REGEX_ENTRY_URI);
        Matcher matcher = pattern.matcher(targetPost.toString());

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));
            long entryId = Long.parseLong(matcher.group(3));

            UserAccount creatorAccount = UserAccount.getInstance(
                    getModel(),
                    post.getCreator().getResource());
            CanvasLmsClient client = null;
            String content = post.getContent();
            if (null != creatorAccount) {
                try {
                    UserAccount serviceAccount = UserAccountUtils
                            .findUserAccountOfService(
                                    getModel(),
                                    creatorAccount,
                                    getConnector().getService());

                    client = getConnector().getClientManager().get(
                            serviceAccount);
                } catch (Exception e) {
                    LOG.debug(
                            "No client found for UserAccount {}: exception -> {}\n{}",
                            creatorAccount,
                            e.getMessage(),
                            Throwables.getStackTraceAsString(e));
                    client = null;
                }
            }

            if (null == client) {
                LOG.debug("Using default client");
                client = getConnector().getClientManager().getDefaultClient();
                content = SoccUtils.formatUnknownMessage(
                        getConnector(),
                        post);
            }

            if (!SoccUtils.hasAnyContentWatermark(content)) {
                // add watermark for 'already forwarded' check
                content = SoccUtils.addContentWatermark(post.getIsPartOf(),
                        content);
            }

            try {
                Entry resultEntry = client.courses()
                        .discussionTopics(courseId)
                        .entries(topicId)
                        .postReply(content, entryId)
                        .execute();

                if (!targetPost.hasContainer()) {
                    try {
                        Container container = getConnector()
                                .getStructureReader()
                                .getContainer(
                                        CanvasLmsSiocUtils
                                                .createDiscussionTopicUri(
                                                        getServiceEndpoint(),
                                                        courseId,
                                                        topicId));

                        targetPost.setContainer(container);
                    } catch (Exception e) {
                        LOG.warn(
                                "Failed to get discussion topic course='{}' topic='{}' ",
                                courseId,
                                topicId);
                    }
                }

                Post resultPost = CanvasLmsSiocUtils.createSiocPost(
                        getConnector(),
                        resultEntry,
                        targetPost.getContainer(),
                        targetPost);

                resultPost.hasSibling(post);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("Writing successful, result post:\n{}",
                            RdfUtils.resourceToString(
                                    resultPost,
                                    Syntax.Turtle));
                } else {
                    LOG.info("Writing successful, result post:\n{}",
                            resultPost);
                }
                return;
            } catch (CanvasLmsException e) {
                if (e instanceof NetworkException) {
                    throw new IOException(e);
                } else if (e instanceof AuthorizationException) {
                    throw new AuthenticationException(e);
                }

                throw Throwables.propagate(e);
            }
        }

        LOG.warn("Failed to write post(s) to uri " + targetPost);
    }
}
