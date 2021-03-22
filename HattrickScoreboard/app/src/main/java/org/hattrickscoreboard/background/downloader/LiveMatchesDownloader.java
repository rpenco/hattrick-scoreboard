package org.hattrickscoreboard.background.downloader;

import android.content.Context;
import android.util.Log;

import org.hattrick.providers.params.HMatchQuery;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class LiveMatchesDownloader extends Downloader {

    static final String TAG = (LiveMatchesDownloader.class).getSimpleName();

    public LiveMatchesDownloader(Context context, IRequest request,
                                 IParams param, HattrickBDD bdd, UpdateListener listener) {
        super(context, request, param, bdd, listener);
    }

    public Match getMatch(int matchID, String sourceSystem) {

        // Get object if is valid
        Match match = (Match) bdd.read(MatchesTable.class,
                MatchesTable.COL_MATCH_ID + "=" + matchID + " AND "
                        + MatchesTable.COL_SOURCE_SYSTEM + "='" + sourceSystem
                        + "'");

        // If object is not null, return. (Object valid)
        if (isValid(match)) {
            Log.w(TAG, "Match valid, no update..");
            return match;
        }

        // Download object and return null
        MatchUpdate update = new MatchUpdate();
        update.addListener(listener);

        // Create params
        HMatchQuery query = new HMatchQuery();
        query.setEvent(true);
        query.setMatchID(matchID);
        query.setSourceSystem(sourceSystem);

        // Set params
        param.setObjectParam(query);

        update.update(TAG, context, request, param, bdd);

        return match;
    }

    public ArrayList<DLive> getLives() {

        // Get object if is valid
        ArrayList<DLive> lives = bdd.readAll(LiveTable.class, DLive.class,
                "1=1 ORDER BY " + LiveTable.COL_MATCH_DATE + " ASC");

        return lives;
    }

}