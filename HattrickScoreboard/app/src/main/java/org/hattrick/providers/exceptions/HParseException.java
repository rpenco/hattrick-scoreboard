package org.hattrick.providers.exceptions;

public class HParseException extends Exception {

    private static final long serialVersionUID = 3891131272132059377L;

    public HParseException() {
    }

    public HParseException(String message) {
        super(message);
    }

    public HParseException(Throwable cause) {
        super(cause);
    }

    public HParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
