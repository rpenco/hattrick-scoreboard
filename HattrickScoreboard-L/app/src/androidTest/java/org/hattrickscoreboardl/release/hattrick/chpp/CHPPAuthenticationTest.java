package org.hattrickscoreboardl.release.hattrick.chpp;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;

import junit.framework.Assert;

import org.hattrick.chpp.CHPPAuthentication;
import org.hattrick.chpp.CHPPToken;
import org.hattrickscoreboardl.utils.Hattrick;
import org.scribe.model.Token;

/**
 * Created by romain
 * on 28/10/2014.
 */
public class CHPPAuthenticationTest extends AndroidTestCase {


    private CHPPToken token;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        token = new CHPPToken();
        token.setSecret(Hattrick.TOKEN_SECRET);
        token.setToken(Hattrick.TOKEN_TOKEN);
    }


    @Suppress
    public void testCHPPAuthenticationAutomatic() throws Throwable{

        CHPPAuthentication authentication = new CHPPAuthentication();
        Token token = authentication.authenticate(Hattrick.USER_LOGIN,Hattrick.USER_PASSWORD);
        Assert.assertNotNull(token.getToken());
    }

    @Suppress
    public void testCHPPAuthenticationByParts()  {


        CHPPAuthentication authentication = new CHPPAuthentication();

        //Part One
        String url = authentication.authenticatePartOne();
        Log.d("URL", url);
        Assert.assertTrue(url.contains("hattrick"));

        //Display URL in browser, authenticate, and receive secret code
        //authentication.authenticatePartTwo("listbutton");
    }
}
