package org.hattrickscoreboard.background.tasks.tables;

import android.content.Context;
import android.util.Log;

import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.background.process.ProcessListener;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.database.HattrickBDD;
import org.khips.tools.networks.KNetwork;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class Update implements ProcessListener {

    private String TAG = (TeamUpdate.class).getSimpleName();

    private String FROM = "update";
    private ArrayList<UpdateListener> listeners = new ArrayList<UpdateListener>();

    protected void setFrom(String from) {
        this.FROM = from;
    }

    protected void setTag(String tag) {
        this.TAG = tag;
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, Class<T> processClass) {
        update(TAG, context, request, params, datasource, processClass, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, Class<T> processClass,
                           boolean forceUpdate) {

        // Perfom process
        HProcess process;
        try {
            process = (HProcess) processClass.newInstance();
            process.addListener(this);
            process.set(context, request, params, datasource, forceUpdate);
            if (KNetwork.hasInternet(context)) {
                process.perform();
            } else {
                process.networkFailed();
            }

        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // /////////////////////////
    // Listeners
    // ////////////////////////

    public void addListener(UpdateListener listener) {
        listeners.add(listener);
    }

    public void removeListener(UpdateListener listener) {
        listeners.remove(listener);
    }

    public void clearListener() {
        listeners.clear();
    }

    protected void fireStart() {
        for (UpdateListener listener : listeners) {
            listener.onUpdateStart(FROM);
        }
    }

    protected void fireSuccess() {
        for (UpdateListener listener : listeners) {
            listener.onUpdateSuccess(FROM);
        }
    }

    protected void fireError(int code) {
        for (UpdateListener listener : listeners) {
            listener.onUpdateCanceled(FROM);
        }
    }

    @Override
    public void onStartProcess() {
        Log.v(TAG, "onStartProcess");
        fireStart();
    }

    @Override
    public void onFinishProcess(int code) {

        if (code == Background.RESULT_OK) {
            fireSuccess();
        } else {
            fireError(code);
        }
    }

}
