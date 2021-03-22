package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.util.Log;

import org.hattrick.models.teams.Team;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.extended.tasks.AsyncImageTaskListener;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.tasks.LogoTask;
import org.hattrickscoreboard.database.tables.TeamTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class TeamProcess extends HProcess implements AsyncImageTaskListener {

    static final String TAG = (TeamProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        boolean needUpdate = true;

        if (params.getObjectParam() != null) {
            HQuery obj = (HQuery) params.getObjectParam();
            int teamID = (obj == null) ? 1 : obj.getTeamID();

            needUpdate = datasource.needUpdate(TeamTable.class, forceUpdate,
                    TeamTable.COL_TEAM_ID + "=" + teamID);
        }

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(TeamDetails.class);
        request.setParams(params);

        TeamDetails res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Set to DBB
        if (res == null || res.getTeams() == null) {
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Case of multi-teams manager
        if (res.getTeams() != null) {
            for (Team t : res.getTeams()) {
                ContentValues values = new ContentValues();
                values.put(TeamTable.COL_USER_ID, res.getUser().getUserID());
                values.put(TeamTable.COL_TEAM_ID, t.getTeamID());
                values.put(TeamTable.COL_TEAM_NAME, t.getTeamName());
                values.put(TeamTable.COL_TEAM_SHORT_NAME, t.getShortTeamName());
                values.put(TeamTable.COL_PRIMARY_CLUB, t.isIsPrimaryClub());
                values.put(TeamTable.COL_FOUNDED_DATE, t.getFoundedDate());
                values.put(TeamTable.COL_ARENA_ID, t.getArenaID());
                values.put(TeamTable.COL_ARENA_NAME, t.getArenaName());
                values.put(TeamTable.COL_LEAGUE_ID, t.getLeagueID());
                values.put(TeamTable.COL_LEAGUE_NAME, t.getLeagueName());
                values.put(TeamTable.COL_REGION_ID, t.getRegionID());
                values.put(TeamTable.COL_REGION_NAME, t.getRegionName());
                values.put(TeamTable.COL_TRAINER_ID, t.getTrainerID());
                values.put(TeamTable.COL_HOME_PAGE, t.getHomePage());
                values.put(TeamTable.COL_DRESS_URI, t.getDressURI());
                values.put(TeamTable.COL_DRESS_ALT_URI,
                        t.getDressAlternateURI());
                values.put(TeamTable.COL_LEAGUE_LEVEL_ID,
                        t.getLeagueLevelUnitID());
                values.put(TeamTable.COL_LEAGUE_LEVEL_NAME,
                        t.getLeagueLevelUnitName());
                values.put(TeamTable.COL_BOT, t.isBot());
                values.put(TeamTable.COL_STILL_CUP, t.isStillInCup());
                values.put(TeamTable.COL_CUP_ID, t.getCupID());
                values.put(TeamTable.COL_CUP_NAME, t.getCupName());

                values.put(TeamTable.COL_CUP_LEAGUE_LEVEL,
                        t.getCupLeagueLevel());
                values.put(TeamTable.COL_CUP_LEVEL, t.getCupLevel());
                values.put(TeamTable.COL_CUP_LEVEL_INDEX, t.getCupLevelIndex());
                values.put(TeamTable.COL_CUP_MATCH_ROUND, t.getCupMatchRound());
                values.put(TeamTable.COL_CUP_MATCH_ROUNDS_LEFT,
                        t.getCupMatchRoundsLeft());

                values.put(TeamTable.COL_FRIENDLY_ID, t.getFriendlyTeamID());
                values.put(TeamTable.COL_VICTORIES, t.getNumberOfVictories());
                values.put(TeamTable.COL_UNDEFEATED, t.getNumberOfUndefeated());
                values.put(TeamTable.COL_RANK, t.getTeamRank());
                values.put(TeamTable.COL_FAN_ID, t.getFanclubID());
                values.put(TeamTable.COL_FAN_NAME, t.getFanclubName());
                values.put(TeamTable.COL_FAN_SIZE, t.getFanclubSize());
                values.put(TeamTable.COL_LOGO_URL, t.getLogoURL());
                values.put(TeamTable.COL_YOUTH_ID, t.getYouthTeamID());
                values.put(TeamTable.COL_YOUTH_NAME, t.getYouthTeamName());
                values.put(TeamTable.COL_VISITS, t.getNumberOfVisits());
                values.put(TeamTable.COL_FETCHED_DATE,
                        HattrickDate.getDateTime());
                values.put(TeamTable.COL_VALIDITY_TIME,
                        HattrickUpdater.VALIDITY_TEAM_DETAILS);

                // Create or update
                datasource.createOrUpdate(TeamTable.class, values,
                        TeamTable.COL_TEAM_ID + "=" + t.getTeamID());

                // Pre-download logo...
                LogoTask logoTask = new LogoTask(context, this);
                logoTask.execute(t.getLogoURL());
            }
        }

        // Send broadcast
        fireSuccess();
    }

    @Override
    public void onImageStart() {

    }

    @Override
    public void onImageResult(Bitmap image) {

    }

}
