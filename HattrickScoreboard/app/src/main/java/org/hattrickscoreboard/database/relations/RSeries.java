package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DSeriesFixtures;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 21 avr. 2014
 */
public class RSeries {

    ArrayList<DSeries> leaguelist;
    ArrayList<DSeriesFixtures> matches;
    ArrayList<DLive> lives;

    DWorld world;
    DTeam team;

    public ArrayList<DSeries> getLeaguelist() {
        return leaguelist;
    }

    public void setLeaguelist(ArrayList<DSeries> leaguelist) {
        this.leaguelist = leaguelist;
    }

    public ArrayList<DSeriesFixtures> getFixtures() {
        return matches;
    }

    public void setMatches(ArrayList<DSeriesFixtures> matches) {
        this.matches = matches;
    }

    public ArrayList<DLive> getLives() {
        return lives;
    }

    public void setLives(ArrayList<DLive> lives) {
        this.lives = lives;
    }

    public DWorld getWorld() {
        return world;
    }

    public void setWorld(DWorld world) {
        this.world = world;
    }

    public DTeam getTeam() {
        return team;
    }

    public void setTeam(DTeam team) {
        this.team = team;
    }

}
