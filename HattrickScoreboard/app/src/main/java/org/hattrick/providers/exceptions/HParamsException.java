package org.hattrick.providers.exceptions;

public class HParamsException extends Exception {

    private static final long serialVersionUID = 3891131272132059377L;

    public HParamsException() {
    }

    public HParamsException(String message) {
        super(message);
    }

    public HParamsException(Throwable cause) {
        super(cause);
    }

    public HParamsException(String message, Throwable cause) {
        super(message, cause);
    }

}
