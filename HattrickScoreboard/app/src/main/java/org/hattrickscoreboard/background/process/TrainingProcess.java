package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.training.Training;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.TrainingTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class TrainingProcess extends HProcess {

    static final String TAG = (TrainingProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(TrainingTable.class,
                forceUpdate, TrainingTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Training.class);
        request.setParams(params);

        Training res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Set to DBB
        ContentValues values = new ContentValues();
        values.put(TrainingTable.COL_TEAM_ID, res.getTeamID());
        values.put(TrainingTable.COL_TRAININGLEVEL, res.getTrainingLevel());
        values.put(TrainingTable.COL_TRAINING_TYPE, res.getTrainingType());
        values.put(TrainingTable.COL_STAMINA_PART, res.getStaminaTrainingPart());
        values.put(TrainingTable.COL_LAST_TRAINING_TYPE,
                res.getLastTrainingTrainingType());
        values.put(TrainingTable.COL_LAST_TRAINING_LEVEL,
                res.getLastTrainingTrainingLevel());
        values.put(TrainingTable.COL_LAST_STAMINA_PART,
                res.getLastTrainingStaminaTrainingPart());
        values.put(TrainingTable.COL_TRAINER_ID, res.getTrainerID());
        values.put(TrainingTable.COL_TRAINER_ARRIVAL_DATE,
                res.getTrainerArrivalDate());
        values.put(TrainingTable.COL_MORALE, res.getMorale());
        values.put(TrainingTable.COL_SELF_CONFIDENCE, res.getSelfConfidence());
        values.put(TrainingTable.COL_EXPERIENCE_442, res.getExperience442());
        values.put(TrainingTable.COL_EXPERIENCE_433, res.getExperience433());
        values.put(TrainingTable.COL_EXPERIENCE_451, res.getExperience451());
        values.put(TrainingTable.COL_EXPERIENCE_352, res.getExperience352());
        values.put(TrainingTable.COL_EXPERIENCE_532, res.getExperience532());
        values.put(TrainingTable.COL_EXPERIENCE_343, res.getExperience343());
        values.put(TrainingTable.COL_EXPERIENCE_541, res.getExperience541());
        values.put(TrainingTable.COL_EXPERIENCE_523, res.getExperience523());
        values.put(TrainingTable.COL_EXPERIENCE_550, res.getExperience550());
        values.put(TrainingTable.COL_EXPERIENCE_253, res.getExperience253());
        values.put(TrainingTable.COL_FETCHED_DATE, HattrickDate.getDateTime());
        values.put(TrainingTable.COL_VALIDITY_TRAINING,
                HattrickUpdater.VALIDITY_TRAINING);

        // Create or update
        datasource.createOrUpdate(TrainingTable.class, values,
                TrainingTable.COL_TEAM_ID + "=" + res.getTeamID());

        // Send broadcast
        fireSuccess();
    }

}
