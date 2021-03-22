package org.hattrickscoreboard.application.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.match.EventsTable;
import org.khips.tools.time.KReminder;

import java.text.ParseException;
import java.util.ArrayList;

public class HattrickLive {

    static final String TAG = (HattrickLive.class).getSimpleName();

    public static void setUpcomingMatchReminder(Context context,
                                                Intent liveIntent, DLive live) throws ParseException {

        // Set id live
        Bundle args = new Bundle();
        args.putLong(LiveTable.COL_ID, live.getID());

        // Set reminder
        long time = KReminder.setReminder(context, liveIntent,
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
        int playedSecond = HattrickDate.getMatchCurrentSecond(live
                .getMatchDate());

        // Next event minute refered to played minutes
        int nextEventPlayedSecond = HattrickDate.minuteToSecond(live
                .getNextEventMinute());

        // get seconds
        long time = -2;

        // Reminder now!
        if (live.getLastReadEventIndex() != live.getLastShownEventIndex()) {

            // Set reminder now! (5s)
            time = KReminder.setReminder(context, intent, 5, args);

        } else {
            if (HattrickDate.secondToMinute(playedSecond) < 200) {

                // Set reminder to next event played minute
                time = KReminder.setReminder(context, intent,
                        (nextEventPlayedSecond - playedSecond), args);
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
    }
}
