package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class TournamentTeam {

    @Element
    int TeamID;

    @Element
    String TeamName;

    @Element
    int Position;

    @Element
    int PositionChange;

    @Element
    int Matches;

    @Element
    int GoalsFor;

    @Element
    int GoalsAgainst;

    @Element
    int Points;

    @Element
    int Won;

    @Element
    int Draws;

    @Element
    int Lost;

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getPosition() {
        return Position;
    }

    public int getPositionChange() {
        return PositionChange;
    }

    public int getMatches() {
        return Matches;
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

    public int getWon() {
        return Won;
    }

    public int getDraws() {
        return Draws;
    }

    public int getLost() {
        return Lost;
    }
}
