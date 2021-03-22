package org.hattrickscoreboard.application.views.arena;

import android.app.Activity;
import android.os.Bundle;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.extended.fragments.HattrickViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class ArenaViewPager extends HattrickViewPagerFragment {

    static final String TAG = (ArenaViewPager.class).getSimpleName();
    int teamID;

    public ArenaViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_arena);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();
        fList.add(new ArenaFragment().newInstance(getTeamID()));
        titles.add(toUpperCase(R.string.menu_arena));
        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}