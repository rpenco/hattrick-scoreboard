package org.khips.tools.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

/**
 * Create and display easy notifications
 *
 * @author Khips
 * @since 17 august 2014
 */
public class KNotification {

    /**
     * Create notification (not sended!)
     *
     * @param ctx
     * @param icon
     * @param title
     * @param text
     * @return builder
     */
    public static Builder builder(Context ctx, int icon, String title,
                                  String text) {

        return new NotificationCompat.Builder(ctx).setSmallIcon(icon)
                .setContentTitle(title).setContentText(text);

    }

    /**
     * Definie onclick action
     *
     * @param ctx
     * @param mBuilder
     * @param resultIntent
     * @return
     */

    public static Builder action(Context ctx, Builder mBuilder,
                                 Intent resultIntent) {

        // Because clicking the notification opens a new ("special") activity,
        // there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent = PendingIntent.getActivity(ctx, 0,
                resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        return mBuilder;

    }

    public static void show(Context ctx, Builder mBuilder, int mNotificationId) {

        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) ctx
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    public static Builder sound(Context ctx, Builder builder, int sound) {

        Uri uri = Uri.parse("android.resource://" + ctx.getPackageName() + "/"
                + sound);

        builder.setSound(uri);
        return builder;
    }

    public static Builder vibrate(Builder builder, long[] vibrate) {

        builder.setVibrate(vibrate);
        return builder;
    }

    public static Builder vibrate(Builder builder) {

        builder.setDefaults(Notification.DEFAULT_VIBRATE);

        return builder;
    }
}
