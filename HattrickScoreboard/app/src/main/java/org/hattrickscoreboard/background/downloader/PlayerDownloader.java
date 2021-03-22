package org.hattrickscoreboard.background.downloader;

import android.content.Context;
import android.util.Log;

import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.tables.PlayersTable;
import org.hattrickscoreboard.database.tables.TeamTable;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class PlayerDownloader extends Downloader {

    static final String TAG = (PlayerDownloader.class).getSimpleName();

    public PlayerDownloader(Context context, IRequest request, IParams param,
                            HattrickBDD bdd, UpdateListener listener) {
        super(context, request, param, bdd, listener);
    }

    public DTeam getTeam(int teamID) {

        // Get object if is valid
        DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_TEAM_ID
                + "=" + teamID);

        // If object is not null, return. (Object valid)
        if (isValid(team)) {
            Log.w(TAG, "Team '" + teamID + "' valid, no update..");
            return team;
        }

        // Download object and return null
        TeamUpdate update = new TeamUpdate();

        // Create params
        HQuery obj = new HQuery();
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return team;
    }

    public DPlayer getPlayer(int playerID) {
        // Get object if is valid
        DPlayer player = (DPlayer) bdd.read(PlayersTable.class,
                PlayersTable.COL_PLAYER_ID + "=" + playerID);

        return player;

    }

}