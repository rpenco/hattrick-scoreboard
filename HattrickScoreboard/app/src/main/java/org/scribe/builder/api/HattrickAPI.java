package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

public class HattrickAPI extends DefaultApi10a {

    private static final String API_ENDPOINT = "https://chpp.hattrick.org";
    private static final String AUTHORIZATION_URL = "/oauth/authorize.aspx";

    private static final String REQUEST_TOKEN_RESOURCE = "/oauth/request_token.ashx";
    private static final String ACCESS_TOKEN_RESOURCE = "/oauth/access_token.ashx";

    @Override
    public String getAccessTokenEndpoint() {
        return API_ENDPOINT + ACCESS_TOKEN_RESOURCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return API_ENDPOINT + REQUEST_TOKEN_RESOURCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    @Override
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return String.format(API_ENDPOINT + AUTHORIZATION_URL
                + "?oauth_token=%s", requestToken.getToken());
    }
}
