package org.hattrickscoreboardl.ui.drawer.componants;

import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;

/**
 * Created by romain on 26/10/2014.
 */
public class DrawerNationalTeam extends Drawer {

    private HNationalTeam team;

    public DrawerNationalTeam(int id, HNationalTeam team) {
        this.id = id;
        this.team = team;

    }

    public HNationalTeam getTeam(){
        return team;
    }

}
