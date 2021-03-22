package org.hattrick.models.world;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class WorldDetails {

    @ElementList
    ArrayList<League> LeagueList;

    public ArrayList<League> getLeagueList() {
        return LeagueList;
    }

}
