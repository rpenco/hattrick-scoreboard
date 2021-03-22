package org.hattrick.providers.exceptions;

public class SerializerException extends Exception {

    private static final long serialVersionUID = -8183723336596839954L;

    public SerializerException() {
    }

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(Throwable cause) {
        super(cause);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

}
