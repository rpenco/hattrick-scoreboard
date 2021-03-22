package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.constants.match.HMatchStatus;
import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.leagues.LeagueTeam;
import org.hattrick.models.leagues.Match;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.database.models.series.HSeries;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class SeriesProcess extends HProcess {

    static final String TAG = (SeriesProcess.class).getSimpleName();

    public SeriesProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        int leagueLevelUnitID = (Integer) args[0];

        //Find arena if exist
        HSeries series = HSeries.findOne(HSeries.class, "LEAGUE_LEVEL_UNIT_ID = ?", "" + leagueLevelUnitID);

        ////////////////////////////////////

        //Check if need update
        if(series != null ){
            if(isUpToDate(series.getFetchedDate(), Validity.LEAGUE)){
                fireSuccess();
                return;
            }
        }else{
            series = new HSeries();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (arenaID)
        IParam hparam = new HattrickParam(LeagueDetails.class, leagueLevelUnitID);
        LeagueDetails league = (LeagueDetails) getResource(TAG, hparam);
        if(league == null){
            return;
        }

        ////////////////////////////////////
        //Insert xml to database

        series.setCurrentMatchRound(league.getCurrentMatchRound());
        series.setLeagueID(league.getLeagueID());
        series.setLeagueLevel(league.getLeagueLevel());
        series.setLeagueLevelUnitID(league.getLeagueLevelUnitID());
        series.setLeagueLevelUnitName(league.getLeagueLevelUnitName());
        series.setLeagueName(league.getLeagueName());
        series.setMaxLevel(league.getMaxLevel());
        series.setFetchedDate(HattrickDate.getDateTime());
        series.save();

        //Update team series
        for(int i = 0; i < league.getTeams().size(); i++) {

            LeagueTeam t = league.getTeams().get(i);

            HTeam team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", String.valueOf(t.getTeamID()));
            if(team == null) {
                team = new HTeam();
            }

            team.setLeagueID(league.getLeagueID());
            team.setLeagueLevel(league.getLeagueLevel());
            team.setLeagueName(league.getLeagueName());
            team.setLeagueLevelUnitName(league.getLeagueLevelUnitName());
            team.setLeagueLevelUnitID(league.getLeagueLevelUnitID());

            team.setTeamID(t.getTeamID());
            team.setTeamName(t.getTeamName());
            team.setPosition(t.getPosition());
            team.setPositionChange(t.getPositionChange());
            team.setMatches(t.getMatches());
            team.setGoalsFor(t.getGoalsFor());
            team.setGoalsAgainst(t.getGoalsAgainst());
            team.setPoints(t.getPoints());
            team.setWon(t.getWon());
            team.setDraws(t.getDraws());
            team.setLost(t.getLost());
            team.save();

        }



        /////////////////////////////////////
        // AND league Fixtures


        //Create URI parameter (SourceSystem, matchID)
        IParam param = new HattrickParam(LeagueFixtures.class, league.getLeagueLevelUnitID());
        LeagueFixtures fixtures = (LeagueFixtures) getResource(TAG, param);
        if(fixtures == null){
            return;
        }


        //Update matches
        int currentRound = league.getCurrentMatchRound();
        for(int i = 0; i < fixtures.getMatchs().size(); i++) {

            Match m = fixtures.getMatchs().get(i);

            HMatch match = HMatch.findOne(HMatch.class, "MATCH_ID = ?", String.valueOf(m.getMatchID()));
            if (match == null) {
                match = new HMatch();
            }

            if(currentRound > m.getMatchRound()){
                match.setStatus(HMatchStatus.FINISHED);
            }
            else
            {
                match.setStatus(HMatchStatus.UPCOMING);
            }

            match.setSourceSystem("Hattrick");
            match.setAwayGoals(m.getAwayGoals());
            match.setAwayTeamID(m.getAwayTeamID());
            match.setAwayTeamName(m.getAwayTeamName());
            match.setHomeTeamName(m.getHomeTeamName());
            match.setHomeGoals(m.getHomeGoals());
            match.setHomeTeamID(m.getHomeTeamID());
            match.setMatchDate(m.getMatchDate());
            match.setMatchID(m.getMatchID());
            match.setMatchRound(m.getMatchRound());
            match.setLeagueLevelUnitID(league.getLeagueLevelUnitID());
            match.setLeagueLevelUnitName(league.getLeagueLevelUnitName());
            match.save();
        }

        fireSuccess();
    }


}
