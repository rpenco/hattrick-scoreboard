package org.hattrickscoreboardl.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import org.hattrickscoreboardl.R;

/**
 * Create and display easy notifications
 *
 * @author Khips
 * @since 17 aot 2014
 */
public class Notification {

    Context ctx;

    public static int NOTIF_ICON = R.drawable.ic_notification;

    public Notification(Context ctx) {
        this.ctx = ctx;
    }

    public void notifyCompact(Class resultClass, String title, String content, long id){


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx)
                .setSmallIcon(NOTIF_ICON)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentTitle(title)
                .setContentText(content)
                .setAutoCancel(true);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_ALL);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);

        Intent resultIntent = new Intent(ctx, resultClass);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(resultClass);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        // mId allows you to update the notification later on.
        mNotificationManager.notify((int) id, mBuilder.build());

    }


    public void notifyExpended(Class resultClass, String title, String content, String[] events, long id){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx)
                .setSmallIcon(NOTIF_ICON)
                .setContentTitle(title)
                .setContentText(content)
                .setNumber(events.length)
                .setAutoCancel(true);

        mBuilder.setDefaults(NotificationCompat.DEFAULT_ALL);

        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();

        // Sets a title for the Inbox in expanded layout
        inboxStyle.setBigContentTitle(title);

        // Moves events into the expanded layout
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        // Moves the expanded layout object into the notification object.
        mBuilder.setStyle(inboxStyle);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);

        Intent resultIntent = new Intent(ctx, resultClass);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(resultClass);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        // mId allows you to update the notification later on.
        mNotificationManager.notify((int) id, mBuilder.build());

    }
}
