package org.hattrickscoreboardl.ui.drawer;

import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.drawer.componants.Drawer;
import org.hattrickscoreboardl.ui.views.arena.ArenaViewFragment;
import org.hattrickscoreboardl.ui.views.club.ClubViewFragment;
import org.hattrickscoreboardl.ui.views.economies.EconomiesViewFragment;
import org.hattrickscoreboardl.ui.views.players.PlayersViewFragment;
import org.hattrickscoreboardl.ui.views.transfers.TransfersViewFragment;

/**
 * Created by romain on 26/10/2014.
 */
public final class DrawerFragmentSelection {

    static String TAG = (DrawerFragmentSelection.class).getSimpleName();

    public static Fragment getFragment(boolean tabletMode, Drawer drawer, HTeam team) {

        int id = drawer.getId();

        //Default view
        if ( id == 1) {
            return ClubViewFragment.newInstance(team);
        }

        if (id  == 2) {
            return ArenaViewFragment.newInstance(team);
        }

        if (id  == 5) {
                return TransfersViewFragment.newInstance(team);
        }

        if (id  == 6) {
                return EconomiesViewFragment.newInstance(team);
        }

        if (id  == 7) {
            return PlayersViewFragment.newInstance(team);
        }

        return PlayersViewFragment.newInstance(team);
    }
}
