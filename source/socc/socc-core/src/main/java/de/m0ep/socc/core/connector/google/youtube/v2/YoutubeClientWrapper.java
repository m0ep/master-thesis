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

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.youtube.UserProfileEntry;
import com.google.gdata.util.ServiceException;

import de.m0ep.sioc.services.auth.APIKey;
import de.m0ep.sioc.services.auth.Password;
import de.m0ep.sioc.services.auth.Username;
import de.m0ep.socc.core.exceptions.AuthenticationException;

/**
 * Wraps the service client of Youtube to store extra stuff.
 * 
 * @author Florian Müller
 * 
 */
public class YoutubeClientWrapper {
	private final YouTubeService service;
	private UserProfileEntry userProfile;

	/**
	 * Constructs a new {@link YoutubeClientWrapper} with an <code>apiKey</code>
	 * , <code>username</code> and <code>password</code>.
	 * 
	 * @param apiKey
	 *            The API key for Youtube.
	 * @param username
	 *            The username of an Youtube account.
	 * @param password
	 *            The password for an Youtube account.
	 * 
	 * @throws NullPointerException
	 *             Thrown if one ore more parameters are <code>null</code>.
	 * @throws IllegalArgumentException
	 *             Thrown if one or more parameters have no valid value.
	 * @throws IOException
	 *             Thrown if a network error occurred.
	 * @throws AuthenticationException
	 *             Thrown if creating the defaultClient failed because of
	 *             authentication problems.
	 */
	public YoutubeClientWrapper(
	        APIKey apiKey,
	        Username username,
	        Password password )
	        throws AuthenticationException,
	        IOException {
		Preconditions.checkNotNull( apiKey,
		        "Required parameter apiKey must be specified." );
		Preconditions.checkArgument( apiKey.hasValue(),
		        "The parameter apiKey has no value" );
		Preconditions.checkNotNull( username,
		        "Required parameter username must be specified." );
		Preconditions.checkArgument( username.hasValue(),
		        "The parameter username has no value" );
		Preconditions.checkNotNull( password,
		        "Required parameter password must be specified." );
		Preconditions.checkArgument( password.hasValue(),
		        "The parameter password has no value" );

		this.service = new YouTubeService( "socc", apiKey.getValue() );

		try {
			this.service.setUserCredentials(
			        username.getValue(),
			        password.getValue() );
		} catch ( com.google.gdata.util.AuthenticationException e ) {
			throw new AuthenticationException( e );
		}

		try {
			this.userProfile = this.service
			        .getEntry(
			                new URL( "http://gdata.youtube.com/feeds/api/users/default" ),
			                UserProfileEntry.class );
		} catch ( MalformedURLException | ServiceException e ) {
			Throwables.propagate( e );
		}
	}

	public YouTubeService getYoutubeService() {
		return service;
	}

	public UserProfileEntry getUserProfile() {
		return userProfile;
	}
}
