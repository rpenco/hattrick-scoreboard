package org.khips.tools.time;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.hattrickscoreboard.database.tables.LiveTable;

import java.util.Calendar;
import java.util.Date;

public class KReminder {

    /**
     * Create reminder at date 'date' sending broadcast.
     *
     * @param ctx
     * @param broadcastReceiver
     * @param date
     * @param args
     * @return long time to reminder start
     */
    public static long setReminder(Context ctx, Intent intent, Date date,
                                   Bundle args) {

        Calendar cal = Calendar.getInstance();
        int time = (int) ((date.getTime() - cal.getTimeInMillis()) / 1000);

        return setReminder(ctx, intent, time, args);
    }

    public static long setReminder(Context ctx, Intent intent, int addSecond,
                                   Bundle args) {

        int securitySecs = 20;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, addSecond + securitySecs);

        intent.putExtras(args);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(ctx,
                (int) args.getLong(LiveTable.COL_ID), intent, 0);

        AlarmManager alarmManager = (AlarmManager) ctx
                .getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(),
                pendingIntent);

        return addSecond;
    }

}
