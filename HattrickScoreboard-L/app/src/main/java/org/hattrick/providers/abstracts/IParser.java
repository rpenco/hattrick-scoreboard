package org.hattrick.providers.abstracts;


import org.hattrick.providers.exceptions.ParserException;

public abstract class IParser {

    /**
     * Parse result to Java resource
     * e.g. parse XML to Object
     * @param <T>  Object result
     * @param content result to parse
     * @return
     */
    public abstract <T> T parse (Class<T> object, String content) throws ParserException;
}
