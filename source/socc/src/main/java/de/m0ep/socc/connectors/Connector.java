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

package de.m0ep.socc.connectors;

import java.util.Iterator;
import java.util.Properties;

import org.ontoware.rdf2go.model.Model;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Forum;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.Site;
import org.rdfs.sioc.Thread;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.Usergroup;

/**
 * Interface for a connector to a social online community
 * 
 * @author Florian Müller
 * 
 */
public interface Connector {

    /**
     * Called if the connector will be destroyed.
     */
    public void destroy();

    /**
     * Return the id of this Connector
     * 
     * @return Id of Connector
     */
    public String getId();

    /**
     * Return the URL of the connected social online community
     * 
     * @return URL of community site
     */
    public String getURL();

    /**
     * Returns the config of this Connector
     * 
     * @return Config of this Connector
     */
    public Properties getConfig();

    /**
     * Get the {@link Model} used by this Connector
     * 
     * @return Used {@link Model}
     */
    public Model getModel();

    /**
     * Returns {@link Site} object of the connected community
     * 
     * @return
     */
    public Site getSite();

    /**
     * Returns the {@link UserAccount} object of the used user to connect to tge
     * community.
     * 
     * @return {@link UserAccount} object of the used user.
     */
    public UserAccount getUser();

    /**
     * Returns all accessable {@link Forum}s of this community.
     * 
     * @return Iterator of all accessable {@link Forum}s.
     */
    public Iterator<Forum> getForums();

    /**
     * Returns all {@link Thread}s of the given {@link Forum}.
     * 
     * @param forum
     *            {@link Forum} from where the {@link Thread}s should be
     *            retrieved.
     * @return Iterator of all found {@link Thread}s.
     */
    public Iterator<Thread> getThreads(Forum forum);

    /**
     * Returns all {@link Post}s an their Replies (also Posts) inside the given
     * {@link Container}. The container can be a {@link Forum} or {@link Thread}
     * where {@link Connector#hasPosts(Container)} returns true.
     * 
     * @param container
     *            {@link Container} from where the {@link Post}s should be
     *            retrieved.
     * @return Iterator of all found {@link Post}s.
     */
    public Iterator<Post> getPosts(Container container);

    /**
     * Returns all known {@link Usergroup}s of this community.
     * 
     * @return Iterator of all found {@link Usergroup}s.
     */
    public Iterator<Usergroup> getUsergroups();

    /**
     * Returns all known {@link UserAccount}s of this community.
     * 
     * @return Iterator of all found {@link UserAccount}s.
     */
    public Iterator<UserAccount> getUserAccounts();

    /**
     * Tests if {@link Post}s can be published on this {@link Container}
     * 
     * @param container
     *            {@link Container} to test for publishing.
     * 
     * @return Returns true if it's ok to publish {@link Post}s on this
     *         {@link Container}, false otherwise.
     */
    public boolean canPublishOn( Container container );

    /**
     * Tests if it's possible to post a reply on this {@link Post}
     * 
     * @param parent
     *            {@link Post} to test for replying.
     * @return Returns true if it's ok to reply on this {@link Post}.
     */
    public boolean canReplyOn(Post parent);

    /**
     * Test if their are possible {@link Post}s inside this {@link Container}.
     * E.g. a usual Forum has no Post direct inside it, but the threads inside
     * this forum have some posts.
     * 
     * @param container
     *            {@link Container} to test for containing {@link Post}s.
     * @return Returns true if there are possibly {@link Post}s, false
     *         otherwise.
     */
    public boolean hasPosts(Container container);

    /**
     * Publish a {@link Post} to the given {@link Container}.
     * 
     * @param post
     *            {@link Post} object to publish.
     * @param container
     *            {@link Container} where to publish the {@link Post}.
     * @return Returns true if publishing was successful, false otherwise.
     */
    public boolean publishPost(Post post, Container container);

    /**
     * Reply a {@link Post} to the given parent {@link Post}.
     * 
     * @param post
     *            {@link Post} object of the reply.
     * @param parent
     *            {@link Post} where to reply on.
     * @return Returns true if replying was successful, false otherwise.
     */
    public boolean replyPost(Post post, Post parent);
}
