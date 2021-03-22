package org.hattrickscoreboard.database.models;

public class DSeries extends DModel {

    long _id;
    int leagueID;
    int leagueLevel;
    int maxLevel;
    int leagueLevelUnitID;
    String leagueLevelUnitName;
    int currentMatchRound;
    int teamID;
    String teamName;
    int position;
    int positionChange;
    int matches;
    int goalsFor;
    int goalsAgainst;
    int points;
    int won;
    int draws;
    int lost;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }

    public int getLeagueLevel() {
        return leagueLevel;
    }

    public void setLeagueLevel(int leagueLevel) {
        this.leagueLevel = leagueLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
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

    public int getCurrentMatchRound() {
        return currentMatchRound;
    }

    public void setCurrentMatchRound(int currentMatchRound) {
        this.currentMatchRound = currentMatchRound;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPositionChange() {
        return positionChange;
    }

    public void setPositionChange(int positionChange) {
        this.positionChange = positionChange;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

}
