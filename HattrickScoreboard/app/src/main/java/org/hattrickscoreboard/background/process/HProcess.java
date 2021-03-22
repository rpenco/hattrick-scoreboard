package org.hattrickscoreboard.background.process;

import android.content.Context;

import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.database.HattrickBDD;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class HProcess {

    protected Context context;
    protected IRequest request;
    protected IParams params;
    protected HattrickBDD datasource;
    protected boolean forceUpdate;
    ArrayList<ProcessListener> listeners = new ArrayList<ProcessListener>();

    public void set(Context context, IRequest request, IParams params,
                    HattrickBDD datasource, boolean forceUpdate) {
        this.context = context;
        this.request = request;
        this.params = params;
        this.datasource = datasource;
        this.forceUpdate = forceUpdate;
    }

    // /////////////////////////
    // Listeners
    // ////////////////////////

    public void addListener(ProcessListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ProcessListener listener) {
        listeners.remove(listener);
    }

    public void clearListener() {
        listeners.clear();
    }

    protected void fireStart() {
        for (ProcessListener listener : listeners) {
            listener.onStartProcess();
        }
    }

    protected void fireError(int code) {
        for (ProcessListener listener : listeners) {
            listener.onFinishProcess(code);
        }
    }

    protected void fireSuccess() {
        for (ProcessListener listener : listeners) {
            listener.onFinishProcess(Background.RESULT_OK);
        }
    }

    public void perform() {
        fireStart();
    }

    /**
     * Check if force update
     */
    public boolean isNotForceUpdate() {
        return !this.forceUpdate;
    }

    public void networkFailed() {
        fireStart();
        fireError(Background.RESULT_ERROR_CONN);
    }
}
