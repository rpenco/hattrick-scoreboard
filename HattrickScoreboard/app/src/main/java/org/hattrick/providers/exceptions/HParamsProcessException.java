package org.hattrick.providers.exceptions;

public class HParamsProcessException extends Exception {

    private static final long serialVersionUID = 3891131272132059377L;

    public HParamsProcessException() {
    }

    public HParamsProcessException(String message) {
        super(message);
    }

    public HParamsProcessException(Throwable cause) {
        super(cause);
    }

    public HParamsProcessException(String message, Throwable cause) {
        super(message, cause);
    }

}
