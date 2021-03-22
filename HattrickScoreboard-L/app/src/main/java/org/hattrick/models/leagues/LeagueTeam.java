package org.hattrick.models.leagues;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class LeagueTeam {

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
