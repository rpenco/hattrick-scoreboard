package org.hattrickscoreboardl.ui.drawer.componants;

import org.hattrickscoreboardl.database.models.teams.HTeam;

/**
 * Created by romain on 26/10/2014.
 */
public class DrawerTeam extends Drawer {

    private HTeam team;

    public DrawerTeam(int id, HTeam team) {
        this.id = id;
        this.team = team;

    }

    public HTeam getTeam(){
        return team;
    }

}
