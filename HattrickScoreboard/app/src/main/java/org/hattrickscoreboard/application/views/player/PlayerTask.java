package org.hattrickscoreboard.application.views.player;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.PlayerDownloader;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RPlayer;

/**
 * @author Khips
 * @since 25 august 2014
 */
public class PlayerTask extends AsyncFragmentTask implements UpdateListener {

    static final String TAG = (PlayerTask.class).getSimpleName();

    public PlayerTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RPlayer doInBackground(Object... params) {

        int playerID = (int) params[0];

        // Else bug on orientation change...
        if (playerID == 0)
            return null;

        // For download or update if need
        PlayerDownloader downloader = new PlayerDownloader(context, request,
                param, bdd, this);

        DPlayer player = downloader.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        DTeam team = downloader.getTeam(player.getTeamId());

        // match exist
        if (team != null) {

            // Return infos
            RPlayer mResult = new RPlayer();
            mResult.setPlayer(player);
            mResult.setTeam(team);

            return mResult;
        }

        return null;

    }

}
