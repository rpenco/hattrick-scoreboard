package org.hattrick.models.worldcup;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class WorldMatch {

    @Element
    int MatchID;

    @Element(name = "TeamID")
    @Path("HomeTeam")
    int HomeTeamID;

    @Element(name = "TeamName")
    @Path("HomeTeam")
    String HomeTeamName;

    @Element(name = "TeamID")
    @Path("AwayTeam")
    int AwayTeamID;

    @Element(name = "TeamName")
    @Path("AwayTeam")
    String AwayTeamName;

    @Element
    String MatchDate;

    @Element
    String FinishedDate;

    @Element
    int HomeGoals;

    @Element
    int AwayGoals;

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

    public String getFinishedDate() {
        return FinishedDate;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }
}
