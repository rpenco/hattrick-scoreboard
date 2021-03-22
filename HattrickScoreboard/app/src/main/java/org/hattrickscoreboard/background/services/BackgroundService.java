package org.hattrickscoreboard.background.services;

import android.content.Intent;
import android.util.Log;

import org.hattrick.providers.params.HLiveQuery;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.ArenaUpdate;
import org.hattrickscoreboard.background.tasks.tables.BookmarksUpdate;
import org.hattrickscoreboard.background.tasks.tables.ClubUpdate;
import org.hattrickscoreboard.background.tasks.tables.EconomyUpdate;
import org.hattrickscoreboard.background.tasks.tables.LanguageUpdate;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.StaffUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.TrainingUpdate;
import org.hattrickscoreboard.background.tasks.tables.TransfersUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.background.tasks.tables.WorldUpdate;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.tables.TeamTable;

import java.util.ArrayList;

/**
 * Run when application start or device start
 *
 * @author Khips
 * @since 17 march 2014
 */
public class BackgroundService extends HattrickService {

    static final String TAG = (BackgroundService.class).getSimpleName();

    // All Updater
    private LanguageUpdate langUp;
    private PlayersUpdate playersUp;
    private ClubUpdate clubUp;
    private ArenaUpdate arenUp;
    private StaffUpdate staffUp;
    private TransfersUpdate transferUp;
    private MatchesUpdate matchesUp;
    private EconomyUpdate economyUp;
    private TrainingUpdate trainingUp;
    private SeriesUpdate seriesUp;
    private WorldUpdate worldUp;
    private BookmarksUpdate bookUp;
    private TeamUpdate teamUp;
    private LiveUpdate liveUp;

    public BackgroundService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);

        Log.i(TAG, "Starting service...");

        // Load language...
        langUp = new LanguageUpdate();
        langUp.addListener(this);

        // Load players...
        playersUp = new PlayersUpdate();
        playersUp.addListener(this);

        // Load clubs...
        clubUp = new ClubUpdate();
        clubUp.addListener(this);

        // Load arena...
        arenUp = new ArenaUpdate();
        arenUp.addListener(this);

        // Load staff...
        staffUp = new StaffUpdate();
        staffUp.addListener(this);

        // Load transfers...
        transferUp = new TransfersUpdate();
        transferUp.addListener(this);

        // Load matches...
        matchesUp = new MatchesUpdate();
        matchesUp.addListener(this);

        // Load economy...
        economyUp = new EconomyUpdate();
        economyUp.addListener(this);

        // Load training...
        trainingUp = new TrainingUpdate();
        trainingUp.addListener(this);

        // Load series...
        seriesUp = new SeriesUpdate();
        seriesUp.addListener(this);

        // Load world detail (infos & cup)...
        worldUp = new WorldUpdate();
        worldUp.addListener(this);

        // Load bookmarks (friend teams)
        bookUp = new BookmarksUpdate();
        bookUp.addListener(this);

        // Load HT-Live matchs
        liveUp = new LiveUpdate();
        liveUp.addListener(this);

        // Load Team...
        teamUp = new TeamUpdate();
        teamUp.addListener(new UpdateListener() {

            @Override
            public void onUpdateSuccess(String from) {

                // Send broadcast team updated!
                Log.i(TAG, "Send broadcast '" + from + "' success");
                sendBrodcastNotification(Background.RESULT_OK, from);

                // Get my informations
                DTeam myTeam = (DTeam) bdd.read(TeamTable.class,
                        TeamTable.COL_ID + "=1");

                // Get all my teams
                ArrayList<DTeam> teams = bdd.readAll(TeamTable.class,
                        DTeam.class,
                        TeamTable.COL_USER_ID + "=" + myTeam.getUserID());

                // For each my teams, update all (if needed)
                for (DTeam team : teams) {

                    Log.v(TAG, "Team ID: " + team.getTeamID());

                    // Set params
                    params.setObjectParam(new HQuery(team, team));

                    // Launch club update...
                    clubUp.update(TAG, context, request, params, bdd, FU);

                    // Launch staff update...
                    staffUp.update(TAG, context, request, params, bdd, FU);

                    // Launch players update...
                    playersUp.update(TAG, context, request, params, bdd, FU);

                    // Launch arena update...
                    arenUp.update(TAG, context, request, params, bdd, FU);

                    // Launch transfers update...
                    transferUp.update(TAG, context, request, params, bdd, FU);

                    // Launch series update...
                    seriesUp.update(TAG, context, request, params, bdd, FU);

                    // Launch matches update...
                    matchesUp.update(TAG, context, request, params, bdd, FU);

                    // Launch economy update...
                    economyUp.update(TAG, context, request, params, bdd, FU);

                    // Launch training update...
                    trainingUp.update(TAG, context, request, params, bdd, FU);

                }

                // Launch language update...
                langUp.update(TAG, context, request, params, bdd, FU);

                // Launch bookmarks update...
                bookUp.update(TAG, context, request, params, bdd, FU);

                // Launch world update...
                worldUp.update(TAG, context, request, params, bdd, FU);

                // Launch live update...
                HLiveQuery livequery = new HLiveQuery();
                livequery.setActionType(HLiveQuery.VIEW_ALL);
                params.setObjectParam(livequery);
                liveUp.update(TAG, context, request, params, bdd, FU);

            }

            @Override
            public void onUpdateCanceled(String from) {
                Log.i(TAG, "Send broadcast '" + from + "' canceled!");
                sendBrodcastNotification(Background.RESULT_ERROR, from);
            }

            @Override
            public void onUpdateStart(String from) {
                Log.i(TAG, "Send broadcast '" + from + "' started");
                sendBrodcastNotification(Background.RESULT_START, from);

            }
        });

        teamUp.update(TAG, context, request, params, bdd, true);
    }

}
