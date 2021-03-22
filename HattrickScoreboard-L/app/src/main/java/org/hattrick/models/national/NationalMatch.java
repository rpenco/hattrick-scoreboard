package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class NationalMatch {

    @Element
    int MatchID;

    @Element
    String MatchDate;

    @Element
    int MatchType;

    @Element
    String HomeTeamName;

    @Element
    String AwayTeamName;

    @Element(required = false)
    @Path("MatchResult")
    int HomeGoals;

    @Element(required = false)
    @Path("MatchResult")
    int AwayGoals;

    public int getMatchID() {
        return MatchID;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }
}
