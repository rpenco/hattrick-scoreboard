package org.hattrickscoreboardl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import org.hattrickscoreboardl.database.models.live.HLive;
import org.hattrickscoreboardl.services.live.LiveService;
import org.hattrickscoreboardl.services.receivers.HattrickLiveReceiver;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class HattrickLive {

    static final String TAG = (HattrickLive.class).getSimpleName();

   /**
     * Set reminder 1 hours left, 30 minutes left and o'clock
     * @param ctx
     * @param live
     * @param forced
     */
    public void setReminders(Context ctx, HLive live, boolean forced) {

        Intent itt = new Intent(ctx, HattrickLiveReceiver.class);
        itt.putExtra(LiveService.LIVE, "");

        if(live.getMatchDate() == null) {
            Log.e(TAG, live.getMatchID()+". match date == null.");
            return;
        }

        //Second before..
        long secondKickoff =  getRealSecondFromMatchStarting(live.getMatchDate());
        long secondBefore30MinKickoff =  secondKickoff + 1800;
        long secondBefore1HKickoff =  secondKickoff + 3600;

        //Force reminder now.
        if(forced){
            setAlarm(itt, ctx, live, 5);
            return;
        }

        //Upcoming reminder
        if(secondKickoff < 0){

            if(secondBefore1HKickoff < 0){
                Log.i(TAG, live.getMatchID()+". Set before 1H reminder.");
                itt.putExtra(LiveService.LIVE, LiveService.LIVE1H);
                setAlarm(itt, ctx, live, Math.abs(secondBefore1HKickoff));
            }
            else{
                if(secondBefore30MinKickoff < 0){
                    Log.i(TAG, live.getMatchID()+". Set before 30Min reminder.");
                    itt.putExtra(LiveService.LIVE, LiveService.LIVE30);
                    setAlarm(itt, ctx, live, Math.abs(secondBefore30MinKickoff));
                }else{
                    Log.i(TAG, live.getMatchID() + ". Set kickoff reminder.");
                    setAlarm(itt, ctx, live, Math.abs(secondKickoff + 60)); //Secure second
                }
            }
        }
        else{
            //Ongoing reminder (next event)
            Log.i(TAG, live.getMatchID()+". Set event reminder.");

            //Next event in second
            long nextEventSecond = getMatchNextEventSecond(live);

            //Set with halftime (add 15min)
            if(nextEventSecond == -2){
                Log.i(TAG, live.getMatchID()+". is halftime.");

                //Half time left
                long tpsLeftRealMT = (minToSec(45) + minToSec(15)) - secondKickoff;

                //Next event after half time starting
                long nextEventAfterMT = minToSec(live.getNextEventMinute()) - minToSec(45);

                //Time before next event
                nextEventSecond = tpsLeftRealMT + nextEventAfterMT;
                nextEventSecond += 30; //Secure second

            }

            //Fix bug..
            if(nextEventSecond < 0){

                Log.i(TAG, live.getMatchID()+". fix next event second < 0. NextEventMin: "+live.getNextEventMinute());
                nextEventSecond = 30;
            }

            setAlarm(itt, ctx, live, nextEventSecond);

        }
    }

    public void setReminders(Context ctx, HLive live) {
        setReminders(ctx, live, false);
    }

    /**
     * Get real second from start match
     * @param matchDate
     * @return value > 0 match started, else match upcoming
     */
    public static long getRealSecondFromMatchStarting(String matchDate){

        try {
            Date currentDate = HattrickDate.StringToDate(HattrickDate.getDateTime());
            Date mDate = HattrickDate.StringToDate(matchDate);
            return ((currentDate.getTime() - mDate.getTime()) / 1000);
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     * Get Current match Second value > 0
     * @param matchDate
     * @return current second. -1 if not started. -2 if half time
     */
    public static long getSecondMatchFromStarting(String matchDate){

        //Get real time second (with half)
        long realSecond = getRealSecondFromMatchStarting(matchDate);

        // if real > 0, match started
        if (realSecond > 0) {

            // First half, real second == match second
            if (realSecond < minToSec(45)) {
                return realSecond;
            } else {

                // Half-time, match second == 45.
                if (realSecond >= minToSec(45)
                        && realSecond < minToSec(60)) {
                    return -2;
                } else {

                    // Second half, match second == real second - 15min.
                    if (realSecond >= minToSec(60)
                            && realSecond < minToSec(105)) {
                        return realSecond - minToSec(15);
                    } else {

                        // Extra-time (real - 1er half - Extra?)
                        return realSecond - minToSec(15);
                    }
                }
            }
        }
        return -1;
    }


    public static long getMatchNextEventSecond(HLive live){

        long currentSecond =  getSecondMatchFromStarting(live.getMatchDate());
        long nextEventSecond = minToSec(live.getNextEventMinute());
        if(currentSecond > 0) {
            return nextEventSecond - currentSecond;
        }
        else{
            return currentSecond;
        }
    }


    public static void setAlarm(Intent itt, Context ctx, HLive live, long time){

        Calendar cal = Calendar.getInstance();
//        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        cal.add(Calendar.SECOND, (int) time);

        //Set match id
        itt.putExtra(LiveService.LIVEID, live.getId());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(ctx,
                live.getMatchID(), itt, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) ctx
                .getSystemService(Context.ALARM_SERVICE);

        //Set status bar color (Lollipop)
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.KITKAT){

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                    pendingIntent);
        }else{
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),0,pendingIntent);
        }


        Log.e(TAG,
                "Set reminder : Live ID: " + live.getMatchID() + ", date:"
                        + live.getMatchDate() + ", set : "
                        + time + "sec. Next event: "+live.getNextEventMinute()+"'");
    }

    public static int secToMin(long second) {
        return (int) (second / 60);
    }

    public static int minToSec(int minute) {
        return minute * 60;
    }


  /*  public static void setReminders(Context ctx, Intent itt, HLive live, boolean forced) {

        //Get current date/time
        Calendar cal = Calendar.getInstance();

        //Time to remind
        long time = 0;

        //Forced reminder for now?
        if(forced) {
            Log.i(TAG, live.getMatchID()+". Force reminder.");
            time = 5;
        }else{

            Date matchDate;

            try {
                //Get match date/time
                matchDate = HattrickDate.StringToDate(live.getMatchDate());
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }

            //Get when match start
            time = ((matchDate.getTime() - cal.getTimeInMillis()) / 1000);

            //Second from kickoff
            long fromStartSecond =  getRealSecondFromMatchStarting(matchDate);

            //Ongoing match
            if(time <= 0){

                //Next event in second
                time = getMatchNextEventSecond(matchDate, live.getNextEventMinute());

                //Set with halftime (add 15min)
                if(time == -2){

                    Log.i(TAG, "Match ID:"+live.getMatchID()+" is halftime.");

                    //Half time left
                    long tpsLeftRealMT = (minToSec(45) + minToSec(15)) - fromStartSecond;

                    //Next event after half time starting
                    long nextEventAfterMT = minToSec(live.getNextEventMinute()) - minToSec(45);

                    //Time before next event
                    time = tpsLeftRealMT + nextEventAfterMT;
                }

                //Security second
                time += 30;
            }

            //No event?
            if (time <= 0 && fromStartSecond > 0) {
                Log.e(TAG, live.getMatchID()+". time reminder < 0. Match not finished, reminder at 20 sec");
                time = 20;

            }
        }

        //add
        cal.add(Calendar.SECOND, (int) time);

        //Set match id
        itt.putExtra(LiveService.LIVEID, live.getId());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(ctx,
                live.getMatchID(), itt, 0);

        AlarmManager alarmManager = (AlarmManager) ctx
                .getSystemService(Context.ALARM_SERVICE);

        alarmManager.setExact(AlarmManager.RTC, cal.getTimeInMillis(),
                    pendingIntent);

        Log.e(TAG,
                "Set reminder : Live ID: " + live.getMatchID() + ", date:"
                        + live.getMatchDate() + ", set : "
                        + time + "sec. Next event: "+live.getNextEventMinute()+"'");

    }*/

    /*static Date getMatchDate(String date) {

        if(date != null) {
            try {
                //Get match date/time
                return HattrickDate.StringToDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }*/











   /* public static void setUpcomingMatchReminder(Context context,
                                                Intent liveIntent, DLive live) throws ParseException {

        // Set id live
        Bundle args = new Bundle();
        args.putLong(LiveTable.COL_ID, live.getID());

        // Set reminder
        long time = KReminder.setReminders(context, liveIntent,
                HattrickDate.StringToDate(live.getMatchDate()), args);

        Log.e(TAG,
                "Live upcoming: " + live.getID() + ", date:"
                        + live.getMatchDate() + ", set reminder: "
                        + HattrickDate.secondToMinute((int) time) + "'");

    }

    public static long setOngoingMatchReminder(Context context, Intent intent,
                                               DLive live) throws ParseException {

        // Set id live
        Bundle args = new Bundle();
        args.putLong(LiveTable.COL_ID, live.getID());

        // Match second without half time
        int matchSecond = HattrickDate.getRealMatchCurrentSecond(live
                .getMatchDate());

        // Played seconds
        int playedSecond = HattrickDate.getSecondMatchFromStarting(live
                .getMatchDate());

        // Next event minute refered to played minutes
        int nextEventPlayedSecond = HattrickDate.minuteToSecond(live
                .getNextEventMinute());

        // Log.w(TAG,
        // "Live " + live.getID() + ", Match minute: "
        // + HattrickDate.secondToMinute(matchSecond)
        // + "', played minutes: "
        // + HattrickDate.secondToMinute(playedSecond)
        // + "', next event minute: "
        // + HattrickDate.secondToMinute(nextEventPlayedSecond)
        // + "'");

        // get seconds
        long time = -2;

        // Reminder now!
        if (live.getLastReadEventIndex() != live.getLastShownEventIndex()) {

            // Set reminder now! (5s)
            time = KReminder.setReminders(context, intent, 5, args);
            // Log.e(TAG,
            // "Live ongoing " + live.getID() + ", date:"
            // + live.getMatchDate()
            // + ", event in waiting... set reminder: "
            // + HattrickDate.secondToMinute((int) time) + "'");

        } else {
            if (HattrickDate.secondToMinute(playedSecond) < 200) {

                // Set reminder to next event played minute
                time = KReminder.setReminders(context, intent,
                        (nextEventPlayedSecond - playedSecond), args);
                // Log.e(TAG,
                // "Live ongoing " + live.getID() + ", date:"
                // + live.getMatchDate() + ", set reminder: "
                // + HattrickDate.secondToMinute((int) time) + "'");
            } else {

                Log.e(TAG,
                        "Live finished? " + live.getID() + ", date:"
                                + live.getMatchDate() + ", played: "
                                + HattrickDate.secondToMinute(playedSecond)
                                + "'");
            }
        }
        return time;
    }

    public static ArrayList<Event> getNewEvent(HattrickBDD bdd, DLive live) {

        ArrayList<Event> newEvents = bdd.readAll(
                EventsTable.class,
                Event.class,
                EventsTable.COL_MATCH_ID + "=" + live.getMatchID() + " AND "
                        + EventsTable.COL_SOURCE_SYSTEM + "='"
                        + live.getSourceSystem() + "' AND "
                        + EventsTable.COL_INDEX + " > "
                        + live.getLastReadEventIndex());

        if (newEvents != null)
            Log.w(TAG,
                    "live " + live.getID() + ", new events: "
                            + newEvents.size());

        return newEvents;
    }

    public static DLive isOnLive(Context ctx, Match match,
                                 ArrayList<DLive> lives) {

        if (lives != null)
            for (DLive live : lives) {

                if (match.getMatchID() == live.getMatchID()
                        && match.getSourceSystem().equals(
                        live.getSourceSystem()))
                    return live;

            }
        return null;
    }*/
}
