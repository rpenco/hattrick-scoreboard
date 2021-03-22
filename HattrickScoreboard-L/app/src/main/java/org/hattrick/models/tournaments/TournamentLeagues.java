package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class TournamentLeagues {

    @Element
    int TournamentId;

    @ElementList
    ArrayList<TournamentLeague> TournamentLeagueTables;

    public int getTournamentId(){
        return TournamentId;
    }
    public ArrayList<TournamentLeague> getTournamentLeagueTable() {
        return TournamentLeagueTables;
    }
}
