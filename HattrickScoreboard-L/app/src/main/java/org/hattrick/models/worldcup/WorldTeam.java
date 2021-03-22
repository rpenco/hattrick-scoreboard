package org.hattrick.models.worldcup;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class WorldTeam {

    @Element
    int TeamID;

    @Element
    String TeamName;

    @Element
    int Place;

    @Element
    int CupSeriesUnitID;

    @Element
    String CupSeriesUnitName;

    @Element
    int MatchesPlayed;

    @Element
    int GoalsFor;

    @Element
    int GoalsAgainst;

    @Element
    int Points;

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getPlace() {
        return Place;
    }

    public int getCupSeriesUnitID() {
        return CupSeriesUnitID;
    }

    public String getCupSeriesUnitName() {
        return CupSeriesUnitName;
    }

    public int getMatchesPlayed() {
        return MatchesPlayed;
    }

    public int getGoalsFor() {
        return GoalsFor;
    }

    public int getGoalsAgainst() {
        return GoalsAgainst;
    }

    public int getPoints() {
        return Points;
    }
}
