package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.constants.match.HMatchStatus;
import org.hattrick.constants.match.HMatchTypeID;
import org.hattrick.models.match.Booking;
import org.hattrick.models.match.Event;
import org.hattrick.models.match.Goal;
import org.hattrick.models.match.Injury;
import org.hattrick.models.match.MatchDetails;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.match.MatchTeam;
import org.hattrick.models.match.PlayerLineup;
import org.hattrick.models.match.Referee;
import org.hattrick.models.match.Substitution;
import org.hattrick.models.matches.Match;
import org.hattrick.models.matches.Matches;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.models.HMatchLineupParam;
import org.hattrick.providers.models.HMatchParam;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.matches.HBooking;
import org.hattrickscoreboardl.database.models.matches.HEvent;
import org.hattrickscoreboardl.database.models.matches.HInjury;
import org.hattrickscoreboardl.database.models.matches.HLineup;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.database.models.matches.HReferer;
import org.hattrickscoreboardl.database.models.matches.HScorer;
import org.hattrickscoreboardl.database.models.matches.HSubstitution;
import org.hattrickscoreboardl.database.models.world.HCup;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;
import org.hattrickscoreboardl.utils.events.EventPattern;
import org.hattrickscoreboardl.utils.events.EventPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class MatchesProcess extends HProcess {

    static final String TAG = (MatchesProcess.class).getSimpleName();

    public MatchesProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        //Create URI parameter (teamID)
        int teamID = (Integer) args[0];
        boolean fullDetails = false;

        if(args.length > 1) {
            fullDetails = (Boolean) args[1];
        }

        ////////////////////////////////////

        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG+"_"+teamID);

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
        IParam hparam = new HattrickParam(Matches.class, teamID);
        Matches matches = (Matches) getResource(TAG, hparam);
        if(matches == null){
            return;
        }

        ////////////////////////////////////
        //Insert xml to database



        //Update all his matches
        for (int i = 0; i < matches.getMatchList().size(); i++) {

            Match m = matches.getMatchList().get(i);

            //Find Team informations or create new
            HMatch match = HMatch.findOne(HMatch.class, "MATCH_ID = ?", "" + m.getMatchID());
            if (match == null) {
                match = new HMatch();
            }

            match.setMatchID(m.getMatchID());
            match.setHomeTeamID(m.getHomeTeamID());
            match.setHomeTeamName(m.getHomeTeamName());
            match.setAwayTeamID(m.getAwayTeamID());
            match.setAwayTeamName(m.getAwayTeamName());
            match.setMatchDate(m.getMatchDate());
            match.setSourceSystem(m.getSourceSystem());
            match.setMatchType(m.getMatchType());
            match.setMatchContextId(m.getMatchContextID());
            match.setHomeGoals(m.getHomeGoals());
            match.setAwayGoals(m.getAwayGoals());
            match.setStatus(m.getStatus());
            match.setOrdersGiven(m.isOrdersGiven());

            //Complete if Cup details exist
            if(m.getMatchType() == HMatchTypeID.CUP_MATCH_STANDARD_LEAGUE_MATCH){
                HCup cup = HCup.findOne(HCup.class, "CUP_ID = ?", String.valueOf(m.getMatchContextID()));
                if(cup != null){
                    match.setCupID(cup.getCupID());
                    match.setCupLeagueLevel(cup.getCupLeagueLevel());
                    match.setCupLevel(cup.getCupLevel());
                    match.setCupLevelIndex(cup.getCupLevelIndex());
                    match.setCupMatchRound(cup.getMatchRound());
                }
            }

            //If want full match details
            if(fullDetails){
            //Download infos if match finished and not all downloaded
            if (HMatchStatus.FINISHED.equals(m.getStatus()) && match.getFinishedDate() == null) {


                //Create URI parameter (SourceSystem, matchID)
                HMatchParam mparam = new HMatchParam(m.getSourceSystem(), m.getMatchID());
                IParam param = new HattrickParam(MatchDetails.class, mparam);
                MatchDetails details = (MatchDetails) getResource(TAG, param);
                if(details == null){
                    continue;
                }

                //Complete informations
                match.setMatchType(details.getMatchType());
                match.setMatchDate(details.getMatchDate());
                match.setMatchContextId(details.getMatchContextId());
                match.setFinishedDate(details.getFinishedDate());
                match.setArenaID(details.getArenaID());
                match.setArenaName(details.getArenaName());
                match.setWeatherID(details.getWeatherID());
                match.setSoldTotal(details.getSoldTotal());
                match.setSoldTerraces(details.getSoldTerraces());
                match.setSoldBasic(details.getSoldBasic());
                match.setSoldRoof(details.getSoldRoof());
                match.setSoldVIP(details.getSoldVIP());
                match.setPossessionFirstHalfHome(details.getPossessionFirstHalfHome());
                match.setPossessionFirstHalfAway(details.getPossessionFirstHalfAway());
                match.setPossessionSecondHalfHome(details.getPossessionSecondHalfHome());
                match.setPossessionSecondHalfAway(details.getPossessionSecondHalfAway());

                //Home team
                MatchTeam home = details.getHomeTeam();

                match.setHomeFormation(home.getFormation());
                match.setHomeGoals(home.getGoals());
                match.setHomeTacticType(home.getTacticType());
                match.setHomeTacticSkill(home.getTacticSkill());
                match.setHomeRatingMidfield(home.getRatingMidfield());
                match.setHomeRatingRightDef(home.getRatingRightDef());
                match.setHomeRatingMidDef(home.getRatingMidDef());
                match.setHomeRatingLeftDef(home.getRatingLeftDef());
                match.setHomeRatingRightAtt(home.getRatingRightAtt());
                match.setHomeRatingMidAtt(home.getRatingMidAtt());
                match.setHomeRatingLeftAtt(home.getRatingLeftAtt());
                match.setHomeTeamAttitude(home.getTeamAttitude());
                match.setHomeRatingIndirectSetPiecesDef(home.getRatingIndirectSetPiecesDef());
                match.setHomeRatingIndirectSetPiecesAtt(home.getRatingIndirectSetPiecesAtt());

                //Away team
                MatchTeam away = details.getAwayTeam();

                match.setAwayFormation(away.getFormation());
                match.setAwayGoals(away.getGoals());
                match.setAwayTacticType(away.getTacticType());
                match.setAwayTacticSkill(away.getTacticSkill());
                match.setAwayRatingMidfield(away.getRatingMidfield());
                match.setAwayRatingRightDef(away.getRatingRightDef());
                match.setAwayRatingMidDef(away.getRatingMidDef());
                match.setAwayRatingLeftDef(away.getRatingLeftDef());
                match.setAwayRatingRightAtt(away.getRatingRightAtt());
                match.setAwayRatingMidAtt(away.getRatingMidAtt());
                match.setAwayRatingLeftAtt(away.getRatingLeftAtt());
                match.setAwayTeamAttitude(away.getTeamAttitude());
                match.setAwayRatingIndirectSetPiecesDef(away.getRatingIndirectSetPiecesDef());
                match.setAwayRatingIndirectSetPiecesAtt(away.getRatingIndirectSetPiecesAtt());

                //////////////////////////////////////////
                // SCORER

                //Remove scorer if exist
                HScorer.deleteAll(HScorer.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ?", String.valueOf(details.getMatchID()), String.valueOf(details.getMatchContextId()));
                //Add scorers
                ArrayList<Goal> goals = details.getScorers();
                if (goals != null) {
                    for (int g = 0; g < goals.size(); g++) {
                        Goal goal = goals.get(g);
                        HScorer scorer = new HScorer();
                        scorer.setScorerIndex(goal.getIndex());
                        scorer.setMatchContextID(details.getMatchContextId());
                        scorer.setMatchID(details.getMatchID());
                        scorer.setAwayGoals(goal.getAwayGoals());
                        scorer.setHomeGoals(goal.getHomeGoals());
                        scorer.setMinute(goal.getMinute());
                        scorer.setPlayerID(goal.getPlayerID());
                        scorer.setPlayerName(goal.getPlayerName());
                        scorer.setTeamID(goal.getTeamID());
                        scorer.save();
                    }
                }

                //////////////////////////////////////////
                // BOOKING

                //Remove booking if exist
                HBooking.deleteAll(HBooking.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ?", String.valueOf(details.getMatchID()), String.valueOf(details.getMatchContextId()));
                //Add scorers
                ArrayList<Booking> bookings = details.getBookings();
                if (bookings != null) {
                    for (int g = 0; g < bookings.size(); g++) {
                        Booking book = bookings.get(g);
                        HBooking booking = new HBooking();
                        booking.setBookIndex(book.getIndex());
                        booking.setMatchContextID(details.getMatchContextId());
                        booking.setMatchID(details.getMatchID());
                        booking.setMinute(book.getMinute());
                        booking.setPlayerID(book.getPlayerID());
                        booking.setPlayerName(book.getPlayerName());
                        booking.setTeamID(book.getTeamID());
                        booking.setType(book.getType());
                        booking.save();
                    }
                }


                //////////////////////////////////////////
                // INJURIES

                //Remove injury if exist
                HInjury.deleteAll(HInjury.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ?", String.valueOf(details.getMatchID()), String.valueOf(details.getMatchContextId()));
                //Add scorers
                ArrayList<Injury> injuries = details.getInjuries();
                if (injuries != null) {
                    for (int g = 0; g < injuries.size(); g++) {
                        Injury inj = injuries.get(g);
                        HInjury injury = new HInjury();
                        injury.setMatchContextID(details.getMatchContextId());
                        injury.setMatchID(details.getMatchID());
                        injury.setMinute(inj.getMinute());
                        injury.setPlayerID(inj.getPlayerID());
                        injury.setPlayerName(inj.getPlayerName());
                        injury.setTeamID(inj.getTeamID());
                        injury.setType(inj.getType());
                        injury.save();
                    }
                }


                //Add referer
                Referee referee = details.getReferee();
                if(referee != null) {
                    HReferer ref = HReferer.findOne(HReferer.class, "REFEREER_ID = ?", String.valueOf(referee.getRefereeId()));
                    if (ref == null) {
                        ref = new HReferer();
                    }
                    ref.setCountryId(referee.getRefereeCountryId());
                    ref.setCountryName(referee.getRefereeCountryName());
                    ref.setRefereerId(referee.getRefereeId());
                    ref.setName(referee.getRefereeName());
                    ref.setTeamId(referee.getRefereeTeamId());
                    ref.setTeamName(referee.getRefereeTeamname());
                    ref.save();

                    match.setRefereeID(referee.getRefereeId());
                }

                //Assistant 1

                Referee refereeAssistant1 = details.getRefereeAssistant1();
                if(refereeAssistant1 != null) {
                    HReferer ref1 = HReferer.findOne(HReferer.class, "REFEREER_ID = ?", String.valueOf(refereeAssistant1.getRefereeId()));
                    if (ref1 == null) {
                        ref1 = new HReferer();
                    }

                    ref1.setCountryId(refereeAssistant1.getRefereeCountryId());
                    ref1.setCountryName(refereeAssistant1.getRefereeCountryName());
                    ref1.setRefereerId(refereeAssistant1.getRefereeId());
                    ref1.setName(refereeAssistant1.getRefereeName());
                    ref1.setTeamId(refereeAssistant1.getRefereeTeamId());
                    ref1.setTeamName(refereeAssistant1.getRefereeTeamname());
                    ref1.save();

                    match.setRefereeAssistant1ID(refereeAssistant1.getRefereeId());
                }

                //Assistant 2

                Referee refereeAssistant2 = details.getRefereeAssistant2();
                if(refereeAssistant2 != null){

                    HReferer ref2 = HReferer.findOne(HReferer.class, "REFEREER_ID = ?", String.valueOf(refereeAssistant2.getRefereeId()));

                    if (ref2 == null) {
                        ref2 = new HReferer();
                    }

                    ref2.setCountryId(refereeAssistant2.getRefereeCountryId());
                    ref2.setCountryName(refereeAssistant2.getRefereeCountryName());
                    ref2.setRefereerId(refereeAssistant2.getRefereeId());
                    ref2.setName(refereeAssistant2.getRefereeName());
                    ref2.setTeamId(refereeAssistant2.getRefereeTeamId());
                    ref2.setTeamName(refereeAssistant2.getRefereeTeamname());
                    ref2.save();

                    match.setRefereeAssistant2ID(refereeAssistant2.getRefereeId());
                }

                //Remove events if exist
                HEvent.deleteAll(HEvent.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ?", String.valueOf(details.getMatchID()), String.valueOf(details.getMatchContextId()));
                //Add scorers
                ArrayList<Event> events = details.getEventList();
                if (events != null) {
                    for (int g = 0; g < events.size(); g++) {
                        Event ev = events.get(g);
                        HEvent event = new HEvent();
                        event.setMatchContextID(details.getMatchContextId());
                        event.setMatchID(details.getMatchID());
                        event.setMinute(ev.getMinute());
                        event.setEventTypeID(ev.getEventTypeID());
                        event.setEventVariation(ev.getEventVariation());
                        event.setObjectPlayerID(Integer.parseInt(ev.getObjectPlayerID()));
                        event.setSubjectPlayerID(Integer.parseInt(ev.getSubjectPlayerID()));
                        event.setSubjectTeamID(Integer.parseInt(ev.getSubjectTeamID()));

                        if(ev.getEventText() != null) {

                            //Explode string.
                            List<EventPlayer> players = EventPattern.getPlayers(ev.getEventText());
                            for(EventPlayer player : players){

                                //Object player.
                                if(Integer.valueOf(ev.getObjectPlayerID()) == player.getPlayerID()){
                                    event.setObjectPlayerName(player.getPlayerName());
                                }

                                //Object player.
                                if(Integer.valueOf(ev.getSubjectPlayerID()) == player.getPlayerID()){
                                    event.setSubjectPlayerName(player.getPlayerName());
                                }

                            }

                            //Clear string
                            event.setEventText(EventPattern.cleanEventText(ev.getEventText()));
                        }

                        event.save();
                    }
                }

                ////////////////////////////////////////////////////////////////
                //Get lineup & substitutions

                //Home
                match = lineup(match, m.getHomeTeamID(), true);

                //Away
                match = lineup(match, m.getAwayTeamID(), false);

                //Save object
                match.setFetchedDate(HattrickDate.getDateTime());
            }
                match.save();

            }
        }

        //Save updater only if all downloaded
        if(fullDetails) {
            update.setProcessName(TAG + "_" + teamID);
            update.setFetchedDate(HattrickDate.getDateTime());
            update.save();
        }

        fireSuccess();
    }


    HMatch lineup(HMatch m, int teamID, boolean isHomeTeam){

        //HOME

        //Create URI parameter (SourceSystem, matchID)
        HMatchLineupParam mparam = new HMatchLineupParam(m.getSourceSystem(), m.getMatchID(), teamID);
        IParam param = new HattrickParam(MatchLineUp.class, mparam);
        MatchLineUp lineUp = (MatchLineUp) getResource(TAG, param);
        if(lineUp == null){
            return  m;
        }

        //Remove all linup if exist
        HLineup.deleteAll(HLineup.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ? and TEAM_ID = ?", String.valueOf(m.getMatchID()), String.valueOf(m.getMatchContextId()), String.valueOf(teamID));

        //Complete match information
        if(isHomeTeam) {
            m.setHomeExperienceLevel(lineUp.getExperienceLevel());
        }else{
            m.setAwayExperienceLevel(lineUp.getExperienceLevel());
        }

        //Populate lineup
        ArrayList<PlayerLineup> pLineup = lineUp.getLineup();
        if(pLineup != null){
            for(int g=0; g < pLineup.size(); g++){
                PlayerLineup l = pLineup.get(g);
                HLineup lineup = new HLineup();
                lineup.setBehaviour(l.getBehaviour());
                lineup.setFirstName(l.getFirstName());
                lineup.setLastName(l.getLastName());
                lineup.setLineupType("LINEUP");
                lineup.setMatchContextID(m.getMatchContextId());
                lineup.setMatchID(m.getMatchID());
                lineup.setNickName(l.getNickName());
                lineup.setPlayerID(l.getPlayerID());
                lineup.setRatingStars(l.getRatingStars());
                lineup.setRoleID(l.getRoleID());
                lineup.setRatingStarsEndOfMatch(l.getRatingStarsEndOfMatch());
                lineup.setTeamID(teamID);
                lineup.save();
            }

        }

        //Populate starting lineup
        ArrayList<PlayerLineup> startingLineup = lineUp.getStartingLineup();
        if(startingLineup != null){
            for(int g=0; g < startingLineup.size(); g++){
                PlayerLineup l = startingLineup.get(g);
                HLineup lineup = new HLineup();
                lineup.setBehaviour(l.getBehaviour());
                lineup.setFirstName(l.getFirstName());
                lineup.setLastName(l.getLastName());
                lineup.setLineupType("STARTING");
                lineup.setMatchContextID(m.getMatchContextId());
                lineup.setMatchID(m.getMatchID());
                lineup.setNickName(l.getNickName());
                lineup.setPlayerID(l.getPlayerID());
                lineup.setRatingStars(l.getRatingStars());
                lineup.setRoleID(l.getRoleID());
                lineup.setRatingStarsEndOfMatch(l.getRatingStarsEndOfMatch());
                lineup.setTeamID(teamID);
                lineup.save();
            }

        }


        //Remove all linup if exist
        HSubstitution.deleteAll(HSubstitution.class, "MATCH_ID = ? and MATCH_CONTEXT_ID = ? and TEAM_ID = ?", String.valueOf(m.getMatchID()), String.valueOf(m.getMatchContextId()), String.valueOf(teamID));

        //Populate substition
        ArrayList<Substitution> substitutions = lineUp.getSubstitutions();
        if(substitutions != null){
            for(int g=0; g < substitutions.size(); g++){
                Substitution s = substitutions.get(g);
                HSubstitution sub = new HSubstitution();
                sub.setMatchID(m.getMatchID());
                sub.setMatchContextID(m.getMatchContextId());
                sub.setMatchMinute(s.getMatchMinute());
                sub.setNewPositionBehaviour(s.getNewPositionBehaviour());
                sub.setNewPositionId(s.getNewPositionId());
                sub.setObjectPlayerID(s.getObjectPlayerID());
                sub.setOrderType(s.getOrderType());
                sub.setSubjectPlayerID(s.getSubjectPlayerID());
                sub.setTeamID(teamID);
                sub.save();
            }

        }

        return m;
    }
}
