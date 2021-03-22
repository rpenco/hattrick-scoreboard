package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.economies.Economy;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.EconomyTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class EconomyProcess extends HProcess {

    static final String TAG = (EconomyProcess.class).getSimpleName();

    @Override
    public void perform() {

        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(EconomyTable.class,
                forceUpdate, EconomyTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Economy.class);
        request.setParams(params);

        Economy res;

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

        values.put(EconomyTable.COL_TEAM_ID, res.getTeamID());

        values.put(EconomyTable.COL_CURRENT_CASH, res.getCash());
        values.put(EconomyTable.COL_EXPECTED_CASH, res.getExpectedCash());
        values.put(EconomyTable.COL_SPONSORS_POPULARITY,
                res.getSponsorsPopularity());
        values.put(EconomyTable.COL_SUPPORTERS_POPULARITY,
                res.getSupportersPopularity());
        values.put(EconomyTable.COL_INCOME_SPECTATORS,
                res.getIncomeSpectators());
        values.put(EconomyTable.COL_INCOME_SPONSORS, res.getIncomeSponsors());
        values.put(EconomyTable.COL_INCOME_FINANCIAL, res.getIncomeFinancial());
        values.put(EconomyTable.COL_INCOME_SOLD_PLAYERS,
                res.getIncomeSoldPlayers());
        values.put(EconomyTable.COL_INCOME_SOLD_PLAYERS_COMMISSION,
                res.getIncomeSoldPlayersCommission());
        values.put(EconomyTable.COL_INCOME_TEMPORARY, res.getIncomeTemporary());
        values.put(EconomyTable.COL_INCOME_SUM, res.getIncomeSum());
        values.put(EconomyTable.COL_COSTS_ARENA, res.getCostsArena());
        values.put(EconomyTable.COL_COSTS_PLAYERS, res.getCostsPlayers());
        values.put(EconomyTable.COL_COSTS_FINANCIAL, res.getCostsFinancial());
        values.put(EconomyTable.COL_COSTS_STAFF, res.getCostsStaff());
        values.put(EconomyTable.COL_COSTS_BOUGHTPLAYERS,
                res.getCostsBoughtPlayers());
        values.put(EconomyTable.COL_COSTS_ARENABUILDING,
                res.getCostsArenaBuilding());
        values.put(EconomyTable.COL_COSTS_TEMPORARY, res.getCostsTemporary());
        values.put(EconomyTable.COL_COSTS_YOUTH, res.getCostsYouth());
        values.put(EconomyTable.COL_COSTS_SUM, res.getCostsSum());
        values.put(EconomyTable.COL_EXPECTED_WEEKS_TOTAL,
                res.getExpectedWeeksTotal());
        values.put(EconomyTable.COL_LAST_INCOME_SPECTATORS,
                res.getLastIncomeSpectators());
        values.put(EconomyTable.COL_LAST_INCOME_SPONSORS,
                res.getLastIncomeSponsors());
        values.put(EconomyTable.COL_LAST_INCOME_FINANCIAL,
                res.getLastIncomeFinancial());
        values.put(EconomyTable.COL_LAST_INCOME_SOLDPLAYERS,
                res.getLastIncomeSoldPlayers());
        values.put(EconomyTable.COL_LAST_INCOME_SOLD_PLAYERS_COMMISSION,
                res.getLastIncomeSoldPlayersCommission());
        values.put(EconomyTable.COL_LAST_INCOME_TEMPORARY,
                res.getLastIncomeTemporary());
        values.put(EconomyTable.COL_LAST_INCOME_SUM, res.getLastIncomeSum());
        values.put(EconomyTable.COL_LAST_COSTS_ARENA, res.getLastCostsArena());
        values.put(EconomyTable.COL_LAST_COSTS_PLAYERS,
                res.getLastCostsPlayers());
        values.put(EconomyTable.COL_LAST_COSTS_FINANCIAL,
                res.getLastCostsFinancial());
        values.put(EconomyTable.COL_LAST_COSTS_STAFF, res.getLastCostsStaff());
        values.put(EconomyTable.COL_LAST_COSTS_BOUGHT_PLAYERS,
                res.getLastCostsBoughtPlayers());
        values.put(EconomyTable.COL_LAST_COSTS_ARENA_BUILDING,
                res.getLastCostsArenaBuilding());
        values.put(EconomyTable.COL_LAST_COSTS_TEMPORARY,
                res.getLastCostsTemporary());
        values.put(EconomyTable.COL_LAST_COSTS_YOUTH, res.getLastCostsYouth());
        values.put(EconomyTable.COL_LAST_COSTS_SUM, res.getLastCostsSum());
        values.put(EconomyTable.COL_LAST_WEEKS_TOTAL, res.getLastWeeksTotal());
        values.put(EconomyTable.COL_FETCHED_DATE, fetchedDate);
        values.put(EconomyTable.COL_VALIDITY_TIME,
                HattrickUpdater.VALIDITY_ECONOMY);

        // Create or update
        datasource.createOrUpdate(EconomyTable.class, values,
                EconomyTable.COL_TEAM_ID + "=" + res.getTeamID());

        // Send broadcast
        fireSuccess();

    }

}
