package org.hattrickscoreboard.application.views.settings;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.tables.WorldTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class SettingsTask extends AsyncFragmentTask {

    static final String TAG = (SettingsTask.class).getSimpleName();

    public SettingsTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected ArrayList<DWorld> doInBackground(Object... params) {

        ArrayList<DWorld> worlds = bdd.readAll(WorldTable.class, DWorld.class,
                WorldTable.COL_CURRENCY_RATE + ">=1 ORDER BY "
                        + WorldTable.COL_COUNTRY_NAME + " ASC");
        return worlds;
    }

}
