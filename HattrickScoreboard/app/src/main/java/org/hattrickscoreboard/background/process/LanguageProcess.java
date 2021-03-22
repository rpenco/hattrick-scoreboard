package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.world.Language;
import org.hattrick.models.world.WorldLanguage;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.LanguagesTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class LanguageProcess extends HProcess {

    static final String TAG = (LanguageProcess.class).getSimpleName();

    @Override
    public void perform() {

        super.perform();

        // HattrickObject obj = (HattrickObject) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(LanguagesTable.class,
                forceUpdate, LanguagesTable.COL_ID + "=" + 1);

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(WorldLanguage.class);
        request.setParams(params);

        WorldLanguage res;

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

        // Insert or update into DB
        for (Language el : res.getLanguageList()) {

            ContentValues values = new ContentValues();
            values.put(LanguagesTable.COL_LANGUE_ID, el.getLanguageID());
            values.put(LanguagesTable.COL_LANGUE_NAME, el.getLanguageName());
            values.put(LanguagesTable.COL_FETCHED_DATE, fetchedDate);
            values.put(LanguagesTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_LANGUAGE);

            // Create or update
            datasource.createOrUpdate(LanguagesTable.class, values,
                    LanguagesTable.COL_LANGUE_ID + "=" + el.getLanguageID());

        }

        // Send broadcast
        fireSuccess();
    }
}
