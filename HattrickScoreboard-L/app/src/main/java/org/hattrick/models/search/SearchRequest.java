package org.hattrick.models.search;

public class SearchRequest {

    static final int TYPE_PLAYERS = 0;
    static final int TYPE_ARENAS = 1;
    static final int TYPE_MANAGERS = 2;
    static final int TYPE_SERIES = 3;
    static final int TYPE_TEAMS = 4;
    static final int TYPE_REGIONS = 5;
    static final int TYPE_MATCH = 6;

    String version;

    int searchType;

    String searchString;

    String searchString2;

    int searchID;

    int searchLeagueID;

    int pageIndex;

    public static int getTypePlayers() {
        return TYPE_PLAYERS;
    }

    public static int getTypeArenas() {
        return TYPE_ARENAS;
    }

    public static int getTypeManagers() {
        return TYPE_MANAGERS;
    }

    public static int getTypeSeries() {
        return TYPE_SERIES;
    }

    public static int getTypeTeams() {
        return TYPE_TEAMS;
    }

    public static int getTypeRegions() {
        return TYPE_REGIONS;
    }

    public static int getTypeMatch() {
        return TYPE_MATCH;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString2() {
        return searchString2;
    }

    public void setSearchString2(String searchString2) {
        this.searchString2 = searchString2;
    }

    public int getSearchID() {
        return searchID;
    }

    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }

    public int getSearchLeagueID() {
        return searchLeagueID;
    }

    public void setSearchLeagueID(int searchLeagueID) {
        this.searchLeagueID = searchLeagueID;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

}
