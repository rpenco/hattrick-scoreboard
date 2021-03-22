package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.economies.Economy;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.economy.HEconomy;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class EconomyProcess extends HProcess {

    static final String TAG = (EconomyProcess.class).getSimpleName();

    public EconomyProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        //Get parameter
        int teamID = (Integer) args[0];

        //Find all economies if exist
        HEconomy economy = HEconomy.findOne(HEconomy.class, "TEAM_ID = ?", "" + teamID);

        ////////////////////////////////////


        //Check if need update (last row)
        if(economy != null ){
            if(isUpToDate(economy.getFetchedDate(), Validity.ECONOMY)){
                fireSuccess();
                return;
            }
        }else{
            economy = new HEconomy();
        }


        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(Economy.class, teamID);
        Economy eco = (Economy) getResource(TAG, hparam);
        if(eco == null){
            return;
        }

        //////////////////////////////////////////////

        //Save each week in one row (for stats)

        /*economy.setLastIncomeSpectators(eco.getLastIncomeSpectators());
        economy.setLastIncomeSponsors(eco.getLastIncomeSponsors());
        economy.setLastIncomeFinancial(eco.getLastIncomeFinancial());
        economy.setLastIncomeSoldPlayers(eco.getLastIncomeSoldPlayers());
        economy.setLastIncomeSoldPlayersCommission(eco.getLastIncomeSoldPlayersCommission());
        economy.setLastIncomeTemporary(eco.getLastIncomeTemporary());
        economy.setLastIncomeSum(eco.getLastIncomeSum());
        economy.setLastCostsArena(eco.getLastCostsArena());
        economy.setLastCostsPlayers(eco.getLastCostsPlayers());
        economy.setLastCostsFinancial(eco.getLastCostsFinancial());
        economy.setLastCostsStaff(eco.getLastCostsStaff());
        economy.setLastCostsBoughtPlayers(eco.getLastCostsBoughtPlayers());
        economy.setLastCostsArenaBuilding(eco.getLastCostsArenaBuilding());
        economy.setLastCostsTemporary(eco.getLastCostsTemporary());
        economy.setLastCostsYouth(eco.getLastCostsYouth());
        economy.setLastCostsSum(eco.getLastCostsSum());
        economy.setLastWeeksTotal(eco.getLastWeeksTotal());*/

        economy.setTeamID(eco.getTeamID());
        economy.setCash(eco.getCash());
        economy.setExpectedCash(eco.getExpectedCash());
        economy.setSponsorsPopularity(eco.getSponsorsPopularity());
        economy.setSupportersPopularity(eco.getSupportersPopularity());
        economy.setIncomeSpectators(eco.getIncomeSpectators());
        economy.setIncomeSponsors(eco.getIncomeSponsors());
        economy.setIncomeFinancial(eco.getIncomeFinancial());
        economy.setIncomeSoldPlayers(eco.getIncomeSoldPlayers());
        economy.setIncomeSoldPlayersCommission(eco.getIncomeSoldPlayersCommission());
        economy.setIncomeTemporary(eco.getIncomeTemporary());
        economy.setIncomeSum(eco.getIncomeSum());
        economy.setCostsArena(eco.getCostsArena());
        economy.setCostsPlayers(eco.getCostsPlayers());
        economy.setCostsFinancial(eco.getCostsFinancial());
        economy.setCostsStaff(eco.getCostsStaff());
        economy.setCostsBoughtPlayers(eco.getCostsBoughtPlayers());
        economy.setCostsArenaBuilding(eco.getCostsArenaBuilding());
        economy.setCostsTemporary(eco.getCostsTemporary());
        economy.setCostsYouth(eco.getCostsYouth());
        economy.setCostsSum(eco.getCostsSum());
        economy.setExpectedWeeksTotal(eco.getExpectedWeeksTotal());
        economy.setFetchedDate(HattrickDate.getDateTime());
        economy.save();

        fireSuccess();
    }


}
