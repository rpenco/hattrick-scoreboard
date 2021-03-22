package org.hattrickscoreboard.application.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Khips
 * @since 16 july 2014
 */
public class HattrickDate {

    static String TAG = (HattrickDate.class).getSimpleName();

    // Default format from Hattrick
    static String HattrickDateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    // Default locale
    static Locale locale = Locale.getDefault();

    /**
     * Get current date time formatted like Hattrick API
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    @SuppressLint("SimpleDateFormat")
    public static String getDateTime() {

        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat(HattrickDateTimeFormat);
        String dat = dateFormat.format(actuelle);
        return dat;
    }

    /**
     * Check if need update information, referenced by fetched date and validity
     * time
     *
     * @param fetchedDate
     * @param validity
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean needUpdate(String fetchedDate, int validity) {

        Date date;
        try {
            date = new SimpleDateFormat(HattrickDateTimeFormat, locale)
                    .parse(fetchedDate);
        } catch (ParseException e) {
            Log.e(TAG, "Error parse date, need Update");
            return true;
        }

        date.setSeconds(date.getSeconds() + validity);

        if ((date.after(new Date()))) {
            return false;
        }

        return true;
    }

    /**
     * Convert Hattrick string date to Date object
     *
     * @param date
     * @param hattrickDateFormat
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                HattrickDateTimeFormat, Locale.ENGLISH);
        Date rdate = null;

        rdate = formatter.parse(date);

        return rdate;
    }

    /**
     * Get week of year of a date
     *
     * @param d
     * @return
     */
    public static int getWeekOfYear(Date d) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int WEEK_OF_YEAR = calendar.get(Calendar.WEEK_OF_YEAR);
        return WEEK_OF_YEAR;
    }

    public static int minuteToSecond(int minute) {
        return minute * 60;
    }

    public static int secondToMinute(int second) {
        return (int) (second / 60);
    }

    /**
     * Get REAL current second of match != getCurrentMatchSecond. Si le match a
     * demarre depuis 50minutes, cet methode renvois 50*60 seconde. <b>Mais il
     * ne tiens pas compte des mi-temps</b>.
     *
     * @param matchStart
     * @return
     * @throws ParseException
     */
    public static int getRealMatchCurrentSecond(String matchStart) {

        try {
            Date startMatch = StringToDate(matchStart);
            Date currentDate = StringToDate(getDateTime());

            int diff = (int) ((currentDate.getTime() - startMatch.getTime()) / 1000);

            return diff;
        } catch (ParseException e) {
            int diff = 0;
            return diff;
        }

    }

    public static int getMatchCurrentSecond(String matchStart) {

        int realSecond = getRealMatchCurrentSecond(matchStart);

        // Not started
        if (realSecond < 0) {
            return 0;
        } else {

            // First half, real second == match second
            if (realSecond < minuteToSecond(45)) {
                return realSecond;
            } else {

                // Half-time, match second == 45.
                if (realSecond >= minuteToSecond(45)
                        && realSecond < minuteToSecond(60)) {
                    return minuteToSecond(45);
                } else {

                    // Second half, match second == real second - 15min.
                    if (realSecond >= minuteToSecond(60)
                            && realSecond < minuteToSecond(105)) {
                        return realSecond - minuteToSecond(15);
                    } else {

                        // Extra-time (real - 1er half - Extra?)
                        return realSecond - minuteToSecond(15);
                    }

                }
            }
        }

    }
}
