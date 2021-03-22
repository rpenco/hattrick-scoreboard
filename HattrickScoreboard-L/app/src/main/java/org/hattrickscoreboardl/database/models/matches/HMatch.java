package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

import java.util.List;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HMatch extends HModel {


    public HMatch(){ }

    int MatchID;

    int HomeTeamID;

    String HomeTeamName;

    int AwayTeamID;

    String AwayTeamName;

    String MatchDate;

    String SourceSystem;

    int MatchType;

    int MatchContextId;

    int HomeGoals;

    int AwayGoals;

    String Status;

    boolean OrdersGiven;

    //From fans
    int FanMatchExpectation;

    int FanMoodAfterMatch;

    //From match details

    String FinishedDate;

    int ArenaID;

    String ArenaName;

    int WeatherID;

    int SoldTotal;

    int SoldTerraces;

    int SoldBasic;

    int SoldRoof;

    int SoldVIP;

    int PossessionFirstHalfHome;

    int PossessionFirstHalfAway;

    int PossessionSecondHalfHome;

    int PossessionSecondHalfAway;

    int RefereeID;

    int RefereeAssistant1ID;

    int RefereeAssistant2ID;

    //Home team

    String HomeFormation;

    int HomeTacticType;

    int HomeTacticSkill;

    int HomeRatingMidfield;

    int HomeRatingRightDef;

    int HomeRatingMidDef;

    int HomeRatingLeftDef;

    int HomeRatingRightAtt;

    int HomeRatingMidAtt;

    int HomeRatingLeftAtt;

    int HomeTeamAttitude;

    int HomeRatingIndirectSetPiecesDef;

    int HomeRatingIndirectSetPiecesAtt;


    //Away team

    String AwayFormation;

    int AwayTacticType;

    int AwayTacticSkill;

    int AwayRatingMidfield;

    int AwayRatingRightDef;

    int AwayRatingMidDef;

    int AwayRatingLeftDef;

    int AwayRatingRightAtt;

    int AwayRatingMidAtt;

    int AwayRatingLeftAtt;

    int AwayTeamAttitude;

    int AwayRatingIndirectSetPiecesDef;

    int AwayRatingIndirectSetPiecesAtt;

    String FetchedDate;

    //From lineup
    int HomeExperienceLevel;

    int AwayExperienceLevel;

    //From series fixtures

    int LeagueLevelUnitID;

    String LeagueLevelUnitName;

    int MatchRound;

    //From Cup
    int CupLeagueLevel;

    int CupLevel;

    int CupLevelIndex;

    int CupID;

    int CupMatchRound;


    public int getMatchID() {
        return MatchID;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public int getMatchType() {
        return MatchType;
    }

    public int getMatchContextId() {
        return MatchContextId;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public String getStatus() {
        return Status;
    }

    public boolean isOrdersGiven() {
        return OrdersGiven;
    }

    public int getFanMatchExpectation() {
        return FanMatchExpectation;
    }

    public int getFanMoodAfterMatch() {
        return FanMoodAfterMatch;
    }

    public String getFinishedDate() {
        return FinishedDate;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getWeatherID() {
        return WeatherID;
    }

    public int getSoldTotal() {
        return SoldTotal;
    }

    public int getSoldTerraces() {
        return SoldTerraces;
    }

    public int getSoldBasic() {
        return SoldBasic;
    }

    public int getSoldRoof() {
        return SoldRoof;
    }

    public int getSoldVIP() {
        return SoldVIP;
    }

    public int getPossessionFirstHalfHome() {
        return PossessionFirstHalfHome;
    }

    public int getPossessionFirstHalfAway() {
        return PossessionFirstHalfAway;
    }

    public int getPossessionSecondHalfHome() {
        return PossessionSecondHalfHome;
    }

    public int getPossessionSecondHalfAway() {
        return PossessionSecondHalfAway;
    }

    public int getRefereeID() {
        return RefereeID;
    }

    public int getRefereeAssistant1ID() {
        return RefereeAssistant1ID;
    }

    public int getRefereeAssistant2ID() {
        return RefereeAssistant2ID;
    }

    public String getHomeFormation() {
        return HomeFormation;
    }

    public int getHomeTacticType() {
        return HomeTacticType;
    }

    public int getHomeTacticSkill() {
        return HomeTacticSkill;
    }

    public int getHomeRatingMidfield() {
        return HomeRatingMidfield;
    }

    public int getHomeRatingRightDef() {
        return HomeRatingRightDef;
    }

    public int getHomeRatingMidDef() {
        return HomeRatingMidDef;
    }

    public int getHomeRatingLeftDef() {
        return HomeRatingLeftDef;
    }

    public int getHomeRatingRightAtt() {
        return HomeRatingRightAtt;
    }

    public int getHomeRatingMidAtt() {
        return HomeRatingMidAtt;
    }

    public int getHomeRatingLeftAtt() {
        return HomeRatingLeftAtt;
    }

    public int getHomeTeamAttitude() {
        return HomeTeamAttitude;
    }

    public int getHomeRatingIndirectSetPiecesDef() {
        return HomeRatingIndirectSetPiecesDef;
    }

    public int getHomeRatingIndirectSetPiecesAtt() {
        return HomeRatingIndirectSetPiecesAtt;
    }

    public String getAwayFormation() {
        return AwayFormation;
    }

    public int getAwayTacticType() {
        return AwayTacticType;
    }

    public int getAwayTacticSkill() {
        return AwayTacticSkill;
    }

    public int getAwayRatingMidfield() {
        return AwayRatingMidfield;
    }

    public int getAwayRatingRightDef() {
        return AwayRatingRightDef;
    }

    public int getAwayRatingMidDef() {
        return AwayRatingMidDef;
    }

    public int getAwayRatingLeftDef() {
        return AwayRatingLeftDef;
    }

    public int getAwayRatingRightAtt() {
        return AwayRatingRightAtt;
    }

    public int getAwayRatingMidAtt() {
        return AwayRatingMidAtt;
    }

    public int getAwayRatingLeftAtt() {
        return AwayRatingLeftAtt;
    }

    public int getAwayTeamAttitude() {
        return AwayTeamAttitude;
    }

    public int getAwayRatingIndirectSetPiecesDef() {
        return AwayRatingIndirectSetPiecesDef;
    }

    public int getAwayRatingIndirectSetPiecesAtt() {
        return AwayRatingIndirectSetPiecesAtt;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public int getHomeExperienceLevel() {
        return HomeExperienceLevel;
    }

    public int getAwayExperienceLevel() {
        return AwayExperienceLevel;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
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

    public int getCupID() {
        return CupID;
    }

    public int getCupMatchRound() {
        return CupMatchRound;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public void setHomeTeamID(int homeTeamID) {
        HomeTeamID = homeTeamID;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public void setAwayTeamID(int awayTeamID) {
        AwayTeamID = awayTeamID;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public void setMatchType(int matchType) {
        MatchType = matchType;
    }

    public void setMatchContextId(int matchContextId) {
        MatchContextId = matchContextId;
    }

    public void setHomeGoals(int homeGoals) {
        HomeGoals = homeGoals;
    }

    public void setAwayGoals(int awayGoals) {
        AwayGoals = awayGoals;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setOrdersGiven(boolean ordersGiven) {
        OrdersGiven = ordersGiven;
    }

    public void setFanMatchExpectation(int fanMatchExpectation) {
        FanMatchExpectation = fanMatchExpectation;
    }

    public void setFanMoodAfterMatch(int fanMoodAfterMatch) {
        FanMoodAfterMatch = fanMoodAfterMatch;
    }

    public void setFinishedDate(String finishedDate) {
        FinishedDate = finishedDate;
    }

    public void setArenaID(int arenaID) {
        ArenaID = arenaID;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }

    public void setWeatherID(int weatherID) {
        WeatherID = weatherID;
    }

    public void setSoldTotal(int soldTotal) {
        SoldTotal = soldTotal;
    }

    public void setSoldTerraces(int soldTerraces) {
        SoldTerraces = soldTerraces;
    }

    public void setSoldBasic(int soldBasic) {
        SoldBasic = soldBasic;
    }

    public void setSoldRoof(int soldRoof) {
        SoldRoof = soldRoof;
    }

    public void setSoldVIP(int soldVIP) {
        SoldVIP = soldVIP;
    }

    public void setPossessionFirstHalfHome(int possessionFirstHalfHome) {
        PossessionFirstHalfHome = possessionFirstHalfHome;
    }

    public void setPossessionFirstHalfAway(int possessionFirstHalfAway) {
        PossessionFirstHalfAway = possessionFirstHalfAway;
    }

    public void setPossessionSecondHalfHome(int possessionSecondHalfHome) {
        PossessionSecondHalfHome = possessionSecondHalfHome;
    }

    public void setPossessionSecondHalfAway(int possessionSecondHalfAway) {
        PossessionSecondHalfAway = possessionSecondHalfAway;
    }

    public void setRefereeID(int refereeID) {
        RefereeID = refereeID;
    }

    public void setRefereeAssistant1ID(int refereeAssistant1ID) {
        RefereeAssistant1ID = refereeAssistant1ID;
    }

    public void setRefereeAssistant2ID(int refereeAssistant2ID) {
        RefereeAssistant2ID = refereeAssistant2ID;
    }

    public void setHomeFormation(String homeFormation) {
        HomeFormation = homeFormation;
    }

    public void setHomeTacticType(int homeTacticType) {
        HomeTacticType = homeTacticType;
    }

    public void setHomeTacticSkill(int homeTacticSkill) {
        HomeTacticSkill = homeTacticSkill;
    }

    public void setHomeRatingMidfield(int homeRatingMidfield) {
        HomeRatingMidfield = homeRatingMidfield;
    }

    public void setHomeRatingRightDef(int homeRatingRightDef) {
        HomeRatingRightDef = homeRatingRightDef;
    }

    public void setHomeRatingMidDef(int homeRatingMidDef) {
        HomeRatingMidDef = homeRatingMidDef;
    }

    public void setHomeRatingLeftDef(int homeRatingLeftDef) {
        HomeRatingLeftDef = homeRatingLeftDef;
    }

    public void setHomeRatingRightAtt(int homeRatingRightAtt) {
        HomeRatingRightAtt = homeRatingRightAtt;
    }

    public void setHomeRatingMidAtt(int homeRatingMidAtt) {
        HomeRatingMidAtt = homeRatingMidAtt;
    }

    public void setHomeRatingLeftAtt(int homeRatingLeftAtt) {
        HomeRatingLeftAtt = homeRatingLeftAtt;
    }

    public void setHomeTeamAttitude(int homeTeamAttitude) {
        HomeTeamAttitude = homeTeamAttitude;
    }

    public void setHomeRatingIndirectSetPiecesDef(int homeRatingIndirectSetPiecesDef) {
        HomeRatingIndirectSetPiecesDef = homeRatingIndirectSetPiecesDef;
    }

    public void setHomeRatingIndirectSetPiecesAtt(int homeRatingIndirectSetPiecesAtt) {
        HomeRatingIndirectSetPiecesAtt = homeRatingIndirectSetPiecesAtt;
    }

    public void setAwayFormation(String awayFormation) {
        AwayFormation = awayFormation;
    }

    public void setAwayTacticType(int awayTacticType) {
        AwayTacticType = awayTacticType;
    }

    public void setAwayTacticSkill(int awayTacticSkill) {
        AwayTacticSkill = awayTacticSkill;
    }

    public void setAwayRatingMidfield(int awayRatingMidfield) {
        AwayRatingMidfield = awayRatingMidfield;
    }

    public void setAwayRatingRightDef(int awayRatingRightDef) {
        AwayRatingRightDef = awayRatingRightDef;
    }

    public void setAwayRatingMidDef(int awayRatingMidDef) {
        AwayRatingMidDef = awayRatingMidDef;
    }

    public void setAwayRatingLeftDef(int awayRatingLeftDef) {
        AwayRatingLeftDef = awayRatingLeftDef;
    }

    public void setAwayRatingRightAtt(int awayRatingRightAtt) {
        AwayRatingRightAtt = awayRatingRightAtt;
    }

    public void setAwayRatingMidAtt(int awayRatingMidAtt) {
        AwayRatingMidAtt = awayRatingMidAtt;
    }

    public void setAwayRatingLeftAtt(int awayRatingLeftAtt) {
        AwayRatingLeftAtt = awayRatingLeftAtt;
    }

    public void setAwayTeamAttitude(int awayTeamAttitude) {
        AwayTeamAttitude = awayTeamAttitude;
    }

    public void setAwayRatingIndirectSetPiecesDef(int awayRatingIndirectSetPiecesDef) {
        AwayRatingIndirectSetPiecesDef = awayRatingIndirectSetPiecesDef;
    }

    public void setAwayRatingIndirectSetPiecesAtt(int awayRatingIndirectSetPiecesAtt) {
        AwayRatingIndirectSetPiecesAtt = awayRatingIndirectSetPiecesAtt;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public void setHomeExperienceLevel(int homeExperienceLevel) {
        HomeExperienceLevel = homeExperienceLevel;
    }

    public void setAwayExperienceLevel(int awayExperienceLevel) {
        AwayExperienceLevel = awayExperienceLevel;
    }

    public void setLeagueLevelUnitID(int leagueLevelUnitID) {
        LeagueLevelUnitID = leagueLevelUnitID;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        LeagueLevelUnitName = leagueLevelUnitName;
    }

    public void setMatchRound(int matchRound) {
        this.MatchRound = matchRound;
    }

    public int getMatchRound() {
        return MatchRound;
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

    public void setCupID(int cupID) {
        CupID = cupID;
    }

    public void setCupMatchRound(int cupMatchRound) {
        CupMatchRound = cupMatchRound;
    }

    ////////////////////////////

    public static List<HMatch> findSeries(int teamID,String andOther, String order, int limit){
        return HMatch.find(HMatch.class,
                "(HOME_TEAM_ID = ? or AWAY_TEAM_ID = ?) " +
                        "and (     MATCH_TYPE = 1 " +
                        "       or MATCH_TYPE = 2 " +
                        "       or MATCH_TYPE = 3 " +
                        "       or MATCH_TYPE = 7 " +
                        "       or MATCH_TYPE = 10 " +
                        "       or MATCH_TYPE = 11 " +
                        "       or MATCH_TYPE = 100 ) " +
                        ((andOther != null)? "and "+andOther : ""),
                new String[]{String.valueOf(teamID), String.valueOf(teamID)}, null, order, String.valueOf(limit));
    }
}

