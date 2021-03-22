package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class TournamentFixturesMatch {

    @Element
    int MatchId;

    @Element
    int HomeTeamId;


    @Element
    String HomeTeamName;

    @Element
    String HomeShortTeamName;

    @Element
    int AwayTeamId;

    @Element
    String AwayTeamName;

    @Element
    String AwayShortTeamName;

    @Element
    String MatchDate;

    @Element
    int MatchType;

    @Element
    int MatchRound;

    @Element
    int Group;

    @Element
    int Status;

    @Element
    int HomeGoals;

    @Element
    int AwayGoals;

    @Element(required = false)
    String HomeStatement;

    @Element(required = false)
    String AwayStatement;

    public int getMatchId() {
        return MatchId;
    }

    public int getHomeTeamId() {
        return HomeTeamId;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public String getHomeShortTeamName() {
        return HomeShortTeamName;
    }

    public int getAwayTeamId() {
        return AwayTeamId;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public String getAwayShortTeamName() {
        return AwayShortTeamName;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public int getGroup() {
        return Group;
    }

    public int getStatus() {
        return Status;
    }

    public int getHomeGoals() {
        return HomeGoals;
    }

    public int getAwayGoals() {
        return AwayGoals;
    }

    public String getHomeStatement() {
        return HomeStatement;
    }

    public String getAwayStatement() {
        return AwayStatement;
    }
}
