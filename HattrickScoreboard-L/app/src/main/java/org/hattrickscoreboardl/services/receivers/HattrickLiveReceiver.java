package org.hattrickscoreboardl.services.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.hattrickscoreboardl.services.live.LiveService;

/**
 * @author Khips
 * @since 17 aot 2014
 */
public class HattrickLiveReceiver extends BroadcastReceiver {
    static String TAG = (HattrickLiveReceiver.class).getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"Receive intent...");

        Intent liveIntent = new Intent(context, LiveService.class);
        liveIntent.putExtras(intent.getExtras());
        context.startService(liveIntent);
    }

}
