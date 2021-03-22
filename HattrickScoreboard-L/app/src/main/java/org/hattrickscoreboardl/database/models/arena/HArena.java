package org.hattrickscoreboardl.database.models.arena;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HArena extends HModel {

    public HArena(){

    }

    //ALL PLAYERS

     int ArenaID;

     String ArenaName;

     int TeamID;

     int LeagueID;

     int RegionID;

     int CurrentTerraces;

     int CurrentBasic;

     int CurrentRoof;

     int CurrentVIP;

     int CurrentTotal;

     String RebuiltDate;

     int ExpandedTerraces;

     int ExpandedBasic;

     int ExpandedRoof;

     int ExpandedVIP;

     int ExpandedTotal;

     String ExpansionDate;

    //SUPPORTERS ONLY

     int NumberOfMatches;

     int AverageTerraces;

     int AverageBasic;

     int AverageRoof;

     int AverageVIP;

     int AverageTotal;

     int MostTerraces;

     int MostBasic;

     int MostRoof;

     int MostVIP;

     int MostTotal;

     int LeastTerraces;

     int LeastBasic;

     int LeastRoof;

     int LeastVIP;

     int LeastTotal;

    String FetchedDate;

    // Getter


    public void setArenaID(int arenaID) {
        ArenaID = arenaID;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public void setRegionID(int regionID) {
        RegionID = regionID;
    }

    public void setCurrentTerraces(int currentTerraces) {
        CurrentTerraces = currentTerraces;
    }

    public void setCurrentBasic(int currentBasic) {
        CurrentBasic = currentBasic;
    }

    public void setCurrentRoof(int currentRoof) {
        CurrentRoof = currentRoof;
    }

    public void setCurrentVIP(int currentVIP) {
        CurrentVIP = currentVIP;
    }

    public void setCurrentTotal(int currentTotal) {
        CurrentTotal = currentTotal;
    }

    public void setRebuiltDate(String rebuiltDate) {
        RebuiltDate = rebuiltDate;
    }

    public void setExpandedTerraces(int expandedTerraces) {
        ExpandedTerraces = expandedTerraces;
    }

    public void setExpandedBasic(int expandedBasic) {
        ExpandedBasic = expandedBasic;
    }

    public void setExpandedRoof(int expandedRoof) {
        ExpandedRoof = expandedRoof;
    }

    public void setExpandedVIP(int expandedVIP) {
        ExpandedVIP = expandedVIP;
    }

    public void setExpandedTotal(int expandedTotal) {
        ExpandedTotal = expandedTotal;
    }

    public void setExpansionDate(String expansionDate) {
        ExpansionDate = expansionDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        NumberOfMatches = numberOfMatches;
    }

    public void setAverageTerraces(int averageTerraces) {
        AverageTerraces = averageTerraces;
    }

    public void setAverageBasic(int averageBasic) {
        AverageBasic = averageBasic;
    }

    public void setAverageRoof(int averageRoof) {
        AverageRoof = averageRoof;
    }

    public void setAverageVIP(int averageVIP) {
        AverageVIP = averageVIP;
    }

    public void setAverageTotal(int averageTotal) {
        AverageTotal = averageTotal;
    }

    public void setMostTerraces(int mostTerraces) {
        MostTerraces = mostTerraces;
    }

    public void setMostBasic(int mostBasic) {
        MostBasic = mostBasic;
    }

    public void setMostRoof(int mostRoof) {
        MostRoof = mostRoof;
    }

    public void setMostVIP(int mostVIP) {
        MostVIP = mostVIP;
    }

    public void setMostTotal(int mostTotal) {
        MostTotal = mostTotal;
    }

    public void setLeastTerraces(int leastTerraces) {
        LeastTerraces = leastTerraces;
    }

    public void setLeastBasic(int leastBasic) {
        LeastBasic = leastBasic;
    }

    public void setLeastRoof(int leastRoof) {
        LeastRoof = leastRoof;
    }

    public void setLeastVIP(int leastVIP) {
        LeastVIP = leastVIP;
    }

    public void setLeastTotal(int leastTotal) {
        LeastTotal = leastTotal;
    }

    public int getLeastTotal() {
        return LeastTotal;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getTeamID() {
        return TeamID;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public int getRegionID() {
        return RegionID;
    }

    public int getCurrentTerraces() {
        return CurrentTerraces;
    }

    public int getCurrentBasic() {
        return CurrentBasic;
    }

    public int getCurrentRoof() {
        return CurrentRoof;
    }

    public int getCurrentVIP() {
        return CurrentVIP;
    }

    public int getCurrentTotal() {
        return CurrentTotal;
    }

    public String getRebuiltDate() {
        return RebuiltDate;
    }

    public int getExpandedTerraces() {
        return ExpandedTerraces;
    }

    public int getExpandedBasic() {
        return ExpandedBasic;
    }

    public int getExpandedRoof() {
        return ExpandedRoof;
    }

    public int getExpandedVIP() {
        return ExpandedVIP;
    }

    public int getExpandedTotal() {
        return ExpandedTotal;
    }

    public String getExpansionDate() {
        return ExpansionDate;
    }

    public int getNumberOfMatches() {
        return NumberOfMatches;
    }

    public int getAverageTerraces() {
        return AverageTerraces;
    }

    public int getAverageBasic() {
        return AverageBasic;
    }

    public int getAverageRoof() {
        return AverageRoof;
    }

    public int getAverageVIP() {
        return AverageVIP;
    }

    public int getAverageTotal() {
        return AverageTotal;
    }

    public int getMostTerraces() {
        return MostTerraces;
    }

    public int getMostBasic() {
        return MostBasic;
    }

    public int getMostRoof() {
        return MostRoof;
    }

    public int getMostVIP() {
        return MostVIP;
    }

    public int getMostTotal() {
        return MostTotal;
    }

    public int getLeastTerraces() {
        return LeastTerraces;
    }

    public int getLeastBasic() {
        return LeastBasic;
    }

    public int getLeastRoof() {
        return LeastRoof;
    }

    public int getLeastVIP() {
        return LeastVIP;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }
}

