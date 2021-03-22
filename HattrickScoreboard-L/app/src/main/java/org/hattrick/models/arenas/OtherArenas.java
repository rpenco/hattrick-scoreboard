package org.hattrick.models.arenas;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Supporters Only
 */
@Root(strict = false)
public class OtherArenas {

    @ElementList(name = "OtherArenaStatList")
    @Path("LeagueArenaStats")
    ArrayList<ArenaStat> arenas;

    public ArrayList<ArenaStat> getArenas() {
        return arenas;
    }
}
