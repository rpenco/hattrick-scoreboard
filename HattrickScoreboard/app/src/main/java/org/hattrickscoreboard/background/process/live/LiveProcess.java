package org.hattrickscoreboard.background.process.live;

import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.models.live.Live;
import org.hattrick.models.live.LiveMatch;
import org.hattrick.providers.params.HMatchQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.background.services.LiveService;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.tables.LiveTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class LiveProcess extends HProcess {

    static final String TAG = (LiveProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        // Result class (XML from CHPP)
        params.setResultClass(Live.class);
        request.setParams(params);

        Live res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        String fetchedDate = HattrickDate.getDateTime();

        if (res.getMatchList() != null) {

            for (LiveMatch match : res.getMatchList()) {

                // Get match if exist
                DLive live = (DLive) datasource.read(LiveTable.class,
                        LiveTable.COL_MATCH_ID + "=" + match.getMatchID()
                                + " AND " + LiveTable.COL_SOURCE_SYSTEM + "='"
                                + match.getSourceSystem() + "'");

                ContentValues values = new ContentValues();
                values.put(LiveTable.COL_FETCHED_DATE, fetchedDate);

                // New match...
                if (live == null) {

                    Log.i(TAG, " Add new live match " + match.getMatchDate());

                    // Match infos
                    values.put(LiveTable.COL_MATCH_ID, match.getMatchID());
                    values.put(LiveTable.COL_SOURCE_SYSTEM,
                            match.getSourceSystem());
                    values.put(LiveTable.COL_MATCH_DATE, match.getMatchDate());
                    values.put(LiveTable.COL_LAST_READ_EVENT_INDEX, -1);

                    // OnGoing match
                    if (match.getNextEventMinute() != null) {

                        values.put(LiveTable.COL_NEXT_EVENT_MINUTE,
                                match.getNextEventMinute());

                        values.put(LiveTable.COL_LAST_SHOWN_EVENT_INDEX,
                                match.getLastShownEventIndex());

                        values.put(LiveTable.COL_STATUS,
                                HMatchStatus.ONGOING);

                        // If goals -> Update
                        if (match.getHomeGoals() != null
                                && match.getAwayGoals() != null) {
                            values.put(LiveTable.COL_HOME_GOALS,
                                    match.getHomeGoals());
                            values.put(LiveTable.COL_AWAY_GOALS,
                                    match.getAwayGoals());
                        }

                    } else {
                        values.put(LiveTable.COL_NEXT_EVENT_MINUTE, -1);
                        values.put(LiveTable.COL_STATUS,
                                HMatchStatus.UPCOMING);
                        values.put(LiveTable.COL_HOME_GOALS, -1);
                        values.put(LiveTable.COL_AWAY_GOALS, -1);
                    }

                    // Match == null -> add row match on MachesTable
                    MatchUpdate update = new MatchUpdate();
                    HMatchQuery query = new HMatchQuery();
                    query.setMatchID(match.getMatchID());
                    query.setSourceSystem(match.getSourceSystem());
                    query.setEvent(true);
                    params.setObjectParam(query);

                    update.update(TAG, context, request, params, datasource);

                } else {

                    // Match already exist
                    Log.i(TAG,
                            " Update live ID: " + live.getID() + ", "
                                    + live.getMatchDate());

                    // OnGoing match
                    if (match.getNextEventMinute() != null) {

                        values.put(LiveTable.COL_NEXT_EVENT_MINUTE,
                                match.getNextEventMinute());

                        values.put(LiveTable.COL_LAST_SHOWN_EVENT_INDEX,
                                match.getLastShownEventIndex());

                        values.put(LiveTable.COL_STATUS,
                                HMatchStatus.ONGOING);

                        // If goals -> Update
                        if (match.getHomeGoals() != null
                                && match.getAwayGoals() != null) {
                            values.put(LiveTable.COL_HOME_GOALS,
                                    match.getHomeGoals());
                            values.put(LiveTable.COL_AWAY_GOALS,
                                    match.getAwayGoals());
                        }

                    }

                }

                // Create or update
                datasource.createOrUpdate(LiveTable.class, values,
                        LiveTable.COL_MATCH_ID + "=" + match.getMatchID()
                                + " AND " + LiveTable.COL_SOURCE_SYSTEM + "='"
                                + match.getSourceSystem() + "'");

                continue;

            }
        }

        // Start LiveService
        Intent startService = new Intent(context, LiveService.class);
        context.startService(startService);

        // Send broadcast
        fireSuccess();
    }
}
