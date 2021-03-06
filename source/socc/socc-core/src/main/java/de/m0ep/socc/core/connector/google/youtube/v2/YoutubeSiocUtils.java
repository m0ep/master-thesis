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

package de.m0ep.socc.core.connector.google.youtube.v2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.util.Builder;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Forum;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.Site;
import org.rdfs.sioc.Thread;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Service;
import org.rdfs.sioc.services.Thing;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Throwables;
import com.google.gdata.data.Link;
import com.google.gdata.data.Person;
import com.google.gdata.data.TextContent;
import com.google.gdata.data.youtube.CommentEntry;
import com.google.gdata.data.youtube.PlaylistLinkEntry;
import com.google.gdata.data.youtube.PlaylistLinkFeed;
import com.google.gdata.data.youtube.UserProfileEntry;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.google.gdata.data.youtube.YouTubeNamespace;
import com.google.gdata.util.ServiceException;

import de.m0ep.socc.core.exceptions.AuthenticationException;
import de.m0ep.socc.core.exceptions.NotFoundException;
import de.m0ep.socc.core.utils.DateUtils;
import de.m0ep.socc.core.utils.SiocUtils;
import de.m0ep.socc.core.utils.StringUtils;

/**
 * Utility methods to convert Youtube resources to SIOC and handle URIs
 * 
 * @author Florian Müller
 * 
 */
public class YoutubeSiocUtils {
	public static final String YOUTUBE_GDATA_API_ROOT_URI = "http://gdata.youtube.com/feeds/api";

	public static final String REGEX_STRING_ID_GROUP = "([^/\\s?]+)";

	public static final String REGEX_USER_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/users/"
	        + REGEX_STRING_ID_GROUP;

	public static final String REGEX_PLAYLIST_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/playlists/"
	        + REGEX_STRING_ID_GROUP;

	public static final String REGEX_VIDEO_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/videos/"
	        + REGEX_STRING_ID_GROUP;

	public static final String REGEX_COMMENT_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/videos/"
	        + REGEX_STRING_ID_GROUP
	        + "/comments/"
	        + REGEX_STRING_ID_GROUP;

	public static final String REGEX_USER_UPLOADS_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/users/"
	        + REGEX_STRING_ID_GROUP
	        + "/uploads";

	public static final String REGEX_USER_PLAYLISTS_URI = "^"
	        + YOUTUBE_GDATA_API_ROOT_URI
	        + "/users/"
	        + REGEX_STRING_ID_GROUP
	        + "/playlists";

	public static final String TEMPLATE_VAR_USER_ID = "userId";

	public static final String TEMPLATE_VAR_PLAYLIST_ID = "playlistId";

	public static final String TEMPLATE_VAR_VIDEO_ID = "videoId";

	public static final String TEMPLATE_VAR_COMMENT_ID = "commentId";

