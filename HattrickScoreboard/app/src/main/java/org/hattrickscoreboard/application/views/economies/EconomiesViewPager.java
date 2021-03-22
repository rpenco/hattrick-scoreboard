package org.hattrickscoreboard.application.views.economies;

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
public class EconomiesViewPager extends HattrickViewPagerFragment {

    static final String TAG = (EconomiesViewPager.class).getSimpleName();

    public EconomiesViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_finances);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        if (isTablet()) {

            if (isRightFragment()) {

                // Last week
                fList.add(new EconomiesFragment().newInstance(getTeamID(), 1));
                titles.add(toUpperCase(R.string.finances_title_lastweek));

            } else {

                // Current week
                fList.add(new EconomiesFragment().newInstance(getTeamID(), 0));
                titles.add(toUpperCase(R.string.finances_title_current));

            }
        } else {

            // Current week
            fList.add(new EconomiesFragment().newInstance(getTeamID(), 0));
            titles.add(toUpperCase(R.string.finances_title_current));

            // Last week
            fList.add(new EconomiesFragment().newInstance(getTeamID(), 1));
            titles.add(toUpperCase(R.string.finances_title_lastweek));

        }

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}