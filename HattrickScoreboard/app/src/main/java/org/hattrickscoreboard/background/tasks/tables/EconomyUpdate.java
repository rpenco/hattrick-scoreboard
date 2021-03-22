package org.hattrickscoreboard.background.tasks.tables;

import android.content.Context;

import org.hattrickscoreboard.background.process.EconomyProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.database.HattrickBDD;

public class EconomyUpdate extends Update {

    public static String FROM = "economy";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((EconomyUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                EconomyProcess.class, forceUpdate);
    }
}