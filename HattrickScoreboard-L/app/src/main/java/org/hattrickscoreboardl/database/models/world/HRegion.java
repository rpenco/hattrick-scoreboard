package org.hattrickscoreboardl.database.models.world;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HRegion extends HModel {

    public HRegion(){}

    int CountryID;

    int RegionID;

    String RegionName;


    //From Region

    int LeagueID;

    int WeatherID;

    int TomorrowWeatherID;

    int NumberOfUsers;

    int NumberOfOnline;

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
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

    public int getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public int getWeatherID() {
        return WeatherID;
    }

    public void setWeatherID(int weatherID) {
        WeatherID = weatherID;
    }

    public int getTomorrowWeatherID() {
        return TomorrowWeatherID;
    }

    public void setTomorrowWeatherID(int tomorrowWeatherID) {
        TomorrowWeatherID = tomorrowWeatherID;
    }

    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        NumberOfUsers = numberOfUsers;
    }

    public int getNumberOfOnline() {
        return NumberOfOnline;
    }

    public void setNumberOfOnline(int numberOfOnline) {
        NumberOfOnline = numberOfOnline;
    }
}
