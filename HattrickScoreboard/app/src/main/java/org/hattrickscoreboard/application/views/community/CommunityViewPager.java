package org.hattrickscoreboard.application.views.community;

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
public class CommunityViewPager extends HattrickViewPagerFragment {

    static final String TAG = (CommunityViewPager.class).getSimpleName();

    public CommunityViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_community);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        // Staff
        fList.add(new CommunityFragment().newInstance());
        titles.add(toUpperCase(R.string.community_title_bookmarks));

        // Other; forum, player, history...
        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}