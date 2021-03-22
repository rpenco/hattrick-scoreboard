package org.hattrickscoreboardl.utils.gtracker;

import android.content.Context;
import android.util.Log;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.StandardExceptionParser;
import com.google.analytics.tracking.android.Tracker;

public final class GTracker {

    private static String TAG = (GTracker.class).getSimpleName();

    /**
     * Send Exception !
     *
     * @param ctx
     * @param e
     */
    public static void TrackException(Context ctx, Throwable e) {
        EasyTracker easyTracker = EasyTracker.getInstance(ctx);

        if (easyTracker == null) {
            Log.e(TAG, "Erreur easyTracker initialization");
            return;
        }

        easyTracker.send(MapBuilder.createException(
                new StandardExceptionParser(ctx, null).getDescription(Thread
                        .currentThread().getName(), e), false).build());
    }

    public static void TrackDimension(Context ctx, int customDim,
                                      String paramValue) {
        // May return null if EasyTracker has not yet been initialized with a
        // property ID.
        EasyTracker easyTracker = EasyTracker.getInstance(ctx);

        // Send the custom dimension value with a screen view.
        // Note that the value only needs to be sent once, so it is set on the
        // Map,
        // not the tracker.
        easyTracker.send(MapBuilder.createAppView()
                .set(Fields.customDimension(customDim), paramValue).build());
    }

    public static void TrackMetric(Context ctx, int customMetric,
                                   String paramValue) {
        // May return null if EasyTracker has not yet been initialized with a
        // property ID.
        EasyTracker easyTracker = EasyTracker.getInstance(ctx);

        // Send the custom dimension value with a screen view.
        // Note that the value only needs to be sent once, so it is set on the
        // Map,
        // not the tracker.
        easyTracker.send(MapBuilder.createAppView()
                .set(Fields.customMetric(customMetric), paramValue).build());
    }

    /**
     * Track event
     *
     * @param ctx
     * @param category
     * @param action
     * @param label
     */
    public static void TrackEvent(Context ctx, String category, String action,
                                  String label) {
        EasyTracker easyTracker = EasyTracker.getInstance(ctx);

        easyTracker.send(MapBuilder.createEvent(category, action, label, null)
                .build());
    }

    /**
     * TrackScreen
     *
     * @param ctx
     * @param screen
     */
    public static void TrackScreen(Context ctx, String screen) {
        // May return null if EasyTracker has not yet been initialized with a
        // property
        // ID.
        Tracker easyTracker = EasyTracker.getInstance(ctx);

        // This screen name value will remain set  	on the tracker and sent with
        // hits until it is set to a new value or to null.
        easyTracker.set(Fields.SCREEN_NAME, screen);

        easyTracker.send(MapBuilder.createAppView().build());
    }
}
