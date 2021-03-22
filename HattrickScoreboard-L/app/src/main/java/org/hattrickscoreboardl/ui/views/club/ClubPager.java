package org.hattrickscoreboardl.ui.views.club;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.BasePager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 mars 2014
 */
public class ClubPager extends BasePager {

    static String TAG = (ClubPager.class).getSimpleName();

    public ClubPager(FragmentManager fm, HTeam team, Context ctx) {
        super(fm, team, ctx);
    }


    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(ClubFragment.newInstance((HTeam) getParam()));
        fragments.add(TrophyFragment.newInstance((HTeam) getParam()));
        return fragments;
    }

    @Override
    public List<String> getTitles() {
        List<String> title = new ArrayList<String>();
        title.add(getString(R.string.tab_club));
        title.add(getString(R.string.tab_prize_list));
        title.add("Livre d'or");
        title.add("Supporters");
        title.add("Réussites");
        title.add("Temple");
        return title;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }
}