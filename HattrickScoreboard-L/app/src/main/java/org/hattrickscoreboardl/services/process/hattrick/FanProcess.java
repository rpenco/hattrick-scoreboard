package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.services.process.HProcess;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class FanProcess extends HProcess {

    static final String TAG = (FanProcess.class).getSimpleName();

    public FanProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

      /*  //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(Fans.class, (Integer) args[0]);

        //Get resource
        Fans fans = null;
        try {
            fans = (Fans) request.get(hparam);
        } catch (IOException e) {
            e.printStackTrace();
            fireError(TAG, UpdateCode.CODE_NETWORK_ERROR);
        }

        if(fans == null){
            fireError(TAG, UpdateCode.CODE_PARSER_ERROR);
            return;
        }


        //Find User informations or create new
        HFan fan = HFan.findOne(HFan.class, "TEAM_ID = ?", "" + fans.getTeamID());
        if(fan == null){
            fan = new HFan();
        }


        fan.setTeamID(fans.getTeamID());
        fan.setFanclubId(fans.getFanClubId());
        fan.setFanClubName(fans.getFanClubName());
        fan.setFanMood(fans.getFanMood());
        fan.setMembers(fans.getMembers());
        fan.setFanSeasonExpectation(fans.getFanSeasonExpectation());
        fan.setFetchedDate(HattrickDate.getDateTime());
        fan.save();

        //Update Fans in match if exist
        for(int i = 0; i < fans.getPlayedMatches().size(); i++) {

            Match m = fans.getPlayedMatches().get(i);

            HMatch match = HMatch.findOne(HMatch.class, "MATCH_ID = ?", String.valueOf(m.getMatchID()));
            if(match != null){

                match.setFanMatchExpectation(m.getFanMatchExpectation());
                match.setFanMoodAfterMatch(m.getFanMoodAfterMatch());
                match.save();
            }
        }

        //Update Fans in match if exist
        for(int i = 0; i < fans.getUpcomingMatches().size(); i++) {

            Match m = fans.getUpcomingMatches().get(i);

            HMatch match = HMatch.findOne(HMatch.class, "MATCH_ID = ?", String.valueOf(m.getMatchID()));
            if(match != null){

                match.setFanMatchExpectation(m.getFanMatchExpectation());
                match.setFanMoodAfterMatch(m.getFanMoodAfterMatch());
                match.save();
            }
        }
        fireSuccess();*/
    }


}
