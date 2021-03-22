package org.hattrickscoreboardl.services.live;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.hattrick.constants.match.HMatchStatus;
import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.models.HLiveParam;
import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.database.models.live.HLive;
import org.hattrickscoreboardl.database.models.live.HLiveEvent;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.services.UpdateListener;
import org.hattrickscoreboardl.services.process.hattrick.LiveProcess;
import org.hattrickscoreboardl.services.process.hattrick.MatchProcess;
import org.hattrickscoreboardl.utils.HattrickLive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romain
 * on 03/12/2014.
 */
public class LiveService extends IntentService {

    static String TAG = (LiveService.class).getSimpleName();

    Context ctx;

    // For request
    IRequest request;

    //For update event notification
    Intent intent;
    public static String INTENT = "org.hattrickscoreboard.service.livereceiver";
    public static String UPDATECODE = "updatecode";
    public static String LIVEID = "liveID";

    public static String LIVE = "LIVE";
    public static String LIVE30 = "LIVE30";
    public static String LIVE1H = "LIVE1H";

    //Force update process
    boolean force = false;
    private long liveID;
    private HLive live;

    public LiveService() {
        super((LiveService.class).getSimpleName());
        intent = new Intent(INTENT);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Starting service...");

        ctx = this;

        request = new HattrickRequest(this, ((HattrickApplication) getApplication()).getCHPPToken(this));

        ////////////////////////////////////////////////////
        //By default, update all live steam
        if(intent.getExtras() == null) {

            LiveProcess liveProcess = new LiveProcess(ctx, request, force);
            liveProcess.setListener(new UpdateListener() {

                @Override
                public void onUpdateStart(String from) {
                    Log.v(TAG,"Starting update live....");
                }

                @Override
                public void onUpdateError(String from, int code) {
                    Log.e(TAG,"Error on update live. Code: "+code+".");
                }

                @Override
                public void onUpdateSuccess(String from) {
                    Log.w(TAG, "HTLive updated.");

                    //Get lives and set reminder if need
                    List<HLive> lives = HLive.listAll(HLive.class);

                    for(HLive live : lives){

                        //Upcoming match -> reminder for later
                        if(HMatchStatus.UPCOMING.equals(live.getMatchStatus())){

                            //Set reminder (1h left, 30min left)
                            HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                            continue;
                        }

                        //Ongoing match -> reminder next event
                        if(HMatchStatus.ONGOING.equals(live.getMatchStatus())){

                            //Set reminder now (for passed event)
                            HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live, true);
                            continue;
                        }


                        //Finished match -> update infos if need
                        if(HMatchStatus.FINISHED.equals(live.getMatchStatus())){

                            MatchProcess match = new MatchProcess(ctx, request, force);
                            match.setListener(new UpdateListener() {
                                @Override
                                public void onUpdateStart(String from) {
                                    Log.v(TAG,"Starting match process.");
                                }

                                @Override
                                public void onUpdateSuccess(String from) {
                                    Log.v(TAG,"Finished match process.");
                                }

                                @Override
                                public void onUpdateError(String from, int code) {
                                    Log.v(TAG,"Error match process....");
                                }
                            });
                            match.perform(live.getMatchID(), live.getSourceSystem());
                        }
                    }
                }
            });

            HLiveParam params = new HLiveParam();
            params.setActionType(HLiveParam.VIEW_ALL);
            liveProcess.perform(params);
        }

