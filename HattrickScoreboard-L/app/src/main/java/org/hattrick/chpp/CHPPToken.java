package org.hattrick.chpp;

import org.hattrick.constants.Hattrick;
import org.scribe.model.Token;

/**
 * @author Khips 18 avr. 2014
 */
public class CHPPToken {

    private String token;
    private String secret;

    public CHPPToken() {

    }

    public CHPPToken(String token, String secret) {
        setToken(token);
        setSecret(secret);
    }

    public CHPPToken(Token token) {
        setToken(token.getToken());
        setSecret(token.getSecret());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public CHPPToken fromSave(String readInternalFile) throws Exception {
        CHPPEncryption encryption = new CHPPEncryption();
        String data = encryption.decrypt(Hattrick.APIKEY, readInternalFile);

        if (data != null) {
            String split[] = data.split("/");
            setSecret(split[0]);
            setToken(split[1]);
        }
        return this;
    }

    public String toSave() throws Exception {
        CHPPEncryption encryption = new CHPPEncryption();
        return encryption.encrypt(Hattrick.APIKEY, getSecret() + "/"
                + getToken());
    }

}
