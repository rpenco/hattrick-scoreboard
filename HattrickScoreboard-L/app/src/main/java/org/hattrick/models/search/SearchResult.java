package org.hattrick.models.search;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Khips
 * @since 27 mars 2014
 */
@Root(strict = false)
public class SearchResult {

    @Element
    int ResultID;

    @Element
    String ResultName;

    public int getResultID() {
        return ResultID;
    }

    public String getResultName() {
        return ResultName;
    }

}
