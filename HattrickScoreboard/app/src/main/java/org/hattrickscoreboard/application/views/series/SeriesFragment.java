package org.hattrickscoreboard.application.views.series;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.relations.RSeries;

public final class SeriesFragment extends HattrickFragment {

    static final String TAG = (SeriesFragment.class).getSimpleName();

    int teamID;
    RSeries rlLeague;

    public SeriesFragment newInstance(int teamID) {
        SeriesFragment fragment = new SeriesFragment();
        fragment.teamID = teamID;
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
        setStubLayout(R.layout.fragment_leagues);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        Log.v(TAG, "display informations on screen...");

        if (getFragmentView() == null)
            return;

        SeriesAdapter seriesAdapter = new SeriesAdapter(getActivity(), teamID,
                rlLeague.getLeaguelist(), getFragmentManager());

        ListView lvSeries = ((ListView) getFragmentView().findViewById(
                R.id.lvTeamSeries));
        if (lvSeries == null)
            return;

        lvSeries.setAdapter(seriesAdapter);

        lvSeries.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                                    long arg3) {

                SeriesHolder holder = (SeriesHolder) view.getTag();

                if (holder.teamID == teamID) {
                    return;
                }

                // Start consult activity
                // Intent intent = new Intent(getActivity(),
                // ConsultActivity.class);
                // intent.putExtra(ConsultActivity.RESULTID, holder.teamID);
                // intent.putExtra(ConsultActivity.RESULTTYPE, 4);

                // Start activity
                // startActivity(intent);

            }
        });

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
