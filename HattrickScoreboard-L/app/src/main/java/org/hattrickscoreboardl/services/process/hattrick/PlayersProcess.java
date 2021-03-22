package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.players.Player;
import org.hattrick.models.players.PlayerDetails;
import org.hattrick.models.players.Players;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.players.HPlayer;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class PlayersProcess extends HProcess {

    static final String TAG = (PlayersProcess.class).getSimpleName();

    public PlayersProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        boolean fullDetails = false;

        if(args.length > 1) {
            fullDetails = (Boolean) args[1];
        }

        ////////////////////////////////////
        //Not exist or need update

        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG+"_"+teamID);

        //Check if need update
        if(update != null ){
            if(isUpToDate(update.getFetchedDate(), Validity.PLAYER)){
                fireSuccess();
                return;
            }
        }else
        {
            update = new HUpdate();
        }

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(Players.class, teamID);
        Players players = (Players) getResource(TAG, hparam);
        if(players == null){
            return;
        }

        //Remove old players
        HPlayer.deleteAll(HPlayer.class,"TEAM_ID = ?", String.valueOf(teamID));

        //Add players
        for(int i=0; i < players.getPlayers().size();i++) {

            Player p = players.getPlayers().get(i);

            HPlayer player = new HPlayer();

            player.setTeamID(teamID);
            player.setPlayerID(p.getPlayerID());
            player.setFirstName(p.getFirstName());
            player.setNickName(p.getNickName());
            player.setLastName(p.getLastName());
            player.setPlayerNumber(p.getPlayerNumber());
            player.setAge(p.getAge());
            player.setAgeDays(p.getAgeDays());
            player.setTSI(p.getTSI());
            player.setPlayerForm(p.getPlayerForm());
            player.setStatement(p.getStatement());
            player.setExperience(p.getExperience());
            player.setLoyalty(p.getLoyalty());
            player.setMotherClubBonus(p.isMotherClubBonus());
            player.setLeadership(p.getLeadership());
            player.setSalary(p.getSalary());
            player.setAbroad(p.isAbroad());
            player.setAgreeability(p.getAgreeability());
            player.setAggressiveness(p.getAggressiveness());
            player.setHonesty(p.getHonesty());
            player.setLeagueGoals(p.getLeagueGoals());
            player.setCupGoals(p.getCupGoals());
            player.setFriendliesGoals(p.getFriendliesGoals());
            player.setCareerGoals(p.getCareerGoals());
            player.setCareerHattricks(p.getCareerHattricks());
            player.setSpecialty(p.getSpecialty());
            player.setTransferListed(p.isTransferListed());
            player.setNationalTeamID(p.getNationalTeamID());
            player.setCountryID(p.getCountryID());
            player.setCaps(p.getCaps());
            player.setCapsU20(p.getCapsU20());
            player.setCards(p.getCards());
            player.setInjuryLevel(p.getInjuryLevel());
            player.setStaminaSkill(p.getStaminaSkill());
            player.setKeeperSkill(p.getKeeperSkill());
            player.setPlaymakerSkill(p.getPlaymakerSkill());
            player.setScorerSkill(p.getScorerSkill());
            player.setPassingSkill(p.getPassingSkill());
            player.setWingerSkill(p.getWingerSkill());
            player.setDefenderSkill(p.getDefenderSkill());
            player.setSetPiecesSkill(p.getSetPiecesSkill());
            player.setPlayerCategoryID(p.getPlayerCategoryId());
            player.setLastMatchDate(p.getDate());
            player.setLastMatchId(p.getMatchId());
            player.setLastMatchPositionCode(p.getPositionCode());
            player.setLastMatchPlayedMinutes(p.getPlayedMinutes());
            player.setLastMatchRating(p.getRating());
            player.setLastMatchRatingEndOfGame(p.getRatingEndOfGame());


            if(fullDetails) {
                //Get player details
                hparam = new HattrickParam(PlayerDetails.class, p.getPlayerID());
                PlayerDetails playerDetails = (PlayerDetails) getResource(TAG, hparam);

                if (playerDetails != null) {

                    player.setOwnerNotes(playerDetails.getOwnerNotes());
                    player.setNextBirthDay(playerDetails.getNextBirthDay());
                    player.setArrivalDate(playerDetails.getArrivalDate());

                    player.setPlayerLanguageID(playerDetails.getPlayerLanguageID());
                    player.setPlayerLanguage(playerDetails.getPlayerLanguage());

                    player.setTrainerType(playerDetails.getTrainerType());
                    player.setTrainerSkill(playerDetails.getTrainerSkill());

                    player.setNativeCountryID(playerDetails.getNativeCountryID());
                    player.setNativeLeagueID(playerDetails.getNativeLeagueID());
                    player.setNativeLeagueName(playerDetails.getNativeLeagueName());
                    player.setLeagueID(playerDetails.getLeagueID());

                    player.setTransferAskingPrice(playerDetails.getAskingPrice());
                    player.setTransferDeadline(playerDetails.getDeadline());
                    player.setTransferHighestBid(playerDetails.getHighestBid());
                    player.setTransferMaxBid(playerDetails.getMaxBid());
                    player.setTransferBidderTeamID(playerDetails.getBidderTeamID());
                    player.setTransferBidderTeamName(playerDetails.getBidderTeamName());
                }
            }

            player.save();
        }

        if(fullDetails) {
            //Save updater
            update.setProcessName(TAG + "_" + teamID);
            update.setFetchedDate(HattrickDate.getDateTime());
            update.save();
        }

        fireSuccess();
    }


}
