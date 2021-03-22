package org.hattrickscoreboard.background.tasks.live;

import android.content.Context;

import org.hattrickscoreboard.background.process.live.LiveProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.Update;
import org.hattrickscoreboard.database.HattrickBDD;

public class LiveUpdate extends Update {

    public static String FROM = "htlive";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((LiveUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                LiveProcess.class, forceUpdate);
    }
}
