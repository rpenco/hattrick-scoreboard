package org.hattrick.models.fans;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Match {

    @Element
    int MatchID;

    @Element
    @Path("HomeTeam")
    int HomeTeamID;

    @Element
    @Path("HomeTeam")
    String HomeTeamName;

    @Element
    @Path("AwayTeam")
    int AwayTeamID;

    @Element
    @Path("AwayTeam")
    String AwayTeamName;

    @Element
    String MatchDate;

    @Element
    int MatchType;

    @Element(required = false)
    int HomeGoals;

    @Element(required = false)
    int AwayGoals;

    @Element
    int FanMatchExpectation;

    @Element(required = false)
    int FanMoodAfterMatch;

    @Element(required = false)
    int Weather;

    @Element(required = false)
    int SoldSeats;

    public int getMatchID() {
        return MatchID;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public int getFanMatchExpectation() {
        return FanMatchExpectation;
    }

    public int getFanMoodAfterMatch() {
        return FanMoodAfterMatch;
    }

    public int getWeather() {
        return Weather;
    }

    public int getSoldSeats() {
        return SoldSeats;
    }
}
