package org.hattrick.models.youth;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class YouthMatch {

    @Element
    int MatchID;

    @Element
    int MatchRound;

    @Element
    String Status;

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

    public String getStatus() {
        return Status;
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
