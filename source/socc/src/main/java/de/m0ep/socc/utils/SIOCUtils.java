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

package de.m0ep.socc.utils;

import java.text.ParseException;
import java.util.Date;

import org.rdfs.sioc.Container;
import org.rdfs.sioc.Post;

public class SIOCUtils {
    public static void updateLastItemDate(Container container, Post post) {
	if (post.hasCreated()) {
	    if (container.hasLastitemdate()) {
		try {
		    Date postDate = DateUtils.parseISO8601(post.getCreated());
		    Date lastDate = DateUtils.parseISO8601(container
			    .getLastitemdate());

		    // return if this post is older then the last
		    if (!postDate.after(lastDate))
			return;

		} catch (ParseException e) {
		    // ignore this post
		    return;
		}
	    }

	    container.setLastitemdate(post.getCreated());
	}
    }

    public static void updateLastReplyDate(Post parent, Post reply) {
	if (reply.hasCreated()) {
	    if (parent.hasLastreplydate()) {
		try {
		    Date replyDate = DateUtils.parseISO8601(reply.getCreated());
		    Date parentDate = DateUtils.parseISO8601(parent
			    .getLastreplydate());

		    // return if this reply is older then the last
		    if (!replyDate.after(parentDate))
			return;

		} catch (ParseException e) {
		    // ignore this post
		    return;
		}
	    }

	    parent.setLastreplydate(reply.getCreated());
	}
    }
}