	/*
	 * http://gdata.youtube.com/feeds/api/users/{userId}
	 */
	public static final String TEMPLATE_USER_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/users/{"
	                + TEMPLATE_VAR_USER_ID
	                + "}";
	/*
	 * http://gdata.youtube.com/feeds/api/playlists/{playlistId}
	 */
	public static final String TEMPLATE_PLAYLIST_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/playlists/{"
	                + TEMPLATE_VAR_PLAYLIST_ID
	                + "}";

	/*
	 * http://gdata.youtube.com/feeds/api/videos/{videoId}
	 */
	public static final String TEMPLATE_VIDEO_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/videos/{"
	                + TEMPLATE_VAR_VIDEO_ID
	                + "}";
	/*
	 * http://gdata.youtube.com/feeds/api/videos/{videoId}/comments/{commentId}
	 */
	public static final String TEMPLATE_COMMENT_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/videos/{"
	                + TEMPLATE_VAR_VIDEO_ID
	                + "}/comments/{"
	                + TEMPLATE_VAR_COMMENT_ID
	                + "}";
	/*
	 * http://gdata.youtube.com/feeds/api/users/{userId}/uploads
	 */
	public static final String TEMPLATE_USER_UPLOADS_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/users/{"
	                + TEMPLATE_VAR_USER_ID
	                + "}/uploads";

	/*
	 * http://gdata.youtube.com/feeds/api/users/{userId}/playlists
	 */
	public static final String TEMPLATE_USER_PLAYLISTS_URI =
	        YOUTUBE_GDATA_API_ROOT_URI
	                + "/users/{"
	                + TEMPLATE_VAR_USER_ID
	                + "}/playlists";

	private YoutubeSiocUtils() {
	}

	/**
	 * Create {@link UserAccount} from an author {@link Person}
	 * 
	 * @param connector
	 *            Used Connector
	 * @param author
	 *            Author {@link Person}
	 * @return An {@link UserAccount} from the converted authors {@link Person}.
	 * 
	 * @throws NotFoundException
	 *             Thrown if no resource was found at the URI
	 * @throws AuthenticationException
	 *             Thrown if there is a problem with authentication.
	 * @throws IOException
	 *             Thrown if there ist problem in communication.
	 */
	public static UserAccount createSiocUserAccount(
	        final YoutubeConnector connector,
	        final Person author )
	        throws NotFoundException,
	        AuthenticationException,
	        IOException {
		Model model = connector.getContext().getModel();

		URI uri = Builder.createURI( author.getUri() );
		if ( !UserAccount.hasInstance( model, uri ) ) {
			YoutubeClientWrapper client = connector.getClientManager()
			        .getDefaultClient();
			UserProfileEntry profileEntry = null;
			try {
				// load full profile
				connector.waitForCooldown();
				profileEntry = client.getYoutubeService().getEntry(
				        new URL( author.getUri() ),
				        UserProfileEntry.class );
			} catch ( MalformedURLException e ) {
				// shouldn't happened
				Throwables.propagate( e );
			} catch ( ServiceException e ) {
				YoutubeConnector.handleYoutubeExceptions( e );
			}
			Service service = connector.getService();

			UserAccount result = new UserAccount( model, uri, true );
			result.setId( profileEntry.getUsername() );
			result.setName( profileEntry.getTitle().toString() );
			result.setAccountName( profileEntry.getUsername() );
			result.setAccountServiceHomepage( service.getServiceEndpoint() );

			Thing.setService( result.getModel(), result.asResource(), service );
			service.addServiceOf( result );

			return result;
		}

		return UserAccount.getInstance( model, uri );
	}

	/**
	 * Creates an {@link Forum} of an {@link PlaylistLinkFeed}.
	 * 
	 * @param connector
	 *            Used Connector.
	 * @param uri
	 *            URI of the {@link PlaylistLinkFeed}.
	 * @param playlistFeed
	 *            The {@link PlaylistLinkFeed}.
	 * @return An {@link Forum} converted from {@link PlaylistLinkFeed}
	 */
	public static Forum createSiocForum(
	        final YoutubeConnector connector,
	        final URI uri,
	        final PlaylistLinkFeed playlistFeed ) {
		Model model = connector.getContext().getModel();
		Pattern pattern = Pattern
		        .compile( YoutubeSiocUtils.REGEX_USER_PLAYLISTS_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		matcher.find();

		Forum result = new Forum( model, uri, true );
		result.setId( matcher.group( 1 ) + "/playlists" );
		result.setName( playlistFeed.getTitle().getPlainText() );

		Site site = connector.getStructureReader().getSite();
		result.setHost( site );
		site.addHostOf( result );
		return result;
	}

	/**
	 * Creates an {@link Forum} of an {@link VideoFeed}.
	 * 
	 * @param connector
	 *            Used Connector.
	 * @param uri
	 *            URI of the {@link VideoFeed}.
	 * @param videoFeed
	 *            The {@link VideoFeed}.
	 * @return An {@link Forum} converted from {@link VideoFeed}
	 */
	public static Forum createSiocForum(
	        final YoutubeConnector connector,
	        final URI uri,
	        final VideoFeed videoFeed ) {
		Model model = connector.getContext().getModel();

		Pattern pattern = Pattern
		        .compile( YoutubeSiocUtils.REGEX_USER_UPLOADS_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		matcher.find();

		Forum result = new Forum( model, uri, true );
		result.setId( matcher.group( 1 ) + "/uploads" );
		result.setName( videoFeed.getTitle().getPlainText() );

		Site site = connector.getStructureReader().getSite();
		result.setHost( site );
		site.addHostOf( result );

		return result;
	}

	/**
	 * Creates an {@link Thread} from a {@link PlaylistLinkEntry} of a parent
	 * {@link PlaylistLinkFeed} {@link Forum}.
	 * 
	 * @param connector
	 *            Used Connector.
	 * @param playlistEntry
	 *            The {@link PlaylistLinkEntry}.
	 * @param parent
	 *            The parent {@link PlaylistLinkFeed} {@link Forum}.
	 * @return A {@link Thread} converted from a {@link PlaylistLinkEntry}.
	 */
	public static Thread createSiocThread(
	        final YoutubeConnector connector,
	        final PlaylistLinkEntry playlistEntry,
	        final Forum parent ) {
		Model model = connector.getContext().getModel();
		URI uri = createPlaylistUri( playlistEntry.getPlaylistId() );

		if ( !Thread.hasInstance( model, uri ) ) {
			Thread result = new Thread( model, uri, true );
			result.setId( playlistEntry.getPlaylistId() );

			if ( null != playlistEntry.getTitle() ) {
				result.setName( playlistEntry.getTitle().getPlainText() );
			}

			if ( null != playlistEntry.getSummary() ) {
				result.setDescription( playlistEntry.getSummary().getPlainText() );
			}

			if ( null != playlistEntry.getPublished() ) {
				result.setCreated( DateUtils.formatISO8601( playlistEntry
				        .getPublished().getValue() ) );
			}
			if ( null != playlistEntry.getUpdated() ) {
				result.setModified( DateUtils.formatISO8601( playlistEntry
				        .getUpdated().getValue() ) );
			}

			if ( null != parent ) {
				result.setParent( parent );
				parent.addParentOf( result );
				SiocUtils.incNumThreads( parent );
			}

			return result;
		}

		return Thread.getInstance( model, uri );
	}

	/**
	 * Creates a {@link Post} from a {@link VideoEntry}.
	 * 
	 * @param connector
	 *            Used Connector.
	 * @param videoEntry
	 *            {@link VideoEntry} to convert.
	 * @param container
	 *            The parent {@link Container} of the {@link VideoEntry}.
	 * @return A {@link Post} converted from a {@link VideoEntry}.
	 * 
	 * @throws NotFoundException
	 *             Thrown if no resource was found at the URI
	 * @throws AuthenticationException
	 *             Thrown if there is a problem with authentication.
	 * @throws IOException
	 *             Thrown if there ist problem in communication.
	 */
	public static Post createSiocPost(
	        final YoutubeConnector connector,
	        final VideoEntry videoEntry,
	        final Container container )
	        throws NotFoundException,
	        AuthenticationException,
	        IOException {
		Model model = connector.getContext().getModel();
		YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();

		URI uri = createVideoUri( mediaGroup.getVideoId() );

		Post result = new Post( model, uri, true );
		result.setId( mediaGroup.getVideoId() );
		result.setIsPartOf( connector.getStructureReader().getSite() );

		for ( Person author : videoEntry.getAuthors() ) {
			UserAccount creator = createSiocUserAccount( connector, author );
			result.addCreator( creator );
		}

		if ( null != mediaGroup.getTitle() ) {
			result.setTitle( mediaGroup.getTitle().getPlainTextContent() );
		}

		if ( null != videoEntry.getContent()
		        && videoEntry.getContent() instanceof TextContent ) {
			result.setContent(
			        StringUtils.stripHTML(
			                videoEntry.getPlainTextContent() ) );
		} else if ( null != mediaGroup.getDescription() ) {
			result.setContent(
			        StringUtils.stripHTML(
			                mediaGroup.getDescription().getPlainTextContent() ) );
		}

		// get the link to the video on Youtube
		Link videoLink = videoEntry.getLink( "alternate", "text/html" );
		if ( null != videoLink ) {
			result.addAttachment( Builder.createURI( videoLink.getHref() ) );
		}

		Date createdDate = new Date( videoEntry.getPublished().getValue() );
		result.setCreated( DateUtils.formatISO8601( createdDate ) );

		if ( null != videoEntry.getUpdated() ) {
			result.setModified(
			        DateUtils.formatISO8601(
			                videoEntry.getUpdated().getValue() ) );
		}

		if ( null != container ) {
			result.setContainer( container );
			container.addContainerOf( result );
			SiocUtils.incNumItems( container );
			SiocUtils.updateLastItemDate( container, createdDate );
		}

		return result;
	}

	/**
	 * Creates a {@link Post} from a {@link CommentEntry}.
	 * 
	 * @param connector
	 *            Used Connector.
	 * @param commentEntry
	 *            {@link CommentEntry} to convert.
	 * @param parentPost
	 *            The parent {@link Post} of the {@link CommentEntry}.
	 * @return A {@link Post} converted from a {@link CommentEntry}.
	 * 
	 * @throws NotFoundException
	 *             Thrown if no resource was found at the URI
	 * @throws AuthenticationException
	 *             Thrown if there is a problem with authentication.
	 * @throws IOException
	 *             Thrown if there ist problem in communication.
	 */
	public static Post createSiocPost(
	        final YoutubeConnector connector,
	        final CommentEntry commentEntry,
	        final Post parentPost )
	        throws NotFoundException,
	        AuthenticationException,
	        IOException {
		Model model = connector.getContext().getModel();

		Link selfLink = commentEntry.getLink( "self", null );

		Pattern pattern = Pattern.compile( YoutubeSiocUtils.REGEX_COMMENT_URI );
		Matcher matcher = pattern.matcher( selfLink.getHref() );
		matcher.find();

		String commentId = matcher.group( 2 );
		String videoId = matcher.group( 1 );

		URI uri = createCommentUri( videoId, commentId );

		Post result = new Post( model, uri, true );
		result.setId( commentId );
		result.setIsPartOf( connector.getStructureReader().getSite() );

		for ( Person author : commentEntry.getAuthors() ) {
			UserAccount creator = createSiocUserAccount( connector, author );
			result.addCreator( creator );
		}

		if ( null != commentEntry.getTitle() ) {
			result.setTitle( commentEntry.getTitle().getPlainText() );
		}

		if ( null != commentEntry.getPlainTextContent() ) {
			result.setContent( commentEntry.getPlainTextContent() );
		}

		Date createdDate = new Date( commentEntry.getPublished().getValue() );
		result.setCreated( DateUtils.formatISO8601( createdDate ) );

		if ( null != commentEntry.getUpdated() ) {
			result.setModified(
			        DateUtils.formatISO8601(
			                commentEntry.getUpdated().getValue() ) );
		}

		if ( null != parentPost && parentPost.hasContainer() ) {
			Container container = parentPost.getContainer();
			result.setContainer( container );
			container.addContainerOf( result );
			SiocUtils.incNumItems( container );
			SiocUtils.updateLastItemDate( container, createdDate );
		}

		// check for in_reply_to
		Link replyToLink = commentEntry.getLink(
		        YouTubeNamespace.IN_REPLY_TO,
		        "application/atom+xml" );
		if ( null != replyToLink ) { // it's a reply to another comment
			String replyToLinkHref = replyToLink.getHref();

			int qmIndex = replyToLinkHref.indexOf( '?' );

			String replyToId = replyToLinkHref.substring(
			        replyToLinkHref.lastIndexOf( '/' ) + 1,
			        ( -1 != qmIndex ) ? qmIndex : replyToLinkHref.length() );
			URI replyToUri = createCommentUri( videoId, replyToId );

			Post replyToPost = new Post( model, replyToUri, true );
			replyToPost.setId( replyToId );

			result.setReplyOf( replyToPost );
			replyToPost.addReply( result );
			SiocUtils.incNumReplies( result );
			SiocUtils.updateLastReplyDate( result, createdDate );

			if ( result.hasContainer() ) {
				Container container = result.getContainer();
				replyToPost.setContainer( container );
				container.addContainerOf( replyToPost );
				SiocUtils.incNumItems( container );
				SiocUtils.updateLastItemDate( container, createdDate );
			}
		}
		else if ( null != parentPost ) { // it's a reply to a video
			result.setReplyOf( parentPost );
			parentPost.addReply( result );
			SiocUtils.incNumReplies( parentPost );
			SiocUtils.updateLastReplyDate( parentPost, createdDate );
		}

		return result;
	}

	/**
	 * Creates an URI for an users account in Youtube.
	 * 
	 * @param userId
	 *            Id of the users account.
	 * @return URI for that user account
	 */
	public static URI createUserUri( final String userId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_USER_URI )
		                .set( TEMPLATE_VAR_USER_ID, userId )
		                .expand() );
	}

	/**
	 * Creates an URI for an Uploads {@link Forum} of an user.
	 * 
	 * @param userId
	 *            Id of the user
	 * @return URI for that Uploads {@link Forum}
	 */
	public static URI createUserUploadsUri( final String userId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_USER_UPLOADS_URI )
		                .set( TEMPLATE_VAR_USER_ID, userId )
		                .expand() );
	}

	/**
	 * Creates an URI for an Playlists {@link Forum} of an user.
	 * 
	 * @param userId
	 *            Id of the user
	 * @return URI for that Playlists {@link Forum}
	 */
	public static URI createUserPlaylistsUri( final String userId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_USER_PLAYLISTS_URI )
		                .set( TEMPLATE_VAR_USER_ID, userId )
		                .expand() );
	}

	/**
	 * Creates an URI for an playlist {@link Thread}.
	 * 
	 * @param playlistId
	 *            Id of the playlist.
	 * @return URI of that playlist {@link Thread}.
	 */
	public static URI createPlaylistUri( final String playlistId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_PLAYLIST_URI )
		                .set( TEMPLATE_VAR_PLAYLIST_ID, playlistId )
		                .expand() );
	}

	/**
	 * Creates an URI for a Video {@link Post}.
	 * 
	 * @param videoId
	 *            Id of the video.
	 * @return URI for that Video {@link Post}.
	 */
	public static URI createVideoUri( final String videoId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_VIDEO_URI )
		                .set( TEMPLATE_VAR_VIDEO_ID, videoId )
		                .expand() );
	}

	/**
	 * Creates an URI for a video comment {@link Post}.
	 * 
	 * @param videoId
	 *            Id of the video.
	 * @param commentId
	 *            Id of the comment.
	 * @return URI for that video comment {@link Post}.
	 */
	public static URI createCommentUri( final String videoId, final String commentId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( TEMPLATE_COMMENT_URI )
		                .set( TEMPLATE_VAR_VIDEO_ID, videoId )
		                .set( TEMPLATE_VAR_COMMENT_ID, commentId )
		                .expand() );
	}

	/**
	 * Tests if the URI is from an {@link UserAccount}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from an {@link UserAccount},
	 *         <code>false</code> otherwise.
	 */
	public static boolean isUserUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_USER_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches();
	}

	/**
	 * Tests if the URI is from an uploads {@link Forum}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from an {@link Forum},
	 *         <code>false</code> otherwise.
	 */
	public static boolean isUserUploadsUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_USER_UPLOADS_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches();
	}

	/**
	 * Tests if an URI is from from a playlists {@link Forum}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from a playlists {@link Forum},
	 *         <code>false</code> otherwise.
	 */
	public static boolean isUserPlaylistsUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_USER_PLAYLISTS_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches();
	}

	/**
	 * Tests if an URI is from a playlist {@link Thread}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from a playlist {@link Thread},
	 *         <code>false</code> otherwise.
	 */
	public static boolean isPlaylistUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_PLAYLIST_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches();
	}

	/**
	 * Tests if an URI is from an video {@link Post}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from a video {@link Post},
	 *         <code>false</code> otherwise
	 */
	public static boolean isVideoUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_VIDEO_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches() && !isCommentUri( uri );
	}

	/**
	 * Tests if an URI is from an video comment {@link Post}.
	 * 
	 * @param uri
	 *            URI to test.
	 * @return <code>true</code> if the URI is from a video comment {@link Post}
	 *         , <code>false</code> otherwise.
	 */
	public static boolean isCommentUri( final URI uri ) {
		Pattern pattern = Pattern.compile( REGEX_COMMENT_URI );
		Matcher matcher = pattern.matcher( uri.toString() );
		return matcher.matches();
	}
}
