package org.hattrickscoreboard.database.models;

public class DLive extends DModel {

    long _id;
    int MatchID;
    String SourceSystem;
    String MatchDate;
    int HomeGoals;
    int AwayGoals;
    int LastShownEventIndex;
    int LastReadEventIndex;
    int NextEventMinute;
    String MatchStatus;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public int getLastShownEventIndex() {
        return LastShownEventIndex;
    }

    public void setLastShownEventIndex(int lastShownEventIndex) {
        LastShownEventIndex = lastShownEventIndex;
    }

    public int getNextEventMinute() {
        return NextEventMinute;
    }

    public void setNextEventMinute(int nextEventMinute) {
        NextEventMinute = nextEventMinute;
    }

    public String getMatchStatus() {
        return MatchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        MatchStatus = matchStatus;
    }

    public int getLastReadEventIndex() {
        return LastReadEventIndex;
    }

    public void setLastReadEventIndex(int lastReadEventIndex) {
        LastReadEventIndex = lastReadEventIndex;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        HomeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        AwayGoals = awayGoals;
    }

}
