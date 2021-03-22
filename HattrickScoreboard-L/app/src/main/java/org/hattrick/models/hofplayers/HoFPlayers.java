package org.hattrick.models.hofplayers;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false)
public class HoFPlayers {

    @ElementList
    ArrayList<HoFPlayer> PlayerList;

    public ArrayList<HoFPlayer> getPlayers() {
        return PlayerList;
    }
}
