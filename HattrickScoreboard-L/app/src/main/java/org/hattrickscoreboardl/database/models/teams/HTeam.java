package org.hattrickscoreboardl.database.models.teams;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HTeam extends HModel {


    public HTeam(){}

    int UserID;

    int TeamID;

    String TeamName;

    boolean IsPrimaryClub;

    String FoundedDate;

    int ArenaID;

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

    int LeagueLevel;

    boolean bot;

    String BotSince;

    boolean StillInCup;

    int CupID;

    String CupName;

    int CupLeagueLevel;

    int CupLevel;

    int CupLevelIndex;

    int MatchRound;

    int MatchRoundsLeft;

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

    String FetchedDate;

    //From league details team

    int Position;

    int PositionChange;

    int Matches;

    int GoalsFor;

    int GoalsAgainst;

    int Points;

    int Won;

    int Draws;

    int Lost;


    public int getUserID() {
        return UserID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }


    public boolean isPrimaryClub() {
        return IsPrimaryClub;
    }

    public String getFoundedDate() {
        return FoundedDate;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getRegionID() {
        return RegionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public String getHomePage() {
        return HomePage;
    }

    public String getDressURI() {
        return DressURI;
    }

    public String getDressAlternateURI() {
        return DressAlternateURI;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public boolean isBot() {
        return bot;
    }

    public String getBotSince() {
        return BotSince;
    }

    public boolean isStillInCup() {
        return StillInCup;
    }

    public int getCupID() {
        return CupID;
    }

    public String getCupName() {
        return CupName;
    }

    public int getCupLeagueLevel() {
        return CupLeagueLevel;
    }

    public int getCupLevel() {
        return CupLevel;
    }

    public int getCupLevelIndex() {
        return CupLevelIndex;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public int getMatchRoundsLeft() {
        return MatchRoundsLeft;
    }

    public int getFriendlyTeamID() {
        return FriendlyTeamID;
    }

    public int getNumberOfVictories() {
        return NumberOfVictories;
    }

    public int getNumberOfUndefeated() {
        return NumberOfUndefeated;
    }

    public int getTeamRank() {
        return TeamRank;
    }

    public int getFanclubID() {
        return FanclubID;
    }

    public String getFanclubName() {
        return FanclubName;
    }

    public int getFanclubSize() {
        return FanclubSize;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public int getYouthTeamID() {
        return YouthTeamID;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public int getNumberOfVisits() {
        return NumberOfVisits;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    //Setter

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }


    public void setPrimaryClub(boolean isPrimaryClub) {
        IsPrimaryClub = isPrimaryClub;
    }

    public void setFoundedDate(String foundedDate) {
        FoundedDate = foundedDate;
    }

    public void setArenaID(int arenaID) {
        ArenaID = arenaID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public void setRegionID(int regionID) {
        RegionID = regionID;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public void setHomePage(String homePage) {
        HomePage = homePage;
    }

    public void setDressURI(String dressURI) {
        DressURI = dressURI;
    }

    public void setDressAlternateURI(String dressAlternateURI) {
        DressAlternateURI = dressAlternateURI;
    }

    public void setLeagueLevelUnitID(int leagueLevelUnitID) {
        LeagueLevelUnitID = leagueLevelUnitID;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        LeagueLevelUnitName = leagueLevelUnitName;
    }

    public void setLeagueLevel(int leagueLevel) {
        LeagueLevel = leagueLevel;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public void setBotSince(String botSince) {
        BotSince = botSince;
    }

    public void setStillInCup(boolean stillInCup) {
        StillInCup = stillInCup;
    }

    public void setCupID(int cupID) {
        CupID = cupID;
    }

    public void setCupName(String cupName) {
        CupName = cupName;
    }

    public void setCupLeagueLevel(int cupLeagueLevel) {
        CupLeagueLevel = cupLeagueLevel;
    }

    public void setCupLevel(int cupLevel) {
        CupLevel = cupLevel;
    }

    public void setCupLevelIndex(int cupLevelIndex) {
        CupLevelIndex = cupLevelIndex;
    }

    public void setMatchRound(int matchRound) {
        MatchRound = matchRound;
    }

    public void setMatchRoundsLeft(int matchRoundsLeft) {
        MatchRoundsLeft = matchRoundsLeft;
    }

    public void setFriendlyTeamID(int friendlyTeamID) {
        FriendlyTeamID = friendlyTeamID;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        NumberOfVictories = numberOfVictories;
    }

    public void setNumberOfUndefeated(int numberOfUndefeated) {
        NumberOfUndefeated = numberOfUndefeated;
    }

    public void setTeamRank(int teamRank) {
        TeamRank = teamRank;
    }

    public void setFanclubID(int fanclubID) {
        FanclubID = fanclubID;
    }

    public void setFanclubName(String fanclubName) {
        FanclubName = fanclubName;
    }

    public void setFanclubSize(int fanclubSize) {
        FanclubSize = fanclubSize;
    }

    public void setLogoURL(String logoURL) {
        LogoURL = logoURL;
    }

    public void setYouthTeamID(int youthTeamID) {
        YouthTeamID = youthTeamID;
    }

    public void setYouthTeamName(String youthTeamName) {
        YouthTeamName = youthTeamName;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        NumberOfVisits = numberOfVisits;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public int getPositionChange() {
        return PositionChange;
    }

    public void setPositionChange(int positionChange) {
        PositionChange = positionChange;
    }

    public int getMatches() {
        return Matches;
    }

    public void setMatches(int matches) {
        Matches = matches;
    }

    public int getGoalsFor() {
        return GoalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        GoalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return GoalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        GoalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        Points = points;
    }

    public int getWon() {
        return Won;
    }

    public void setWon(int won) {
        Won = won;
    }

    public int getDraws() {
        return Draws;
    }

    public void setDraws(int draws) {
        Draws = draws;
    }

    public int getLost() {
        return Lost;
    }

    public void setLost(int lost) {
        Lost = lost;
    }
}

