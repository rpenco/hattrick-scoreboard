package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.managers.ManagerCompendium;
import org.hattrick.models.managers.ManagerTeam;
import org.hattrick.models.managers.ManagerYouthTeam;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.teams.HUser;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

import java.util.ArrayList;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class ManagerProcess extends HProcess {

    static final String TAG = (ManagerProcess.class).getSimpleName();

    public ManagerProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        int userID = (Integer) args[0];

        //Find user if exist
        HUser user = null;
        if(userID == 0) {
            user = HUser.findById(HUser.class, 1l);
        }else{
            user = HUser.findOne(HUser.class, "USER_ID = ?", String.valueOf(userID));
        }

        ////////////////////////////////////

        //Check if need update
        if(user != null){
            if(isUpToDate(user.getFetchedDate(), Validity.CLUB)){
                fireSuccess();
                return;
            }
        }else{
            user = new HUser();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(ManagerCompendium.class, userID);
        ManagerCompendium manager = (ManagerCompendium) getResource(TAG, hparam);
        if(manager == null){
            return;
        }

        //Save user infos
        user.setLoginname(manager.getLoginname());
        user.setSupporterTier(manager.getSupporterTier());
        user.setUserID(manager.getUserId());
        user.setFetchedDate(HattrickDate.getDateTime());

        //For each teams
        ArrayList<ManagerTeam> teams = manager.getTeams();
        for(int i=0; i < teams.size(); i++){

            //Senior team
            ManagerTeam t = teams.get(i);

            //Get team if exist
            HTeam team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", String.valueOf(t.getTeamId()));
            if(team == null){
                team = new HTeam();
            }

            team.setTeamID(t.getTeamId());
            team.setTeamName(t.getTeamName());
            team.setArenaID(t.getArenaId());
            team.setLeagueID(t.getLeagueId());
            team.setLeagueName(t.getLeagueName());
            team.setLeagueLevelUnitID(t.getLeagueLevelUnitId());
            team.setLeagueLevelUnitName(t.getLeagueLevelUnitName());
            team.setRegionID(t.getRegionId());
            team.setRegionName(t.getRegionName());



            //Youth team
            ManagerYouthTeam y = t.getYouthTeam();
            if(y != null){
                //like senior with youth team
                team.setYouthTeamID(y.getYouthTeamId());
                team.setYouthTeamName(y.getYouthTeamName());
            }

            // Save senior team
            team.save();

        }


        user.save();
        fireSuccess();
    }


}
