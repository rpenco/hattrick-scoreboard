package org.hattrickscoreboard.application.extended.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.params.HattrickParams;
import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class AsyncFragmentTask extends AsyncTask<Object, String, Object>
        implements UpdateListener {

    public static String INTENT = "org.hattrickscoreboard.service.receiver";
    public static String FROM = "FROM";
    public static String RESULT = "RESULT";
    static String TAG = (AsyncFragmentTask.class).getSimpleName();
    protected HattrickBDD bdd;
    protected IRequest request;
    protected IParams param;
    protected Context context;
    protected FragmentTaskListener listener;
    boolean isRunning = false;
    // For broadcast
    Intent intent;

    public AsyncFragmentTask(Context context, FragmentTaskListener listener) {
        this.context = context;
        this.listener = listener;

        // Init database
        bdd = ((HattrickApplication) context.getApplicationContext())
                .getBDD(context);

        // Init connexion
        request = new HattrickRequest();
        request.init(context);
        param = new HattrickParams();

        intent = new Intent(INTENT);
        intent.putExtra(FROM, TAG);

    }

    /**
     * Notify start
     */
    protected void fireStart() {
        if (listener != null) {
            listener.onTaskStart();
        }
    }

    /**
     * Notify finish
     *
     * @param obj
     */
    protected void fireFinish(Object obj) {
        if (listener != null) {
            listener.onTaskFinish(obj);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        isRunning = true;
        fireStart();
    }

    @Override
    protected Object doInBackground(Object... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        isRunning = false;
        fireFinish(result);

    }

    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Send notifications manually for notify cancel
     *
     * @param serviceFrom
     */
    protected void sendBrodcastNotificationCancel(String serviceFrom) {
        sendBrodcastNotification(Background.RESULT_ERROR, serviceFrom);
    }

    /**
     * Send notifications manually for notify success
     *
     * @param serviceFrom
     */
    protected void sendBrodcastNotificationSuccess(String serviceFrom) {
        sendBrodcastNotification(Background.RESULT_OK, serviceFrom);
    }

    /**
     * Send notifications manually for notify success
     *
     * @param serviceFrom
     */
    protected void sendBrodcastNotificationStart(String serviceFrom) {
        sendBrodcastNotification(Background.RESULT_START, serviceFrom);
    }

    /**
     * Send broadcast
     *
     * @param resultCode
     * @param serviceFrom
     */
    private void sendBrodcastNotification(int resultCode, String serviceFrom) {
        intent.putExtra(RESULT, resultCode);
        intent.putExtra(FROM, serviceFrom);
        context.getApplicationContext().sendBroadcast(intent);
    }

    @Override
    public void onUpdateSuccess(String serviceFrom) {
        sendBrodcastNotificationSuccess(serviceFrom);
    }

    @Override
    public void onUpdateCanceled(String serviceFrom) {
        sendBrodcastNotificationCancel(serviceFrom);
    }

    @Override
    public void onUpdateStart(String serviceFrom) {
        sendBrodcastNotificationStart(serviceFrom);
    }

}
