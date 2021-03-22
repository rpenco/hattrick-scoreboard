package org.hattrick.models.search;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 27 march 2014
 */
@Root(strict = false)
public class SearchResponse {

    @Element
    @Path("SearchParams")
    int SearchType;

    @Element(required = false)
    @Path("SearchParams")
    String SearchString;

    @Element(required = false)
    @Path("SearchParams")
    String SearchString2;

    @Element(required = false)
    @Path("SearchParams")
    int SearchID;

    @Element
    @Path("SearchParams")
    int SearchLeagueID;

    @Element(required = false)
    int PageIndex;

    @Element(required = false)
    int Pages;

    @ElementList(required = false)
    ArrayList<SearchResult> SearchResults;

    public int getSearchType() {
        return SearchType;
    }

    public String getSearchString() {
        return SearchString;
    }

    public String getSearchString2() {
        return SearchString2;
    }

    public int getSearchID() {
        return SearchID;
    }

    public int getSearchLeagueID() {
        return SearchLeagueID;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public int getPages() {
        return Pages;
    }

    public ArrayList<SearchResult> getSearchResults() {
        return SearchResults;
    }

}
