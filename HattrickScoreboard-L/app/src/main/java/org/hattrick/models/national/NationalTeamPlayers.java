package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class NationalTeamPlayers {

    @Element
    int TeamID;

    @Element
    String TeamName;

   @ElementList
    ArrayList<NationalPlayer> Players;

    public ArrayList<NationalPlayer> getPlayers() {
        return Players;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }
}
