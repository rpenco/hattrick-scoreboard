package org.hattrickscoreboardl.database.models.nationals;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HNationalMatch extends HModel {


    public HNationalMatch(){ }

    int LeagueOfficeTypeID;

    int MatchID;

    String MatchDate;

    int MatchType;

    String HomeTeamName;

    String AwayTeamName;

    int HomeGoals;

    int AwayGoals;

    public int getAwayGoals() {
        return AwayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        AwayGoals = awayGoals;
    }

    public int getLeagueOfficeTypeID() {
        return LeagueOfficeTypeID;
    }

    public void setLeagueOfficeTypeID(int leagueOfficeTypeID) {
        LeagueOfficeTypeID = leagueOfficeTypeID;
    }

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

    public int getMatchType() {
        return MatchType;
    }

    public void setMatchType(int matchType) {
        MatchType = matchType;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        HomeGoals = homeGoals;
    }
}

