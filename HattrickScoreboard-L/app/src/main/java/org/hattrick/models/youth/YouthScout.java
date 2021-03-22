package org.hattrick.models.youth;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class YouthScout {

    @Element
    int YouthScoutID;

    @Element
    String ScoutName;

    @Element
    int Age;

    @Element
    @Path("Country")
    int CountryID;

    @Element
    @Path("Country")
    String CountryName;

    @Element
    @Path("Region")
    int RegionID;

    @Element
    @Path("Region")
    String RegionName;

    @Element(name = "CountryID")
    @Path("InCountry")
    int InCountryID;

    @Element(name = "CountryName")
    @Path("InCountry")
    String InCountryName;

    @Element(name = "RegionID")
    @Path("InRegion")
    int InRegionID;

    @Element(name = "RegionName")
    @Path("InRegion")
    String InRegionName;

    @Element
    String HiredDate;

    @Element
    String LastCalled;

    @Element
    int PlayerTypeSearch;

    @Element(required = false)
    @Path("Travel")
    String TravelStartDate;

    @Element(required = false)
    @Path("Travel")
    int TravelLength;

    @Element(required = false)
    @Path("Travel")
    int TravelType;

    public int getYouthScoutID() {
        return YouthScoutID;
    }

    public String getScoutName() {
        return ScoutName;
    }

    public int getAge() {
        return Age;
    }

    public int getCountryID() {
        return CountryID;
    }

    public String getCountryName() {
        return CountryName;
    }

    public int getRegionID() {
        return RegionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public int getInCountryID() {
        return InCountryID;
    }

    public String getInCountryName() {
        return InCountryName;
    }

    public int getInRegionID() {
        return InRegionID;
    }

    public String getInRegionName() {
        return InRegionName;
    }

    public String getHiredDate() {
        return HiredDate;
    }

    public String getLastCalled() {
        return LastCalled;
    }

    public int getPlayerTypeSearch() {
        return PlayerTypeSearch;
    }

    public String getTravelStartDate() {
        return TravelStartDate;
    }

    public int getTravelLength() {
        return TravelLength;
    }

    public int getTravelType() {
        return TravelType;
    }
}
