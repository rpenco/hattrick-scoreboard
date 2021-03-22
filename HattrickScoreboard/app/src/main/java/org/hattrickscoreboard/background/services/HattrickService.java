package org.hattrickscoreboard.background.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.params.HattrickParams;
import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;

/**
 * Run when application start or device start
 *
 * @author Khips
 * @since 17 march 2014
 */
public class HattrickService extends IntentService implements UpdateListener {

    static final String TAG = (HattrickService.class).getSimpleName();
    public static String INTENT = "org.hattrickscoreboard.service.receiver";
    public static String FROM = "FROM";
    public static String RESULT = "RESULT";

    // Access to DB
    // Force update (debug mode)
    protected boolean FU = false;
    protected Context context;
    protected HattrickBDD bdd;
    // For Hattrick CHPP request
    protected IRequest request = new HattrickRequest();
    protected IParams params = new HattrickParams();
    // For broadcast
    protected Intent intent;
    // Default result
    protected int result = Background.RESULT_ERROR;

    // Need else crash...
    public HattrickService() {
        super(TAG);
    }

    public HattrickService(String TAG) {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(INTENT);
        intent.putExtra(FROM, TAG);
    }

    /**
     * Initialize service
     */
    void init() {

        // Get bdd connection
        bdd = ((HattrickApplication) getApplication()).getBDD(this);

        // Prepare
        request.init(this);

        // Set context
        context = this;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Starting service...");
        init();
    }

    @Override
    public void onUpdateStart(String from) {

        Log.i(TAG, "Send broadcast '" + from + "' started");
        sendBrodcastNotification(Background.RESULT_START, from);
    }

    @Override
    public void onUpdateSuccess(String from) {

        Log.i(TAG, "Send broadcast '" + from + "' success");
        sendBrodcastNotification(Background.RESULT_OK, from);
    }

    @Override
    public void onUpdateCanceled(String from) {

        Log.i(TAG, "Send broadcast '" + from + "' canceled!");
        sendBrodcastNotification(Background.RESULT_ERROR, from);
    }

    protected void sendBrodcastNotification(int resultCode, String serviceFrom) {
        intent.putExtra(RESULT, resultCode);
        intent.putExtra(FROM, serviceFrom);
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // bdd.close();
    }

}
