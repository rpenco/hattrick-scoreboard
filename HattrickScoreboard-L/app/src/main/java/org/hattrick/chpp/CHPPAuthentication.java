package org.hattrick.chpp;

import org.hattrick.constants.Hattrick;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.HattrickAPI;
import org.scribe.model.OAuthRequest;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

/**
 * Created by romain on 28/10/2014.
 */
public class CHPPAuthentication {

    private OAuthService service;
    private Token token;

    private  OAuthService createOAuthService(){
        // Create OAuth service
        service = new ServiceBuilder().provider(HattrickAPI.class)
                .apiKey(Hattrick.APIKEY).apiSecret(Hattrick.APISECRET)
                .signatureType(SignatureType.Header).build();
        return service;
    }

    /**
     * Automatic authentication
     * @param login
     * @param password
     * @return
     * @throws IOException
     */
    public Token authenticate(String login, String password) throws IOException {

        //Create OAuth service
        createOAuthService();

        // Obtain the Request Token
        token = service.getRequestToken();

        // 1st URL for User login
        String url = service.getAuthorizationUrl(token);

        // Add Scope (for write/send order on Hattrick)
        url = url + "&scope=" + Hattrick.CHPPSCOPE;

        Document page1, page2;


            // Get 1st auth page
            Connection.Response res = Jsoup.connect(url).execute();
            page1 = res.parse();

            // Prepare post data
            String hidToken = token.getToken();
            String hidAuthenticityToken = page1.select("#hidAuthenticityToken")
                    .attr("value");

            String __EVENTTARGET = "";
            String __EVENTARGUMENT = "";
            String __LASTFOCUS = "";
            String __VIEWSTATE = page1.select("#__VIEWSTATE").attr("value");
            String __EVENTVALIDATION = page1.select("#__EVENTVALIDATION").attr(
                    "value");

            String hidScope = Hattrick.CHPPSCOPE;

            String btnAllow = "Autoriser";
            String ddlLanguage = "5";
            String ddlPermissions = "read_access";

            // Get page 2
            page2 = Jsoup.connect(url).userAgent("Mozilla")
                    .cookies(res.cookies()).data("hidToken", hidToken)
                    .data("hidAuthenticityToken", hidAuthenticityToken)
                    .data("txtUsername", login)
                    .data("txtPassword", password)
                    .data("__EVENTTARGET", __EVENTTARGET)
                    .data("__EVENTARGUMENT", __EVENTARGUMENT)
                    .data("__LASTFOCUS", __LASTFOCUS)
                    .data("__VIEWSTATE", __VIEWSTATE)
                    .data("__EVENTVALIDATION", __EVENTVALIDATION)
                    .data("hidScope", hidScope).data("btnAllow", btnAllow)
                    .data("ddlLanguage", ddlLanguage)
                    .data("ddlPermissions", ddlPermissions).post();

            // Parse result and find temporary token
            String keyAuth = page2.select("#pnlAccessGranted").select("pre")
                    .html();

            if (keyAuth.equals("") || keyAuth.equals("")) {
                return null;
            }

            // I have token -> final step -> send it by OAuth service

            Verifier verifier = new Verifier(keyAuth);

            Token accessToken;
            accessToken = service.getAccessToken(token, verifier);

            OAuthRequest request = new OAuthRequest(Verb.GET,
                    Hattrick.RESOURCESURL);
            service.signRequest(accessToken, request);
            request.send();

            return accessToken;

    }

    /**
     * Default authentication, with webpage
     * Step One generate URL for form page
     * @return String url to display into webview
     */
    public String authenticatePartOne(){

        //Create OAuth service
        createOAuthService();

        // Obtain the Request Token
        token = service.getRequestToken();

        // 1st URL for User login
        String url = service.getAuthorizationUrl(token);

        // Add Scope (for write/send order on Hattrick)
        return url + "&scope=" + Hattrick.CHPPSCOPE;
    }


    /**
     * Pass unique key from web page
     * @param keyAuth unique key from web page
     * @return Token token
     */
    public Token authenticatePartTwo(String keyAuth){

        if (keyAuth == null || keyAuth.equals("")) {
            return null;
        }

        // I have token -> final step -> send it by OAuth service

        Verifier verifier = new Verifier(keyAuth);

        Token accessToken;
        accessToken = service.getAccessToken(token, verifier);

        OAuthRequest request = new OAuthRequest(Verb.GET,
                Hattrick.RESOURCESURL);

        service.signRequest(accessToken, request);
        request.send();

        return accessToken;
    }
}
