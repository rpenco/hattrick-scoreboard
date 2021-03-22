package org.hattrickscoreboard.application.views.matches.live;

import android.content.Context;

import org.hattrick.providers.params.HLiveQuery;
import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.tasks.live.LiveDeleteUpdate;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.relations.RMatches;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class LiveTask extends AsyncFragmentTask implements UpdateListener {

    static final String TAG = (LiveTask.class).getSimpleName();

    public LiveTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RMatches doInBackground(Object... params) {

        HLiveQuery query = (HLiveQuery) params[0];

        if (query == null)
            return null;

        if (query.getActionType().equals(HLiveQuery.ADD_MATCH)) {
            LiveUpdate live = new LiveUpdate();
            live.addListener(this);
            param.setObjectParam(query);
            live.update(TAG, context, request, param, bdd);

        } else if (query.getActionType().equals(HLiveQuery.DEL_MATCH)) {
            LiveDeleteUpdate live = new LiveDeleteUpdate();
            live.addListener(this);
            param.setObjectParam(query);
            live.update(TAG, context, request, param, bdd);

        }

        return null;
    }

}
