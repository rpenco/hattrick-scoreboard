package org.hattrickscoreboard.application.views.staff;

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
public class StaffViewPager extends HattrickViewPagerFragment {

    static final String TAG = (StaffViewPager.class).getSimpleName();

    public StaffViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_staff);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        if (isTablet() && !isRightFragment()) {
            // Staff
            fList.add(new StaffFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.menu_staff));

        } else if (isTablet() && isRightFragment()) {
            // Statistics
            fList.add(new StaffStatsFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.label_statistics));

        } else {

            // Staff
            fList.add(new StaffFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.menu_staff));

            // Statistics
            fList.add(new StaffStatsFragment().newInstance(getTeamID()));
            titles.add(toUpperCase(R.string.label_statistics));
        }
        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}