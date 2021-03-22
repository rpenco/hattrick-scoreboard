package org.hattrick.chpp;

/**
 * @author Khips
 * @since 18 avr. 2014
 */
public class CHPPRequest {

    private String filesave;
    private String params;
    private CHPPToken token;

    public CHPPRequest(CHPPToken token, String filesave, String params) {
        this.token = token;
        this.filesave = filesave;
        this.params = params;
    }

    public String getFilesave() {
        return filesave;
    }

    public void setFilesave(String filesave) {
        this.filesave = filesave;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public CHPPToken getToken() {
        return token;
    }

    public void setToken(CHPPToken token) {
        this.token = token;
    }
}
