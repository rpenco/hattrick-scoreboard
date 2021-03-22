package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;

/**
 * @author Khips
 * @since 25 aot 2014
 */
public class RPlayer {

    DPlayer player;
    DTeam team;
    DWorld world;

    public DPlayer getPlayer() {
        return player;
    }

    public void setPlayer(DPlayer player) {
        this.player = player;
    }

    public DTeam getTeam() {
        return team;
    }

    public void setTeam(DTeam team) {
        this.team = team;
    }

    public DWorld getWorld() {
        return world;
    }

    public void setWorld(DWorld world) {
        this.world = world;
    }

}
