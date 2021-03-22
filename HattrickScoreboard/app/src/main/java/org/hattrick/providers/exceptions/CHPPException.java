package org.hattrick.providers.exceptions;

public class CHPPException extends Exception {

    private static final long serialVersionUID = -8183723336596839954L;

    public CHPPException() {
    }

    public CHPPException(String message) {
        super(message);
    }

    public CHPPException(Throwable cause) {
        super(cause);
    }

    public CHPPException(String message, Throwable cause) {
        super(message, cause);
    }

}
