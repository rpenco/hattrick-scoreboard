package org.hattrickscoreboardl.ui.views.chpp;

import android.content.Context;
import android.os.AsyncTask;

import org.hattrick.chpp.CHPPToken;
import org.hattrick.constants.Hattrick;
import org.hattrickscoreboardl.utils.storage.IStorage;
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

public class CHPPAuthorizationTask extends AsyncTask<String, String, Token> {

    @SuppressWarnings("unused")
    private static final String TAG = (CHPPAuthorizationTask.class)
            .getSimpleName();

    CHPPAuthorizationListener listener;
    Context context;

    public CHPPAuthorizationTask(Context context,
                                 CHPPAuthorizationListener listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected Token doInBackground(String... logins) {

        String login = logins[0];
        String password = logins[1];

        // Create OAuth service
        OAuthService service = new ServiceBuilder().provider(HattrickAPI.class)
                .apiKey(Hattrick.APIKEY).apiSecret(Hattrick.APISECRET)
                .signatureType(SignatureType.Header).build();

        // Obtain the Request Token
        Token token;
        token = service.getRequestToken();

        // 1st URL for User login
        String url = service.getAuthorizationUrl(token);

        // Add Scope (for write/send order on Hattrick)
        url = url + "&scope=" + Hattrick.CHPPSCOPE;

        Document page1, page2;
        try {

            // Get 1st auth page
            Connection.Response res = Jsoup.connect(url).execute();
            page1 = res.parse();

            // Prepare post data
            String txtUsername = login;
            String txtPassword = password;
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
                    .data("txtUsername", txtUsername)
                    .data("txtPassword", txtPassword)
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
                    .html().toString();

            if (keyAuth == null || keyAuth.equals("")) {
                // BugSenseHandler
                // .sendEvent("keyAuth == null || keyAuth.equals(\"\")");
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

        } catch (IOException e) {
            // BugSenseHandler.sendException(e);
            listener.onAuthenticationError();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Token token) {
        super.onPostExecute(token);

        // Return null -> error
        if (token == null) {
            listener.onAuthenticationError();
            return;
        }

        // Save token
        try {
            CHPPToken chppToken = new CHPPToken(token);
            IStorage.internalWriteFileString(context, Hattrick.TOKEN_FILE,
                    chppToken.toSave());
            listener.onAuthenticationSuccess();
        } catch (Exception e) {
            // BugSenseHandler.sendException(e);
            listener.onError();
        }
    }
}