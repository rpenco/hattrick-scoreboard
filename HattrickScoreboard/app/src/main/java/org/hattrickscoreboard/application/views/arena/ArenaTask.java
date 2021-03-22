package org.hattrickscoreboard.application.views.arena;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.tables.ArenaTable;

public class ArenaTask extends AsyncFragmentTask {

    public ArenaTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected DArena doInBackground(Object... params) {

        DArena arena = (DArena) bdd.read(ArenaTable.class, ArenaTable.COL_ID
                + "=1");

        return arena;
    }

}
