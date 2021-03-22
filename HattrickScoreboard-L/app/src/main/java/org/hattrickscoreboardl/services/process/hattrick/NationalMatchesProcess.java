package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.national.NationalMatch;
import org.hattrick.models.national.NationalTeamMatches;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.nationals.HNationalMatch;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class NationalMatchesProcess extends HProcess {

    static final String TAG = (NationalMatchesProcess.class).getSimpleName();

    public NationalMatchesProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        //Create URI parameter (leagueOfficeTypeID)
        int leagueOfficeTypeID = (Integer) args[0];

        ////////////////////////////////////

        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG+"_"+leagueOfficeTypeID);

        //Check if need update
        if(update != null ){
            if(isUpToDate(update.getFetchedDate(), Validity.MATCH)){
                fireSuccess();
                return;
            }
        }else
        {
            update = new HUpdate();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(NationalTeamMatches.class, leagueOfficeTypeID);
        NationalTeamMatches matches = (NationalTeamMatches) getResource(TAG, hparam);
        if(matches == null){
            return;
        }

        ////////////////////////////////////
        //Insert xml to database



        //Update all his matches
        for (int i = 0; i < matches.getMatches().size(); i++) {

            NationalMatch m = matches.getMatches().get(i);

            //Find Team informations or create new
            HNationalMatch match = HNationalMatch.findOne(HNationalMatch.class, "MATCH_ID = ?", "" + m.getMatchID());
            if (match == null) {
                match = new HNationalMatch();
            }

            match.setMatchID(m.getMatchID());
            match.setHomeTeamName(m.getHomeTeamName());
            match.setAwayTeamName(m.getAwayTeamName());
            match.setMatchDate(m.getMatchDate());
            match.setMatchType(m.getMatchType());
            match.setHomeGoals(m.getHomeGoals());
            match.setAwayGoals(m.getAwayGoals());
            match.setLeagueOfficeTypeID(leagueOfficeTypeID);
            match.save();

        }

        //Save updater
        update.setProcessName(TAG+"_"+leagueOfficeTypeID);
        update.setFetchedDate(HattrickDate.getDateTime());
        update.save();

        fireSuccess();
    }
}
