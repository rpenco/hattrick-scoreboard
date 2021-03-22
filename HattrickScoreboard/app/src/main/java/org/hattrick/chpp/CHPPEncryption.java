package org.hattrick.chpp;

import android.annotation.SuppressLint;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author Khips
 * @since 14 august 2014
 */
public class CHPPEncryption {
    private String charsetName = "UTF8";
    private String algorithm = "DES";
    private int base64Mode = Base64.DEFAULT;

    @SuppressLint("TrulyRandom")
    public String encrypt(String key, String data) throws Exception {
        if (key == null || data == null)
            return null;
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory
                .getInstance(algorithm);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        byte[] dataBytes = data.getBytes(charsetName);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.encodeToString(cipher.doFinal(dataBytes), base64Mode);
    }

    public String decrypt(String key, String data) throws Exception {
        if (key == null || data == null)
            return null;

        byte[] dataBytes = Base64.decode(data, base64Mode);
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charsetName));
        SecretKeyFactory secretKeyFactory = SecretKeyFactory
                .getInstance(algorithm);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] dataBytesDecrypted = (cipher.doFinal(dataBytes));
        return new String(dataBytesDecrypted);

    }
}
