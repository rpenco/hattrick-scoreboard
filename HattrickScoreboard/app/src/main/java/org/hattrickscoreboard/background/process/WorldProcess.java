package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.world.Country;
import org.hattrick.models.world.Cup;
import org.hattrick.models.world.League;
import org.hattrick.models.world.WorldDetails;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.NationalCupTable;
import org.hattrickscoreboard.database.tables.WorldTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 4 aot 2014
 */
public class WorldProcess extends HProcess {

    static final String TAG = (WorldProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        boolean needUpdate = datasource.needUpdate(WorldTable.class,
                forceUpdate, WorldTable.COL_ID + "= 1");

        if (!needUpdate && !forceUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(WorldDetails.class);
        request.setParams(params);

        WorldDetails res;

        // Get CHPP file
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
        for (League league : res.getLeagueList()) {

            ContentValues values = new ContentValues();
            values.put(WorldTable.COL_LEAGUE_ID, league.getLeagueID());
            values.put(WorldTable.COL_LEAGUE_NAME, league.getLeagueName());
            values.put(WorldTable.COL_SEASON, league.getSeason());
            values.put(WorldTable.COL_SEASON_OFFSET, league.getSeasonOffset());
            values.put(WorldTable.COL_MATCH_ROUND, league.getMatchRound());
            values.put(WorldTable.COL_SHORT_NAME, league.getShortName());
            values.put(WorldTable.COL_CONTINENT, league.getContinent());
            values.put(WorldTable.COL_ZONENAME, league.getZoneName());
            values.put(WorldTable.COL_ENGLISH_NAME, league.getEnglishName());
            values.put(WorldTable.COL_NATIONAL_TEAM_ID,
                    league.getNationalTeamId());
            values.put(WorldTable.COL_U20_TEAM_ID, league.getU20TeamId());
            values.put(WorldTable.COL_ACTIVE_TEAMS, league.getActiveTeams());
            values.put(WorldTable.COL_ACTIVE_USERS, league.getActiveUsers());
            values.put(WorldTable.COL_WAITING_USERS, league.getWaitingUsers());
            values.put(WorldTable.COL_TRAINING_DATE, league.getTrainingDate());
            values.put(WorldTable.COL_ECONOMY_DATE, league.getEconomyDate());
            values.put(WorldTable.COL_CUP_MATCH_DATE, league.getCupMatchDate());
            values.put(WorldTable.COL_SERIES_MATCH_DATE,
                    league.getSeriesMatchDate());
            values.put(WorldTable.COL_NUMBER_OF_LEVELS,
                    league.getNumberOfLevels());
            values.put(WorldTable.COL_FETCHED_DATE, fetchedDate);
            values.put(WorldTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_WORLD);

            Country country = league.getCountry();
            values.put(WorldTable.COL_COUNTRY_ID, country.getCountryID());
            values.put(WorldTable.COL_COUNTRY_NAME, country.getCountryName());
            values.put(WorldTable.COL_CURRENCY_NAME, country.getCurrencyName());
            values.put(WorldTable.COL_CURRENCY_RATE, country.getCurrencyRate());

            // Because hattrick date format is not compatible with Java
            // SimpleDateFormat
            String dateFormat = country.getDateFormat();
            dateFormat = dateFormat.replaceAll("D", "d");
            dateFormat = dateFormat.replaceAll("Y", "y");
            values.put(WorldTable.COL_DATE_FORMAT, dateFormat);

            String timeFormat = country.getTimeFormat();
            timeFormat = timeFormat.replaceAll("h", "H");
            values.put(WorldTable.COL_TIME_FORMAT, timeFormat);

            // Create or update
            datasource.createOrUpdate(WorldTable.class, values,
                    WorldTable.COL_LEAGUE_ID + "=" + league.getLeagueID());

            // For each cup
            for (Cup cup : league.getCupList()) {

                ContentValues valuesCup = new ContentValues();

                valuesCup.put(NationalCupTable.COL_LEAGUE_ID,
                        league.getLeagueID());
                valuesCup.put(NationalCupTable.COL_COUNTRY_ID,
                        league.getLeagueID());
                valuesCup.put(NationalCupTable.COL_CUP_ID, cup.getCupID());
                valuesCup.put(NationalCupTable.COL_CUP_NAME, cup.getCupName());
                valuesCup.put(NationalCupTable.COL_CUP_LEAGUELEVEL,
                        cup.getCupLeagueLevel());
                valuesCup
                        .put(NationalCupTable.COL_CUP_LEVEL, cup.getCupLevel());
                valuesCup.put(NationalCupTable.COL_CUP_LEVEL_INDEX,
                        cup.getCupLevelIndex());
                valuesCup.put(NationalCupTable.COL_MATCH_ROUND,
                        cup.getMatchRound());
                valuesCup.put(NationalCupTable.COL_MATCH_ROUNDS_LEFT,
                        cup.getMatchRoundsLeft());
                valuesCup.put(NationalCupTable.COL_FETCHED_DATE, fetchedDate);
                valuesCup.put(NationalCupTable.COL_VALIDITY_TIME,
                        HattrickUpdater.VALIDITY_WORLD);

                // Create or update
                datasource.createOrUpdate(NationalCupTable.class, valuesCup,
                        NationalCupTable.COL_CUP_ID + "=" + cup.getCupID());

            }
        }

        // Send broadcast
        fireSuccess();
    }
}
