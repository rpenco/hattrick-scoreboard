package org.hattrickscoreboard.background.tasks.match;

import android.content.Context;

import org.hattrickscoreboard.background.process.match.MatchProcess;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.Update;
import org.hattrickscoreboard.database.HattrickBDD;

public class MatchUpdate extends Update {

    public static String FROM = "matchdetail";

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource) {
        update(TAG, context, request, params, datasource, false);
    }

    public <T> void update(String TAG, Context context, IRequest request,
                           IParams params, HattrickBDD datasource, boolean forceUpdate) {

        setTag((MatchUpdate.class).getSimpleName());
        setFrom(FROM);

        super.update(TAG, context, request, params, datasource,
                MatchProcess.class, forceUpdate);
    }
}
