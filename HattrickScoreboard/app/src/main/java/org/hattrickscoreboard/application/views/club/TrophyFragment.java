package org.hattrickscoreboard.application.views.club;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.database.relations.RClub;

public final class TrophyFragment extends HattrickFragment {

    private static final String TAG = (TrophyFragment.class).getSimpleName();

    public int teamID;

    // Result from task
    private RClub rteam;

    public TrophyFragment newInstance(int teamID) {
        TrophyFragment fragment = new TrophyFragment();
        fragment.teamID = teamID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        ClubTask task = new ClubTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rteam = (RClub) result;
        if (rteam == null)
            return;

        // Set new layout
        setStubLayout(R.layout.club_trophy_fragment);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

    }

}
