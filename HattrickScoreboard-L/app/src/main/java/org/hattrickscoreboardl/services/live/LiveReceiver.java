package org.hattrickscoreboardl.services.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Notify other part for live event
 */
public class LiveReceiver extends BroadcastReceiver {
    static String TAG = (LiveReceiver.class).getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"Receive intent live...");
    }



}
