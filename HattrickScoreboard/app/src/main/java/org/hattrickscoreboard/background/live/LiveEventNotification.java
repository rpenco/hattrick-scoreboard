package org.hattrickscoreboard.background.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

import org.hattrickscoreboard.MainActivity;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.views.match.workers.HattrickEventIcon;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.khips.tools.notifications.KNotification;

import java.util.ArrayList;

public class LiveEventNotification {

    static final String TAG = (LiveEventNotification.class).getSimpleName();

    /**
     * Check if match is with my team
     *
     * @param myTeams
     */
    private static boolean isMyTeam(ArrayList<DTeam> myTeams, Match match) {

        // Is my 1st or 2d team
        for (DTeam myTeam : myTeams) {
            if (match.getHomeTeamID() == myTeam.getTeamID()
                    || match.getAwayTeamID() == myTeam.getTeamID())
                return true;
        }
        return false;
    }

    /**
     * Get my USER ID
     *
     * @param bdd
     * @return
     */
    private static long getUserID(HattrickBDD bdd) {

        // Get my USERID
        DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_ID + "="
                + 1);
        return team.getUserID();
    }

    private static void notify(Context ctx, Match match, String title,
                               String text1, int sound) {

        // Create notif
        Builder builder = KNotification.builder(ctx, R.drawable.ic_launcher,
                title, text1);

        // Set sound
        builder = KNotification.sound(ctx, builder, sound);

        // Set vibrate
        builder = KNotification.vibrate(builder);

        // Create action
        Intent resultIntent = new Intent(ctx, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("matchID", match.getMatchID());
        bundle.putString("sourcesystem", match.getSourceSystem());

        resultIntent.putExtras(bundle);
        builder = KNotification.action(ctx, builder, resultIntent);

        // Send
        KNotification.show(ctx, builder, (int) match.getMatchID());
    }

    private static boolean isHomeTeam(Match match, Event ev) {
        return (match.getHomeTeamID() == ev.getSubjectTeamID());
    }

    private static String setTitle(Context ctx, Match match, DLive live,
                                   Event event, boolean isTeam, boolean isGoal) {

        int resString = R.string.notif_title_team_default;

        if (isTeam) {
            // Border team name
            if (isHomeTeam(match, event)) {

                resString = R.string.notif_title_team_home;
            } else {

                resString = R.string.notif_title_team_away;
            }
        } else if (isGoal) {
            // Border goal score
            if (isHomeTeam(match, event)) {

                resString = R.string.notif_title_goal_home;
            } else {

                resString = R.string.notif_title_goal_away;
            }

        }

        return ctx.getString(resString, match.getHomeTeamName(),
                match.getAwayTeamName(), live.getHomeGoals(),
                live.getAwayGoals());

    }

    private static String setText(Context ctx, Event event, int resString) {
        return event.getMinute() + "', " + ctx.getString(resString);
    }

    private static boolean notify(boolean isMyTeam, boolean myPref,
                                  boolean followedPref) {
        return notify(isMyTeam, true, myPref, followedPref, false, false);
    }

    private static boolean notify(boolean isMyTeam, boolean isMyEvent,
                                  boolean myPref, boolean followedPref, boolean myOppPref,
                                  boolean followedOppPref) {

        // My team match
        if (isMyTeam) {

            if (isMyEvent) {
                // Enable pref for this event
                if (myPref) {
                    return true;
                }

            } else {
                // Enable pref for this event (opponent)
                if (myOppPref) {
                    return true;
                }

            }
            // Followed match
        } else {

            // Enable pref for this event
            if (followedPref) {
                return true;
            }

        }
        return false;

    }

    private static boolean isMyEvent(ArrayList<DTeam> myTeams, Event lastEvent) {

        for (DTeam team : myTeams) {
            if (team.getTeamID() == lastEvent.getSubjectTeamID())
                return true;
        }
        return false;
    }

    public static EventNotif workEvent(Context ctx, Match match, DLive live,
                                       Event event, boolean isMyTeam, boolean isMyEvent) {

        Log.v(TAG,
                "Events: type:" + event.getEventTypeID() + " variation:"
                        + event.getEventVariation() + " teamID: "
                        + event.getSubjectTeamID());

        // Create object
        EventNotif notif = new EventNotif();

        // Get my preferences
        Preferences pref = new Preferences(ctx);

        // Get icon
        int res = HattrickEventIcon.icon(event);

        // Kickoff
        if (res == R.drawable.ic_event_31_rain
                || res == R.drawable.ic_event_32_fear
                || res == R.drawable.ic_event_33_sunny
                || res == R.drawable.ic_event_30_rain) {

            notif.setSound(EventNotif.SOUND_MATCH_KICKOFF);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_kickoff));
            notif.setNotify(notify(isMyTeam, pref.isKickOffNotification(),
                    pref.isKickOffFollowedNotification()));
        }

        // Half
        if (res == R.drawable.ic_event_45_half) {

            notif.setSound(EventNotif.SOUND_MATCH_HALFTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_halftime));
            notif.setNotify(notify(isMyTeam, pref.isHalfTimeNotification(),
                    pref.isHalfTimeFollowedNotification()));

        }

        // Walkover (forfait)
        if (res == R.drawable.ic_event_501_502_walkover) {
            notif.setSound(EventNotif.SOUND_MATCH_FULLTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_walkover));
            notif.setNotify(notify(isMyTeam, pref.isKickOffNotification(),
                    pref.isKickOffFollowedNotification()));
        }

        // Penalty goal
        if (res == R.drawable.ic_event_55_56_57_104_114_124_134_154_164_174_184_penalty_goal) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_penalty));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        // SE goal
        if (res == R.drawable.ic_event_105a109_115a119_125_se_goal) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_se));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        // Counter goal
        if (res == R.drawable.ic_event_140a143_186_counter_attack) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_goal_counter_attack));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        // Extension
        if (res == R.drawable.ic_event_70_extension) {
            notif.setSound(EventNotif.SOUND_MATCH_HALFTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_extension));
            notif.setNotify(notify(isMyTeam, pref.isHalfTimeNotification(),
                    pref.isHalfTimeFollowedNotification()));
        }

        // Penalty contest
        if (res == R.drawable.ic_event_71_penalty_contest) {
            notif.setSound(EventNotif.SOUND_MATCH_HALFTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_penalty_contest));
            notif.setNotify(notify(isMyTeam, pref.isHalfTimeNotification(),
                    pref.isHalfTimeFollowedNotification()));
        }

        // Coin
        if (res == R.drawable.ic_event_73_coin) {
            notif.setSound(EventNotif.SOUND_MATCH_HALFTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_coin));
            notif.setNotify(notify(isMyTeam, pref.isHalfTimeNotification(),
                    pref.isHalfTimeFollowedNotification()));
        }

        if (res == R.drawable.ic_event_90_94_injury_playing) {

            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, true, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_injury));
            notif.setNotify(notify(isMyTeam, pref.isKickOffNotification(),
                    pref.isKickOffFollowedNotification()));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isInjuriesNotification(),
                    pref.isInjuriesFollowedNotification(),
                    pref.isInjuriesOppNotification(),
                    pref.isInjuriesOppFollowedNotification()));

        }

        if (res == R.drawable.ic_event_91_95_injury_leave) {

            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, true, false));
            notif.setText2(setText(ctx, event, R.string.notif_text_injury_leave));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isInjuriesNotification(),
                    pref.isInjuriesFollowedNotification(),
                    pref.isInjuriesOppNotification(),
                    pref.isInjuriesOppFollowedNotification()));
        }

        if (res == R.drawable.ic_event_92_badly_injury_leave) {

            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, true, false));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_badly_injury_leave));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isInjuriesNotification(),
                    pref.isInjuriesFollowedNotification(),
                    pref.isInjuriesOppNotification(),
                    pref.isInjuriesOppFollowedNotification()));
        }

        if (res == R.drawable.ic_event_93_96_badly_injury_no_remplace) {

            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, true, false));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_badly_injury_no_leave));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isInjuriesNotification(),
                    pref.isInjuriesFollowedNotification(),
                    pref.isInjuriesOppNotification(),
                    pref.isInjuriesOppFollowedNotification()));
        }

        if (res == R.drawable.ic_event_100_110_120_130_150_160_170_180_freekick) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_goal_freekick));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_101_111_121_131_151_161_171_181_goal_middle) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_middle));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_102_112_122_132_152_162_172_182_goal_left) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_left));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_103_113_123_133_153_163_173_183_goal_right) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_right));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_185_indirect_freekick) {

            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_goal_indirect_freekick));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_187_goal_long) {
            notif.setSound(EventNotif.SOUND_MATCH_GOAL);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_goal_long));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isGoalNotification(),
                    pref.isGoalFollowedNotification()));
        }

        if (res == R.drawable.ic_event_510_511_yellow) {

            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_yellow_card));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isWarningNotification(),
                    pref.isWarningFollowedNotification(),
                    pref.isWarningOppNotification(),
                    pref.isWarningOppFollowedNotification()));

        }

        if (res == R.drawable.ic_event_512_513_yellow_red) {
            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event,
                    R.string.notif_text_yellow_red_card));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isWarningNotification(),
                    pref.isWarningFollowedNotification(),
                    pref.isWarningOppNotification(),
                    pref.isWarningOppFollowedNotification()));
        }

        if (res == R.drawable.ic_event_514_red) {
            notif.setSound(EventNotif.SOUND_EVENT);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_red_card));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, isMyEvent,
                    pref.isWarningNotification(),
                    pref.isWarningFollowedNotification(),
                    pref.isWarningOppNotification(),
                    pref.isWarningOppFollowedNotification()));
        }

        if (res == R.drawable.ic_event_599_fulltime) {

            notif.setSound(EventNotif.SOUND_MATCH_FULLTIME);
            notif.setText1(setTitle(ctx, match, live, event, false, true));
            notif.setText2(setText(ctx, event, R.string.notif_text_fulltime));

            // Enable notif?
            notif.setNotify(notify(isMyTeam, pref.isKickOffNotification(),
                    pref.isKickOffFollowedNotification()));
        }

        return notif;
    }

    public static void notifyEvents(Context ctx, Match match, DLive live,
                                    ArrayList<Event> newEvents, HattrickBDD bdd) {

        // My userid
        long userID = getUserID(bdd);

        // Get all my teams
        ArrayList<DTeam> myTeams = bdd.readAll(TeamTable.class, DTeam.class,
                TeamTable.COL_USER_ID + "=" + userID);

        // Check if is an event of my teams (for preferences notifs)
        boolean isMyTeam = isMyTeam(myTeams, match);

        // Events exist
        if (newEvents != null) {

            EventNotif notif = null;

            // Get only last event (not notify before)
            for (Event event : newEvents) {

                // Check if is an event of my team
                boolean isMyEvent = isMyEvent(myTeams, event);

                // Create event notification object
                EventNotif tempNotif = workEvent(ctx, match, live, event,
                        isMyTeam, isMyEvent);

                // if object enable notification
                if (tempNotif.isNotify()) {
                    notif = tempNotif;
                }
            }

            // if object notification
            if (notif != null) {

                // Send notification
                notify(ctx, match, notif.getText1(), notif.getText2(),
                        notif.getSound());
            }
            // else {
            //
            // // Send notification
            // notify(ctx, match, "Aucun evenement notifiable.", "Live ID: "
            // + live.getID(), R.raw.app_event);
            // }
        }
    }
}
