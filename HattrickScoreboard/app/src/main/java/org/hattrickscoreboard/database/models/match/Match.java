package org.hattrickscoreboard.database.models.match;

import org.hattrickscoreboard.database.models.DModel;

public class Match extends DModel {

    long _id;
    int MatchID;
    String SourceSystem;
    boolean IsYouth;
    String MatchDate;
    int MatchType;
    int MatchContext;

    int HomeTeamID;
    String HomeTeamName;
    String HomeTeamShortName;
    String HomeFormation;
    int HomeTacticType;
    int HomeTacticSkill;
    int HomeExperienceLevel;
    String HomeDressURI;
    int HomeTeamAttitude;
    int HomeRatingMidfield;
    int HomeRatingRightDef;
    int HomeRatingMidDef;
    int HomeRatingLeftDef;
    int HomeRatingRightAtt;
    int HomeRatingMidAtt;
    int HomeRatingLeftAtt;
    int HomeRatingIndirectSetPiecesDef;
    int HomeRatingIndirectSetPiecesAtt;

    int awayTeamID;
    String awayTeamName;
    String awayTeamShortName;
    String AwayFormation;
    int AwayTacticType;
    int AwayTacticSkill;
    int AwayExperienceLevel;
    String AwayDressURI;
    int AwayTeamAttitude;
    int AwayRatingMidfield;
    int AwayRatingRightDef;
    int AwayRatingMidDef;
    int AwayRatingLeftDef;
    int AwayRatingRightAtt;
    int AwayRatingMidAtt;
    int AwayRatingLeftAtt;
    int AwayRatingIndirectSetPiecesDef;
    int AwayRatingIndirectSetPiecesAtt;

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
    int homeGoals;
    int awayGoals;
    String MatchFinishedDate;
    String matchStatus;
    private boolean OrdersGiven;
    private int Referee;
    private int RefereeAssistant1;
    private int RefereeAssistant2;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public boolean isMatchYouth() {
        return IsYouth;
    }

