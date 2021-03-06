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

package de.m0ep.socc.core.connector.facebook;

import java.io.IOException;

import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.util.Builder;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Service;

import com.google.common.base.Throwables;
import com.restfb.exception.FacebookException;
import com.restfb.exception.FacebookNetworkException;
import com.restfb.exception.FacebookOAuthException;

import de.m0ep.socc.config.ConnectorConfig;
import de.m0ep.socc.core.ISoccContext;
import de.m0ep.socc.core.connector.DefaultConnector;
import de.m0ep.socc.core.connector.IConnector;
import de.m0ep.socc.core.exceptions.AuthenticationException;
import de.m0ep.socc.core.exceptions.NotFoundException;

/**
 * Implementation of an {@link IConnector} for Facebook.
 * 
 * @author Florian Müller
 */
public class FacebookConnector extends DefaultConnector {
	public static final URI URI_SERVICE_ENDPOINT = Builder
	        .createURI( "https://www.facebook.com" );

	private FacebookClientManager clientManager;
	private FacebookStructureReader serviceStructureReader;
	private FacebookPostReader postReader;
	private FacebookPostWriter postWriter;

	/**
	 * Construct a new {@link FacebookConnector} wich an <code>id</code>,
	 * <code>context</code>, <code>defaultUserAccount</code> and
	 * <code>service</code> objects.
	 * 
	 * @param id
	 *            The Id of the connector.
	 * @param context
	 *            The context of the connector.
	 * @param defaultUserAccount
	 *            The default user account of the connector.
	 * @param service
	 *            The service object of the Moodle service.
	 */
	public FacebookConnector(
	        final String id,
	        final ISoccContext context,
	        final UserAccount defaultUserAccount,
	        final Service service ) {
		super( id, context, defaultUserAccount, service );
	}

	/**
	 * Construct a new {@link FacebookConnector} with a <code>context</code> and
	 * a connector <code>config</code>.
	 * 
	 * @param context
	 *            The context of the connector.
	 * @param config
	 *            {@link ConnectorConfig} with all other data.
	 */
	public FacebookConnector( final ISoccContext context, final ConnectorConfig config ) {
		super( context, config );
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public FacebookClientManager getClientManager() {
		return clientManager;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public FacebookStructureReader getStructureReader() {
		if ( null == serviceStructureReader ) {
			serviceStructureReader = new FacebookStructureReader( this );
		}

		return serviceStructureReader;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public FacebookPostReader getPostReader() {
		if ( null == postReader ) {
			this.postReader = new FacebookPostReader( this );
		}

		return postReader;
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public FacebookPostWriter getPostWriter() {
		if ( null == postWriter ) {
			postWriter = new FacebookPostWriter( this );
		}
		return postWriter;
	}

	@Override
	public void initialize() throws AuthenticationException, IOException {
		getService().setServiceEndpoint( URI_SERVICE_ENDPOINT );

		try {
			clientManager = new FacebookClientManager( getService(),
			        getDefaultUserAccount() );
		} catch ( Exception e ) {
			Throwables.propagateIfInstanceOf( e, IOException.class );
			Throwables.propagateIfInstanceOf( e, AuthenticationException.class );
			throw Throwables.propagate( e );
		}

		setInitialized( true );
	}

	@Override
	public void shutdown() {
		clientManager.clear();
		setInitialized( false );
	}

	/**
	 * Converts Facebook exceptions to SOCC exceptions an propagates them.
	 * 
	 * @param eexception
	 *            Exception to convert.
	 * 
	 * @throws NotFoundException
	 *             Thrown if no resource was found at the URI
	 * @throws AuthenticationException
	 *             Thrown if there is a problem with authentication.
	 * @throws IOException
	 *             Thrown if there is problem in communication.
	 */
	public static void handleFacebookException( final FacebookException eexception )
	        throws AuthenticationException,
	        NotFoundException, IOException {
		if ( eexception instanceof FacebookOAuthException ) {
			FacebookOAuthException fae = (FacebookOAuthException) eexception;

			// error codes:
			// http://www.fb-developers.info/tech/fb_dev/faq/general/gen_10.html
			switch ( fae.getErrorCode() ) {
				case 101: // Invalid API key
				case 190: // Invalid Access Token
				case 400: // Invalid email address
				case 401: // Invalid username or password
				case 402: // Invalid application auth signature
				case 403: // Invalid timestamp for authentication
				case 450: // Session key specified has passed its expiration
					      // time
				case 451: // Session key specified cannot be used to call this
					// method
				case 452: // Session key invalid. This could be because the
					      // session
					// key has an incorrect format, or because the user has
				case 453: // revoked this session
				case 454: // A session key is required for calling this method
				case 455: // A session key must be specified when request is
					      // signed
					// with a session secret
					throw new AuthenticationException( fae.getErrorMessage(),
					        fae );
				case 803: // Specified object cannot be found
					throw new NotFoundException( "Not found", fae );
			}
		} else if ( eexception instanceof FacebookNetworkException ) {
			FacebookNetworkException fne = (FacebookNetworkException) eexception;
			throw new IOException( "Network error: "
			        + fne.getHttpStatusCode() + " " + fne.getMessage(), fne );
		}

		throw Throwables.propagate( eexception );
	}
}
