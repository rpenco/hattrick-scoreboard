package org.hattrickscoreboardl.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import org.hattrickscoreboardl.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Khips
 * @since 16 juil. 2014
 */
public class HattrickDate {

    static String TAG = (HattrickDate.class).getSimpleName();

    // Default format from Hattrick API
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
     * Convert Hattrick string date to Date object
     *
     * @param date
     * @return
     * @throws java.text.ParseException
     */
    public static Date StringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                HattrickDateTimeFormat, Locale.ENGLISH);
        Date rdate = null;

        rdate = formatter.parse(date);

        return rdate;
    }

    /**
     * Get current date/time
     * @return
     */
    public static Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        return cal;
    }

    public static String formatDate(Context ctx, String datetime){
        Date d;
        try {
            d = HattrickDate.StringToDate(datetime);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            return formatter.format(d);

        } catch (ParseException e) {
//            GTracker.TrackException(getActivity(), e);
            return ctx.getString(R.string.unavailable);
        }
    }

    public static String formatDateTimeSmall(Context ctx, String datetime){
        Date d;
        try {
            d = HattrickDate.StringToDate(datetime);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM HH:mm");
            return formatter.format(d);

        } catch (ParseException e) {
//            GTracker.TrackException(getActivity(), e);
            return ctx.getString(R.string.unavailable);
        }
    }

    public static String formatDateTime(Context ctx, String datetime){
        Date d;
        try {
            d = HattrickDate.StringToDate(datetime);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm");
            return formatter.format(d);

        } catch (ParseException e) {
//            GTracker.TrackException(getActivity(), e);
            return ctx.getString(R.string.unavailable);
        }
    }
}
