package org.hattrickscoreboardl.database.models.nationals;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HNationalTeam extends HModel{

    public HNationalTeam(){}

   
    boolean IsPlayingMatch;
    
    int TeamID;

    String TeamName;

    String ShortTeamName;

    int NationalCoachUserID;

    String NationalCoachLoginname;

    int LeagueID;

    String LeagueName;

    int TrainerID;

    String TrainerName;

    String HomePage;

    String Logo;

    String DressURI;

    String DressAlternateURI;

    int Experience433;

    int Experience451;

    int Experience352;

    int Experience532;

    int Experience343;

    int Experience541;

    int Experience523;

    int Experience550;

    int Experience253;

    int Experience442;

    int Morale;

    int SelfConfidence;

    int SupportersPopularity;

    int RatingScore;

    int FanClubSize;

    int Rank;

    int LeagueOfficeTypeID;

    int CupID;

    String FetchedDate;

    public int getCupID() {
        return CupID;
    }

    public boolean isPlayingMatch() {
        return IsPlayingMatch;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public int getNationalCoachUserID() {
        return NationalCoachUserID;
    }

    public String getNationalCoachLoginname() {
        return NationalCoachLoginname;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public String getTrainerName() {
        return TrainerName;
    }

    public String getHomePage() {
        return HomePage;
    }

    public String getLogo() {
        return Logo;
    }

    public String getDressURI() {
        return DressURI;
    }

    public String getDressAlternateURI() {
        return DressAlternateURI;
    }

    public int getExperience433() {
        return Experience433;
    }

    public int getExperience451() {
        return Experience451;
    }

    public int getExperience352() {
        return Experience352;
    }

    public int getExperience532() {
        return Experience532;
    }

    public int getExperience343() {
        return Experience343;
    }

    public int getExperience541() {
        return Experience541;
    }

    public int getExperience523() {
        return Experience523;
    }

    public int getExperience550() {
        return Experience550;
    }

    public int getExperience253() {
        return Experience253;
    }

    public int getExperience442() {
        return Experience442;
    }

    public int getMorale() {
        return Morale;
    }

    public int getSelfConfidence() {
        return SelfConfidence;
    }

    public int getSupportersPopularity() {
        return SupportersPopularity;
    }

    public int getRatingScore() {
        return RatingScore;
    }

    public int getFanClubSize() {
        return FanClubSize;
    }

    public int getRank() {
        return Rank;
    }

    public int getLeagueOfficeTypeID() {
        return LeagueOfficeTypeID;
    }
    public String getFetchedDate() {
        return FetchedDate;
    }

    //


    public void setPlayingMatch(boolean isPlayingMatch) {
        IsPlayingMatch = isPlayingMatch;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public void setShortTeamName(String shortTeamName) {
        ShortTeamName = shortTeamName;
    }

    public void setNationalCoachUserID(int nationalCoachUserID) {
        NationalCoachUserID = nationalCoachUserID;
    }

    public void setNationalCoachLoginname(String nationalCoachLoginname) {
        NationalCoachLoginname = nationalCoachLoginname;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public void setTrainerID(int trainerID) {
        TrainerID = trainerID;
    }

    public void setTrainerName(String trainerName) {
        TrainerName = trainerName;
    }

    public void setHomePage(String homePage) {
        HomePage = homePage;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public void setDressURI(String dressURI) {
        DressURI = dressURI;
    }

    public void setDressAlternateURI(String dressAlternateURI) {
        DressAlternateURI = dressAlternateURI;
    }

    public void setExperience433(int experience433) {
        Experience433 = experience433;
    }

    public void setExperience451(int experience451) {
        Experience451 = experience451;
    }

    public void setExperience352(int experience352) {
        Experience352 = experience352;
    }

    public void setExperience532(int experience532) {
        Experience532 = experience532;
    }

    public void setExperience343(int experience343) {
        Experience343 = experience343;
    }

    public void setExperience541(int experience541) {
        Experience541 = experience541;
    }

    public void setExperience523(int experience523) {
        Experience523 = experience523;
    }

    public void setExperience550(int experience550) {
        Experience550 = experience550;
    }

    public void setExperience253(int experience253) {
        Experience253 = experience253;
    }

    public void setExperience442(int experience442) {
        Experience442 = experience442;
    }

    public void setMorale(int morale) {
        Morale = morale;
    }

    public void setSelfConfidence(int selfConfidence) {
        SelfConfidence = selfConfidence;
    }

    public void setSupportersPopularity(int supportersPopularity) {
        SupportersPopularity = supportersPopularity;
    }

    public void setRatingScore(int ratingScore) {
        RatingScore = ratingScore;
    }

    public void setFanClubSize(int fanClubSize) {
        FanClubSize = fanClubSize;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public void setLeagueOfficeTypeID(int leagueOfficeTypeID) {
        LeagueOfficeTypeID = leagueOfficeTypeID;
    }

    public void setCupID(int cupID) {
        CupID = cupID;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }


}
