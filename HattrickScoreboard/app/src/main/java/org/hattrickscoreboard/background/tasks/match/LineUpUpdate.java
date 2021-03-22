package org.hattrickscoreboard.background.tasks.match;

import android.content.Context;

import org.hattrickscoreboard.background.process.match.LineUpProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.Update;
import org.hattrickscoreboard.database.HattrickBDD;

public class LineUpUpdate extends Update {

    public static String FROM = "lineup";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((LineUpUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                LineUpProcess.class, forceUpdate);
    }
}