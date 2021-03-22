package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "HattrickData", strict = false)
public class MatchHeader {

    @Element
    private String FileName;

    @Element
    private String Version;

    @Element
    private String UserID;

    @Element
    private String FetchedDate;

    @Element(required = false)
    private boolean UserSupporterTier;

    @Element
    private String SourceSystem;

    @Element
    private MatchDetails Match;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public boolean isUserSupporterTier() {
        return UserSupporterTier;
    }

    public void setUserSupporterTier(boolean userSupporterTier) {
        UserSupporterTier = userSupporterTier;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public MatchDetails getMatch() {
        return Match;
    }

    public void setMatch(MatchDetails match) {
        Match = match;
    }

}
