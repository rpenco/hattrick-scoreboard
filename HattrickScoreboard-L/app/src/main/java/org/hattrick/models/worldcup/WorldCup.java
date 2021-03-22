package org.hattrick.models.worldcup;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class WorldCup {

    @ElementList
    ArrayList<WorldMatch> Matches;

    @ElementList
    ArrayList<WorldRound> Rounds;

    public ArrayList<WorldMatch> getMatches() {
        return Matches;
    }

    public ArrayList<WorldRound> getRounds() {
        return Rounds;
    }
}
