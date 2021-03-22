package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.arena.ArenaDetails;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.ArenaTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class ArenaProcess extends HProcess {

    static final String TAG = (ArenaProcess.class).getSimpleName();

    @Override
    public void perform() {

        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(ArenaTable.class,
                forceUpdate, ArenaTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(ArenaDetails.class);
        request.setParams(params);

        ArenaDetails res;

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

        ContentValues values = new ContentValues();
        values.put(ArenaTable.COL_ARENA_ID, res.getArenaID());
        values.put(ArenaTable.COL_ARENA_NAME, res.getArenaName());
        values.put(ArenaTable.COL_CUR_BASIC, res.getCurrentCapacity()
                .getBasic());
        values.put(ArenaTable.COL_CUR_ROOF, res.getCurrentCapacity().getRoof());
        values.put(ArenaTable.COL_CUR_TERRACES, res.getCurrentCapacity()
                .getTerraces());
        values.put(ArenaTable.COL_CUR_TOTAL, res.getCurrentCapacity()
                .getTotal());
        values.put(ArenaTable.COL_CUR_VIP, res.getCurrentCapacity().getVIP());
        values.put(ArenaTable.COL_LEAGUE_ID, res.getLeagueID());
        values.put(ArenaTable.COL_REGION_ID, res.getLeagueName());
        values.put(ArenaTable.COL_TEAM_ID, res.getTeamID());

        values.put(ArenaTable.COL_REBUILT_DATE, res.getCurrentCapacity().getRebuiltDate());
        values.put(ArenaTable.COL_EXPANSION_DATE, res.getExpandedCapacity().getExpansionDate());
        values.put(ArenaTable.COL_EXPANSION_TERRACES, res.getExpandedCapacity().getTerraces());
        values.put(ArenaTable.COL_EXPANSION_BASIC, res.getExpandedCapacity().getBasic());
        values.put(ArenaTable.COL_EXPANSION_ROOF, res.getExpandedCapacity().getRoof());
        values.put(ArenaTable.COL_EXPANSION_VIP, res.getExpandedCapacity().getVIP());
        values.put(ArenaTable.COL_EXPANSION_TOTAL, res.getExpandedCapacity().getTotal());
        values.put(ArenaTable.COL_FETCHED_DATE, fetchedDate);
        values.put(ArenaTable.COL_VALIDITY_TIME, HattrickUpdater.VALIDITY_ARENA);

        // Create or update
        datasource.createOrUpdate(ArenaTable.class, values,
                ArenaTable.COL_ARENA_ID + "=" + res.getArenaID());

        // Send broadcast
        fireSuccess();
    }

}
