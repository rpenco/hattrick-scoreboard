package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class League {

    @Element
    int LeagueID;

    @Element
    String LeagueName;

    @Element
    int Season;

    @Element(required = false)
    int SeasonOffset;

    @Element
    int MatchRound;

    @Element
    String ShortName;

    @Element
    String Continent;

    @Element
    String ZoneName;

    @Element
    String EnglishName;

    @Element
    int NationalTeamId;

    @Element
    int U20TeamId;

    @Element(required = false)
    int ActiveTeams;

    @Element(required = false)
    int ActiveUsers;

    @Element(required = false)
    int WaitingUsers;

    @Element
    String TrainingDate;

    @Element
    String EconomyDate;

    @Element
    String CupMatchDate;

    @Element
    String SeriesMatchDate;

    @Element
    int NumberOfLevels;

    @Element
    Country Country;

    @ElementList
    ArrayList<Cup> Cups;

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getSeason() {
        return Season;
    }

    public int getSeasonOffset() {
        return SeasonOffset;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public String getShortName() {
        return ShortName;
    }

    public String getContinent() {
        return Continent;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public int getNationalTeamId() {
        return NationalTeamId;
    }

    public int getU20TeamId() {
        return U20TeamId;
    }

    public int getActiveTeams() {
        return ActiveTeams;
    }

    public int getActiveUsers() {
        return ActiveUsers;
    }

    public int getWaitingUsers() {
        return WaitingUsers;
    }

    public String getTrainingDate() {
        return TrainingDate;
    }

    public String getEconomyDate() {
        return EconomyDate;
    }

    public String getCupMatchDate() {
        return CupMatchDate;
    }

    public String getSeriesMatchDate() {
        return SeriesMatchDate;
    }

    public int getNumberOfLevels() {
        return NumberOfLevels;
    }

    public Country getCountry() {
        return Country;
    }

    public ArrayList<Cup> getCupList() {
        return Cups;
    }

}
