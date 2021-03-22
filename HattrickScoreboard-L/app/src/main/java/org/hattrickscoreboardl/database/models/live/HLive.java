package org.hattrickscoreboardl.database.models.live;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HLive extends HModel {
    
    public  HLive(){}

    int MatchID;

    String MatchDate;

    String SourceSystem;

    int HomeGoals;

    int AwayGoals;

    int HomeTeamID;

    String HomeTeamName;

    int AwayTeamID;

    String AwayTeamName;

    int LastShownEventIndex;

    int NextEventMinute;

    //For Hattrick Scoreboard

    int LastReadEventIndex;

    String MatchStatus;

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
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

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        HomeTeamID = homeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        AwayTeamID = awayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
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

    public int getLastReadEventIndex() {
        return LastReadEventIndex;
    }

    public void setLastReadEventIndex(int lastReadEventIndex) {
        LastReadEventIndex = lastReadEventIndex;
    }

    public String getMatchStatus() {
        return MatchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        MatchStatus = matchStatus;
    }
}
