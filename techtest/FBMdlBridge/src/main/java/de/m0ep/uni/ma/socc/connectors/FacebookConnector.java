package de.m0ep.uni.ma.socc.connectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.ontoware.rdf2go.util.RDFTool;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Forum;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.SIOCThing;
import org.rdfs.sioc.Site;
import org.rdfs.sioc.Thread;
import org.rdfs.sioc.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Group;
import com.restfb.types.Link;
import com.restfb.types.Photo;
import com.restfb.types.User;
import com.restfb.types.Video;
import com.restfb.util.StringUtils;

import de.m0ep.uni.ma.socc.DefaultSIOCModel;
import de.m0ep.uni.ma.socc.SIOCModel;

public class FacebookConnector implements Connector {

    private static final Logger log              = LoggerFactory
                                                         .getLogger( FacebookConnector.class );

    public static final String URL              = "http://facebook.com/";
    public static final String ID               = "com.facebook";
    public static final String NAME             = "Facebook";
    public static final String KEY_ACCESS_TOKEN = ID + ".access_token";

    private Properties config;

    private SIOCModel           model;
    private FacebookClient     client;

    private Set<String>        postable;
    private int                post_limit;


    public FacebookConnector() {
        this.postable = new HashSet<String>();
    }

    public String getURL() {
        return URL;
    }

    public String getUserFriendlyName() {
        return NAME;
    }

    public SIOCModel getModel() {
        return model;
    }

    public void init( SIOCModel model, Properties config ) {
        this.model = model;
        this.config = config;
        this.post_limit = Integer
                .parseInt( config.getProperty( "post_limit", "25" ) );



        String token = this.config.getProperty( KEY_ACCESS_TOKEN );

        if( null != token ) {
            client = new DefaultFacebookClient( token );
        } else {
            throw new RuntimeException( "no access token in config" );
        }
    }

    public void destroy() {
        client = null;
    }

    public Site getSite() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Forum> getForums() {
        List<Forum> result = new ArrayList<Forum>();

        Forum wall = model.createForum( URL + "me/feed" );
        wall.setId( "me" );
        wall.setName( "Wall" );
        postable.add( wall.getResource().toString() );
        result.add( wall );

        Connection<FacebookType> groupsConnections = client.fetchConnection(
                "me/groups", FacebookType.class );

        for ( List<FacebookType> myGroups : groupsConnections ) {
            for ( FacebookType type : myGroups ) {
                Group group = client.fetchObject( type.getId(), Group.class );

                Forum forum = model.createForum( URL + "groups/"
                        + group.getId() );
                forum.setId( group.getId() );
                forum.setName( group.getName() );
                
                if( null != group.getDescription() )
                    forum.setDescription( group.getDescription() );

                if( null != group.getUpdatedTime() )
                    forum.setModified( RDFTool.dateTime2String( group
                            .getUpdatedTime() ) );

                postable.add( forum.getResource().toString() );
                result.add( forum );
            }
        }

        return result;
    }

    public List<Thread> getThreads( Forum forum ) {
        return new ArrayList<Thread>();
    }

