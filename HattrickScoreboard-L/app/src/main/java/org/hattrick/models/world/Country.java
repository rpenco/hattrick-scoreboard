package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Country {

    @Element
    int CountryID;

    @Element
    String CountryName;

    @Element
    String CurrencyName;

    @Element
    String CurrencyRate;

    @Element
    String DateFormat;

    @Element
    String TimeFormat;

    @ElementList(required = false)
    ArrayList<Region> RegionList;

    public ArrayList<Region> getRegionList() {
        return RegionList;
    }

    public double getCurrencyRate() {
        String currency = CurrencyRate.replaceAll(",", ".");
        return Double.parseDouble(currency);
    }

    public int getCountryID() {
        return CountryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public String getDateFormat() {
        return DateFormat;
    }

    public String getTimeFormat() {
        return TimeFormat;
    }
}
