package org.hattrickscoreboard.application.views.series;

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
public class SeriesViewPager extends HattrickViewPagerFragment {

    static final String TAG = (SeriesViewPager.class).getSimpleName();

    public SeriesViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_series);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        if (isTablet() && !isRightFragment()) {

            // Current series
            fList.add(new SeriesFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.series_title_classment));

        } else if (isTablet() && isRightFragment()) {

            // Fixtures series
            fList.add(new SeriesFixturesFragment().newInstance(getTeamID(), 0));
            titles.add(toUpperCase(R.string.series_title_date));
        } else {
            // Current series
            fList.add(new SeriesFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.series_title_classment));

            // Fixtures
            fList.add(new SeriesFixturesFragment().newInstance(getTeamID(), 0));
            titles.add(toUpperCase(R.string.series_title_date));
        }
        // Order by attack?
        // fList.add(new SeriesFragment()
        // .newInstance(teamID, SeriesFragment.HOME));
        // titles.add("ATTAQUE");

        // Order by defense?
        // fList.add(new SeriesFragment()
        // .newInstance(teamID, SeriesFragment.AWAY));
        // titles.add("DEFENSE");

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}