package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 21 avr. 2014
 */
public class RPlayers {

    ArrayList<DPlayer> playerlist;
    DTeam team;

    public RPlayers(ArrayList<DPlayer> playerlist) {
        super();
        this.playerlist = playerlist;
    }

    public ArrayList<DPlayer> getPlayerlist() {
        return playerlist;
    }

    public void setLeaguelist(ArrayList<DPlayer> playerlist) {
        this.playerlist = playerlist;
    }

    public DTeam getTeam() {
        return this.team;
    }

    public void setTeam(DTeam team) {
        this.team = team;
    }
}