    public void setMatchYouth(String isYouth) {
        if (isYouth != null)
            IsYouth = isYouth.equals("1");
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public void setMatchType(int matchType) {
        MatchType = matchType;
    }

    public int getMatchContext() {
        return MatchContext;
    }

    public void setMatchContext(int matchContext) {
        MatchContext = matchContext;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public void setHomeTeamID(int homeTeamID) {
        HomeTeamID = homeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getHomeTeamShortName() {
        return HomeTeamShortName;
    }

    public void setHomeTeamShortName(String homeTeamShortName) {
        HomeTeamShortName = homeTeamShortName;
    }

    public String getHomeFormation() {
        return HomeFormation;
    }

    public void setHomeFormation(String homeFormation) {
        HomeFormation = homeFormation;
    }

    public int getHomeTacticType() {
        return HomeTacticType;
    }

    public void setHomeTacticType(int homeTacticType) {
        HomeTacticType = homeTacticType;
    }

    public int getHomeTacticSkill() {
        return HomeTacticSkill;
    }

    public void setHomeTacticSkill(int homeTacticSkill) {
        HomeTacticSkill = homeTacticSkill;
    }

    public int getHomeExperienceLevel() {
        return HomeExperienceLevel;
    }

    public void setHomeExperienceLevel(int homeExperienceLevel) {
        HomeExperienceLevel = homeExperienceLevel;
    }

    public String getHomeDressURI() {
        return HomeDressURI;
    }

    public void setHomeDressURI(String homeDressURI) {
        HomeDressURI = homeDressURI;
    }

    public int getHomeTeamAttitude() {
        return HomeTeamAttitude;
    }

    public void setHomeTeamAttitude(int homeTeamAttitude) {
        HomeTeamAttitude = homeTeamAttitude;
    }

    public int getHomeRatingMidfield() {
        return HomeRatingMidfield;
    }

    public void setHomeRatingMidfield(int homeRatingMidfield) {
        HomeRatingMidfield = homeRatingMidfield;
    }

    public int getHomeRatingRightDef() {
        return HomeRatingRightDef;
    }

    public void setHomeRatingRightDef(int homeRatingRightDef) {
        HomeRatingRightDef = homeRatingRightDef;
    }

    public int getHomeRatingMidDef() {
        return HomeRatingMidDef;
    }

    public void setHomeRatingMidDef(int homeRatingMidDef) {
        HomeRatingMidDef = homeRatingMidDef;
    }

    public int getHomeRatingLeftDef() {
        return HomeRatingLeftDef;
    }

    public void setHomeRatingLeftDef(int homeRatingLeftDef) {
        HomeRatingLeftDef = homeRatingLeftDef;
    }

    public int getHomeRatingRightAtt() {
        return HomeRatingRightAtt;
    }

    public void setHomeRatingRightAtt(int homeRatingRightAtt) {
        HomeRatingRightAtt = homeRatingRightAtt;
    }

    public int getHomeRatingMidAtt() {
        return HomeRatingMidAtt;
    }

    public void setHomeRatingMidAtt(int homeRatingMidAtt) {
        HomeRatingMidAtt = homeRatingMidAtt;
    }

    public int getHomeRatingLeftAtt() {
        return HomeRatingLeftAtt;
    }

    public void setHomeRatingLeftAtt(int homeRatingLeftAtt) {
        HomeRatingLeftAtt = homeRatingLeftAtt;
    }

    public int getHomeRatingIndirectSetPiecesDef() {
        return HomeRatingIndirectSetPiecesDef;
    }

    public void setHomeRatingIndirectSetPiecesDef(
            int homeRatingIndirectSetPiecesDef) {
        HomeRatingIndirectSetPiecesDef = homeRatingIndirectSetPiecesDef;
    }

    public int getHomeRatingIndirectSetPiecesAtt() {
        return HomeRatingIndirectSetPiecesAtt;
    }

    public void setHomeRatingIndirectSetPiecesAtt(
            int homeRatingIndirectSetPiecesAtt) {
        HomeRatingIndirectSetPiecesAtt = homeRatingIndirectSetPiecesAtt;
    }

    public int getAwayTeamID() {
        return awayTeamID;
    }

    public void setAwayTeamID(int awayTeamId) {
        this.awayTeamID = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getAwayTeamShortName() {
        return awayTeamShortName;
    }

    public void setAwayTeamShortName(String awayTeamShortName) {
        this.awayTeamShortName = awayTeamShortName;
    }

    public String getAwayFormation() {
        return AwayFormation;
    }

    public void setAwayFormation(String awayFormation) {
        AwayFormation = awayFormation;
    }

    public int getAwayTacticType() {
        return AwayTacticType;
    }

    public void setAwayTacticType(int awayTacticType) {
        AwayTacticType = awayTacticType;
    }

    public int getAwayTacticSkill() {
        return AwayTacticSkill;
    }

    public void setAwayTacticSkill(int awayTacticSkill) {
        AwayTacticSkill = awayTacticSkill;
    }

    public int getAwayExperienceLevel() {
        return AwayExperienceLevel;
    }

    public void setAwayExperienceLevel(int awayExperienceLevel) {
        AwayExperienceLevel = awayExperienceLevel;
    }

    public String getAwayDressURI() {
        return AwayDressURI;
    }

    public void setAwayDressURI(String awayDressURI) {
        AwayDressURI = awayDressURI;
    }

    public int getAwayTeamAttitude() {
        return AwayTeamAttitude;
    }

    public void setAwayTeamAttitude(int awayTeamAttitude) {
        AwayTeamAttitude = awayTeamAttitude;
    }

    public int getAwayRatingMidfield() {
        return AwayRatingMidfield;
    }

    public void setAwayRatingMidfield(int awayRatingMidfield) {
        AwayRatingMidfield = awayRatingMidfield;
    }

    public int getAwayRatingRightDef() {
        return AwayRatingRightDef;
    }

    public void setAwayRatingRightDef(int awayRatingRightDef) {
        AwayRatingRightDef = awayRatingRightDef;
    }

    public int getAwayRatingMidDef() {
        return AwayRatingMidDef;
    }

    public void setAwayRatingMidDef(int awayRatingMidDef) {
        AwayRatingMidDef = awayRatingMidDef;
    }

    public int getAwayRatingLeftDef() {
        return AwayRatingLeftDef;
    }

    public void setAwayRatingLeftDef(int awayRatingLeftDef) {
        AwayRatingLeftDef = awayRatingLeftDef;
    }

    public int getAwayRatingRightAtt() {
        return AwayRatingRightAtt;
    }

    public void setAwayRatingRightAtt(int awayRatingRightAtt) {
        AwayRatingRightAtt = awayRatingRightAtt;
    }

    public int getAwayRatingMidAtt() {
        return AwayRatingMidAtt;
    }

    public void setAwayRatingMidAtt(int awayRatingMidAtt) {
        AwayRatingMidAtt = awayRatingMidAtt;
    }

    public int getAwayRatingLeftAtt() {
        return AwayRatingLeftAtt;
    }

    public void setAwayRatingLeftAtt(int awayRatingLeftAtt) {
        AwayRatingLeftAtt = awayRatingLeftAtt;
    }

    public int getAwayRatingIndirectSetPiecesDef() {
        return AwayRatingIndirectSetPiecesDef;
    }

    public void setAwayRatingIndirectSetPiecesDef(
            int awayRatingIndirectSetPiecesDef) {
        AwayRatingIndirectSetPiecesDef = awayRatingIndirectSetPiecesDef;
    }

    public int getAwayRatingIndirectSetPiecesAtt() {
        return AwayRatingIndirectSetPiecesAtt;
    }

    public void setAwayRatingIndirectSetPiecesAtt(
            int awayRatingIndirectSetPiecesAtt) {
        AwayRatingIndirectSetPiecesAtt = awayRatingIndirectSetPiecesAtt;
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

    public int getWeatherID() {
        return WeatherID;
    }

    public void setWeatherID(int weatherID) {
        WeatherID = weatherID;
    }

    public int getSoldTotal() {
        return SoldTotal;
    }

    public void setSoldTotal(int soldTotal) {
        SoldTotal = soldTotal;
    }

    public int getSoldTerraces() {
        return SoldTerraces;
    }

    public void setSoldTerraces(int soldTerraces) {
        SoldTerraces = soldTerraces;
    }

    public int getSoldBasic() {
        return SoldBasic;
    }

    public void setSoldBasic(int soldBasic) {
        SoldBasic = soldBasic;
    }

    public int getSoldRoof() {
        return SoldRoof;
    }

    public void setSoldRoof(int soldRoof) {
        SoldRoof = soldRoof;
    }

    public int getSoldVIP() {
        return SoldVIP;
    }

    public void setSoldVIP(int soldVIP) {
        SoldVIP = soldVIP;
    }

    public int getPossessionFirstHalfHome() {
        return PossessionFirstHalfHome;
    }

    public void setPossessionFirstHalfHome(int possessionFirstHalfHome) {
        PossessionFirstHalfHome = possessionFirstHalfHome;
    }

    public int getPossessionFirstHalfAway() {
        return PossessionFirstHalfAway;
    }

    public void setPossessionFirstHalfAway(int possessionFirstHalfAway) {
        PossessionFirstHalfAway = possessionFirstHalfAway;
    }

    public int getPossessionSecondHalfHome() {
        return PossessionSecondHalfHome;
    }

    public void setPossessionSecondHalfHome(int possessionSecondHalfHome) {
        PossessionSecondHalfHome = possessionSecondHalfHome;
    }

    public int getPossessionSecondHalfAway() {
        return PossessionSecondHalfAway;
    }

    public void setPossessionSecondHalfAway(int possessionSecondHalfAway) {
        PossessionSecondHalfAway = possessionSecondHalfAway;
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

    public String getMatchFinishedDate() {
        return MatchFinishedDate;
    }

    public void setMatchFinishedDate(String matchFinishedDate) {
        MatchFinishedDate = matchFinishedDate;
    }

    public String getStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public boolean isOrdersGiven() {
        return this.OrdersGiven;
    }

    public void setOrdersGiven(String ordersGiven) {
        if (ordersGiven != null)
            this.OrdersGiven = ordersGiven.equals("1");
    }

    public int getReferee() {
        return this.Referee;
    }

    public void setReferee(int referee) {
        this.Referee = referee;
    }

    public int getRefereeAssistant1() {
        return this.RefereeAssistant1;
    }

    public void setRefereeAssistant1(int referee1) {
        this.RefereeAssistant1 = referee1;
    }

    public int getRefereeAssistant2() {
        return this.RefereeAssistant2;
    }

    public void setRefereeAssistant2(int referee2) {
        this.RefereeAssistant2 = referee2;
    }
}
