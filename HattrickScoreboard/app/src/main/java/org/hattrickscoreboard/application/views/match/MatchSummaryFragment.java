package org.hattrickscoreboard.application.views.match;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatch;

import java.util.ArrayList;

public class MatchSummaryFragment extends HattrickFragment {

    static final String TAG = (MatchSummaryFragment.class).getSimpleName();

    int matchID;
    String sourceSystem;

    RMatch matchRes;

    public final MatchSummaryFragment newInstance(int matchID,
                                                  String sourceSystem) {
        MatchSummaryFragment f = new MatchSummaryFragment();
        f.matchID = matchID;
        f.sourceSystem = sourceSystem;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        MatchTask task = new MatchTask(getActivity(), this);
        task.execute(matchID, sourceSystem);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        matchRes = (RMatch) result;

        if (matchRes == null)
            return;

        setStubLayout(R.layout.fragment_listview);

        // Populate all
        onPopulateView();
    }

    protected void onPopulateView() {
        super.onPopulateView();

        Match match = matchRes.getMatch();
        ArrayList<Event> events = matchRes.getEvents();

        if (events != null && match != null) {

            EventsAdapter eventsAdapter = new EventsAdapter(getActivity(),
                    match, events, getFragmentManager());

            ListView lvEvents = ((ListView) getFragmentView().findViewById(
                    R.id.lvListView));
            lvEvents.setAdapter(eventsAdapter);
        }
    }

    ;

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)
                || from.equals(LineUpUpdate.FROM)
                || from.equals(LiveUpdate.FROM)) {

            MatchTask task = new MatchTask(getActivity(), this);
            task.execute(matchID, sourceSystem);
        }
    }
}