package org.hattrick.models.youth;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class YouthPlayers {

    @ElementList
    ArrayList<YouthPlayer> PlayerList;

    public ArrayList<YouthPlayer> getPlayers() {
        return PlayerList;
    }
}
