package org.hattrick.models.ladders;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(name = "Team")
public class LadderTeam {

    @Element
    int TeamId;

    @Element
    String TeamName;

    @Element
    int Position;

    @Element
    int Wins;

    @Element
    int Lost;

    @Element
    int WinsInARow;

    @Element
    int LostInARow;

    public int getTeamId() {
        return TeamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getPosition() {
        return Position;
    }

    public int getWins() {
        return Wins;
    }

    public int getLost() {
        return Lost;
    }

    public int getWinsInARow() {
        return WinsInARow;
    }

    public int getLostInARow() {
        return LostInARow;
    }
}
