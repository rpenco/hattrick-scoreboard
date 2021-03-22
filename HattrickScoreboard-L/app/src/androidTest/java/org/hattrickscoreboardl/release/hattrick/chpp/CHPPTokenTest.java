package org.hattrickscoreboardl.release.hattrick.chpp;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.hattrick.chpp.CHPPToken;
import org.hattrickscoreboardl.utils.Hattrick;

/**
 * Created by romain
 * on 28/10/2014.
 */
public class CHPPTokenTest extends AndroidTestCase {

    public void testCHPPToken() throws Throwable{

        CHPPToken token= new CHPPToken();

        //Get/Set token
        token.setToken(Hattrick.TOKEN_TOKEN);
        token.setSecret(Hattrick.TOKEN_SECRET);
        Assert.assertEquals(Hattrick.TOKEN_TOKEN, token.getToken());
        Assert.assertEquals(Hattrick.TOKEN_SECRET, token.getSecret());

        //Save encrypted token
        String secretToken = token.toSave();
        Assert.assertEquals("V0313CSg+NtW8dMnhHww9AKJU7PjwvDCfW82b0OUx8mHDmTsD6eB8Q==\n", secretToken);

        //Load encrypted token
        token.fromSave("V0313CSg+NtW8dMnhHww9AKJU7PjwvDCfW82b0OUx8mHDmTsD6eB8Q==\n");
        Assert.assertEquals(Hattrick.TOKEN_TOKEN, token.getToken());
        Assert.assertEquals(Hattrick.TOKEN_SECRET, token.getSecret());


    }
}
