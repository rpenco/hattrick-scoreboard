package org.hattrickscoreboard.background.process.players;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.players.Player;
import org.hattrick.models.players.Players;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.tables.PlayersTable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class PlayersProcess extends HProcess {

    static final String TAG = (PlayersProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource.needUpdate(PlayersTable.class,
                forceUpdate, PlayersTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Players.class);
        request.setParams(params);

        Players res;

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

        for (Player player : res.getPlayers()) {

            // Foreach staff member

            ContentValues values = new ContentValues();
            values.put(PlayersTable.COL_LASTMATCH_DATE, player.getDate());
            values.put(PlayersTable.COL_LASTMATCH_MATCHID, player.getMatchId());
            values.put(PlayersTable.COL_LASTMATCH_PLAYEDMINUTES,
                    player.getPlayedMinutes());
            values.put(PlayersTable.COL_LASTMATCH_POSITIONCODE,
                    player.getPositionCode());
            values.put(PlayersTable.COL_LASTMATCH_RATING, player.getRating());
            values.put(PlayersTable.COL_LASTMATCH_RATING_ENDOFGAME,
                    player.getRatingEndOfGame());

            values.put(PlayersTable.COL_PLAYER_AGE, player.getAge());
            values.put(PlayersTable.COL_PLAYER_AGE_DAYS, player.getAgeDays());
            values.put(PlayersTable.COL_PLAYER_AGGRESSIVENESS,
                    player.getAggressiveness());
            values.put(PlayersTable.COL_PLAYER_AGREEABILITY,
                    player.getAgreeability());
            values.put(PlayersTable.COL_PLAYER_CAPS, player.getCaps());
            values.put(PlayersTable.COL_PLAYER_CAPS_U20, player.getCapsU20());
            values.put(PlayersTable.COL_PLAYER_CARDS, player.getCards());
            values.put(PlayersTable.COL_PLAYER_CAREER_GOALS,
                    player.getCareerGoals());
            values.put(PlayersTable.COL_PLAYER_CAREER_HATTRICKS,
                    player.getCareerHattricks());
            values.put(PlayersTable.COL_PLAYER_CATEGORYID,
                    player.getPlayerCategoryId());
            values.put(PlayersTable.COL_PLAYER_COUNTRY_ID,
                    player.getCountryID());
            values.put(PlayersTable.COL_PLAYER_CUP_GOALS, player.getCupGoals());
            values.put(PlayersTable.COL_PLAYER_DEFENDER_SKILL,
                    player.getDefenderSkill());
            values.put(PlayersTable.COL_PLAYER_EXPERIENCE,
                    player.getExperience());
            values.put(PlayersTable.COL_PLAYER_FIRSTNAME, player.getFirstName());
            values.put(PlayersTable.COL_PLAYER_FORM, player.getPlayerForm());
            values.put(PlayersTable.COL_PLAYER_FRIENDLIES_GOALS,
                    player.getFriendliesGoals());
            values.put(PlayersTable.COL_PLAYER_HONESTY, player.getHonesty());
            values.put(PlayersTable.COL_PLAYER_ID, player.getPlayerID());
            values.put(PlayersTable.COL_PLAYER_INJURY_LEVEL,
                    player.getInjuryLevel());
            values.put(PlayersTable.COL_PLAYER_ISABROAD, player.getIsAbroad());
            values.put(PlayersTable.COL_PLAYER_KEEPER_SKILL,
                    player.getKeeperSkill());
            values.put(PlayersTable.COL_PLAYER_LASTNAME, player.getLastName());
            values.put(PlayersTable.COL_PLAYER_LEADERSHIP,
                    player.getLeadership());
            values.put(PlayersTable.COL_PLAYER_LEAGUE_GOALS,
                    player.getLeagueGoals());
            values.put(PlayersTable.COL_PLAYER_LOYALTY, player.getLoyalty());
            values.put(PlayersTable.COL_PLAYER_MOTHERCLUB_BONUS,
                    player.isMotherClubBonus());
            values.put(PlayersTable.COL_PLAYER_NATIONAL_TEAM_ID,
                    player.getNationalTeamID());
            values.put(PlayersTable.COL_PLAYER_NICKNAME, player.getNickName());
            values.put(PlayersTable.COL_PLAYER_NUMBER, player.getPlayerNumber());
            values.put(PlayersTable.COL_PLAYER_PASSING_SKILL,
                    player.getPassingSkill());
            values.put(PlayersTable.COL_PLAYER_PLAYMAKER_SKILL,
                    player.getPlaymakerSkill());
            values.put(PlayersTable.COL_PLAYER_SALARY, player.getSalary());
            values.put(PlayersTable.COL_PLAYER_SCORER_SKILL,
                    player.getScorerSkill());
            values.put(PlayersTable.COL_PLAYER_SETPIECES_SKILL,
                    player.getSetPiecesSkill());
            values.put(PlayersTable.COL_PLAYER_SPECIALTY, player.getSpecialty());
            values.put(PlayersTable.COL_PLAYER_STAMINA_SKILL,
                    player.getStaminaSkill());
            values.put(PlayersTable.COL_PLAYER_STATEMENT, player.getStatement());
            values.put(PlayersTable.COL_PLAYER_TRANSFER_LISTED,
                    player.isTransferListed());
            values.put(PlayersTable.COL_PLAYER_TSI, player.getTSI());
            values.put(PlayersTable.COL_PLAYER_WINGER_SKILL,
                    player.getWingerSkill());
            values.put(PlayersTable.COL_TEAM_ID, obj.getTeamID());
            values.put(PlayersTable.COL_FETCHED_DATE, fetchedDate);
            values.put(PlayersTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_PLAYER);

            // Create or update
            datasource.createOrUpdate(PlayersTable.class, values,
                    PlayersTable.COL_PLAYER_ID + "=" + player.getPlayerID());

        }

        // Get all player from team and remove all no-updated (sent or hired)
        ArrayList<DPlayer> players = datasource
                .readAll(PlayersTable.class, DPlayer.class,
                        PlayersTable.COL_TEAM_ID + "=" + obj.getTeamID());

        for (DPlayer play : players) {
            if (!play.getFetchedDate().equals(fetchedDate)) {

                Log.w(TAG, "Remove obsolet player: " + play.getLastName());
                datasource.delete(PlayersTable.class,
                        PlayersTable.COL_PLAYER_ID + "=" + play.getPlayerID());
            }
        }

        // /////////////////////////////////////////////////////////////////

        // Send broadcast
        fireSuccess();

        Log.w(TAG, "Download avatars...");

        PlayersAvatarProcess avatarProcess = new PlayersAvatarProcess();
        avatarProcess.set(context, request, params, null, forceUpdate);
        avatarProcess.perform(request, params);

    }

}
