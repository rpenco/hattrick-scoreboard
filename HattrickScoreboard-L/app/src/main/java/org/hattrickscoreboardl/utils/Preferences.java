package org.hattrickscoreboardl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Khips
 * @since 19 mars 2014
 */
public final class Preferences {

    private static String PREFERENCESNAME = (Preferences.class).getSimpleName();
    private SharedPreferences preferences;
    private Editor editor;

    //Preferences application
    public static String SELECTED_LOCALE = "locale";    /*fr_fr*/
    public static String FIRST_LAUNCH = "firstLaunch"; //Tuto..

    public static String USER_ID = "userID";
    public static String SELECTED_TEAM_ID = "selectedTeam"; //ID

    /////////////////////////////////////
    /** Nationals teams  **/

    public static String NATIONAL_LEAGUE_ID = "nationalLeagueID"; /*5*/

    /*National senior */
    public static String NOTIF_NATIONAL_REMINDER_1H = "notifNationalReminder1H";
    public static String NOTIF_NATIONAL_REMINDER_30M = "notifNationalReminder30M";
    public static String NOTIF_NATIONAL_KICKOFF = "notifNationalKickoff";
    public static String NOTIF_NATIONAL_HALFTIME = "notifNationalHalftime";
    public static String NOTIF_NATIONAL_GOALS = "notifNationalGoals";
    public static String NOTIF_NATIONAL_INJURIES = "notifNationalInjuries";
    public static String NOTIF_NATIONAL_CARDS = "notifNationalCards";

    /* National Junior*/
    public static String NOTIF_U20_REMINDER_1H = "notifU20Reminder1H";
    public static String NOTIF_U20_REMINDER_30M = "notifU20Reminder30M";
    public static String NOTIF_U20_KICKOFF = "notifU20Kickoff";
    public static String NOTIF_U20_HALFTIME = "notifU20Halftime";
    public static String NOTIF_U20_GOALS = "notifU20Goals";
    public static String NOTIF_U20_INJURIES = "notifU20Injuries";
    public static String NOTIF_U20_CARDS = "notifU20Cards";


    /////////////////////////////////////
    /** Team 1 (Primary team) **/

    public static String COLOR_RGB_1STTEAM = "color1stTeam";
    public static String TIMEZONE_OFFSET_1STTEAM = "timezone1stTeam";
    public static String WORLD_1STTEAM = "world1stTeam";

    public static String NOTIF_1STTEAM_ECONOMICAL = "economicalNotif";
    public static String NOTIF_1STTEAM_TRAINING = "trainingNotif";

    /** Lives **/
    public static String NOTIF_1STTEAM_REMINDER_1H = "notif1stTeamReminder1H";
    public static String NOTIF_1STTEAM_REMINDER_30M = "notif1stTeamReminder30M";
    public static String NOTIF_1STTEAM_KICKOFF = "notif1stTeamKickoff";
    public static String NOTIF_1STTEAM_HALFTIME = "notif1stTeamHalfteam";
    public static String NOTIF_1STTEAM_GOALS = "notif1stTeamGoals";
    public static String NOTIF_1STTEAM_INJURIES = "notif1stTeamInjuries";
    public static String NOTIF_1STTEAM_CARDS = "notif1stTeamCards";


    /** Team 2 (Secondary team) **/

    public static String COLOR_RGB_2NDTEAM = "color2ndTeam";
    public static String TIMEZONE_OFFSET_2NDTEAM = "timezone2ndTeam";
    public static String WORLD_2NDTEAM = "world2ndTeam";

    public static String NOTIF_2NDTEAM_ECONOMICAL = "economicalNotif";
    public static String NOTIF_2NDTEAM_TRAINING = "trainingNotif";

    /** Lives **/
    public static String NOTIF_2NDTEAM_REMINDER_1H = "notif2ndTeamReminder1H";
    public static String NOTIF_2NDTEAM_REMINDER_30M = "notif2ndTeamReminder30M";
    public static String NOTIF_2NDTEAM_KICKOFF = "notif2ndTeamKickoff";
    public static String NOTIF_2NDTEAM_HALFTIME = "notif2ndTeamHalfteam";
    public static String NOTIF_2NDTEAM_GOALS = "notif2ndTeamGoals";
    public static String NOTIF_2NDTEAM_INJURIES = "notif2ndTeamInjuries";
    public static String NOTIF_2NDTEAM_CARDS = "notif2ndTeamCards";

    /** Other match **/
    /** Lives **/
    public static String NOTIF_OTHERTEAM_REMINDER_1H = "notifOtherTeamReminder1H";
    public static String NOTIF_OTHERTEAM_REMINDER_30M = "notifOtherTeamReminder30M";
    public static String NOTIF_OTHERTEAM_KICKOFF = "notifOtherTeamKickoff";
    public static String NOTIF_OTHERTEAM_HALFTIME = "notifOtherTeamHalfteam";
    public static String NOTIF_OTHERTEAM_GOALS = "notifOtherTeamGoals";
    public static String NOTIF_OTHERTEAM_INJURIES = "notifOtherTeamInjuries";
    public static String NOTIF_OTHERTEAM_CARDS = "notifOtherTeamCards";

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(PREFERENCESNAME,
                Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public int get(String key, int def){
        return preferences.getInt(key,def);
    }

    public String get(String key, String def){
        return preferences.getString(key, def);
    }

    public Boolean get(String key, Boolean def){
        return preferences.getBoolean(key, def);
    }

    /**
     * Save preferences
     * @param key
     * @param value
     */
    public void save(String key, Object value){

        if(value instanceof  Integer) {
            editor.putInt(key, (Integer) value);
        }else{
            if(value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            }else{
                if(value instanceof String){
                    editor.putString(key, (String) value);
                }
            }
        }

        editor.commit();
    }


    /**
     * Remove all preferences
     */
    public void clearAll() {
        editor.clear().commit();
    }

}
