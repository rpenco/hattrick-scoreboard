package org.hattrick.models.tournaments;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class TournamentFixtures {

    @ElementList
    ArrayList<TournamentFixturesMatch> Matches;

    public ArrayList<TournamentFixturesMatch> getMatches() {
        return Matches;
    }
}
