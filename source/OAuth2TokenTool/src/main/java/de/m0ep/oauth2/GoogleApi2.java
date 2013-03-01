package de.m0ep.oauth2;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class GoogleApi2 extends DefaultApi20 {

    private static final String AUTHORIZE_URL = "https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=%s&redirect_uri=%s";
    private static final String SCOPED_AUTHORIZE_URL = AUTHORIZE_URL
	    + "&scope=%s";

    @Override
    public String getAccessTokenEndpoint() {
	return "https://accounts.google.com//o/oauth2/token";
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
	Preconditions.checkValidUrl(config.getCallback(),
		"Must provide a valid url as callback");

	com.google.common.base.Preconditions.checkArgument(config.hasScope(),
		"Google requires a valid scope");

	return String.format(SCOPED_AUTHORIZE_URL, config.getApiKey(),
		OAuthEncoder.encode(config.getCallback()),
		OAuthEncoder.encode(config.getScope()));
    }

    @Override
    public Verb getAccessTokenVerb() {
	return Verb.POST;
    }

}
