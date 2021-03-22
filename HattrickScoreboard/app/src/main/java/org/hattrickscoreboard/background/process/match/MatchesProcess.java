package org.hattrickscoreboard.background.process.match;

import android.content.ContentValues;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.models.matches.Match;
import org.hattrick.models.matches.Matches;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class MatchesProcess extends HProcess {

    static final String TAG = (MatchesProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        // TODO updater for matches
        // HattrickObject obj = (HattrickObject) params.getObjectParam();
        //
        // boolean needUpdate = datasource.needUpdate(MatchesTable.class,
        // forceUpdate, StaffTable.COL_TEAM_ID + "=" + obj.getTeamID());
        //
        // if (!needUpdate) {
        // Log.i(TAG, "not need update.");
        // fireSuccess();
        // return;
        // }

        // Result class (XML from CHPP)
        params.setResultClass(Matches.class);
        request.setParams(params);

        Matches res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Get current date time
        String fetchedDate = HattrickDate.getDateTime();

        // Insert or update into DB

        for (Match match : res.getMatchList()) {

            // Foreach staff member

            ContentValues values = new ContentValues();

            values.put(MatchesTable.COL_MATCH_ID, match.getMatchID());
            values.put(MatchesTable.COL_SOURCE_SYSTEM, match.getSourceSystem());
            values.put(MatchesTable.COL_MATCH_YOUTH, res.isYouth());
            values.put(MatchesTable.COL_MATCH_DATE, match.getMatchDate());
            values.put(MatchesTable.COL_MATCH_TYPE, match.getMatchType());
            values.put(MatchesTable.COL_MATCH_CONTEXT_ID,
                    match.getMatchContextID());

            values.put(MatchesTable.COL_HOME_TEAM_ID, match.getHomeTeamID());
            values.put(MatchesTable.COL_HOME_TEAM_NAME, match.getHomeTeamName());
            values.put(MatchesTable.COL_HOME_TEAM_SHORT_NAME,
                    match.getHomeTeamShortName());

            values.put(MatchesTable.COL_AWAY_TEAM_ID, match.getAwayTeamID());
            values.put(MatchesTable.COL_AWAY_TEAM_NAME, match.getAwayTeamName());
            values.put(MatchesTable.COL_AWAY_TEAM_SHORT_NAME,
                    match.getAwayTeamShortName());

            // Fix bug 0 for match not started and score 0 for match finished
            // Set -1 if not started
            String finished = HMatchStatus.FINISHED;

            values.put(MatchesTable.COL_HOME_GOALS,
                    (match.getStatus().equals(finished) ? match.getHomeGoals()
                            : -1));
            values.put(MatchesTable.COL_AWAY_GOALS,
                    (match.getStatus().equals(finished) ? match.getAwayGoals()
                            : -1));

            values.put(MatchesTable.COL_STATUS, match.getStatus());
            values.put(MatchesTable.COL_ORDERS_GIVEN, match.isOrdersGiven());
            values.put(MatchesTable.COL_FETCHED_DATE, fetchedDate);
            values.put(MatchesTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_MATCH);

            // Create or update
            datasource.createOrUpdate(MatchesTable.class, values,
                    MatchesTable.COL_MATCH_ID + "=" + match.getMatchID());

        }

        // Send broadcast
        fireSuccess();
    }
}
