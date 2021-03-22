package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.arenas.CurrentCapacity;
import org.hattrick.models.arenas.ExpandedCapacity;
import org.hattrick.models.arenas.MyArena;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.arena.HArena;
import org.hattrickscoreboardl.database.models.teams.HUser;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class ArenaProcess extends HProcess {

    static final String TAG = (ArenaProcess.class).getSimpleName();

    public ArenaProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        int arenaID = (Integer) args[0];

        //Find arena if exist
        HArena arena = HArena.findOne(HArena.class, "ARENA_ID = ?", "" + arenaID);

        ////////////////////////////////////

        //Check if need update
        if(arena != null ){
            if(isUpToDate(arena.getFetchedDate(), Validity.ARENA)){
                fireSuccess();
                return;
            }
        }else{
            arena = new HArena();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(ArenaDetails.class, arenaID);
        ArenaDetails arenaDetails = (ArenaDetails) getResource(TAG, hparam);
        if(arenaDetails == null){
            return;
        }

        ////////////////////////////////////
        //Insert xml to database

        arena.setArenaID(arenaDetails.getArenaID()) ;
        arena.setArenaName(arenaDetails.getArenaName());
        arena.setTeamID(arenaDetails.getTeamID());
        arena.setLeagueID(arenaDetails.getLeagueID());
        arena.setRegionID(arenaDetails.getRegionID());

        //Current Capacity
        CurrentCapacity currentCapacity = arenaDetails.getCurrentCapacity();
        if(currentCapacity.getRebuiltDate() != null) {
            arena.setCurrentTerraces(currentCapacity.getTerraces());
            arena.setCurrentBasic( currentCapacity.getBasic());
            arena.setCurrentRoof( currentCapacity.getRoof());
            arena.setCurrentVIP( currentCapacity.getVIP());
            arena.setCurrentTotal( currentCapacity.getTotal());
            arena.setRebuiltDate(currentCapacity.getRebuiltDate());
        }

        //Expanded Capacity
        ExpandedCapacity expandedCapacity = arenaDetails.getExpandedCapacity();
        if(expandedCapacity != null) {
            arena.setExpandedTerraces(expandedCapacity.getTerraces());
            arena.setExpandedBasic( expandedCapacity.getBasic());
            arena.setExpandedRoof( expandedCapacity.getRoof());
            arena.setExpandedVIP( expandedCapacity.getVIP());
            arena.setExpandedTotal( expandedCapacity.getTotal());
            arena.setExpansionDate(expandedCapacity.getExpansionDate());
        }else{
            arena.setExpandedTerraces(0);
            arena.setExpandedBasic(0);
            arena.setExpandedRoof(0);
            arena.setExpandedVIP(0);
            arena.setExpandedTotal(0);
            arena.setExpansionDate(null);
        }


        //Supporters?
        //Download supporters infos.
        MyArena myArena = null;
        HUser user = HUser.findById(HUser.class, 1l);
        if(user.isSupporterTier()) {
            //Create URI parameter (arenaID)
            hparam = new HattrickParam(MyArena.class, null);
            myArena = (MyArena) getResource(TAG, hparam);
        }
        if(myArena != null){
            arena.setNumberOfMatches(myArena.getNumberOfMatches());
            arena.setAverageTerraces(myArena.getAverageTerraces());
            arena.setAverageBasic(myArena.getAverageBasic());
            arena.setAverageRoof(myArena.getAverageRoof());
            arena.setAverageVIP(myArena.getAverageVIP());
            arena.setAverageTotal(myArena.getAverageTotal());
            arena.setMostTerraces(myArena.getMostTerraces());
            arena.setMostBasic(myArena.getMostBasic());
            arena.setMostRoof(myArena.getMostRoof());
            arena.setMostVIP(myArena.getMostVIP());
            arena.setMostTotal(myArena.getMostTotal());
            arena.setLeastTerraces(myArena.getLeastTerraces());
            arena.setLeastBasic(myArena.getLeastBasic());
            arena.setLeastRoof(myArena.getLeastRoof());
            arena.setLeastVIP(myArena.getLeastVIP());
            arena.setLeastTotal(myArena.getLeastTotal());
        }
        else{

            //Clear all previews data
            //and add default values
            arena.setNumberOfMatches(0);
            arena.setAverageTerraces(0);
            arena.setAverageBasic(0);
            arena.setAverageRoof(0);
            arena.setAverageVIP(0);
            arena.setAverageTotal(0);
            arena.setMostTerraces(0);
            arena.setMostBasic(0);
            arena.setMostRoof(0);
            arena.setMostVIP(0);
            arena.setMostTotal(0);
            arena.setLeastTerraces(0);
            arena.setLeastBasic(0);
            arena.setLeastRoof(0);
            arena.setLeastVIP(0);
            arena.setLeastTotal(0);
        }

        //Save object
        arena.setFetchedDate(HattrickDate.getDateTime());
        arena.save();

        fireSuccess();
    }


}
