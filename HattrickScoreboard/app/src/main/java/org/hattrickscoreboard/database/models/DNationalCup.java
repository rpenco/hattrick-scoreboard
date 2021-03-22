package org.hattrickscoreboard.database.models;

public class DNationalCup extends DModel {

    long _id;
    int leageID;
    int countryID;
    int CupID;
    String CupName;
    int CupLeagueLevel;
    int CupLevel;
    int CupLevelIndex;
    int MatchRound;
    int MatchRoundsLeft;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getLeageID() {
        return leageID;
    }

    public void setLeageID(int leageID) {
        this.leageID = leageID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
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
