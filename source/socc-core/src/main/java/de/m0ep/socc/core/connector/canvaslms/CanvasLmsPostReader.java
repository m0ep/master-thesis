/*
 * The MIT License (MIT) Copyright © 2013 Florian Müller
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
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ontoware.rdf2go.model.Syntax;
import org.ontoware.rdf2go.model.node.URI;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

import de.m0ep.canvas.CanvasLmsClient;
import de.m0ep.canvas.Pagination;
import de.m0ep.canvas.exceptions.AuthorizationException;
import de.m0ep.canvas.exceptions.CanvasLmsException;
import de.m0ep.canvas.exceptions.NetworkException;
import de.m0ep.canvas.model.DiscussionTopic;
import de.m0ep.canvas.model.Entry;
import de.m0ep.socc.core.connector.DefaultConnectorIOComponent;
import de.m0ep.socc.core.connector.IConnector.IPostReader;
import de.m0ep.socc.core.exceptions.AuthenticationException;
import de.m0ep.socc.core.exceptions.NotFoundException;
import de.m0ep.socc.core.utils.RdfUtils;
import de.m0ep.socc.core.utils.SoccUtils;

/**
 * @author Florian Müller
 */
public class CanvasLmsPostReader extends
        DefaultConnectorIOComponent<CanvasLmsConnector> implements
        IPostReader<CanvasLmsConnector> {
    private static final Logger LOG = LoggerFactory
            .getLogger(CanvasLmsPostReader.class);

    private final CanvasLmsClient defaultClient;

    /**
     * @param connector
     */
    public CanvasLmsPostReader(final CanvasLmsConnector connector) {
        super(connector);
        this.defaultClient = connector.getClientManager()
                .getDefaultClient();
    }

    @Override
    public boolean isPost(URI uri) {
        return CanvasLmsSiocUtils.isInitialEntryUri(uri, getServiceEndpoint())
                || CanvasLmsSiocUtils.isEntryUri(uri, getServiceEndpoint());
    }

    @Override
    public Post getPost(URI uri) throws NotFoundException,
            AuthenticationException, IOException {
        LOG.info("Read posts from uri='{}'", uri);

        if (Post.hasInstance(getModel(), uri)) {
            return Post.getInstance(getModel(), uri);
        }

        try {
            if (CanvasLmsSiocUtils.isEntryUri(uri, getServiceEndpoint())) {
                return readEntry(uri);
            } else if (CanvasLmsSiocUtils.isInitialEntryUri(uri,
                    getServiceEndpoint())) {
                return readInitialEntry(uri);
            }
        } catch (CanvasLmsException e) {
            if (e instanceof NetworkException) {
                throw new IOException(e);
            } else if (e instanceof AuthorizationException) {
                throw new AuthenticationException(e);
            } else if (e instanceof de.m0ep.canvas.exceptions.NotFoundException) {
                throw new NotFoundException(e);
            }

            throw Throwables.propagate(e);
        }

        throw new NotFoundException("No Canvas LMS post found at uri " + uri);
    }

    @Override
    public boolean hasPosts(URI uri) {
        return CanvasLmsSiocUtils.isDiscussionTopicUri(uri,
                getServiceEndpoint())
                || CanvasLmsSiocUtils.isInitialEntryUri(uri,
                        getServiceEndpoint())
                || CanvasLmsSiocUtils.isEntryUri(uri, getServiceEndpoint());
    }

    @Override
    public List<Post> pollPosts(URI sourceUri, Date since, int limit)
            throws AuthenticationException, IOException {
        LOG.info("Poll posts from sourceUri='{}' since='{}' limit='{}'",
                sourceUri, since, limit);

        try {
            if (CanvasLmsSiocUtils.isDiscussionTopicUri(sourceUri,
                    getServiceEndpoint())
                    || CanvasLmsSiocUtils.isInitialEntryUri(sourceUri,
                            getServiceEndpoint())) {
                return pollPostsFromDiscussionTopic(sourceUri, since, limit);

            } else if (CanvasLmsSiocUtils.isEntryUri(sourceUri,
                    getServiceEndpoint())) {
                return pollPostsFromEntry(sourceUri, since, limit);
            }
        } catch (CanvasLmsException e) {
            if (e instanceof NetworkException) {
                throw new IOException(e);
            } else if (e instanceof AuthorizationException) {
                throw new AuthenticationException(e);
            } else if (e instanceof de.m0ep.canvas.exceptions.NotFoundException) {
                throw new NotFoundException(e);
            }

            throw Throwables.propagate(e);
        }

        throw new IOException(
                "Can't poll posts from uri "
                        + sourceUri
                        + " at service "
                        + getServiceEndpoint());
    }

    /**** Util methods ****/

    private Post readEntry(URI uri) throws
            NotFoundException,
            AuthenticationException,
            IOException, CanvasLmsException {
        if (Post.hasInstance(getModel(), uri)) {
            return Post.getInstance(getModel(), uri);
        }

        Pattern pattern = Pattern.compile(
                getServiceEndpoint()
                        + CanvasLmsSiocUtils.REGEX_ENTRY_URI);
        Matcher matcher = pattern.matcher(uri.toString());

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));
            long entryId = Long.parseLong(matcher.group(3));

            Entry entry = defaultClient.courses()
                    .discussionTopics(courseId)
                    .entries(topicId)
                    .get(entryId)
                    .execute();

            if (null != entry) {
                logEntry(entry);

                Container container = getConnector().getStructureReader()
                        .getContainer(
                                CanvasLmsSiocUtils.createDiscussionTopicUri(
                                        getServiceEndpoint(),
                                        courseId,
                                        topicId));

                Post result = CanvasLmsSiocUtils.createSiocPost(
                        getConnector(),
                        entry,
                        container,
                        null);

                logEntryPost(result);

                return result;
            }
        }

        throw new NotFoundException("Can't read post from uri " + uri);
    }

    private Post readInitialEntry(URI uri) throws
            NotFoundException,
            AuthenticationException,
            IOException {
        if (Post.hasInstance(getModel(), uri)) {
            return Post.getInstance(getModel(), uri);
        }

        Pattern pattern = Pattern.compile(
                getServiceEndpoint()
                        + CanvasLmsSiocUtils.REGEX_INITIAL_ENTRY_URI);
        Matcher matcher = pattern.matcher(uri.toString());

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));

            try {
                DiscussionTopic discussionTopic = defaultClient.courses()
                        .discussionTopics(courseId)
                        .get(topicId)
                        .execute();
                Container container = getConnector().getStructureReader()
                        .getContainer(
                                CanvasLmsSiocUtils.createDiscussionTopicUri(
                                        getServiceEndpoint(),
                                        courseId,
                                        topicId));

                Post result = CanvasLmsSiocUtils.createSiocPost(
                        getConnector(),
                        container,
                        discussionTopic,
                        courseId);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("Convert initial entry to socc post:\n{}",
                            RdfUtils.resourceToString(
                                    result,
                                    Syntax.Turtle));
                } else {
                    LOG.info("Convert entry to socc post:'{}'", result);
                }

                return result;
            } catch (CanvasLmsException e) {
                if (e instanceof NetworkException) {
                    throw new IOException(e);
                } else if (e instanceof AuthorizationException) {
                    throw new AuthenticationException(e);
                } else if (e instanceof de.m0ep.canvas.exceptions.NotFoundException) {
                    throw new NotFoundException(e);
                }

                throw Throwables.propagate(e);
            }
        }

        throw new NotFoundException("Can't read post from uri " + uri);
    }

    private List<Post> pollPostsFromDiscussionTopic(URI sourceUri, Date since,
            int limit)
            throws CanvasLmsException,
            NotFoundException,
            AuthenticationException,
            IOException {
        Pattern pattern = Pattern.compile(
                getServiceEndpoint()
                        + CanvasLmsSiocUtils.REGEX_DISCUSSION_TOPIC_URI);
        Matcher matcher = pattern.matcher(sourceUri.toString());
        List<Post> result = Lists.newArrayList();

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));

            Container container = getConnector().getStructureReader()
                    .getContainer(
                            CanvasLmsSiocUtils.createDiscussionTopicUri(
                                    getServiceEndpoint(),
                                    courseId,
                                    topicId));

            Post initPost = readInitialEntry(
                    CanvasLmsSiocUtils.createInitialEntryUri(
                            getServiceEndpoint(),
                            courseId,
                            topicId));

            Pagination<Entry> pagination = defaultClient.courses()
                    .discussionTopics(courseId)
                    .entries(topicId)
                    .list()
                    .executePagination();

            for (List<Entry> entryPage : pagination) {
                for (Entry entry : entryPage) {
                    addEntryToList(
                            result,
                            since,
                            limit,
                            entry,
                            container,
                            initPost,
                            courseId,
                            topicId);
                }
            }
        }

        return result;
    }

    private List<Post> pollPostsFromEntry(URI sourceUri, Date since, int limit)
            throws
            CanvasLmsException,
            NotFoundException,
            AuthenticationException,
            IOException {
        Pattern pattern = Pattern.compile(
                getServiceEndpoint()
                        + CanvasLmsSiocUtils.REGEX_ENTRY_URI);
        Matcher matcher = pattern.matcher(sourceUri.toString());
        List<Post> result = Lists.newArrayList();

        if (matcher.find()) {
            long courseId = Long.parseLong(matcher.group(1));
            long topicId = Long.parseLong(matcher.group(2));
            long entryId = Long.parseLong(matcher.group(3));

            Container container = getConnector().getStructureReader()
                    .getContainer(
                            CanvasLmsSiocUtils.createDiscussionTopicUri(
                                    getServiceEndpoint(),
                                    courseId,
                                    topicId));

            Post parentPost = readEntry(
                    CanvasLmsSiocUtils.createEntryUri(
                            getServiceEndpoint(),
                            courseId,
                            topicId,
                            entryId));

            Pagination<Entry> pagination = defaultClient.courses()
                    .discussionTopics(courseId)
                    .entries(topicId)
                    .listReplies(entryId)
                    .executePagination();

            for (List<Entry> replyPage : pagination) {
                for (Entry reply : replyPage) {
                    addEntryToList(
                            result,
                            since,
                            Math.max(-1, limit - result.size()),
                            reply,
                            container,
                            parentPost,
                            topicId,
                            topicId);
                }
            }
        }

        return result;
    }

    private void addEntryToList(
            final List<Post> result,
            final Date since,
            final int limit,
            final Entry entry,
            final Container container,
            final Post parentPost,
            final long courseId,
            final long topicId)
            throws CanvasLmsException,
            NotFoundException,
            AuthenticationException,
            IOException {
        logEntry(entry);

        if (0 > limit || limit < result.size()) {
            Date createdDate = entry.getCreatedAt();
            Post post = CanvasLmsSiocUtils.createSiocPost(
                    getConnector(),
                    entry,
                    container,
                    parentPost);

            logEntryPost(post);

            if (SoccUtils.haveReadAccess(
                    getConnector(),
                    post.getCreator(),
                    post.getContainer())) {
                if (null == since || createdDate.after(since)) {
                    result.add(post);
                }
            } else {
                LOG.info(
                        "Have no permission to read posts for this UserAccount='{}'",
                        post.getCreator());
                Post.deleteAllProperties(post.getModel(), post.getResource());
            }

            // read recentReplies
            Entry[] recentReplies = entry.getRecentReplies();
            if (null != recentReplies) {
                for (Entry reply : recentReplies) {
                    addEntryToList(
                            result,
                            since,
                            Math.max(-1, limit - result.size()),
                            reply,
                            container,
                            post,
                            topicId,
                            topicId);
                }
            }

            // read more replies if necessary
            if (entry.hasMoreReplies()) {
                Pagination<Entry> pagination = defaultClient.courses()
                        .discussionTopics(courseId)
                        .entries(topicId)
                        .listReplies(entry.getId())
                        .executePagination();

                for (List<Entry> replyPage : pagination) {
                    for (Entry reply : replyPage) {
                        addEntryToList(
                                result,
                                since,
                                Math.max(-1, limit - result.size()),
                                reply,
                                container,
                                post,
                                topicId,
                                topicId);
                    }
                }
            }
        }
    }

    /**** Logging Methods ****/

    private void logEntry(final Entry entry) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Read new entry from '{}' json:'{}'",
                    getServiceEndpoint(),
                    entry);
        } else {
            LOG.info("Read new entry from '{}' entryID='{}'",
                    getServiceEndpoint(),
                    entry.getId());
        }
    }

    private void logEntryPost(Post post) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Convert entry to SIOC post:\n{}",
                    RdfUtils.resourceToString(
                            post,
                            Syntax.Turtle));
        } else {
            LOG.info("Convert entry to SIOC post:'{}'", post);
        }
    }
}
