package org.hattrickscoreboardl.ui.views.players;

import android.app.Activity;
import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutListFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class PlayersViewFragment extends LayoutListFragment{

    static String TAG = (PlayersViewFragment.class).getSimpleName();
    HTeam team;

    public static PlayersViewFragment newInstance(HTeam team) {
        PlayersViewFragment fragment = new PlayersViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.pagerAdapter = new PlayersPager(getFragmentManager(), team, getActivity());
    }


    @Override
    protected Fragment onCreateRightFragment() {
        return null;
    }


}
