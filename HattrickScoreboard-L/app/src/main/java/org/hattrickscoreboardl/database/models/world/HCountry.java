package org.hattrickscoreboardl.database.models.world;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HCountry extends HModel {

    public HCountry(){}

    int CountryID;

    String CountryName;

    String CurrencyName;

    double CurrencyRate;

    String DateFormat;

    String TimeFormat;

    public int getCountryID() {
        return CountryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public double getCurrencyRate() {
        return CurrencyRate;
    }

    public String getDateFormat() {
        return DateFormat;
    }

    public String getTimeFormat() {
        return TimeFormat;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public void setCurrencyRate(double currencyRate) {
        CurrencyRate = currencyRate;
    }

    public void setDateFormat(String dateFormat) {
        DateFormat = dateFormat;
    }

    public void setTimeFormat(String timeFormat) {
        TimeFormat = timeFormat;
    }
}
