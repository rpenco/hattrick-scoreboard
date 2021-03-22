package org.hattrickscoreboard.application.views.settings;

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
public class SettingsViewPager extends HattrickViewPagerFragment {

    static final String TAG = (SettingsViewPager.class).getSimpleName();

    public SettingsViewPager() {
        super();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_settings);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        fList.add(new SettingsFragment().newInstance());
        titles.add(toUpperCase(R.string.menu_settings));

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}