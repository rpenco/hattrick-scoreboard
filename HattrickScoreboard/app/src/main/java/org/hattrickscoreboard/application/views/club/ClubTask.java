package org.hattrickscoreboard.application.views.club;

import android.content.Context;
import android.util.Log;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.ClubDownloader;
import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.relations.RClub;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class ClubTask extends AsyncFragmentTask {

    static final String TAG = (ClubTask.class).getSimpleName();

    public ClubTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Object doInBackground(Object... params) {
        // Get selected team id
        int teamID = (int) params[0];

        Log.i(TAG, "teamID: " + teamID);

        if (teamID == 0) {
            return null;
        }

        // For download or update if need
        ClubDownloader downloader = new ClubDownloader(context, request, param,
                bdd, this);

        // If team details
        DTeam team = downloader.getTeam(teamID);
        if (team != null) {

            // Get others informations

            // Get arena
            DArena arena = downloader.getArena(team);

            // Get world
            DWorld world = downloader.getWorld(team);

            // Get series
            DSeries series = downloader.getSeries(team);

            // Return completed object
            if (arena != null && world != null && series != null) {
                RClub clubRes = new RClub(team, arena, world, series);
                return clubRes;
            }
        }
        return null;

    }

}
