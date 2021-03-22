package org.hattrickscoreboard.background.process.live;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.models.live.Live;
import org.hattrick.models.live.LiveMatch;
import org.hattrick.models.match.Event;
import org.hattrick.providers.params.HMatchQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.match.EventsTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class LiveNewProcess extends HProcess {

    static final String TAG = (LiveNewProcess.class).getSimpleName();

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
        String matchStatus = HMatchStatus.ONGOING;

        if (res.getMatchList() != null && res.getMatchList().size() > 0) {
            for (LiveMatch match : res.getMatchList()) {

                ContentValues values = new ContentValues();

                // SET LIVE
                values.put(LiveTable.COL_FETCHED_DATE, fetchedDate);

                // Match not started or finished
                if (match.getNextEventMinute() == null) {
                    values.put(LiveTable.COL_NEXT_EVENT_MINUTE, -1);

                    // Match finished
                    values.put(LiveTable.COL_LAST_SHOWN_EVENT_INDEX,
                            match.getLastShownEventIndex());
                    values.put(LiveTable.COL_STATUS,
                            HMatchStatus.FINISHED);
                    matchStatus = HMatchStatus.FINISHED;

                } else {

                    // Update last show and next minute
                    values.put(LiveTable.COL_LAST_SHOWN_EVENT_INDEX,
                            match.getLastShownEventIndex());

                    values.put(LiveTable.COL_NEXT_EVENT_MINUTE,
                            match.getNextEventMinute());

                }

                // Create or update
                datasource.createOrUpdate(LiveTable.class, values,
                        LiveTable.COL_MATCH_ID + "=" + match.getMatchID()
                                + " AND " + LiveTable.COL_SOURCE_SYSTEM + "='"
                                + match.getSourceSystem() + "'");

                // //////////////////////////
                // THEN, IF MATCH FINISHED, CALL MATCHUPDATE TO GET ALL MATCH
                // DETAILS
                if (matchStatus.equals(HMatchStatus.FINISHED)) {

                    // Read match if exist
                    Match finishedMatch = (Match) datasource.read(
                            MatchesTable.class, MatchesTable.COL_MATCH_ID + "="
                                    + match.getMatchID() + " AND "
                                    + MatchesTable.COL_SOURCE_SYSTEM + "='"
                                    + match.getSourceSystem() + "'");

                    // Match finished and infos OK...
                    if (finishedMatch != null
                            && HMatchStatus.FINISHED
                            .equals(finishedMatch.getStatus())) {
                        Log.i(TAG, "Match finished and infos OK...");
                        continue;
                    }

                    // Match finished, download informations...
                    Log.w(TAG, "Match finished, download informations");
                    MatchUpdate update = new MatchUpdate();

                    HMatchQuery query = new HMatchQuery();
                    query.setMatchID(match.getMatchID());
                    query.setSourceSystem(match.getSourceSystem());
                    query.setEvent(true);
                    params.setObjectParam(query);
                    update.update(TAG, context, request, params, datasource);
                    continue;
                }

                // ADD NEW EVENTS
                for (Event event : match.getEventList()) {

                    ContentValues val = new ContentValues();
                    val.put(EventsTable.COL_MATCH_ID, match.getMatchID());
                    val.put(EventsTable.COL_SOURCE_SYSTEM,
                            match.getSourceSystem());
                    val.put(EventsTable.COL_MINUTE, event.getMinute());
                    val.put(EventsTable.COL_SUBJECT_PLAYER_ID,
                            event.getSubjectPlayerID());
                    val.put(EventsTable.COL_SUBJECT_TEAM_ID,
                            event.getSubjectTeamID());
                    val.put(EventsTable.COL_OBJECT_PLAYER_ID,
                            event.getObjectPlayerID());
                    val.put(EventsTable.COL_EVENT_TYPE_ID,
                            event.getEventTypeID());
                    val.put(EventsTable.COL_EVENT_VARIATION,
                            event.getEventVariation());
                    val.put(EventsTable.COL_EVENT_TEXT, event.getEventText());
                    val.put(EventsTable.COL_INDEX, event.getIndex());

                    // Create or update
                    datasource.createOrUpdate(
                            EventsTable.class,
                            val,
                            EventsTable.COL_MATCH_ID + "=" + match.getMatchID()
                                    + " AND " + EventsTable.COL_SOURCE_SYSTEM
                                    + "='" + match.getSourceSystem() + "' AND "
                                    + EventsTable.COL_INDEX + "="
                                    + event.getIndex());

                }

            }

            // Send broadcast
            fireSuccess();

        } else {

            // No result, no match?
            fireError(Background.RESULT_ERROR);
        }

    }
}
