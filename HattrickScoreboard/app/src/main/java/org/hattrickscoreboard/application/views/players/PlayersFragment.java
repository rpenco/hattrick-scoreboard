package org.hattrickscoreboard.application.views.players;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.views.player.PlayerActivity;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.database.relations.RPlayers;

/**
 * @author Khips
 * @since 14 august 2014
 */
public final class PlayersFragment extends HattrickFragment {
    static final String TAG = (PlayersFragment.class).getSimpleName();

    int teamID;
    boolean youth;

    RPlayers rlPlayers;

    public PlayersFragment newInstance(int teamID, boolean youth) {
        PlayersFragment fragment = new PlayersFragment();
        fragment.teamID = teamID;
        fragment.youth = youth;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        PlayersTask task = new PlayersTask(getActivity(), this);
        task.execute(teamID, youth);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rlPlayers = (RPlayers) result;

        if (rlPlayers == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_players);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

        if (getFragmentManager() == null)
            return;

        PlayersAdapter playersAdapter = new PlayersAdapter(getActivity(),
                rlPlayers.getPlayerlist(), getFragmentManager());

        ListView lvPlayers = ((ListView) getFragmentView().findViewById(
                R.id.lvPlayers));
        lvPlayers.setAdapter(playersAdapter);

        lvPlayers.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                                    long arg3) {

                // Start player page
                Intent i = new Intent(view.getContext(), PlayerActivity.class);
                i.putExtra(PlayerActivity.PLAYERID, (int) view.getTag());
                startActivityForResult(i, 0);

            }
        });

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        Log.v(TAG, "Receive broadcast: [" + code + "] from '" + from + "'.");

        if (from.equals(PlayersUpdate.FROM)) {

            PlayersTask task = new PlayersTask(getActivity(), this);
            task.execute(teamID, youth);
        }
    }
}
