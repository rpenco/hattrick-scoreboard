package org.hattrickscoreboardl.database.models.world;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HCup extends HModel {

    public HCup(){}

    int LeagueID;

    int CupID;

    String CupName;

    int CupLeagueLevel;

    int CupLevel;

    int CupLevelIndex;

    int MatchRound;

    int MatchRoundsLeft;

    public int getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public int getCupID() {
        return CupID;
    }

    public void setCupID(int cupID) {
        CupID = cupID;
    }

    public String getCupName() {
        return CupName;
    }

    public void setCupName(String cupName) {
        CupName = cupName;
    }

    public int getCupLeagueLevel() {
        return CupLeagueLevel;
    }

    public void setCupLeagueLevel(int cupLeagueLevel) {
        CupLeagueLevel = cupLeagueLevel;
    }

    public int getCupLevel() {
        return CupLevel;
    }

    public void setCupLevel(int cupLevel) {
        CupLevel = cupLevel;
    }

    public int getCupLevelIndex() {
        return CupLevelIndex;
    }

    public void setCupLevelIndex(int cupLevelIndex) {
        CupLevelIndex = cupLevelIndex;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public void setMatchRound(int matchRound) {
        MatchRound = matchRound;
    }

    public int getMatchRoundsLeft() {
        return MatchRoundsLeft;
    }

    public void setMatchRoundsLeft(int matchRoundsLeft) {
        MatchRoundsLeft = matchRoundsLeft;
    }
}
