package org.hattrick.models.worldcup;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class WorldGroups {

    @Element
    int CupID;

    @Element
    int Season;

    @Element
    int MatchRound;

    @ElementList
    ArrayList<WorldTeam> WorldCupScores;

    @ElementList
    ArrayList<WorldRound> Rounds;

    public ArrayList<WorldTeam> getGroups() {
        return WorldCupScores;
    }

    public ArrayList<WorldRound> getRounds() {
        return Rounds;
    }
}
