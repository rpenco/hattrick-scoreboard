package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HScorer extends HModel {

    public HScorer(){ }

    int ScorerIndex;

    int MatchID;

    int MatchContextID;

    String PlayerID;

    String PlayerName;

    String TeamID;

    String HomeGoals;

    String AwayGoals;

    String Minute;

    public int getScorerIndex() {
        return ScorerIndex;
    }

    public void setScorerIndex(int scorerIndex) {
        ScorerIndex = scorerIndex;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public int getMatchContextID() {
        return MatchContextID;
    }

    public void setMatchContextID(int matchContextID) {
        MatchContextID = matchContextID;
    }

    public String getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(String playerID) {
        PlayerID = playerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getHomeGoals() {
        return HomeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        HomeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return AwayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        AwayGoals = awayGoals;
    }

    public String getMinute() {
        return Minute;
    }

    public void setMinute(String minute) {
        Minute = minute;
    }
}

