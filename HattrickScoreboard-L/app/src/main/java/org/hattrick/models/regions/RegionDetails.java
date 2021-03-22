package org.hattrick.models.regions;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class RegionDetails {

    @Element
    @Path("League")
    int LeagueID;

    @Element
    @Path("League")
    String LeagueName;

    @Element
    @Path("League/Region")
    int RegionID;

    @Element
    @Path("League/Region")
    String RegionName;

    @Element
    @Path("League/Region")
    int WeatherID;

    @Element
    @Path("League/Region")
    int TomorrowWeatherID;

    @Element
    @Path("League/Region")
    int NumberOfUsers;

    @Element
    @Path("League/Region")
    int NumberOfOnline;
}
