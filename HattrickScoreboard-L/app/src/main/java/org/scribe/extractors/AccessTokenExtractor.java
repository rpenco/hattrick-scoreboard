package org.scribe.extractors;

import org.scribe.model.Token;

/**
 * Simple command object that extracts a {@link org.scribe.model.Token} from a String
 *
 * @author Pablo Fernandez
 */
public interface AccessTokenExtractor {
    /**
     * Extracts the access token from the contents of an Http Response
     *
     * @param response the contents of the response
     * @return OAuth access token
     */
    public Token extract(String response);
}
