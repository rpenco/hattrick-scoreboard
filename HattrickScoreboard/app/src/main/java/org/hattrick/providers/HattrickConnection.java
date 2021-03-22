package org.hattrick.providers;

import android.content.Context;
import android.util.Log;

import org.hattrick.chpp.CHPPResult;
import org.hattrick.chpp.CHPPToken;
import org.hattrick.constants.Hattrick;
import org.hattrick.providers.exceptions.CHPPException;
import org.hattrick.providers.exceptions.HParamsException;
import org.hattrick.providers.exceptions.HParamsProcessException;
import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.background.providers.IConnection;
import org.hattrickscoreboard.background.providers.IParams;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.HattrickAPI;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.io.IOException;

/**
 * @author Khips
 * @since 27 march 2014
 */
public class HattrickConnection implements IConnection {

    static String TAG = (HattrickConnection.class).getSimpleName();

    private String query;
    private IParams params;
    private Context ctx;
    private CHPPToken token;

    public HattrickConnection(Context context) {
        this.ctx = context;
        token = ((HattrickApplication) ctx.getApplicationContext())
                .getCHPPToken(context);
    }

    @Override
    public void setParam(IParams params) {
        this.params = params;
    }

    @Override
    public Object get() throws IOException {

        try {

            // Null param
            if (params == null) {
                throw new HParamsException();
            }

            // Get URL
            query = params.processParam();
            Log.v(TAG, query);

            // OAuth Configuration
            OAuthService service = new ServiceBuilder()
                    .provider(HattrickAPI.class).apiKey(Hattrick.APIKEY)
                    .apiSecret(Hattrick.APISECRET)
                    .signatureType(SignatureType.Header).build();

            // Check tocken
            if (token.getToken() == null || token.getSecret() == null) {
                throw new CHPPException("Null token or secret");
            }

            // Prepare request
            Token accessToken = new Token(token.getToken(), token.getSecret());
            OAuthRequest request = new OAuthRequest(Verb.GET,
                    Hattrick.RESOURCESURL + query);
            service.signRequest(accessToken, request);

            Response response;
            response = request.send();

            CHPPResult chppResult = new CHPPResult();
            chppResult.setBody(response.getBody());
            chppResult.setCode(response.getCode());
            return chppResult;

        } catch (HParamsException e) {
            throw new IOException(e);
        } catch (CHPPException e) {
            throw new IOException(e);
        } catch (HParamsProcessException e) {
            throw new IOException(e);
        }

    }
}
