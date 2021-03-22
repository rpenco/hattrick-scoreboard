package org.hattrick.chpp;

import org.scribe.model.Response;

/**
 * @author Khips
 *         18 avr. 2014
 */
public class CHPPResponse {

    private Response response;

    private String body = null;
    private int code = 0;

    public CHPPResponse(Response response) {
        this.response = response;
        if(response != null) {
            this.body = response.getBody();
            this.code = response.getCode();
        }
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public Response getResponse(){ return response;}

}
