package org.hattrick.models.leagues;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Match {

    @Element
    int MatchID;

    @Element
    int MatchRound;

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

    @Element(required = false)
    int HomeGoals;

    @Element(required = false)
    int AwayGoals;

    public int getMatchID() {
        return MatchID;
    }

    public int getMatchRound() {
        return MatchRound;
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

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

}
