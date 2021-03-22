package org.hattrickscoreboardl.ui.views.players;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.BasePager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 mars 2014
 */
public class PlayersPager extends BasePager {

    static String TAG = (PlayersPager.class).getSimpleName();

    public PlayersPager(FragmentManager fm, HTeam team, Context ctx) {
        super(fm, team, ctx);
    }


    @Override
    public List<String> getTitles() {
        List<String> title = new ArrayList<String>();
        title.add("Joueurs");
        title.add("Statistiques");
        title.add("Historiques");
        title.add("Suivis");
        return title;
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(PlayersFragment.newInstance((HTeam)getParam()));
        fragments.add(PlayersStatsFragment.newInstance((HTeam)getParam()));
/*     fragments.add(new PlayersFragment());
        fragments.add(new PlayersFragment());*/
        return fragments;
    }

}