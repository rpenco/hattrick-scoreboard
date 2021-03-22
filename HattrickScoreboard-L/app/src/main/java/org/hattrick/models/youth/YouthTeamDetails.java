package org.hattrick.models.youth;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class YouthTeamDetails {

    @Element
    @Path("YouthTeam")
    int YouthTeamID;

    @Element
    @Path("YouthTeam")
    String YouthTeamName;

    @Element
    @Path("YouthTeam")
    String ShortTeamName;

    @Element
    @Path("YouthTeam")
    String CreatedDate;

    @Element
    @Path("YouthTeam/Country")
    int CountryID;

    @Element
    @Path("YouthTeam/Country")
    String CountryName;

    @Element
    @Path("YouthTeam/Region")
    int RegionID;

    @Element
    @Path("YouthTeam/Region")
    String RegionName;

    @Element
    @Path("YouthTeam/YouthArena")
    int YouthArenaID;

    @Element
    @Path("YouthTeam/YouthArena")
    String YouthArenaName;

    @Element
    @Path("YouthTeam/YouthLeague")
    int YouthLeagueID;

    @Element(required = false)
    @Path("YouthTeam/YouthLeague")
    String YouthLeagueName;

    @Element
    @Path("YouthTeam/YouthLeague")
    int YouthLeagueStatus;

    @Element
    @Path("YouthTeam/OwningTeam")
    int MotherTeamID;

    @Element
    @Path("YouthTeam/OwningTeam")
    String MotherTeamName;

    @Element
    @Path("YouthTeam/YouthTrainer")
    int YouthPlayerID;

    @Element
    @Path("YouthTeam")
    String NextTrainingMatchDate;

    @ElementList
    @Path("YouthTeam")
    ArrayList<YouthScout> ScoutList;

    public int getYouthTeamID() {
        return YouthTeamID;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public String getCreatedDate() {
        return CreatedDate;
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

    public int getYouthArenaID() {
        return YouthArenaID;
    }

    public String getYouthArenaName() {
        return YouthArenaName;
    }

    public int getYouthLeagueID() {
        return YouthLeagueID;
    }

    public String getYouthLeagueName() {
        return YouthLeagueName;
    }

    public int getYouthLeagueStatus() {
        return YouthLeagueStatus;
    }

    public int getMotherTeamID() {
        return MotherTeamID;
    }

    public String getMotherTeamName() {
        return MotherTeamName;
    }

    public int getYouthPlayerID() {
        return YouthPlayerID;
    }

    public String getNextTrainingMatchDate() {
        return NextTrainingMatchDate;
    }

    public ArrayList<YouthScout> getScoutList() {
        return ScoutList;
    }
}
