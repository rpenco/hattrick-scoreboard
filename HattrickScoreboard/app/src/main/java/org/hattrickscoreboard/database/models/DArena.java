package org.hattrickscoreboard.database.models;

public class DArena extends DModel {

    long _id;
    int arenaID;
    String arenaName;
    int teamID;
    int leagueID;
    int regionID;
    int currentTerraces;
    int currentBasic;
    int currentRoof;
    int currentVIP;
    int currentTotal;
    String RebuiltDate;
    String ExpansionDate;
    int ExpansionTerraces;
    int ExpansionBasic;
    int ExpansionRoof;
    int ExpansionVIP;
    int ExpansionTotal;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getArenaID() {
        return arenaID;
    }

    public void setArenaID(int arenaID) {
        this.arenaID = arenaID;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public int getCurrentTerraces() {
        return currentTerraces;
    }

    public void setCurrentTerraces(int currentTerraces) {
        this.currentTerraces = currentTerraces;
    }

    public int getCurrentBasic() {
        return currentBasic;
    }

    public void setCurrentBasic(int currentBasic) {
        this.currentBasic = currentBasic;
    }

    public int getCurrentRoof() {
        return currentRoof;
    }

    public void setCurrentRoof(int currentRoof) {
        this.currentRoof = currentRoof;
    }

    public int getCurrentVIP() {
        return currentVIP;
    }

    public void setCurrentVIP(int currentVIP) {
        this.currentVIP = currentVIP;
    }

    public int getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(int currentTotal) {
        this.currentTotal = currentTotal;
    }

    public String getRebuiltDate() {
        return RebuiltDate;
    }

    public void setRebuiltDate(String rebuiltDate) {
        RebuiltDate = rebuiltDate;
    }

    public String getExpansionDate() {
        return ExpansionDate;
    }

    public void setExpansionDate(String expansionDate) {
        ExpansionDate = expansionDate;
    }

    public int getExpansionTerraces() {
        return ExpansionTerraces;
    }

    public void setExpansionTerraces(int expansionTerraces) {
        ExpansionTerraces = expansionTerraces;
    }

    public int getExpansionBasic() {
        return ExpansionBasic;
    }

    public void setExpansionBasic(int expansionBasic) {
        ExpansionBasic = expansionBasic;
    }

    public int getExpansionRoof() {
        return ExpansionRoof;
    }

    public void setExpansionRoof(int expansionRoof) {
        ExpansionRoof = expansionRoof;
    }

    public int getExpansionVIP() {
        return ExpansionVIP;
    }

    public void setExpansionVIP(int expansionVIP) {
        ExpansionVIP = expansionVIP;
    }

    public int getExpansionTotal() {
        return ExpansionTotal;
    }

    public void setExpansionTotal(int expansionTotal) {
        ExpansionTotal = expansionTotal;
    }

    public int getValidityTime() {
        return ValidityTime;
    }

    public void setValidityTime(int validityTime) {
        ValidityTime = validityTime;
    }

}
