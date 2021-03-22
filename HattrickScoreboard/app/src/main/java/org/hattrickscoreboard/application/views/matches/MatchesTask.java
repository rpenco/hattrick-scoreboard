package org.hattrickscoreboard.application.views.matches;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.MatchesDownloader;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatches;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class MatchesTask extends AsyncFragmentTask {

    static final String TAG = (MatchesTask.class).getSimpleName();

    public MatchesTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RMatches doInBackground(Object... params) {

        int teamID = (int) params[0];
        boolean youth = (boolean) params[1];

        if (teamID == 0)
            return null;

        // For download or update if need
        MatchesDownloader downloader = new MatchesDownloader(context, request,
                param, bdd, this);

        // If team details
        DTeam team = downloader.getTeam(teamID);

        if (team != null) {

            ArrayList<Match> matches = downloader.getMatches(teamID, youth);
            ArrayList<DLive> lives = downloader.getLiveMatches();

            if (matches != null) {
                RMatches rMatches = new RMatches(matches);
                rMatches.setTeam(team);
                rMatches.setLives(lives);
                return rMatches;
            }
        }
        return null;
    }

}
