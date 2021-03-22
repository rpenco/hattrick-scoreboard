package org.hattrickscoreboardl.ui.views.transfers;

import android.app.Activity;
import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutListFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class TransfersViewFragment extends LayoutListFragment{

    static String TAG = (TransfersViewFragment.class).getSimpleName();
    HTeam team;

    public static TransfersViewFragment newInstance(HTeam team) {
        TransfersViewFragment fragment = new TransfersViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.pagerAdapter = new TransfersPager(getFragmentManager(), team, getActivity());
    }


    @Override
    protected Fragment onCreateRightFragment() {
        return null;
    }


}
