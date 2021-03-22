package org.hattrickscoreboardl.database.models.world;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HWorldLeague extends HModel {

    public HWorldLeague(){}

    int LeagueID;

    String LeagueName;

    int Season;

    int SeasonOffset;

    int MatchRound;

    String ShortName;

    String Continent;

    String ZoneName;

    String EnglishName;

    int NationalTeamId;

    int U20TeamId;

    int ActiveTeams;

    int ActiveUsers;

    int WaitingUsers;

    String TrainingDate;

    String EconomyDate;

    String CupMatchDate;

    String SeriesMatchDate;

    int NumberOfLevels;

    int CountryID;

    String FetchedDate;

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

    public int getSeason() {
        return Season;
    }

    public void setSeason(int season) {
        Season = season;
    }

    public int getSeasonOffset() {
        return SeasonOffset;
    }

    public void setSeasonOffset(int seasonOffset) {
        SeasonOffset = seasonOffset;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public void setMatchRound(int matchRound) {
        MatchRound = matchRound;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public int getNationalTeamId() {
        return NationalTeamId;
    }

    public void setNationalTeamId(int nationalTeamId) {
        NationalTeamId = nationalTeamId;
    }

    public int getU20TeamId() {
        return U20TeamId;
    }

    public void setU20TeamId(int u20TeamId) {
        U20TeamId = u20TeamId;
    }

    public int getActiveTeams() {
        return ActiveTeams;
    }

    public void setActiveTeams(int activeTeams) {
        ActiveTeams = activeTeams;
    }

    public int getActiveUsers() {
        return ActiveUsers;
    }

    public void setActiveUsers(int activeUsers) {
        ActiveUsers = activeUsers;
    }

    public int getWaitingUsers() {
        return WaitingUsers;
    }

    public void setWaitingUsers(int waitingUsers) {
        WaitingUsers = waitingUsers;
    }

    public String getTrainingDate() {
        return TrainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        TrainingDate = trainingDate;
    }

    public String getEconomyDate() {
        return EconomyDate;
    }

    public void setEconomyDate(String economyDate) {
        EconomyDate = economyDate;
    }

    public String getCupMatchDate() {
        return CupMatchDate;
    }

    public void setCupMatchDate(String cupMatchDate) {
        CupMatchDate = cupMatchDate;
    }

    public String getSeriesMatchDate() {
        return SeriesMatchDate;
    }

    public void setSeriesMatchDate(String seriesMatchDate) {
        SeriesMatchDate = seriesMatchDate;
    }

    public int getNumberOfLevels() {
        return NumberOfLevels;
    }

    public void setNumberOfLevels(int numberOfLevels) {
        NumberOfLevels = numberOfLevels;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }
}
