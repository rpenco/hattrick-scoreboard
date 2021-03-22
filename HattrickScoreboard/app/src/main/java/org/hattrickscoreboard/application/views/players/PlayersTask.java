package org.hattrickscoreboard.application.views.players;

import android.content.Context;
import android.util.Log;

import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RPlayers;
import org.hattrickscoreboard.database.tables.PlayersTable;
import org.hattrickscoreboard.database.tables.TeamTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class PlayersTask extends AsyncFragmentTask {

    private static final String TAG = (PlayersTask.class).getSimpleName();

    public PlayersTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RPlayers doInBackground(Object... params) {

        int teamID = (int) params[0];
        // boolean youth = (boolean) params[1];

        // Debug
        if (teamID == 0)
            return null;

        // Get team informations
        DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_TEAM_ID + "="
                + teamID);

        ArrayList<DPlayer> players = bdd.readAll(PlayersTable.class,
                DPlayer.class, PlayersTable.COL_TEAM_ID + "=" + teamID
                        + " ORDER BY " + PlayersTable.COL_PLAYER_LASTNAME
                        + " ASC");

        if (players != null) {
            Log.i(TAG, players.size() + " players found.");
            RPlayers relPlayers = new RPlayers(players);
            relPlayers.setTeam(team);
            return relPlayers;
        } else {
            Log.w(TAG, "no players found, download players...");
            downloadInformation(teamID);
        }
        return null;
    }

    /**
     * Update informations
     */
    public void downloadInformation(final int teamID) {

        // Debug orientation change..
        if (teamID == 0)
            return;

        HQuery obj = new HQuery();
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        PlayersUpdate playersUpdate = new PlayersUpdate();
        playersUpdate.addListener(new UpdateListener() {

            @Override
            public void onUpdateSuccess(String serviceFrom) {

                HQuery obj = new HQuery();
                obj.setTeamID(teamID);
                param.setObjectParam(obj);

                sendBrodcastNotificationSuccess(serviceFrom);
            }

            @Override
            public void onUpdateCanceled(String serviceFrom) {
                sendBrodcastNotificationCancel(serviceFrom);
            }

            @Override
            public void onUpdateStart(String serviceFrom) {
                sendBrodcastNotificationStart(serviceFrom);

            }
        });

        playersUpdate.update(TAG, context, request, param, bdd, true);
    }
}
