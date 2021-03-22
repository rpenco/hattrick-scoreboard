package org.hattrickscoreboard.database.models;

public class DWorld extends DModel {

    long _id;
    int LeagueID;
    String LeagueName;
    int Season;
    int SeasonOffset;
    int MatchRound;
    String ShortName;
    String Continent;
    String ZoneName;
    String EnglishName;
    int CountryID;
    String CountryName;
    String CurrencyName;
    float CurrencyRate;
    String DateFormat;
    String TimeFormat;
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

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
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

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public float getCurrencyRate() {
        return CurrencyRate;
    }

    public void setCurrencyRate(float currencyRate) {
        CurrencyRate = currencyRate;
    }

    public String getDateFormat() {
        return DateFormat;
    }

    public void setDateFormat(String dateFormat) {
        DateFormat = dateFormat;
    }

    public String getTimeFormat() {
        return TimeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        TimeFormat = timeFormat;
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

}
