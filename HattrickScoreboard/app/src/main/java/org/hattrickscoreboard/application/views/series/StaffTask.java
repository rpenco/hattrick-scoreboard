package org.hattrickscoreboard.application.views.series;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.database.models.DStaff;
import org.hattrickscoreboard.database.relations.RStaff;
import org.hattrickscoreboard.database.tables.StaffTable;

import java.util.ArrayList;

public class StaffTask extends AsyncFragmentTask {

    private static final String TAG = (StaffTask.class).getSimpleName();

    public StaffTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RStaff doInBackground(Object... params) {

        ArrayList<DStaff> staff = bdd.readAll(StaffTable.class, DStaff.class,
                null); // Debug


        RStaff relStaff = new RStaff(staff);
        return relStaff;
    }

}
