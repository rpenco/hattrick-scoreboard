package org.hattrickscoreboard.database.models;

public class DTeam extends DModel {

    long _id;
    int userID;
    int TeamID;
    String TeamName;
    String ShortTeamName;
    boolean IsPrimaryClub;
    String FoundedDate;
    int ArenaID;
    String ArenaName;
    int LeagueID;
    String LeagueName;
    int RegionID;
    String RegionName;
    int TrainerID;
    String HomePage;
    String DressURI;
    String DressAlternateURI;
    int LeagueLevelUnitID;
    String LeagueLevelUnitName;
    boolean Bot;
    boolean StillInCup;
    int CupID;
    String CupName;
    int FriendlyTeamID;
    int NumberOfVictories;
    int NumberOfUndefeated;
    int TeamRank;
    int FanclubID;
    String FanclubName;
    int FanclubSize;
    String LogoURL;
    int YouthTeamID;
    String YouthTeamName;
    int NumberOfVisits;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public void setShortTeamName(String shortTeamName) {
        ShortTeamName = shortTeamName;
    }

    public boolean isIsPrimaryClub() {
        return IsPrimaryClub;
    }

    public void setIsPrimaryClub(String isPrimaryClub) {
        IsPrimaryClub = isPrimaryClub.equals("1") ? true : false;
    }

    public String getFoundedDate() {
        return FoundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        FoundedDate = foundedDate;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public void setArenaID(int arenaID) {
        ArenaID = arenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public int getRegionID() {
        return RegionID;
    }

    public void setRegionID(int regionID) {
        RegionID = regionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public String getHomePage() {
        return HomePage;
    }

    public void setHomePage(String homePage) {
        HomePage = homePage;
    }

    public String getDressURI() {
        return DressURI;
    }

    public void setDressURI(String dressURI) {
        DressURI = dressURI;
    }

    public String getDressAlternateURI() {
        return DressAlternateURI;
    }

    public void setDressAlternateURI(String dressAlternateURI) {
        DressAlternateURI = dressAlternateURI;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public void setLeagueLevelUnitID(int leagueLevelUnitID) {
        LeagueLevelUnitID = leagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        LeagueLevelUnitName = leagueLevelUnitName;
    }

    public boolean isBot() {
        return Bot;
    }

    public void setBot(String bot) {
        Bot = bot.equals("1") ? true : false;
    }

    public boolean isStillInCup() {
        return StillInCup;
    }

    public void setStillInCup(String stillInCup) {
        StillInCup = stillInCup.equals("1") ? true : false;
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

    public int getFriendlyTeamID() {
        return FriendlyTeamID;
    }

    public void setFriendlyTeamID(int friendlyTeamID) {
        FriendlyTeamID = friendlyTeamID;
    }

    public int getNumberOfVictories() {
        return NumberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        NumberOfVictories = numberOfVictories;
    }

    public int getNumberOfUndefeated() {
        return NumberOfUndefeated;
    }

    public void setNumberOfUndefeated(int numberOfUndefeated) {
        NumberOfUndefeated = numberOfUndefeated;
    }

    public int getTeamRank() {
        return TeamRank;
    }

    public void setTeamRank(int teamRank) {
        TeamRank = teamRank;
    }

    public int getFanclubID() {
        return FanclubID;
    }

    public void setFanclubID(int fanclubID) {
        FanclubID = fanclubID;
    }

    public String getFanclubName() {
        return FanclubName;
    }

    public void setFanclubName(String fanclubName) {
        FanclubName = fanclubName;
    }

    public int getFanclubSize() {
        return FanclubSize;
    }

    public void setFanclubSize(int fanclubSize) {
        FanclubSize = fanclubSize;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public void setLogoURL(String logoURL) {
        LogoURL = logoURL;
    }

    public int getYouthTeamID() {
        return YouthTeamID;
    }

    public void setYouthTeamID(int youthTeamID) {
        YouthTeamID = youthTeamID;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public void setYouthTeamName(String youthTeamName) {
        YouthTeamName = youthTeamName;
    }

    public int getNumberOfVisits() {
        return NumberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        NumberOfVisits = numberOfVisits;
    }

    public int getCupLeagueLevel() {
        return CupLeagueLevel;
    }

    public void setCupLeagueLevel(int CupLeagueLevel) {
        this.CupLeagueLevel = CupLeagueLevel;
    }

    public int getCupLevel() {
        return CupLevel;
    }

    public void setCupLevel(int CupLevel) {
        this.CupLevel = CupLevel;
    }

    public int getCupLevelIndex() {
        return CupLevelIndex;
    }

    public void setCupLevelIndex(int CupLevelIndex) {
        this.CupLevelIndex = CupLevelIndex;
    }

    public int getCupMatchRound() {
        return MatchRound;
    }

    public void setCupMatchRound(int MatchRound) {
        this.MatchRound = MatchRound;
    }

    public int getCupMatchRoundsLeft() {
        return MatchRoundsLeft;
    }

    public void setCupMatchRoundsLeft(int MatchRoundsLeft) {
        this.MatchRoundsLeft = MatchRoundsLeft;
    }
}
