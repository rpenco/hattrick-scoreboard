package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Match;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 21 avr. 2014
 */
public class RMatches {

    ArrayList<Match> matchList;
    DTeam team;
    private ArrayList<DLive> lives;

    public RMatches(ArrayList<Match> matchList) {
        this.matchList = matchList;
    }

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public DTeam getTeam() {
        return this.team;
    }

    public void setTeam(DTeam team) {
        this.team = team;
    }

    public ArrayList<DLive> getLives() {
        return lives;
    }

    public void setLives(ArrayList<DLive> lives) {
        this.lives = lives;
    }

    public DLive isOnLive(Match match) {

        for (DLive live : lives) {
            if (live.getMatchID() == match.getMatchID()
                    && live.getSourceSystem().equals(match.getSourceSystem())) {
                return live;
            }
        }

        return null;
    }
}
