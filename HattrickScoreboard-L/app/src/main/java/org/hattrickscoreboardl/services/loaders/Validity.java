package org.hattrickscoreboardl.services.loaders;

import android.util.Log;

import org.hattrick.constants.Hattrick;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by romain
 * on 27/11/2014.
 */
public class Validity {

    static String TAG = (Validity.class).getSimpleName();

    public static int MIN = 60;
    public static int HOUR = MIN * 60;
    public static int DAY = HOUR * 24;
    public static int WEEK = DAY * 7;

    public static int LANGUAGE = WEEK;
    public static int TRAINING = WEEK;
    public static int WORLD = WEEK;
    public static int STAFF = DAY;
    public static int ARENA = DAY;
    public static int LEAGUE = DAY;
    public static int ECONOMY = DAY;
    public static int BOOKMARK = DAY;
    public static int CLUB = HOUR;
    public static int PLAYER = HOUR;
    public static int MATCH = HOUR;
    public static int TRANSFER = HOUR;
    public static int TEAM = 15 * MIN;
    public static int NATIONAL_TEAM = 5 * HOUR;
    public static int OTHERS_TEAMS = 2 * DAY;


    public static boolean isUpToDate(String TAG, boolean forceUpdate, String fetchedDate, int validity){

        if(fetchedDate == null){
            Log.e(TAG, "need update (fetched null).");
            return false;
        }

        if(forceUpdate) {
            Log.e(TAG, "need update (forced).");
            return false;
        }

        Date date;

        try {
            date = new SimpleDateFormat(Hattrick.DATETIME, Locale.getDefault())
                    .parse(fetchedDate);
        } catch (ParseException e) {
            return false;
        }

        date.setSeconds(date.getSeconds() + validity);

        if(date.after(new Date())) {
            Log.e(TAG, "is up to date.");
            return true;
        }else {
            Log.e(TAG, "need update.");
            return false;
        }
    }
}
