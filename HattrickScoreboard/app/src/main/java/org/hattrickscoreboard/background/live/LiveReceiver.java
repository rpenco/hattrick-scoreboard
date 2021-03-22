package org.hattrickscoreboard.background.live;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.params.HLiveQuery;
import org.hattrick.providers.params.HMatchQuery;
import org.hattrick.providers.params.HattrickParams;
import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.application.utils.HattrickLive;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.services.HattrickService;
import org.hattrickscoreboard.background.tasks.live.LiveNewUpdate;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.text.ParseException;
import java.util.ArrayList;

public class LiveReceiver extends IntentService {

    static final String TAG = (LiveReceiver.class).getSimpleName();
    HattrickRequest request;
    HattrickParams params;
    HattrickBDD bdd;
    long liveColID;
    Context ctx;
    Intent liveBroadcastReceiver;
    private DLive live;

    public LiveReceiver() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "/!\\ Live RECEIVE INTENT");

        // Set attributes
        this.ctx = this;
        request = new HattrickRequest();
        params = new HattrickParams();
        liveBroadcastReceiver = new Intent(ctx, LiveBroadcastReceiver.class);

        // Init requester & DB
        request.init(this);
        // Init database
        bdd = ((HattrickApplication) getApplication()).getBDD(this);

        // Get bundle
        Bundle bundle = intent.getExtras();
        if (bundle != null && bundle.getLong(LiveTable.COL_ID) != 0) {

            // Get which match (column _ID)
            liveColID = bundle.getLong(LiveTable.COL_ID);

            // Get live object
            live = (DLive) bdd.read(LiveTable.class, LiveTable.COL_ID + "="
                    + liveColID);

            if (live == null)
                return;

            // Match finished?
            if (HMatchStatus.FINISHED.equals(live.getMatchStatus())) {
                Log.w(TAG, "match already finished!");
                return;
            }

            // Log.e(TAG,
            // "[!] Before Update: Live "
            // + live.getID()
            // + ", last show: "
            // + live.getLastShownEventIndex()
            // + ", last read: "
            // + live.getLastReadEventIndex()
            // + ", played minute: "
            // + HattrickDate.getMatchCurrentSecond(live
            // .getMatchDate()) / 60 + "'"
            // + ", next minute: " + live.getNextEventMinute()
            // + "'");

            // Prepare query for viewNew events
            // Set parameters
            HLiveQuery obj = new HLiveQuery();
            obj.setActionType(HLiveQuery.VIEW_NEW);
            obj.setLastShowIndex(live);
            params.setObjectParam(obj);

            // Set Updater
            LiveNewUpdate liveUp = new LiveNewUpdate();
            liveUp.addListener(new UpdateListener() {

                @Override
                public void onUpdateSuccess(String serviceFrom) {
                    Log.i(TAG, "New live update for this match.");

                    // Get live object
                    live = (DLive) bdd.read(LiveTable.class, LiveTable.COL_ID
                            + "=" + liveColID);

                    // Get match
                    // Log.e(TAG,
                    // "[!] After Update: Live "
                    // + live.getID()
                    // + ", last show: "
                    // + live.getLastShownEventIndex()
                    // + ", last read: "
                    // + live.getLastReadEventIndex()
                    // + ", played minute: "
                    // + HattrickDate.getMatchCurrentSecond(live
                    // .getMatchDate()) / 60 + "'"
                    // + ", next minute: "
                    // + live.getNextEventMinute() + "'");

                    // Get new events
                    ArrayList<Event> newEvents = HattrickLive.getNewEvent(bdd,
                            live);

                    if (newEvents != null) {

                        // Read match
                        Match match = (Match) bdd.read(
                                MatchesTable.class,
                                MatchesTable.COL_MATCH_ID + "="
                                        + live.getMatchID() + " AND "
                                        + MatchesTable.COL_SOURCE_SYSTEM + "='"
                                        + live.getSourceSystem() + "'");

                        // Notify events
                        Log.i(TAG, "notify events if need");
                        LiveEventNotification.notifyEvents(ctx, match, live,
                                newEvents, bdd);

                        // Update last read events values
                        ContentValues values = new ContentValues();
                        values.put(LiveTable.COL_LAST_READ_EVENT_INDEX,
                                live.getLastShownEventIndex());

                        // Save changes
                        bdd.update(LiveTable.class, values, LiveTable.COL_ID
                                + "=" + liveColID);

                        // Set reminder for next events
                        if (!HMatchStatus.FINISHED.equals(match.getStatus())) {

                            try {
                                HattrickLive.setOngoingMatchReminder(ctx,
                                        liveBroadcastReceiver, live);
                            } catch (ParseException e) {
                            }
                        }

                        // Notifi
                        sendBrodcastNotification(Background.RESULT_OK,
                                LiveUpdate.FROM);
                    } else {

                        Log.i(TAG, "live " + live.getID()
                                + ", no new events...");

                        // Update last read events values
                        ContentValues values = new ContentValues();
                        values.put(LiveTable.COL_STATUS, HMatchStatus.FINISHED);

                        // Save changes
                        bdd.update(LiveTable.class, values, LiveTable.COL_ID
                                + "=" + liveColID);

                    }
                }

                @Override
                public void onUpdateStart(String serviceFrom) {

                }

                @Override
                public void onUpdateCanceled(String serviceFrom) {

                    Log.w(TAG, "Not new events for this match (is finished?)");

                    // Get match infos
                    HMatchQuery obj = new HMatchQuery();
                    obj.setMatchID(live.getMatchID());
                    obj.setSourceSystem(live.getSourceSystem());
                    obj.setEvent(true);
                    params.setObjectParam(obj);

                    MatchUpdate update = new MatchUpdate();
                    update.addListener(new UpdateListener() {

                        @Override
                        public void onUpdateSuccess(String serviceFrom) {
                            Log.i(TAG,
                                    "Receive detail for match (live "
                                            + live.getID() + ")");

                            // Get new events
                            ArrayList<Event> newEvents = HattrickLive
                                    .getNewEvent(bdd, live);

                            // Read match
                            Match match = (Match) bdd.read(
                                    MatchesTable.class,
                                    MatchesTable.COL_MATCH_ID + "="
                                            + live.getMatchID() + " AND "
                                            + MatchesTable.COL_SOURCE_SYSTEM
                                            + "='" + live.getSourceSystem()
                                            + "'");

                            // Work notification
                            LiveEventNotification.notifyEvents(ctx, match,
                                    live, newEvents, bdd);

                            // Match finished!
                            if (match != null
                                    && match.getMatchFinishedDate() != null) {

                                Log.w(TAG, "Live " + live.getID()
                                        + ", Match finished!");

                                // Set finished live
                                ContentValues values = new ContentValues();
                                values.put(LiveTable.COL_STATUS,
                                        HMatchStatus.FINISHED);

                                // Save changes
                                bdd.update(LiveTable.class, values,
                                        LiveTable.COL_ID + "=" + liveColID);
                            } else {

                                if (HMatchStatus.ONGOING.equals(live
                                        .getMatchStatus())) {
                                    Log.e(TAG,
                                            "Live "
                                                    + live.getID()
                                                    + ", Not event & match not finised!");

                                    try {
                                        // Set reminder for next events
                                        HattrickLive.setOngoingMatchReminder(
                                                ctx, liveBroadcastReceiver,
                                                live);

                                    } catch (ParseException e) {
                                    }

                                } else {
                                    Log.e(TAG, "Match not started (Live "
                                            + live.getID() + ")");
                                    try {
                                        // Set reminder for next events
                                        HattrickLive.setUpcomingMatchReminder(
                                                ctx, liveBroadcastReceiver,
                                                live);
                                    } catch (ParseException e) {
                                    }

                                }
                            }

                            // Notifi
                            sendBrodcastNotification(Background.RESULT_OK,
                                    LiveUpdate.FROM);
                        }

                        @Override
                        public void onUpdateStart(String serviceFrom) {

                        }

                        @Override
                        public void onUpdateCanceled(String serviceFrom) {
                            Log.e(TAG, "FAILED receive detail for match (live "
                                    + live.getID() + ")");

                        }
                    });
                    update.update(TAG, ctx, request, params, bdd);

                }
            });

            liveUp.update(TAG, this, request, params, bdd);

        }

    }

    private void sendBrodcastNotification(int resultCode, String serviceFrom) {
        Intent intent = new Intent(HattrickService.INTENT);
        intent.putExtra(HattrickService.RESULT, resultCode);
        intent.putExtra(HattrickService.FROM, serviceFrom);
        sendBroadcast(intent);
    }
}
