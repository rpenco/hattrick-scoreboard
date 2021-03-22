package org.hattrick.models.cups;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false, name = "Match")
public class CupMatch {

    @Element
    int MatchID;

    @Element
    String MatchDate;

    @Element(name = "TeamId")
    @Path("HomeTeam")
    int HomeTeamId;

    @Element(name = "TeamName")
    @Path("HomeTeam")
    String HomeTeamName;

    @Element(name = "TeamId")
    @Path("AwayTeam")
    int AwayTeamId;

    @Element(name = "TeamName")
    @Path("AwayTeam")
    String AwayTeamName;

    @Element(required = false)
    @Path("MatchResult")
    int HomeGoals;

    @Element(required = false)
    @Path("MatchResult")
    int AwayGoals;

    @Element(required = false)
    @Path("LeagueInfo")
    int HomeLeagueID;

    @Element(required = false)
    @Path("LeagueInfo")
    int AwayLeagueID;

    @Element(required = false)
    @Path("LeagueInfo")
    String HomeLeagueName;

    @Element(required = false)
    @Path("LeagueInfo")
    String AwayLeagueName;

    public int getMatchID() {
        return MatchID;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getHomeTeamId() {
        return HomeTeamId;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public int getAwayTeamId() {
        return AwayTeamId;
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

    public int getHomeLeagueID() {
        return HomeLeagueID;
    }

    public int getAwayLeagueID() {
        return AwayLeagueID;
    }

    public String getHomeLeagueName() {
        return HomeLeagueName;
    }

    public String getAwayLeagueName() {
        return AwayLeagueName;
    }
}
