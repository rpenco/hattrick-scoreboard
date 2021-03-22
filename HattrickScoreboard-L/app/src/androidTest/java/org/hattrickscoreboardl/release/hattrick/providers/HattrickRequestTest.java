package org.hattrickscoreboardl.release.hattrick.providers;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.hattrick.chpp.CHPPToken;
import org.hattrick.models.clubs.Club;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.utils.Hattrick;

import java.io.IOException;

/**
 * Main class for testing download file from
 * Hattrick
 * Created by romain on 28/10/2014.
 */
public class HattrickRequestTest extends AndroidTestCase {

    private CHPPToken token;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        token = new CHPPToken();
        token.setSecret(Hattrick.TOKEN_SECRET);
        token.setToken(Hattrick.TOKEN_TOKEN);
    }


    public void testCHPPRequest() throws IOException {

        //Create Hattrick connection
        IRequest hconnection = new HattrickRequest(getContext(),token);

        //Create URI parameter
        IParam hparam = new HattrickParam(Club.class, null);

        //Get resource
        Club result = (Club) hconnection.get(hparam);
        Assert.assertNotNull(result);

    }
}
