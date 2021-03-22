package org.hattrick.models.players;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class PlayerEvents {

    @Element
    @Path("Player")
    int PlayerID;

    @ElementList
    @Path("Player")
    ArrayList<PlayerEvent> PlayerEvents;

    public ArrayList<PlayerEvent> getPlayerEvents() {
        return PlayerEvents;
    }

    public int getPlayerID() {
        return PlayerID;
    }
}
