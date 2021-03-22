package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Supporters ONLY
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class NationalTeamPlayersStats {

    @Element
    int TeamID;

    @Element
    String TeamName;

   @ElementList
   @Path("Stats")
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
