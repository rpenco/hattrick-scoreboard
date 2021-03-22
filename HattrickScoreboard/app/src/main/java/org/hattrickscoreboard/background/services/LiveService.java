package org.hattrickscoreboard.background.services;

import android.content.Intent;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.providers.params.HLiveQuery;
import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.application.utils.HattrickLive;
import org.hattrickscoreboard.background.live.LiveBroadcastReceiver;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Run when application start or device start
 *
 * @author Khips
 * @since 17 march 2014
 */
public class LiveService extends HattrickService {

    static final String TAG = (LiveService.class).getSimpleName();

    Intent liveBroadcastReceiver;

    public LiveService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        Log.i(TAG, "Starting service...");

        // Create intent for receiver
        liveBroadcastReceiver = new Intent(this, LiveBroadcastReceiver.class);

        // add next matches to ht-lives
        updateNextMatches();

        // Update ongoing matches
        updateOngoingMatch();

        // Update upcoming matches
        updateUpcomingMatch();

    }

    /**
     * Set reminders for all followed matches
     */
    private void updateUpcomingMatch() {
        // //////////////////////////////////
        // Get all upcoming lives
        // And update reminder

        // Get all upcoming lives
        ArrayList<DLive> livesUpcoming = bdd.readAll(LiveTable.class,
                DLive.class, LiveTable.COL_STATUS + "='"
                        + HMatchStatus.UPCOMING + "'");

        // Foreach lives
        if (livesUpcoming != null) {
            for (DLive live : livesUpcoming) {

                try {
                    // Set reminder
                    HattrickLive.setUpcomingMatchReminder(context,
                            liveBroadcastReceiver, live);
                } catch (ParseException e) {
                }

            }
        }
    }

    /**
     * Add my next upcoming matches (for all my teams) on Hattrick live tracker
     */
    private void updateNextMatches() {

        // Get all upcoming lives
        ArrayList<DLive> livesUpcoming = bdd.readAll(LiveTable.class,
                DLive.class, LiveTable.COL_STATUS + "='"
                        + HMatchStatus.UPCOMING + "'");

        // Get my USER ID
        int userID = ((HattrickApplication) getApplication()).getMyUserID();

        // Get all my teams by USERID
        ArrayList<DTeam> myTeams = bdd.readAll(TeamTable.class, DTeam.class,
                TeamTable.COL_USER_ID + "=" + userID);

        // For each my teams, get upcoming match,
        // check if is on ht-live else -> addLive & setReminder
        for (DTeam dTeam : myTeams) {

            // Get all upcoming matches for each teams
            ArrayList<Match> myUpMatches = bdd.readAll(
                    MatchesTable.class,
                    Match.class,
                    MatchesTable.COL_STATUS + "='" + HMatchStatus.UPCOMING
                            + "' AND (" + MatchesTable.COL_HOME_TEAM_ID + "="
                            + dTeam.getTeamID() + " OR "
                            + MatchesTable.COL_AWAY_TEAM_ID + "="
                            + dTeam.getTeamID() + ") ORDER BY "
                            + MatchesTable.COL_MATCH_DATE + " ASC LIMIT 2");

            // Foreach match
            for (Match match : myUpMatches) {

                // Check if matches is on live
                DLive live = HattrickLive.isOnLive(this, match, livesUpcoming);

                // Not on live
                if (live == null) {

                    // Create query
                    HLiveQuery query = new HLiveQuery();
                    query.setActionType(HLiveQuery.ADD_MATCH);
                    query.setMatchID(match.getMatchID());
                    query.setSourceSystem(match.getSourceSystem());

                    // Get copy of original params object (in case of used
                    // anywhere..)
                    IParams parm = params;
                    parm.setObjectParam(query);

                    // Add on tracker (And lives table )
                    LiveUpdate update = new LiveUpdate();
                    update.update(TAG, this, request, parm, bdd);

                }

            }

        }

    }

    private void updateOngoingMatch() {
        // //////////////////////////////////
        // Get all ongoing lives
        // And update reminder

        // Get all upcoming lives
        ArrayList<DLive> livesOngoing = bdd.readAll(LiveTable.class,
                DLive.class, LiveTable.COL_STATUS + "='" + HMatchStatus.ONGOING
                        + "'");

        // Foreach lives
        if (livesOngoing != null) {
            for (DLive live : livesOngoing) {

                try {
                    // Set reminder
                    HattrickLive.setOngoingMatchReminder(context,
                            liveBroadcastReceiver, live);
                } catch (ParseException e) {
                }
            }
        }
    }
}
