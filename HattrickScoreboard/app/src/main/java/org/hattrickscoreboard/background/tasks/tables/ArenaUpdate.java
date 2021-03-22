package org.hattrickscoreboard.background.tasks.tables;

import android.content.Context;

import org.hattrickscoreboard.background.process.ArenaProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.database.HattrickBDD;

public class ArenaUpdate extends Update {

    public static String FROM = "arena";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((ArenaUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                ArenaProcess.class, forceUpdate);
    }
}