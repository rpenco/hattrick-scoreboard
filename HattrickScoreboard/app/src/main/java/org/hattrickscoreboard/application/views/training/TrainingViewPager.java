package org.hattrickscoreboard.application.views.training;

import android.app.Activity;
import android.os.Bundle;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.extended.fragments.HattrickViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class TrainingViewPager extends HattrickViewPagerFragment {

    static final String TAG = (TrainingViewPager.class).getSimpleName();

    public TrainingViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(
                    R.string.menu_training);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();
        fList.add(new TrainingFragment().newInstance(getTeamID()));
        titles.add(toUpperCase(R.string.menu_training));

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}