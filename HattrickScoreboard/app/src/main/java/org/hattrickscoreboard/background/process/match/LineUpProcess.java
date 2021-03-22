package org.hattrickscoreboard.background.process.match;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.constants.HMatchRoleID;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.match.PlayerLineup;
import org.hattrick.models.match.Substitution;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.match.LineupTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;
import org.hattrickscoreboard.database.tables.match.SubstitutionsTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class LineUpProcess extends HProcess {

    static final String TAG = (LineUpProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        // Result class (XML from CHPP)
        params.setResultClass(MatchLineUp.class);
        request.setParams(params);

        MatchLineUp res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Get match
        Match match = (Match) datasource.read(
                MatchesTable.class,
                MatchesTable.COL_MATCH_ID + "=" + res.getMatchID() + " AND "
                        + MatchesTable.COL_MATCH_DATE + "='"
                        + res.getMatchDate() + "'");

        // If doesn't exist
        if (match == null) {
            Log.e(TAG, "Match not found!");
            fireError(Background.RESULT_ERROR);
            return;
        }

        // Update match detail elements (EXPERIENCES)
        ContentValues val = new ContentValues();
        if (match.getHomeTeamID() == Integer.parseInt(res.getHomeTeamID())) {
            val.put(MatchesTable.COL_HOME_EXPERIENCE_LEVEL,
                    res.getExperienceLevel());
        } else {
            val.put(MatchesTable.COL_AWAY_EXPERIENCE_LEVEL,
                    res.getExperienceLevel());
        }

        // Create or update
        datasource.createOrUpdate(
                MatchesTable.class,
                val,
                MatchesTable.COL_MATCH_ID + "=" + match.getMatchID() + " AND "
                        + MatchesTable.COL_SOURCE_SYSTEM + "='"
                        + match.getSourceSystem() + "'");

        // For find who is and update after
        PlayerLineup captain = null;
        PlayerLineup setPieces = null;

        // UPDATE STARTING LINEUP
        if (res.getLineup() != null) {
            for (PlayerLineup lineup : res.getLineup()) {

                // Get captain
                if (HMatchRoleID.CAPTAIN == Integer
                        .parseInt(lineup.getRoleID())) {
                    captain = lineup;
                    continue;
                }

                // Get set pieces
                if (HMatchRoleID.SET_PIECES == Integer.parseInt(lineup
                        .getRoleID())) {
                    setPieces = lineup;
                    continue;
                }

                ContentValues values = new ContentValues();

                values.put(LineupTable.COL_MATCH_ID, res.getMatchID());
                values.put(LineupTable.COL_SOURCE_SYSTEM,
                        match.getSourceSystem());
                values.put(LineupTable.COL_PLAYER_ID, lineup.getPlayerID());
                values.put(LineupTable.COL_TEAM_ID, res.getTeamID());
                values.put(LineupTable.COL_PLAYER_FIRST_NAME,
                        lineup.getFirstName());
                values.put(LineupTable.COL_PLAYER_LAST_NAME,
                        lineup.getLastName());
                values.put(LineupTable.COL_PLAYER_NICKNAME,
                        lineup.getNickName());
                values.put(LineupTable.COL_ROLE_ID, lineup.getRoleID());
                values.put(LineupTable.COL_BEHAVIOUR, lineup.getBehaviour());
                values.put(LineupTable.COL_RATING_STARS,
                        lineup.getRatingStars());
                values.put(LineupTable.COL_RATING_STARS_END_OF_MATCH,
                        lineup.getRatingStarsEndOfMatch());
                values.put(LineupTable.COL_CAPTAIN, false);
                values.put(LineupTable.COL_SET_PIECES, false);

                // Don't know if starting game...
                values.put(LineupTable.COL_STARTING_ROLE_ID, -1);
                values.put(LineupTable.COL_STARTING_BEHAVIOUR, -1);

                // Create or update
                datasource.createOrUpdate(LineupTable.class, values,
                        LineupTable.COL_MATCH_ID + "=" + match.getMatchID()
                                + " AND " + LineupTable.COL_PLAYER_ID + "="
                                + lineup.getPlayerID());

            }

            // UPDATE LINEUP BEFORE GAME...
            // Update for starting players
            for (PlayerLineup lineup : res.getStartingLineup()) {
                ContentValues values = new ContentValues();

                // Get captain
                if (HMatchRoleID.CAPTAIN == Integer
                        .parseInt(lineup.getRoleID())) {
                    continue;
                }

                // Get set pieces
                if (HMatchRoleID.SET_PIECES == Integer.parseInt(lineup
                        .getRoleID())) {
                    continue;
                }

                values.put(LineupTable.COL_STARTING_ROLE_ID, lineup.getRoleID());
                values.put(LineupTable.COL_STARTING_BEHAVIOUR,
                        lineup.getBehaviour());

                datasource.createOrUpdate(LineupTable.class, values,
                        LineupTable.COL_MATCH_ID + "=" + match.getMatchID()
                                + " AND " + LineupTable.COL_PLAYER_ID + "="
                                + lineup.getPlayerID());

            }
        }

        // Set Captain & sub

        if (captain != null) {
            ContentValues valCap = new ContentValues();
            valCap.put(LineupTable.COL_CAPTAIN, true);

            datasource.createOrUpdate(LineupTable.class, valCap,
                    LineupTable.COL_MATCH_ID + "=" + match.getMatchID()
                            + " AND " + LineupTable.COL_PLAYER_ID + "="
                            + captain.getPlayerID());
        }

        if (setPieces != null) {
            ContentValues valSP = new ContentValues();
            valSP.put(LineupTable.COL_SET_PIECES, true);

            datasource.createOrUpdate(LineupTable.class, valSP,
                    LineupTable.COL_MATCH_ID + "=" + match.getMatchID()
                            + " AND " + LineupTable.COL_PLAYER_ID + "="
                            + setPieces.getPlayerID());
        }

        // UPDATE SUBSTITUTION
        if (res.getSubstitutions() != null) {
            for (Substitution sub : res.getSubstitutions()) {

                ContentValues values = new ContentValues();
                values.put(SubstitutionsTable.COL_MATCH_ID, res.getMatchID());
                values.put(SubstitutionsTable.COL_SOURCE_SYSTEM,
                        match.getSourceSystem());
                values.put(SubstitutionsTable.COL_SUBJECT_ID,
                        sub.getSubjectPlayerID());
                values.put(SubstitutionsTable.COL_OBJECT_ID,
                        sub.getObjectPlayerID());
                values.put(SubstitutionsTable.COL_TEAM_ID, sub.getTeamID());
                values.put(SubstitutionsTable.COL_ORDER_TYPE,
                        sub.getOrderType());
                values.put(SubstitutionsTable.COL_NEW_POSITION_ID,
                        sub.getNewPositionId());
                values.put(SubstitutionsTable.COL_NEW_POSITION_BEHAVIOUR,
                        sub.getNewPositionBehaviour());
                values.put(SubstitutionsTable.COL_MATCH_MINUTE,
                        sub.getMatchMinute());

                datasource.createOrUpdate(
                        SubstitutionsTable.class,
                        values,
                        SubstitutionsTable.COL_MATCH_ID + "="
                                + match.getMatchID() + " AND "
                                + SubstitutionsTable.COL_SUBJECT_ID + "="
                                + sub.getSubjectPlayerID() + " AND "
                                + SubstitutionsTable.COL_MATCH_MINUTE + "="
                                + sub.getMatchMinute());
            }

        }

        // Send broadcast
        fireSuccess();
    }
}
