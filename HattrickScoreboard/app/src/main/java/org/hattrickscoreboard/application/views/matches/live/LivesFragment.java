package org.hattrickscoreboard.application.views.matches.live;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.views.matches.MatchesCalendar;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.database.relations.RMatches;

public final class LivesFragment extends HattrickFragment {

    static final String TAG = (LivesFragment.class).getSimpleName();

    public RMatches rMatches;

    int teamID;
    boolean youth;

    public LivesFragment newInstance() {
        LivesFragment fragment = new LivesFragment();
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
        LiveMatchesTask task = new LiveMatchesTask(getActivity(), this);
        task.execute();

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
        Log.v(TAG, "display informations on screen...");

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        if (llContainer == null)
            return;

        MatchesCalendar calendar = new MatchesCalendar(getActivity(),
                getWorld());
        calendar.create(llContainer, rMatches, teamID);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(MatchesUpdate.FROM) || from.equals(LiveUpdate.FROM)) {

            LiveMatchesTask task = new LiveMatchesTask(getActivity(), this);
            task.execute();
        }
    }

}
