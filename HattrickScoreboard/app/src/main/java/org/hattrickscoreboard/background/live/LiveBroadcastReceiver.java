package org.hattrickscoreboard.background.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.hattrickscoreboard.database.tables.LiveTable;

/**
 * @author Khips
 * @since 17 aot 2014
 */
public class LiveBroadcastReceiver extends BroadcastReceiver {
    static String TAG = (LiveBroadcastReceiver.class).getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG,
                "receive intent... Live ID: "
                        + intent.getExtras().getLong(LiveTable.COL_ID));
        Intent liveIntent = new Intent(context, LiveReceiver.class);
        Bundle bundle = intent.getExtras();
        liveIntent.putExtras(bundle);
        context.startService(liveIntent);
    }

}
