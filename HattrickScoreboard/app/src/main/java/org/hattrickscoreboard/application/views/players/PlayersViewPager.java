package org.hattrickscoreboard.application.views.players;

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
public class PlayersViewPager extends HattrickViewPagerFragment {

    static final String TAG = (PlayersViewPager.class).getSimpleName();

    boolean youth;

    public PlayersViewPager() {
        super();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get team ID from activity
        youth = getArguments().getBoolean("youth");

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_players);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        // Players list
        fList.add(new PlayersFragment().newInstance(getTeamID(), youth));
        titles.add(toUpperCase(R.string.menu_players));

        // Statistics
        fList.add(new PlayersStatsFragment().newInstance(getTeamID(), youth));
        titles.add(toUpperCase(R.string.label_statistics));

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}