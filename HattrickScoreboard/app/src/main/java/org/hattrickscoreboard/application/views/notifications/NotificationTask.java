package org.hattrickscoreboard.application.views.notifications;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class NotificationTask extends AsyncFragmentTask implements
        UpdateListener {

    static final String TAG = (NotificationTask.class).getSimpleName();

    public NotificationTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Object doInBackground(Object... params) {

        return null;
    }

}
