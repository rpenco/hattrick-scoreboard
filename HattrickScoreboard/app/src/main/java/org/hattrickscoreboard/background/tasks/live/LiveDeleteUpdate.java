package org.hattrickscoreboard.background.tasks.live;

import android.content.Context;

import org.hattrickscoreboard.background.process.live.LiveDeleteProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.Update;
import org.hattrickscoreboard.database.HattrickBDD;

public class LiveDeleteUpdate extends Update {

    public static String FROM = "htlive";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((LiveDeleteUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                LiveDeleteProcess.class, forceUpdate);
    }
}
