package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.leagues.LeagueTeam;
import org.hattrick.models.leagues.Match;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.tables.SeriesFixturesTable;
import org.hattrickscoreboard.database.tables.SeriesTable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class SeriesProcess extends HProcess {

    static final String TAG = (SeriesProcess.class).getSimpleName();

    @Override
    public void perform() {

        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        DTeam teamS = obj.getSubjectTeam();
        ArrayList<DSeries> league = datasource.readAll(SeriesTable.class,
                DSeries.class, SeriesTable.COL_LEAGUE_LEVEL_UNIT_ID + "="
                        + teamS.getLeagueLevelUnitID());

        if (league != null) {

            if (league.size() > 0) {
                if (!HattrickDate.needUpdate(league.get(league.size() - 1)
                        .getFetchedDate(), league.get(league.size() - 1)
                        .getValidityTime())) {

                    Log.i(TAG, "not need update.");

                    fireSuccess();
                    return;
                }
            }
        }

        // Result class (XML from CHPP)
        params.setResultClass(LeagueDetails.class);
        request.setParams(params);

        LeagueDetails res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Get current date time
        String fetchedDate = HattrickDate.getDateTime();

        // Insert or update into DB
        for (LeagueTeam team : res.getTeams()) {

            // Foreach staff member

            ContentValues values = new ContentValues();
            values.put(SeriesTable.COL_CURRENT_ROUND,
                    res.getCurrentMatchRound());
            values.put(SeriesTable.COL_LEAGUE_ID, res.getLeagueID());
            values.put(SeriesTable.COL_LEAGUE_LEVEL, res.getLeagueLevel());
            values.put(SeriesTable.COL_LEAGUE_LEVEL_UNIT_ID,
                    res.getLeagueLevelUnitID());
            values.put(SeriesTable.COL_LEAGUE_LEVEL_UNIT_NAME,
                    res.getLeagueLevelUnitName());
            values.put(SeriesTable.COL_LEAGUE_MAX_LEVEL, res.getMaxLevel());
            values.put(SeriesTable.COL_TEAM_DRAWS, team.getDraws());
            values.put(SeriesTable.COL_TEAM_GOALS_AGAINST,
                    team.getGoalsAgainst());
            values.put(SeriesTable.COL_TEAM_GOALS_FOR, team.getGoalsFor());
            values.put(SeriesTable.COL_TEAM_ID, team.getTeamID());
            values.put(SeriesTable.COL_TEAM_LOST, team.getLost());
            values.put(SeriesTable.COL_TEAM_MATCHES, team.getMatches());
            values.put(SeriesTable.COL_TEAM_NAME, team.getTeamName());
            values.put(SeriesTable.COL_TEAM_POINTS, team.getPoints());
            values.put(SeriesTable.COL_TEAM_POSITION, team.getPosition());
            values.put(SeriesTable.COL_TEAM_POSITION_CHANGE,
                    team.getPositionChange());
            values.put(SeriesTable.COL_TEAM_WON, team.getWon());

            values.put(SeriesTable.COL_FETCHED_DATE, fetchedDate);
            values.put(SeriesTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_LEAGUE);

            // Create or update
            datasource.createOrUpdate(SeriesTable.class, values,
                    SeriesTable.COL_TEAM_ID + "=" + team.getTeamID());

        }

        // UPDATE LEAGUE FIXTURES
        Log.v(TAG, "...Update now league fixtures");

        // Set custom param
        params.setResultClass(LeagueFixtures.class);

        // Do request
        request.setParams(params);
        LeagueFixtures resFix;

        // Get file
        try {
            resFix = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Set to DBB
        for (Match match : resFix.getMatchs()) {

            // Foreach staff member

            ContentValues values = new ContentValues();

            values.put(SeriesFixturesTable.COL_LEAGUE_LEVEL_UNIT_ID,
                    resFix.getLeagueLevelUnitID());
            values.put(SeriesFixturesTable.COL_LEAGUE_LEVEL_UNIT_NAME,
                    resFix.getLeagueLevelUnitName());
            values.put(SeriesFixturesTable.COL_SEASON, resFix.getSeason());
            values.put(SeriesFixturesTable.COL_MATCH_ID, match.getMatchID());
            values.put(SeriesFixturesTable.COL_MATCH_ROUND,
                    match.getMatchRound());
            values.put(SeriesFixturesTable.COL_HOME_TEAM_ID,
                    match.getHomeTeamID());
            values.put(SeriesFixturesTable.COL_HOME_TEAM_NAME,
                    match.getHomeTeamName());
            values.put(SeriesFixturesTable.COL_AWAY_TEAM_ID,
                    match.getAwayTeamID());
            values.put(SeriesFixturesTable.COL_AWAY_TEAM_NAME,
                    match.getAwayTeamName());
            values.put(SeriesFixturesTable.COL_HOME_GOALS, match.getHomeGoals());
            values.put(SeriesFixturesTable.COL_AWAY_GOALS, match.getAwayGoals());
            values.put(SeriesFixturesTable.COL_MATCH_DATE, match.getMatchDate());

            values.put(SeriesTable.COL_FETCHED_DATE, fetchedDate);
            values.put(SeriesTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_LEAGUE);

            // Create or update
            datasource
                    .createOrUpdate(
                            SeriesFixturesTable.class,
                            values,
                            SeriesFixturesTable.COL_MATCH_ID + "="
                                    + match.getMatchID());

        }

        // Send broadcast
        fireSuccess();
    }
}
