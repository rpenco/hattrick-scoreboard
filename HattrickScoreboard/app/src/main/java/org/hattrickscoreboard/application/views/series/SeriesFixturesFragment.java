package org.hattrickscoreboard.application.views.series;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.relations.RSeries;

public final class SeriesFixturesFragment extends HattrickFragment {

    static final String TAG = (SeriesFixturesFragment.class).getSimpleName();

    int teamID;
    int season;

    RSeries rlLeague;

    public SeriesFixturesFragment newInstance(int teamID, int season) {
        SeriesFixturesFragment fragment = new SeriesFixturesFragment();
        fragment.teamID = teamID;
        fragment.season = season;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        SeriesTask task = new SeriesTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rlLeague = (RSeries) result;

        // Prevent crash on orientation change..
        if (rlLeague == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        Log.v(TAG, "display informations on screen...");

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        if (llContainer == null)
            return;

        SeriesCalendar calendar = new SeriesCalendar(getActivity(), getWorld());
        calendar.create(llContainer, rlLeague, teamID);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(SeriesUpdate.FROM)
                || from.equals(MatchesUpdate.FROM)) {

            SeriesTask task = new SeriesTask(getActivity(), this);
            task.execute(teamID);
        }
    }
}
