package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.constants.match.HMatchStatus;
import org.hattrick.models.live.Live;
import org.hattrick.models.live.LiveMatch;
import org.hattrick.models.match.Event;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.models.HLiveParam;
import org.hattrickscoreboardl.database.models.live.HLive;
import org.hattrickscoreboardl.database.models.live.HLiveEvent;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.events.EventPattern;
import org.hattrickscoreboardl.utils.events.EventPlayer;

import java.util.List;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class LiveProcess extends HProcess {

    static final String TAG = (LiveProcess.class).getSimpleName();

    public LiveProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        HLiveParam params = (HLiveParam) args[0];

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(Live.class, params);
        Live htLive = (Live) getResource(TAG, hparam);
        if(htLive == null){
            return;
        }

        String action = params.getActionType();

        if(htLive.getMatchList() != null) {

             //From MainService (load all)
             if(action.equals(HLiveParam.VIEW_ALL)){
                 //Purge events
                 HLiveEvent.deleteAll(HLiveEvent.class);
             }


            //For all ht-lives in tracker update value
            for(LiveMatch match : htLive.getMatchList()) {

                HLive hlive = HLive.findOne(HLive.class, "MATCH_ID = ? and SOURCE_SYSTEM = ?",String.valueOf(match.getMatchID()),match.getSourceSystem());

                //Save lives
                if(action.equals(HLiveParam.VIEW_ALL)){

                    if(hlive == null){
                        hlive = new HLive();
                    }

                    hlive.setMatchID(match.getMatchID());
                    hlive.setSourceSystem(match.getSourceSystem());
                    hlive.setMatchDate(match.getMatchDate());
                    hlive.setAwayTeamName(match.getAwayTeamName());
                    hlive.setAwayTeamID(match.getAwayTeamID());
                    hlive.setHomeTeamName(match.getHomeTeamName());
                    hlive.setHomeTeamID(match.getHomeTeamID());


                    //Upcoming or Finished
                    if(match.getNextEventMinute() == null){

                        //Score == null > Upgoing
                        if(match.getEventList().size() == 0){
                            hlive.setMatchStatus(HMatchStatus.UPCOMING);
                        }else{
                            hlive.setMatchStatus(HMatchStatus.FINISHED);
                            hlive.setHomeGoals(Integer.parseInt(match.getHomeGoals()));
                            hlive.setAwayGoals(Integer.parseInt(match.getAwayGoals()));
                        }

                    }else{

                        //Ongoing
                        hlive.setMatchStatus(HMatchStatus.ONGOING);
                        hlive.setLastShownEventIndex(Integer.parseInt(match.getLastShownEventIndex()));
                        hlive.setNextEventMinute(Integer.parseInt(match.getNextEventMinute()));
                        hlive.setHomeGoals(Integer.parseInt(match.getHomeGoals()));
                        hlive.setAwayGoals(Integer.parseInt(match.getAwayGoals()));
                    }
                }


                //View new update all
                if(action.equals(HLiveParam.VIEW_NEW)){

                    //Update match only if exist
                    if(hlive != null) {

                        //Ongoing
                        if(match.getNextEventMinute() != null) {
                            hlive.setMatchStatus(HMatchStatus.ONGOING);
                            hlive.setNextEventMinute(Integer.parseInt(match.getNextEventMinute()));
                        }else{
                            hlive.setMatchStatus(HMatchStatus.FINISHED);
                        }

                        hlive.setLastShownEventIndex(Integer.parseInt(match.getLastShownEventIndex()));
                        hlive.setHomeGoals(Integer.parseInt(match.getHomeGoals()));
                        hlive.setAwayGoals(Integer.parseInt(match.getAwayGoals()));
                    }
                }


                //Save event too
                if(hlive != null){
                    for(Event event : match.getEventList()){

                        int event_type_id = 0;
                        int event_variation = 0;

                        //Split event id & variation
                        if(event.getEventTypeID() != null) {
                            String[] types = event.getEventTypeID().split("_");

                            event_type_id = Integer.parseInt(types[0]);
                            if(types.length == 2){
                                event_variation = Integer.parseInt(types[1]);
                            }
                        }

                        HLiveEvent ev = HLiveEvent.findOne(HLiveEvent.class, "MATCH_ID = ? and SOURCE_SYSTEM = ? and EVENT_TYPE_ID = ?",
                                new String[]{String.valueOf(match.getMatchID()), match.getSourceSystem(), String.valueOf(event_type_id)});
                        if(ev == null) {
                            ev = new HLiveEvent();
                        }

                        ev.setMatchID(match.getMatchID());
                        ev.setSourceSystem(match.getSourceSystem());
                        ev.setEventTypeID(event_type_id);
                        ev.setEventVariation(event_variation);

                        ev.setEventIndex(event.getIndex());
                        ev.setMinute(event.getMinute());
                        ev.setObjectPlayerID(Integer.parseInt(event.getObjectPlayerID()));
                        ev.setSubjectPlayerID(Integer.parseInt(event.getSubjectPlayerID()));
                        ev.setSubjectTeamID(Integer.parseInt(event.getSubjectTeamID()));

                        if(event.getEventText() != null) {

                            //Explode string.
                            List<EventPlayer> players = EventPattern.getPlayers(event.getEventText());
                            for(EventPlayer player : players){

                                //Object player.
                                if(Integer.valueOf(event.getObjectPlayerID()) == player.getPlayerID()){
                                    ev.setObjectPlayerName(player.getPlayerName());
                                }

                                //Object player.
                                if(Integer.valueOf(event.getSubjectPlayerID()) == player.getPlayerID()){
                                    ev.setSubjectPlayerName(player.getPlayerName());
                                }

                            }

                            //Clear string
                            ev.setEventText(EventPattern.cleanEventText(event.getEventText()));
                        }

                        ev.save();

                    }

                    hlive.save();
                }
            }
        }

        fireSuccess();
    }


}
