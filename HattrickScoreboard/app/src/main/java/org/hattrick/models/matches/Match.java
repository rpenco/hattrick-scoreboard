package org.hattrick.models.matches;

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

    @Element(required = false)
    @Path("HomeTeam")
    String HomeTeamNameShortName;

    @Element
    @Path("AwayTeam")
    int AwayTeamID;

    @Element
    @Path("AwayTeam")
    String AwayTeamName;

    @Element(required = false)
    @Path("AwayTeam")
    String AwayTeamNameShortName;

    @Element
    String MatchDate;

    @Element
    String SourceSystem;

    @Element
    int MatchType;

    @Element
    int MatchContextId;

    @Element(required = false)
    int HomeGoals;

    @Element(required = false)
    int AwayGoals;

    @Element
    String Status;

    @Element(required = false)
    boolean OrdersGiven;

    public int getMatchID() {
        return MatchID;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public String getHomeTeamShortName() {
        return HomeTeamNameShortName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public String getAwayTeamShortName() {
        return AwayTeamNameShortName;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public int getMatchType() {
        return MatchType;
    }

    public int getMatchContextID() {
        return MatchContextId;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public String getStatus() {
        return Status;
    }

    public boolean isOrdersGiven() {
        return OrdersGiven;
    }

}
