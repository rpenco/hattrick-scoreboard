package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.club.Club;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.ClubTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class ClubProcess extends HProcess {

    static final String TAG = (ClubProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(ClubTable.class,
                forceUpdate, ClubTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Club.class);
        request.setParams(params);

        Club res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Get current date time
        String fetchedDate = HattrickDate.getDateTime();

        ContentValues values = new ContentValues();
        values.put(ClubTable.COL_ASSISTANT_TRAINER_LEVEL,
                res.getAssistantTrainerLevels());
        values.put(ClubTable.COL_FETCHED_DATE, fetchedDate);
        values.put(ClubTable.COL_FINANCIAL_DIRECTOR_LEVEL,
                res.getFinancialDirectorLevels());
        values.put(ClubTable.COL_FORM_COACH_LEVEL, res.getFormCoachLevels());
        values.put(ClubTable.COL_HAS_PROMOTED, res.isHasPromoted());
        values.put(ClubTable.COL_MEDIC_LEVEL, res.getMedicLevels());
        values.put(ClubTable.COL_PSYCHOLOGIST_LEVEL,
                res.getSportPsychologistLevels());
        values.put(ClubTable.COL_SPOKES_LEVEL, res.getSpokespersonLevels());
        values.put(ClubTable.COL_TEAM_ID, res.getTeamID());
        values.put(ClubTable.COL_TEAM_NAME, res.getTeamName());
        values.put(ClubTable.COL_USER_ID, res.getUserID());
        values.put(ClubTable.COL_YOUTH_INVESTMENT, res.getInvestment());
        values.put(ClubTable.COL_YOUTH_LEVEL, res.getYouthLevel());
        values.put(ClubTable.COL_VALIDITY_TIME, HattrickUpdater.VALIDITY_CLUB);

        // Create or update
        datasource.createOrUpdate(ClubTable.class, values,
                ClubTable.COL_USER_ID + "=" + res.getUserID());

        // Send broadcast
        fireSuccess();
    }

}
