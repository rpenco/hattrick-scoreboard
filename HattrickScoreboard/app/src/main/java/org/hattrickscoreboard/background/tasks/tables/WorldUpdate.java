package org.hattrickscoreboard.background.tasks.tables;

import android.content.Context;

import org.hattrickscoreboard.background.process.WorldProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.database.HattrickBDD;

public class WorldUpdate extends Update {

    public static String FROM = "world";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((WorldUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                WorldProcess.class, forceUpdate);
    }
}
