package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.teams.Flag;
import org.hattrick.models.teams.Team;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.teams.Trophy;
import org.hattrick.models.teams.User;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.teams.HFlag;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.teams.HTrophy;
import org.hattrickscoreboardl.database.models.teams.HUser;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class TeamProcess extends HProcess {

    static final String TAG = (TeamProcess.class).getSimpleName();

    public TeamProcess(Context ctx, IRequest request, boolean forceUpdate) {
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

        //Find arena if exist
        HTeam team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", "" + teamID);

        ////////////////////////////////////

        //Check if need update
        if(team != null ) {
            if (isUpToDate(team.getFetchedDate(), Validity.TEAM)) {
                fireSuccess();
                return;
            }
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(TeamDetails.class, teamID);
        TeamDetails teamDetails = (TeamDetails) getResource(TAG, hparam);
        if(teamDetails == null){
            return;
        }

        User u = teamDetails.getUser();

        //Find User informations or create new
        HUser user = HUser.findOne(HUser.class, "USER_ID = ?", "" + u.getUserID());
        if(user == null){
            user = new HUser();
        }

        user.setActivationDate(u.getActivationDate());
        user.setICQ(u.getICQ());
        user.setLanguageID(u.getLanguageID());
        user.setLastLoginDate(u.getLastLoginDate());
        user.setName(u.getName());
        user.setLastLoginDate(u.getLastLoginDate());
        user.setUserID(u.getUserID());

//        TODO change user supporter value
        user.setSupporterTier("silver"/*u.getSupporterTier()*/);

        user.setSignupDate(u.getSignupDate());
        user.save();

        //Update all his teams
        for (int i = 0; i < teamDetails.getTeams().size(); i++){

            Team t = teamDetails.getTeams().get(i);

            //Find Team informations or create new
            HTeam hTeam = HTeam.findOne(HTeam.class, "TEAM_ID = ?", "" + t.getTeamID());
            if(hTeam == null){
                hTeam = new HTeam();
            }

            hTeam.setUserID(teamDetails.getUser().getUserID());
            hTeam.setTeamID(t.getTeamID());
            hTeam.setTeamName(t.getTeamName());
            hTeam.setPrimaryClub(t.isIsPrimaryClub());
            hTeam.setFoundedDate(t.getFoundedDate());
            hTeam.setArenaID(t.getArenaID());
            hTeam.setLeagueID(t.getLeagueID());
            hTeam.setLeagueName(t.getLeagueName());
            hTeam.setRegionID(t.getRegionID());
            hTeam.setRegionName(t.getRegionName());
            hTeam.setTrainerID(t.getTrainerID());
            hTeam.setHomePage(t.getHomePage());
            hTeam.setDressURI(t.getDressURI());
            hTeam.setDressAlternateURI(t.getDressAlternateURI());
            hTeam.setLeagueLevelUnitID(t.getLeagueLevelUnitID());
            hTeam.setLeagueLevelUnitName(t.getLeagueLevelUnitName());
            hTeam.setLeagueLevel(t.getLeagueLevel());
            hTeam.setBot(t.isBot());
            hTeam.setBotSince(t.getBotSince());
            hTeam.setStillInCup(t.isStillInCup());
            hTeam.setCupID(t.getCupID());
            hTeam.setCupName(t.getCupName());
            hTeam.setCupLeagueLevel(t.getCupLeagueLevel());
            hTeam.setCupLevel(t.getCupLevel());
            hTeam.setCupLevelIndex(t.getCupLevelIndex());
            hTeam.setMatchRound(t.getCupMatchRound());
            hTeam.setMatchRoundsLeft(t.getCupMatchRoundsLeft());
            hTeam.setFriendlyTeamID(t.getFriendlyTeamID());
            hTeam.setNumberOfVictories(t.getNumberOfVictories());
            hTeam.setNumberOfUndefeated(t.getNumberOfUndefeated());
            hTeam.setTeamRank(t.getTeamRank());
            hTeam.setFanclubID(t.getFanclubID());
            hTeam.setFanclubName(t.getFanclubName()) ;
            hTeam.setFanclubSize(t.getFanclubSize()) ;
            hTeam.setLogoURL(t.getLogoURL());
            hTeam.setYouthTeamID(t.getYouthTeamID());
            hTeam.setYouthTeamName(t.getYouthTeamName());
            hTeam.setNumberOfVisits(t.getNumberOfVisits());

            //Save object
            hTeam.setFetchedDate(HattrickDate.getDateTime());
            hTeam.save();

            //Trophies
            //Remove old trophy (if teamid is a new team)
            HTrophy.deleteAll(HTrophy.class, "TEAM_ID = ?", "" + t.getTeamID() + "");

            //Add trophies
            if(t.getTrophyList() != null){
                for(int j = 0; j < t.getTrophyList().size(); j++){

                    Trophy tr = t.getTrophyList().get(j);

                    HTrophy trophy = new HTrophy();
                    trophy.setTeamID(t.getTeamID());
                    trophy.setTrophyTypeId(tr.getTrophyTypeId());
                    trophy.setTrophySeason(tr.getTrophySeason());
                    trophy.setLeagueLevel(tr.getLeagueLevel());
                    trophy.setLeagueLevelUnitName(tr.getLeagueLevelUnitName());
                    trophy.setGainedDate(tr.getGainedDate());
                    trophy.setImageUrl(tr.getImageUrl());

                    trophy.save();
                }
            }


            //Flags
            //Remove old flags (if teamid is a new team)
            HFlag.deleteAll(HFlag.class, "TEAM_ID = ?", "" + t.getTeamID() + "");

            //Add home flags
            if(t.getHomeFlags() != null){
                for(int j = 0; j < t.getHomeFlags().size(); j++){

                    Flag f = t.getHomeFlags().get(j);

                    HFlag flag = new HFlag();
                    flag.setTeamID(t.getTeamID());
                    flag.setCountryCode(f.getCountryCode());
                    flag.setFlagType("home");
                    flag.setLeagueId(f.getLeagueId());
                    flag.setLeagueName(f.getLeagueName());

                    flag.save();
                }
            }

            if(t.getAwayFlags() != null){
                for(int j = 0; j < t.getAwayFlags().size(); j++){

                    Flag f = t.getAwayFlags().get(j);

                    HFlag flag = new HFlag();
                    flag.setTeamID(t.getTeamID());
                    flag.setCountryCode(f.getCountryCode());
                    flag.setFlagType("away");
                    flag.setLeagueId(f.getLeagueId());
                    flag.setLeagueName(f.getLeagueName());
                    flag.save();
                }
            }

            //SupportedTeams

            //MySupporters
        }

        fireSuccess();
    }


}
