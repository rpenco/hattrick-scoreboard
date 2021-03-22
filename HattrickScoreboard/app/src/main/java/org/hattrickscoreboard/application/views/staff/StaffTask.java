package org.hattrickscoreboard.application.views.staff;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DStaff;
import org.hattrickscoreboard.database.relations.RStaff;
import org.hattrickscoreboard.database.tables.StaffTable;

import java.util.ArrayList;

public class StaffTask extends AsyncFragmentTask implements UpdateListener {

    @SuppressWarnings("unused")
    private static final String TAG = (StaffTask.class).getSimpleName();

    public StaffTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Object doInBackground(Object... params) {

        ArrayList<DStaff> staff = bdd.readAll(StaffTable.class, DStaff.class,
                StaffTable.COL_TEAM_ID + "=" + (int) params[0]);

        RStaff relStaff = new RStaff(staff);
        return relStaff;
    }

}
