package org.hattrickscoreboard.application.views.matches;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.extended.fragments.HattrickViewPagerFragment;
import org.hattrickscoreboard.application.views.matches.live.LivesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 5 august 2014
 */
public class MatchesViewPager extends HattrickViewPagerFragment {

    static final String TAG = (MatchesViewPager.class).getSimpleName();

    public static String VIEW_LIVE = "view_live";

    boolean youth;

    boolean isLive;

    public MatchesViewPager() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Is for youth team?
        youth = getArguments().getBoolean("youth");

        // Is for HT-LIVE?
        isLive = getArguments().getBoolean(VIEW_LIVE);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isLive) {
            createPager(1);
        } else {
            createPager();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_matches);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        if (isTablet() && !isRightFragment()) {

            // My matches
            fList.add(new MatchesFragment().newInstance(getTeamID(), youth));
            titles.add(toUpperCase(R.string.menu_matches));

        } else if (isTablet() && isRightFragment()) {

            // All lives matches
            // Only display on my matches view
            if ((getTeamID() == ((HattrickApplication) getActivity()
                    .getApplication()).getSelectedTeamID()) && youth == false) {
                fList.add(new LivesFragment().newInstance());
                titles.add(toUpperCase(R.string.action_live));
            }

        } else {

            // My matches
            fList.add(new MatchesFragment().newInstance(getTeamID(), youth));
            titles.add(toUpperCase(R.string.menu_matches));

            // All lives matches
            // Only display on my matches view
            if ((getTeamID() == ((HattrickApplication) getActivity()
                    .getApplication()).getSelectedTeamID()) && youth == false) {
                fList.add(new LivesFragment().newInstance());
                titles.add(toUpperCase(R.string.action_live));
            }
        }

        // Others matchs (friends? National?...)
        // fList.add(new MatchesFragment().newInstance(teamID, youth));
        // titles.add("Autres matchs");

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}