package de.m0ep.socc.core.connector.moodle;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;

import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.Node;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.util.Builder;
import org.rdfs.sioc.Forum;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.Site;
import org.rdfs.sioc.Thread;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Thing;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.xmlns.foaf.Person;

import de.m0ep.moodlews.soap.ForumDiscussionRecord;
import de.m0ep.moodlews.soap.ForumPostRecord;
import de.m0ep.moodlews.soap.ForumRecord;
import de.m0ep.moodlews.soap.UserRecord;
import de.m0ep.socc.core.exceptions.AuthenticationException;
import de.m0ep.socc.core.exceptions.NotFoundException;
import de.m0ep.socc.core.utils.DateUtils;
import de.m0ep.socc.core.utils.SiocUtils;
import de.m0ep.socc.core.utils.StringUtils;
import de.m0ep.socc.core.utils.UserAccountUtils;

public class Moodle2SiocConverter {

	public static Forum createSiocForum( Moodle2Connector connector, ForumRecord forumRecord ) {
		Preconditions.checkNotNull( connector,
		        "Required parameter connector must be specified." );
		Preconditions.checkNotNull( forumRecord,
		        "Required parameter forumRecord must be specified." );

		Model model = connector.getContext().getModel();
		URI serviceEndpoint = connector.getService().getServiceEndpoint().asURI();
		URI uri = createSiocForumUri( serviceEndpoint, forumRecord.getId() );

		Forum result;
		if ( Forum.hasInstance( model, uri ) ) {
			result = Forum.getInstance( model, uri );

			Node intro = Builder.createPlainliteral(
			        Strings.nullToEmpty(
			                forumRecord.getIntro() ) );
			if ( result.hasDescription( intro ) ) {
				result.setDescription( intro );
			}
		} else {
			result = new Forum( model, uri, true );

			result.setId( Integer.toString( forumRecord.getId() ) );
			result.setName(
			        "Course (id="
			                + forumRecord.getCourse()
			                + ")/"
			                + forumRecord.getName() );
			result.setDescription( forumRecord.getIntro() );
			result.setNumThreads( 0 );
			result.setNumItems( 0 );

			// update relationships
			Site site = connector.getStructureReader().getSite();
			result.setHost( site );
			site.addHostOf( result );
		}

		return result;
	}

	public static Thread createSiocThread( Moodle2Connector connector,
	        ForumDiscussionRecord discussionRecord, Forum parentForum ) {
		Preconditions.checkNotNull( connector,
		        "Required parameter connector must be specified." );
		Preconditions.checkNotNull( discussionRecord,
		        "Required parameter discussionRecord must be specified." );
		Preconditions.checkNotNull( parentForum,
		        "Required parameter parentForum must be specified." );
		Preconditions.checkArgument( parentForum.hasId(),
		        "The parameter parentForum has no id." );

		Model model = connector.getContext().getModel();
		URI serviceEndpoint = connector.getService().getServiceEndpoint().asURI();
		URI uri = createSiocThreadUri( serviceEndpoint, discussionRecord.getId() );

		Thread result;
		if ( Thread.hasInstance( model, uri ) ) {
			result = Thread.getInstance( model, uri );

			Node name = Builder.createPlainliteral(
			        Strings.nullToEmpty(
			                discussionRecord.getName() ) );
			if ( !result.hasName( name ) ) {
				result.setName( name );
			}
		} else {
			result = new Thread( model, uri,
			        true );
			result.setId( Integer.toString( discussionRecord.getId() ) );
			result.setName( discussionRecord.getName() );
			result.setNumItems( 0 );

			// update relationships
			result.setParent( parentForum );
			parentForum.addParentOf( result );
			SiocUtils.incNumThreads( parentForum );
		}

		return result;
	}

