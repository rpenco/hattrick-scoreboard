package org.hattrick.models.players;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class Players {

    @ElementList(name = "PlayerList")
    @Path(value = "Team")
    ArrayList<Player> Players;

    public ArrayList<Player> getPlayers() {
        return Players;
    }

}
