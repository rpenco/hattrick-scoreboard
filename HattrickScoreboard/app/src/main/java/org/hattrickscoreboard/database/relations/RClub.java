package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;

/**
 * @author Khips
 * @since 30 march 2014
 */
public class RClub {

    private DTeam team;
    private DArena arena;
    private DWorld world;
    private DSeries league;

    public RClub(DTeam team, DArena arena, DWorld world, DSeries league) {

        this.team = team;
        this.arena = arena;
        this.world = world;
        this.setLeague(league);
    }

    public DTeam getTeam() {
        return team;
    }

    public void setTeam(DTeam team) {
        this.team = team;
    }

    public DArena getArena() {
        return arena;
    }

    public void setArena(DArena arena) {
        this.arena = arena;
    }

    public DWorld getWorld() {
        return world;
    }

    public void setWorld(DWorld world) {
        this.world = world;
    }

    public DSeries getLeague() {
        return league;
    }

    public void setLeague(DSeries league) {
        this.league = league;
    }

}