	public static Post createSiocPost( Moodle2Connector connector,
	        ForumPostRecord postRecord, Thread discussion, Post parentPost ) throws IOException,
	        AuthenticationException {
		Preconditions.checkNotNull( connector,
		        "Required parameter connector must be specified." );
		Preconditions.checkNotNull( postRecord,
		        "Required parameter postRecord must be specified." );
		Preconditions.checkNotNull( discussion,
		        "Required parameter discussion must be specified." );

		Model model = connector.getContext().getModel();
		URI serviceEndpoint = connector.getService().getServiceEndpoint().asURI();

		int discussionId;
		try {
			discussionId = Integer.parseInt( discussion.getId() );
		} catch ( NumberFormatException e2 ) {
			throw new IllegalArgumentException( "The parameter discussion has an ivalid id." );
		}

		URI uri = createSiocPostUri( serviceEndpoint, discussionId, postRecord.getId() );

		Post result;
		if ( Post.hasInstance( model, uri ) ) {
			// Update existing post if necessary
			result = Post.getInstance( model, uri );

			// Check if the modified time changes. 
			// if it's true, change the content
			Node modified = Builder.createPlainliteral(
			        DateUtils.formatISO8601(
			                postRecord.getModified() * 1000L ) );
			if ( result.hasModified( modified ) ) {
				result.setModified( modified );
				result.setContent( postRecord.getMessage() );
				result.setTitle( postRecord.getSubject() );
			}
		} else {
			UserAccount creator = null;
			try {
				String accountName = Integer.toString( postRecord.getUserid() );
				creator = UserAccountUtils.findUserAccount( model, accountName, serviceEndpoint );
			} catch ( NotFoundException e ) {
				try {
					creator = createSiocUserAccount( connector, postRecord.getUserid() );
				} catch ( Exception e1 ) {
					Throwables.propagateIfInstanceOf( e1, AuthenticationException.class );
					Throwables.propagateIfInstanceOf( e1, IOException.class );
					Throwables.propagate( e1 );
				}
			}

			result = new Post( model, uri, true );
			result.setId( Integer.toString( postRecord.getId() ) );
			result.setTitle( postRecord.getSubject() );
			result.setCreator( creator );
			result.setNumReplies( 0 );
			result.setContent(
			        StringUtils.stripHTML(
			                Strings.nullToEmpty(
			                        postRecord.getMessage() ) ) );

			Date createdDate = new Date( postRecord.getCreated() * 1000L );
			result.setCreated( DateUtils.formatISO8601( createdDate ) );
			SiocUtils.updateLastItemDate( discussion, createdDate );

			// update relationships
			result.setContainer( discussion );
			discussion.addContainerOf( result );
			SiocUtils.incNumItems( discussion );

			if ( null != parentPost ) {
				result.setReplyOf( parentPost );
				parentPost.addReply( result );
				SiocUtils.updateLastReplyDate( parentPost, createdDate );
				SiocUtils.incNumReplies( parentPost );
			}
		}
		return result;
	}

	public static UserAccount createSiocUserAccount( final Moodle2Connector connector,
	        final int userid )
	        throws AuthenticationException, IOException {
		Preconditions.checkNotNull( connector,
		        "Required parameter connector must be specified." );

		final Moodle2ClientWrapper client = connector.getServiceClientManager().getDefaultClient();
		UserRecord[] userRecords = client.callMethod( new Callable<UserRecord[]>() {
			@Override
			public UserRecord[] call() throws Exception {
				return client.getBindingStub().get_user_byid(
				        client.getAuthClient(), client.getSessionKey(),
				        userid );
			}
		} );

		if ( null != userRecords && 0 < userRecords.length ) {
			UserRecord userRecord = userRecords[0];
			URI serviceEndpoint = connector.getService().getServiceEndpoint().asURI();
			URI uri = createSiocUserUri( serviceEndpoint, userRecord.getId() );

			UserAccount userAccount = new UserAccount( connector.getContext()
			        .getModel(), uri, true );
			userAccount.setId( Integer.toString( userRecord.getId() ) );
			userAccount.setName( userRecord.getName() );
			userAccount.setAccountName( Integer.toString( userRecord.getId() ) );
			userAccount.setAccountServiceHomepage( serviceEndpoint );
			Thing.setService(
			        userAccount.getModel(),
			        userAccount.getResource(),
			        connector.getService() );

			Person person = new Person( connector.getContext().getModel(), true );
			person.setNickname( userRecord.getUsername() );
			person.setName( userRecord.getName() );

			userAccount.setAccountOf( person );
			person.addAccount( userAccount );

			return userAccount;
		}

		throw new IOException( "Failed to read user data" );
	}

	private static URI createSiocForumUri( URI rootUri, int id ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( rootUri + "/mod/forum/view.php?id={forumId}" )
		                .set( "forumId", id )
		                .expand() );
	}

	private static URI createSiocThreadUri( URI rootUri, int id ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( rootUri + "/mod/forum/discuss.php?d={discussionId}" )
		                .set( "discussionId", id )
		                .expand() );
	}

	private static URI createSiocPostUri( URI rootUri, int discussionId, int postId ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( rootUri
		                + "/mod/forum/discuss.php?d={discussionId}#p{postId}" )
		                .set( "discussionId", discussionId )
		                .set( "postId", postId )
		                .expand() );
	}

	private static URI createSiocUserUri( URI rootUri, int id ) {
		return Builder.createURI(
		        UriTemplate.fromTemplate( rootUri + "/user/profile.php?id={userId}" )
		                .set( "userId", id )
		                .expand() );
	}
}
