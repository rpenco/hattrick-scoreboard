package org.hattrickscoreboardl.release.hattrick.chpp;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.hattrick.chpp.CHPPEncryption;

/**
 * Created by romain
 * on 28/10/2014.
 */
public class CHPPEncryptionTest extends AndroidTestCase {

    public void testCHPPEncryption() throws Throwable{

        CHPPEncryption chppEncryption = new CHPPEncryption();

        //Encrypt
        String encrypted = chppEncryption.encrypt("tzb58NjqZcWENDpOz8FUJc","data");
        Assert.assertEquals("6yoQKYpi10s=\n", encrypted);

        //Décrypt
        String decrypted = chppEncryption.decrypt("tzb58NjqZcWENDpOz8FUJc", encrypted);
        Assert.assertEquals("data",decrypted);

    }
}