        ////////////////////////////////////////////////////
        // From Intent Live (Reminder)
        else {

            //From broadcast receiver, ongoing/finished match
            liveID = intent.getExtras().getLong(LiveService.LIVEID);
            String liveIt = intent.getExtras().getString(LIVE);

            //Get live
            live = HLive.findOne(HLive.class, "ID = ?", String.valueOf(liveID));
            if (live == null) {
                Log.e(TAG, "Live error. liveID: "+liveID);
                return;
            }

            //Set new TAG for logger
            TAG = (LiveService.class).getSimpleName()+"_"+live.getMatchID();

            //Reminder 1H before
            if(LIVE1H.equals(liveIt)){

                Log.i(TAG, "On receive live intent reminder 1H.");
                LiveEventNotification notification = new LiveEventNotification(ctx, live);
                notification.notifReminder1hour();

                //Set reminder in case of...
                HattrickLive reminder = new HattrickLive();
                reminder.setReminders(LiveService.this, live, false);
                return;
            }

            //Reminder 30 minutes before
            if(LIVE30.equals(liveIt)){

                Log.i(TAG, "On receive live intent reminder 30 minutes.");
                LiveEventNotification notification = new LiveEventNotification(ctx, live);
                notification.notifReminder30Minutes();

                //Set reminder in case of...
                HattrickLive reminder = new HattrickLive();
                reminder.setReminders(LiveService.this, live, false);
                return;
            }

            Log.i(TAG, "On receive live intent.");

            //HTLive get new events
            LiveProcess process = new LiveProcess(ctx, request, force);
            process.setListener(new UpdateListener() {

                @Override
                public void onUpdateStart(String from) {
                    Log.v(TAG,"Starting live new event...");
                }

                @Override
                public void onUpdateSuccess(String from) {
                    Log.i(TAG, "On Live update successed.");

                    live = HLive.findOne(HLive.class, "ID = ?", String.valueOf(liveID));
                    if(live == null) {
                        Log.e(TAG,"Live is null.");
                        return;
                    }

                    //Get from "lastReadEventID"
                    List<HLiveEvent> nonReadEvents = HLiveEvent.find(HLiveEvent.class, "MATCH_ID = ? and SOURCE_SYSTEM = ? and EVENT_INDEX > ?",
                            new String[]{String.valueOf(live.getMatchID()), live.getSourceSystem(), String.valueOf(live.getLastReadEventIndex())});

                    //Work events
                    if(nonReadEvents.size() > 0){

                        //Show notification
                        LiveEventNotification notif = new LiveEventNotification(ctx, live);
                        notif.notif(nonReadEvents);

                        //Update last read/show events
                        live.setLastReadEventIndex(live.getLastShownEventIndex());
                        live.save();

                        //Get last event
                        HLiveEvent lastEvent = nonReadEvents.get(nonReadEvents.size() - 1);
                        if(lastEvent.getEventTypeID() == 550){
                            Log.i(TAG, "matchID: " + live.getMatchID() + " finished.");
                            downloadMatchDetails(live);
                        }else {
                            //Set reminder for next events
                            HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                        }
                    }else{

                        //No new event...

                        //Current match second
                        long currentTime  = HattrickLive.getSecondMatchFromStarting(live.getMatchDate());
                        Log.i(TAG,"No events. Current second : "+currentTime);

                        //Pre-KickOff
                        if(currentTime == -1){
                            Log.i(TAG,"matchID: "+live.getMatchID()+" not started.");

                            //Set reminder for kickoff
                            HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                            return;
                        }

                        //Halftime
                        if(currentTime == -2){
                            Log.i(TAG,"matchID: "+live.getMatchID()+" halftime.");

                            //Show notification half-time
                            LiveEventNotification notif = new LiveEventNotification(ctx, live);
                            notif.notifHaftTime();

                            //Set reminder for next event
                            HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                            return;
                        }

                        //No event, End game or Error?

                        //Probably classic match
                        if(live.getNextEventMinute() <= 90) {

                            //Classic time
                            if (currentTime > HattrickLive.minToSec(90)) {
                                Log.i(TAG, "Live: matchid: " + live.getMatchID() + " probably finished (classic).");
                                downloadMatchDetails(live);

                            }else{
                                //Try download info in case of walkover
                                if (currentTime > HattrickLive.minToSec(5) && live.getNextEventMinute() == 0) {
                                    Log.w(TAG, "Live: matchid: " + live.getMatchID() + " walkover?.");
                                    downloadMatchDetails(live);
                                }else {

                                    if(currentTime > 0 && live.getNextEventMinute() == 0){

                                        Log.w(TAG, "Live: matchid: " + live.getMatchID() + " probably started (classic).");

                                        //Show notification half-time
                                        LiveEventNotification notif = new LiveEventNotification(ctx, live);
                                        notif.notifKickoff();

                                        HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                                    }else {
                                        Log.w(TAG, "Live: matchid: " + live.getMatchID() + " probably not finished (classic).");
                                        //Set reminder for next event
                                        HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                                    }
                                }
                            }

                        }else{

                            //Extra-time?
                            if (currentTime > HattrickLive.minToSec(140)) {
                                Log.i(TAG, "Live: matchid: " + live.getMatchID() + " probably finished (cup).");
                                downloadMatchDetails(live);
                            }else{

                                Log.w(TAG, "Live: matchid: " + live.getMatchID() + " probably not finished (cup).");
                                //Set reminder for next event
                                HattrickLive reminder = new HattrickLive();                 reminder.setReminders(LiveService.this, live);
                            }
                        }
                    }
                }

                @Override
                public void onUpdateError(String from, int code) {
                    Log.e(TAG, "MATCH ERROR");
                }
            });

            //Set param for HT-live (list all matches and set last show event index)
            List<HLive> lives = HLive.find(HLive.class, "MATCH_STATUS != 'FINISHED'");

            HLiveParam params = new HLiveParam();
            params.setActionType(HLiveParam.VIEW_NEW);

            ArrayList<Long> matchesID = new ArrayList<Long>();
            ArrayList<String> sources = new ArrayList<String>();
            ArrayList<Integer> lastRead = new ArrayList<Integer>();

            for(HLive l : lives) {
                matchesID.add(Long.valueOf(l.getMatchID()));
                sources.add(l.getSourceSystem());
                lastRead.add(l.getLastShownEventIndex());
            }

            params.setLastShowIndex(matchesID, sources, lastRead);
            process.perform(params);

        }
        Log.i(TAG, "End service...");
    }


    private void downloadMatchDetails(final HLive live) {

        MatchProcess matchprocess = new MatchProcess(ctx, request, force);
        matchprocess.setListener(new UpdateListener() {

            @Override
            public void onUpdateStart(String from) {
                Log.v(TAG,"Starting download match detail.");
            }

            @Override
            public void onUpdateSuccess(String from) {
                Log.i(TAG, "Live: matchid: " + live.getMatchID() + " finished and details downloaded.");

                HMatch match = HMatch.findOne(HMatch.class, "MATCH_ID = ? and SOURCE_SYSTEM = ?",
                        String.valueOf(live.getMatchID()), live.getSourceSystem());

                if(match.getFinishedDate() != null) {

                    //Update HTLive infos
                    live.setMatchStatus(HMatchStatus.FINISHED);
                    live.setHomeGoals(match.getHomeGoals());
                    live.setAwayGoals(match.getAwayGoals());
                    live.setLastReadEventIndex(live.getLastShownEventIndex());
                    live.save();

                    //Send notification
                    if (live.getLastShownEventIndex() == 0) {

                        LiveEventNotification notif = new LiveEventNotification(ctx, live);
                        notif.notifWalkover();

                    } else {

                        LiveEventNotification notif = new LiveEventNotification(ctx, live);
                        notif.notifFullTime();
                    }
                }else{

                    Log.e(TAG,"Match not finished. -> reset");

                    //Set reminder for next event
                    HattrickLive reminder = new HattrickLive();
                    reminder.setReminders(LiveService.this, live);
                }
            }

            @Override
            public void onUpdateError(String from, int code) {
                Log.e(TAG, "Match detail download error ["+code+"].");

            }
        });

        matchprocess.perform(live.getMatchID(), live.getSourceSystem());

    }

    void sendBrodcastNotification(String from, int code) {
        intent.putExtra(UPDATECODE, code);
        sendBroadcast(intent);
    }

}
