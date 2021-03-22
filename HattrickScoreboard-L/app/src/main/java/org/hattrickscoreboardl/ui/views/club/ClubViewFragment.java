package org.hattrickscoreboardl.ui.views.club;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutListFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class ClubViewFragment extends LayoutListFragment {

    static String TAG = (ClubViewFragment.class).getSimpleName();
    HTeam team;


    public static ClubViewFragment newInstance(HTeam team) {
        ClubViewFragment fragment = new ClubViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.pagerAdapter = new ClubPager(getFragmentManager(), team, getActivity());
    }

    @Override
    protected Fragment onCreateRightFragment() {
        return ClubRightFragment.newInstance(team);
    }
}
