package org.hattrickscoreboard.background.process.staffs;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.staffs.Staff;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.tables.StaffTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class StaffProcess extends HProcess {

    static final String TAG = (StaffProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(StaffTable.class,
                forceUpdate, StaffTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(StaffList.class);
        request.setParams(params);

        StaffList res;

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
        for (Staff st : res.getStaffMembers()) {

            // Foreach staff member

            ContentValues values = new ContentValues();
            values.put(StaffTable.COL_TEAM_ID,
                    ((HQuery) params.getObjectParam()).getTeamID());
            values.put(StaffTable.COL_NAME, st.getName());
            values.put(StaffTable.COL_STAFF_ID, st.getStaffID());
            values.put(StaffTable.COL_STAFF_TYPE, st.getStaffType());
            values.put(StaffTable.COL_STAFF_LEVEL, st.getStaffLevel());
            values.put(StaffTable.COL_HIRED_DATE, st.getHiredDate());
            values.put(StaffTable.COL_COST, st.getCost());
            values.put(StaffTable.COL_FETCHED_DATE, fetchedDate);
            values.put(StaffTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_STAFF);

            // Create or update
            datasource.createOrUpdate(StaffTable.class, values,
                    StaffTable.COL_STAFF_ID + "=" + st.getStaffID());

        }

        // /////////////////////////////////////////////////////////////////

        // Send broadcast
        fireSuccess();

        Log.w(TAG, "Download staff avatars...");

        StaffsAvatarProcess avatarProcess = new StaffsAvatarProcess();
        avatarProcess.set(context, request, params, null, forceUpdate);
        avatarProcess.perform(request, params);
    }

}
