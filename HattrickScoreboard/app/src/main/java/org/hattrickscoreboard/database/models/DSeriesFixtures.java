package org.hattrickscoreboard.database.models;

public class DSeriesFixtures extends DModel {

    long _id;
    int leagueLevelUnitID;
    String leagueLevelUnitName;
    int saison;
    int matchID;
    int matchRound;
    int homeTeamID;
    String homeTeamName;
    int awayTeamID;
    String awayTeamName;
    String matchDate;
    int homeGoals;
    int awayGoals;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getLeagueLevelUnitID() {
        return leagueLevelUnitID;
    }

    public void setLeagueLevelUnitID(int leagueLevelUnitID) {
        this.leagueLevelUnitID = leagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return leagueLevelUnitName;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        this.leagueLevelUnitName = leagueLevelUnitName;
    }

    public int getSaison() {
        return saison;
    }

    public void setSaison(int saison) {
        this.saison = saison;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public int getMatchRound() {
        return matchRound;
    }

    public void setMatchRound(int matchRound) {
        this.matchRound = matchRound;
    }

    public int getHomeTeamID() {
        return homeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        this.homeTeamID = homeTeamID;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public void setAwayTeamID(int awayTeamID) {
        this.awayTeamID = awayTeamID;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

}
