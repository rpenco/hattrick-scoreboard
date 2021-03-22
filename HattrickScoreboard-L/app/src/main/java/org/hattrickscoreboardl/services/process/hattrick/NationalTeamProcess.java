package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.national.NationalTeamDetails;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class NationalTeamProcess extends HProcess {

    static final String TAG = (NationalTeamProcess.class).getSimpleName();

    public NationalTeamProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        int nationalTeamID = (Integer) args[0];

        //Find arena if exist
        HNationalTeam team = HNationalTeam.findOne(HNationalTeam.class, "TEAM_ID = ?", "" + nationalTeamID);

        ////////////////////////////////////

        //Check if need update
        if(team != null ){
            if(team.getFetchedDate() != null) {
                if (isUpToDate(team.getFetchedDate(), Validity.TEAM)) {
                    fireSuccess();
                    return;
                }
            }
        }else{
            team = new HNationalTeam();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(NationalTeamDetails.class, nationalTeamID);
        NationalTeamDetails t = (NationalTeamDetails) getResource(TAG, hparam);
        if(t == null){
            return;
        }

        ////////////////////////////////////
        //Insert xml to database

        team.setTeamID(t.getTeamID());
        team.setTeamName(t.getTeamName());
        team.setShortTeamName(t.getShortTeamName());
        team.setNationalCoachUserID(t.getNationalCoachUserID());
        team.setNationalCoachLoginname(t.getNationalCoachLoginname());
        team.setLeagueID(t.getLeagueID());
        team.setLeagueName(t.getLeagueName());
        team.setTrainerID(t.getPlayerID());
        team.setTrainerName(t.getPlayerName());
        team.setHomePage(t.getHomePage());
        team.setLogo(t.getLogo());
        team.setDressURI(t.getDressURI());
        team.setDressAlternateURI(t.getDressAlternateURI());
        team.setExperience433(t.getExperience433());
        team.setExperience451(t.getExperience451());
        team.setExperience352(t.getExperience352());
        team.setExperience532(t.getExperience532());
        team.setExperience343(t.getExperience343());
        team.setExperience541(t.getExperience541());
        team.setExperience523(t.getExperience523());
        team.setExperience550(t.getExperience550());
        team.setExperience253(t.getExperience253());
        team.setExperience442(t.getExperience442());
        team.setMorale(t.getMorale());
        team.setSelfConfidence(t.getSelfConfidence());
        team.setSupportersPopularity(t.getSupportersPopularity());
        team.setRatingScore(t.getRatingScore());
        team.setFanClubSize(t.getFanClubSize());
        team.setRank(t.getRank());
        team.setFetchedDate(HattrickDate.getDateTime());
        team.save();
//      team.setLeagueOfficeTypeID();
//      team.setCupID(int cupID);

        fireSuccess();
    }

}
