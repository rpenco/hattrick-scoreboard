package org.hattrickscoreboard.application.views.economies;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.database.models.DEconomy;
import org.hattrickscoreboard.database.tables.EconomyTable;

public class EconomiesTask extends AsyncFragmentTask {

    static final String TAG = (EconomiesTask.class).getSimpleName();

    public EconomiesTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Object doInBackground(Object... params) {

        int teamID = (int) params[0];

        DEconomy economy = null;

        economy = (DEconomy) bdd.read(EconomyTable.class,
                EconomyTable.COL_TEAM_ID + "=" + teamID);
        return economy;
    }

}
