package org.hattrickscoreboard.application.views.training;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.database.models.DTraining;
import org.hattrickscoreboard.database.tables.TrainingTable;

public class TrainingTask extends AsyncFragmentTask {

    static final String TAG = (TrainingTask.class).getSimpleName();

    public TrainingTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Object doInBackground(Object... params) {

        int teamID = (int) params[0];
        DTraining training = (DTraining) bdd.read(TrainingTable.class,
                TrainingTable.COL_TEAM_ID + "=" + teamID);

        return training;
    }
}
