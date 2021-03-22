package org.hattrick.providers.exceptions;

public class ParserException extends Exception {

    int code = -2;
    String content;


    /**
     * Throw unknown exception (no xml file..)
     * @param content content to parse
     */
    public ParserException(String content) {
        super(new Throwable());
      this.content = content;
    }

    public ParserException() {
        super(new Exception());
    }

    /**
     * Throw others exceptions
     * @param cause
     */
    public ParserException(Throwable cause) {
        super(cause);
    }

    /**
     * Throw chpp known exception
     * @param cause
     * @param code
     */
    public ParserException(Throwable cause, int code, String content) {
        super(cause);
        this.code = code;
        this.content = content;
    }

    public int getCode(){
        return code;
    }


    public String getContent(){
        return content;
    }
}
