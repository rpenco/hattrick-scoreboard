package org.hattrickscoreboard.application.views.matches.live;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.LiveMatchesDownloader;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatches;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class LiveMatchesTask extends AsyncFragmentTask {

    static final String TAG = (LiveMatchesTask.class).getSimpleName();

    public LiveMatchesTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RMatches doInBackground(Object... params) {

        // For download or update if need
        LiveMatchesDownloader downloader = new LiveMatchesDownloader(context,
                request, param, bdd, this);

        ArrayList<DLive> lives = downloader.getLives();

        if (lives != null) {

            ArrayList<Match> matches = new ArrayList<>();
            for (DLive dLive : lives) {
                matches.add(downloader.getMatch(dLive.getMatchID(),
                        dLive.getSourceSystem()));
            }

            RMatches rMatches = new RMatches(matches);
            rMatches.setLives(lives);
            return rMatches;
        }

        return null;
    }

}
