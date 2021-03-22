package org.hattrickscoreboard.application.views.matches;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.relations.RMatches;

public final class MatchesFragment extends HattrickFragment {

    static final String TAG = (MatchesFragment.class).getSimpleName();

    public RMatches rMatches;

    int teamID;
    boolean youth;

    public MatchesFragment newInstance(int teamID, boolean youth) {
        MatchesFragment fragment = new MatchesFragment();
        fragment.teamID = teamID;
        fragment.youth = youth;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        MatchesTask task = new MatchesTask(getActivity(), this);
        task.execute(teamID, youth);

    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        Log.v(TAG, "...task finished");

        // Get result
        rMatches = (RMatches) result;
        if (rMatches == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        MatchesCalendar calendar = new MatchesCalendar(getActivity(),
                getWorld());
        calendar.create(llContainer, rMatches, teamID);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(SeriesUpdate.FROM)
                || from.equals(LiveUpdate.FROM)) {

            MatchesTask task = new MatchesTask(getActivity(), this);
            task.execute(teamID, youth);
        }
    }

}
