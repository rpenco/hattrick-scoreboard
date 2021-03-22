package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.national.NationalTeam;
import org.hattrick.models.national.NationalTeams;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class NationalTeamsProcess extends HProcess {

    static final String TAG = (NationalTeamsProcess.class).getSimpleName();

    public NationalTeamsProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        ////////////////////////////////////

        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG);

        //Check if need update
        if(update != null ){
            if(isUpToDate(update.getFetchedDate(), Validity.WORLD)){
                fireSuccess();
                return;
            }
        }else
        {
            update = new HUpdate();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (2 = Senior)
        IParam hparam = new HattrickParam(NationalTeams.class, 2);
        NationalTeams teams = (NationalTeams) getResource(TAG, hparam);
        if(teams == null){
            return;
        }

        //Save senior teams
        saveTeam(teams);


        //Create URI parameter (4 = U-20)
        hparam = new HattrickParam(NationalTeams.class, 4);
        teams = (NationalTeams) getResource(TAG, hparam);
        if(teams == null){
            return;
        }

        //Save youth teams
        saveTeam(teams);

        //Save updater
        update.setProcessName(TAG);
        update.setFetchedDate(HattrickDate.getDateTime());
        update.save();

        fireSuccess();
    }


    public void saveTeam(NationalTeams teams){

        ////////////////////////////////////
        //Insert xml to database

        //Update all national teams
        for (int i = 0; i < teams.getNationalTeams().size(); i++) {

            NationalTeam t = teams.getNationalTeams().get(i);

            //Find Team informations or create new
            HNationalTeam team = HNationalTeam.findOne(HNationalTeam.class, "TEAM_ID = ?", "" + t.getNationalTeamId());
            if (team == null) {
                team = new HNationalTeam();
            }

            team.setTeamID(t.getNationalTeamId());
            team.setTeamName(t.getNationalTeamName());
            team.setLeagueID(t.getLeagueId());
            team.setRank(t.getRatingScores());
            team.setLeagueOfficeTypeID(teams.getLeagueOfficeTypeID());
            team.setCupID(teams.getCupID());
            team.save();

        }
    }
}