    public List<Post> getPost( Container container ) {
        List<Post> result = new ArrayList<Post>();
        String id = container.getAllId_as().firstValue();
        log.debug( "get posts" );

        Connection<FacebookType> feed = client.fetchConnection( id + "/feed",
                FacebookType.class, Parameter.with( "fields", "id, type" ) );

        int loaded_posts = 0;
        for ( List<FacebookType> ftypes : feed ) {
            for ( FacebookType ftype : ftypes ) {
                log.debug( ftype.toString() );
                String type = ftype.getType();

                if( null != type ) {
                    Post siocPost = model.createPost( URL + ftype.getId() );
                    siocPost.setId( ftype.getId() );

                    if( "status".equals( type ) ) {
                        com.restfb.types.Post post = client.fetchObject(
                                        ftype.getId(),
                                        com.restfb.types.Post.class,
                                        Parameter
                                                .with( "fields",
                                                        "created_time, updated_time, message" ) );

                        if( null == post.getMessage() ) {
                            model.removePost( siocPost );
                            continue;
                        }

                        siocPost.setTitle( type );
                        siocPost.setCreated( RDFTool
                                .dateTime2String( post.getCreatedTime() ) );
                        siocPost.setModified( RDFTool
                                .dateTime2String( post.getUpdatedTime() ) );
                        siocPost.setContent( StringUtils.trimToEmpty( post
                                .getMessage() ) );

                    } else if( "photo".equals( type ) ) {
                        Photo photo = client.fetchObject( ftype.getId(),
                                Photo.class, Parameter.with( "fields",
                                        "created_time, link, name" ) );

                        siocPost.setTitle( StringUtils
                                .trimToEmpty( photo.getName() ) );
                        siocPost.setCreated( RDFTool
                                .dateTime2String( photo.getCreatedTime() ) );
                        siocPost.setAttachment( ( (DefaultSIOCModel) model )
                                .getDelegatingModel().createURI(
                                        photo.getLink() ) );

                    } else if( "video".equals( type ) ) {
                        Video video = client.fetchObject( ftype.getId(),
                                        Video.class,
                                        Parameter
                                                .with( "fields",
                                                        "created_time, updated_time, source, name, description" ) );

                        siocPost.setTitle( video.getName() );
                        siocPost.setDescription( StringUtils
                                .trimToEmpty( video.getDescription() ) );
                        siocPost.setCreated( RDFTool
                                .dateTime2String( video.getCreatedTime() ) );
                        siocPost.setModified( RDFTool
                                .dateTime2String( video.getUpdatedTime() ) );
                        siocPost.setAttachment( ( (DefaultSIOCModel) model )
                                .getDelegatingModel().createURI(
                                        video.getSource() ) );

                    } else if( "link".equals( type ) ) {
                        Link link = client.fetchObject( ftype.getId(),
                                Link.class, Parameter.with( "fields",
                                        "created_time, link, message, name" ) );

                        siocPost.setTitle( StringUtils.trimToEmpty( link
                                .getName() ) );
                        siocPost.setCreated( RDFTool
                                .dateTime2String( link.getCreatedTime() ) );
                        siocPost.setContent( StringUtils.trimToEmpty( link
                                .getMessage() ) );
                        siocPost.setAttachment( ( (DefaultSIOCModel) model )
                                .getDelegatingModel()
                                .createURI( link.getLink() ) );
                    }
                    else{
                        model.removePost( siocPost );
                        continue;
                    }

                    result.add( siocPost );

                    System.out.println( post_limit + " " + loaded_posts );
                    if( post_limit == ++loaded_posts )
                        return result;
                }
            }
        }

        return result;
    }

    public boolean canPostOn( Container container ) {
        return postable.contains( container.getResource().toString() );
    }


    public void publishPost( Post post, Container container ) {
        Preconditions.checkArgument( canPostOn( container ) );

        client.publish( container.getAllId_as()
                .firstValue() + "/feed",
 FacebookType.class, Parameter
                .with(
                "message", post
                        .getAllContent_as()
.firstValue() ) );
    }

    public void commentPost( Post post, Post parent ) {
        client.publish( parent.getAllId_as()
                .firstValue() + "/comments",
 FacebookType.class, Parameter
                .with(
                "message", post
                        .getAllContent_as()
.firstValue() ) );

    }

    public UserAccount getUserAccount() {
        UserAccount result = null;
        User user = client.fetchObject( "me", User.class );

        if( null != user ) {
            result = model.createUserAccount( URL + user.getId() );
            SIOCThing.setId( result.getModel(), result.asResource(), user.getId() );
            result.setName( user.getName() );
            result.setAccountname( user.getUsername() );
            result.setModified( RDFTool.dateTime2String( user
                    .getUpdatedTime() ) );
        }

        return result;
    }

}
