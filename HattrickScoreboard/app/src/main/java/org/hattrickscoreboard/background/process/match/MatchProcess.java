package org.hattrickscoreboard.background.process.match;

import android.content.ContentValues;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.models.match.Booking;
import org.hattrick.models.match.Event;
import org.hattrick.models.match.Goal;
import org.hattrick.models.match.Injury;
import org.hattrick.models.match.MatchDetails;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.tables.match.BookingsTable;
import org.hattrickscoreboard.database.tables.match.EventsTable;
import org.hattrickscoreboard.database.tables.match.InjuriesTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;
import org.hattrickscoreboard.database.tables.match.RefereesTable;
import org.hattrickscoreboard.database.tables.match.ScorersTable;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class MatchProcess extends HProcess {

    static final String TAG = (MatchProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        // Result class (XML from CHPP)
        params.setResultClass(MatchDetails.class);
        request.setParams(params);

        MatchDetails res;

        // Get file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        ContentValues values = new ContentValues();

        values.put(MatchesTable.COL_MATCH_ID, res.getMatchID());
        values.put(MatchesTable.COL_SOURCE_SYSTEM, res.getSourceSystem());
        // values.put(MatchesTable.COL_, res.getMatchYouth());
        values.put(MatchesTable.COL_MATCH_DATE, res.getMatchDate());
        values.put(MatchesTable.COL_MATCH_TYPE, res.getMatchType());
        // values.put(MatchesTable.COL_, res.getMatchContext());

        values.put(MatchesTable.COL_HOME_TEAM_ID, res.getHomeTeam().getTeamID());
        values.put(MatchesTable.COL_HOME_TEAM_NAME, res.getHomeTeam()
                .getTeamName());
        // values.put(MatchesTable.COL_HOME_TEAM,
        // res.getHomeTeam().getShortName());
        values.put(MatchesTable.COL_HOME_TEAM_FORMATION, res.getHomeTeam()
                .getFormation());
        values.put(MatchesTable.COL_HOME_TACTIC_TYPE, res.getHomeTeam()
                .getTacticType());
        values.put(MatchesTable.COL_HOME_TACTIC_SKILL, res.getHomeTeam()
                .getTacticSkill());
        // values.put(MatchesTable.COL_HOME_TEAM,
        // res.getHomeTeam().getExperienceLevel());
        values.put(MatchesTable.COL_HOME_DRESS_URI, res.getHomeTeam()
                .getDressURI());
        values.put(MatchesTable.COL_HOME_TEAM_ATTITUDE, res.getHomeTeam()
                .getTeamAttitude());
        values.put(MatchesTable.COL_HOME_RATING_MID_FIELD, res.getHomeTeam()
                .getRatingMidfield());
        values.put(MatchesTable.COL_HOME_RATING_RIGHT_DEF, res.getHomeTeam()
                .getRatingRightDef());
        values.put(MatchesTable.COL_HOME_RATING_MID_DEF, res.getHomeTeam()
                .getRatingMidDef());
        values.put(MatchesTable.COL_HOME_RATING_LEFT_DEF, res.getHomeTeam()
                .getRatingLeftDef());
        values.put(MatchesTable.COL_HOME_RATING_RIGHT_ATT, res.getHomeTeam()
                .getRatingRightAtt());
        values.put(MatchesTable.COL_HOME_RATING_MID_ATT, res.getHomeTeam()
                .getRatingMidAtt());
        values.put(MatchesTable.COL_HOME_RATING_LEFT_ATT, res.getHomeTeam()
                .getRatingLeftAtt());
        values.put(MatchesTable.COL_HOME_RATING_INDIRECT_SET_PIECES_DEF, res
                .getHomeTeam().getRatingIndirectSetPiecesDef());
        values.put(MatchesTable.COL_HOME_RATING_INDIRECT_SET_PIECES_ATT, res
                .getHomeTeam().getRatingIndirectSetPiecesAtt());

        values.put(MatchesTable.COL_AWAY_TEAM_ID, res.getAwayTeam().getTeamID());
        values.put(MatchesTable.COL_AWAY_TEAM_NAME, res.getAwayTeam()
                .getTeamName());

        values.put(MatchesTable.COL_AWAY_TEAM_FORMATION, res.getAwayTeam()
                .getFormation());
        values.put(MatchesTable.COL_AWAY_TACTIC_TYPE, res.getAwayTeam()
                .getTacticType());
        values.put(MatchesTable.COL_AWAY_TACTIC_SKILL, res.getAwayTeam()
                .getTacticSkill());

        values.put(MatchesTable.COL_AWAY_DRESS_URI, res.getAwayTeam()
                .getDressURI());
        values.put(MatchesTable.COL_AWAY_TEAM_ATTITUDE, res.getAwayTeam()
                .getTeamAttitude());
        values.put(MatchesTable.COL_AWAY_RATING_MID_FIELD, res.getAwayTeam()
                .getRatingMidfield());
        values.put(MatchesTable.COL_AWAY_RATING_RIGHT_DEF, res.getAwayTeam()
                .getRatingRightDef());
        values.put(MatchesTable.COL_AWAY_RATING_MID_DEF, res.getAwayTeam()
                .getRatingMidDef());
        values.put(MatchesTable.COL_AWAY_RATING_LEFT_DEF, res.getAwayTeam()
                .getRatingLeftDef());
        values.put(MatchesTable.COL_AWAY_RATING_RIGHT_ATT, res.getAwayTeam()
                .getRatingRightAtt());
        values.put(MatchesTable.COL_AWAY_RATING_MID_ATT, res.getAwayTeam()
                .getRatingMidAtt());
        values.put(MatchesTable.COL_AWAY_RATING_LEFT_ATT, res.getAwayTeam()
                .getRatingLeftAtt());
        values.put(MatchesTable.COL_AWAY_RATING_INDIRECT_SET_PIECES_DEF, res
                .getAwayTeam().getRatingIndirectSetPiecesDef());
        values.put(MatchesTable.COL_AWAY_RATING_INDIRECT_SET_PIECES_ATT, res
                .getAwayTeam().getRatingIndirectSetPiecesAtt());

        values.put(MatchesTable.COL_ARENA_ID, res.getArenaID());
        values.put(MatchesTable.COL_ARENA_NAME, res.getArenaName());
        values.put(MatchesTable.COL_WEATHER_ID, res.getWeatherID());
        values.put(MatchesTable.COL_SOLD_TOTAL, res.getSoldTotal());
        values.put(MatchesTable.COL_SOLD_TERRACES, res.getSoldTerraces());
        values.put(MatchesTable.COL_SOLD_BASIC, res.getSoldBasic());
        values.put(MatchesTable.COL_SOLD_ROOF, res.getSoldRoof());
        values.put(MatchesTable.COL_SOLD_VIP, res.getSoldVIP());

        values.put(MatchesTable.COL_POSSESSION_FIRST_HALF_HOME,
                res.getPossessionFirstHalfHome());
        values.put(MatchesTable.COL_POSSESSION_FIRST_HALF_AWAY,
                res.getPossessionFirstHalfAway());
        values.put(MatchesTable.COL_POSSESSION_SECOND_HALF_HOME,
                res.getPossessionSecondHalfHome());
        values.put(MatchesTable.COL_POSSESSION_SECOND_HALF_AWAY,
                res.getPossessionSecondHalfAway());
        values.put(MatchesTable.COL_HOME_GOALS, res.getHomeTeam().getGoals());
        values.put(MatchesTable.COL_AWAY_GOALS, res.getAwayTeam().getGoals());
        values.put(MatchesTable.COL_MATCH_FINISHED_DATE, res.getFinishedDate());

        if (res.getFinishedDate() != null) {
            values.put(MatchesTable.COL_STATUS, HMatchStatus.FINISHED);
        } else {
            try {
                Date mDate = HattrickDate.StringToDate(res.getMatchDate());
                Date mCurrentDate = HattrickDate.StringToDate(HattrickDate
                        .getDateTime());
                if (mCurrentDate.before(mDate)) {
                    values.put(MatchesTable.COL_STATUS, HMatchStatus.UPCOMING);
                } else {
                    values.put(MatchesTable.COL_STATUS, HMatchStatus.ONGOING);
                }
            } catch (ParseException e) {
                values.put(MatchesTable.COL_STATUS, HMatchStatus.UPCOMING);
            }

        }

        values.put(MatchesTable.COL_FETCHED_DATE, HattrickDate.getDateTime());
        values.put(MatchesTable.COL_VALIDITY_TIME,
                HattrickUpdater.VALIDITY_MATCH);

        if (res.getReferee() != null) {
            values.put(MatchesTable.COL_REFEREE, res.getReferee().getId());
            values.put(MatchesTable.COL_REFEREE_ASSISTANT_1, res
                    .getRefereeAssistant1().getId());
            values.put(MatchesTable.COL_REFEREE_ASSISTANT_2, res
                    .getRefereeAssistant2().getId());
        }

        // Create or update
        datasource.createOrUpdate(
                MatchesTable.class,
                values,
                MatchesTable.COL_MATCH_ID + "=" + res.getMatchID() + " AND "
                        + MatchesTable.COL_SOURCE_SYSTEM + "='"
                        + res.getSourceSystem() + "'");

        // Create or update referee IF EXIST
        if (res.getReferee() != null) {
            ContentValues referee = new ContentValues();
            referee.put(RefereesTable.COL_REFEREE_ID, res.getReferee().getId());
            referee.put(RefereesTable.COL_NAME, res.getReferee().getName());
            referee.put(RefereesTable.COL_COUNTRY_ID, res.getReferee()
                    .getCountryID());
            referee.put(RefereesTable.COL_COUNTRY_NAME, res.getReferee()
                    .getCountryName());
            referee.put(RefereesTable.COL_TEAM_ID, res.getReferee().getTeamID());
            referee.put(RefereesTable.COL_TEAM_NAME, res.getReferee()
                    .getTeamName());

            // Create or update
            datasource.createOrUpdate(RefereesTable.class, referee,
                    RefereesTable.COL_REFEREE_ID + "="
                            + res.getReferee().getId());

            // Create or update referee assist 1
            ContentValues referee1 = new ContentValues();
            referee1.put(RefereesTable.COL_REFEREE_ID, res
                    .getRefereeAssistant1().getId());
            referee1.put(RefereesTable.COL_NAME, res.getRefereeAssistant1()
                    .getName());
            referee1.put(RefereesTable.COL_COUNTRY_ID, res
                    .getRefereeAssistant1().getCountryID());
            referee1.put(RefereesTable.COL_COUNTRY_NAME, res
                    .getRefereeAssistant1().getCountryName());
            referee1.put(RefereesTable.COL_TEAM_ID, res.getRefereeAssistant1()
                    .getTeamID());
            referee1.put(RefereesTable.COL_TEAM_NAME, res
                    .getRefereeAssistant1().getTeamName());

            // Create or update
            datasource.createOrUpdate(RefereesTable.class, referee1,
                    RefereesTable.COL_REFEREE_ID + "="
                            + res.getRefereeAssistant1().getId());

            // Create or update referee assist 2
            ContentValues referee2 = new ContentValues();
            referee2.put(RefereesTable.COL_REFEREE_ID, res
                    .getRefereeAssistant2().getId());
            referee2.put(RefereesTable.COL_NAME, res.getRefereeAssistant2()
                    .getName());
            referee2.put(RefereesTable.COL_COUNTRY_ID, res
                    .getRefereeAssistant2().getCountryID());
            referee2.put(RefereesTable.COL_COUNTRY_NAME, res
                    .getRefereeAssistant2().getCountryName());
            referee2.put(RefereesTable.COL_TEAM_ID, res.getRefereeAssistant2()
                    .getTeamID());
            referee2.put(RefereesTable.COL_TEAM_NAME, res
                    .getRefereeAssistant2().getTeamName());

            // Create or update
            datasource.createOrUpdate(RefereesTable.class, referee2,
                    RefereesTable.COL_REFEREE_ID + "="
                            + res.getRefereeAssistant2().getId());

        }
        if (res.getScorers() != null) {
            // Scorers
            for (Goal scorer : res.getScorers()) {

                ContentValues val = new ContentValues();
                val.put(ScorersTable.COL_MATCH_ID, res.getMatchID());
                val.put(ScorersTable.COL_SOURCE_SYSTEM, res.getSourceSystem());
                val.put(ScorersTable.COL_PLAYER_ID, scorer.getPlayerID());
                val.put(ScorersTable.COL_PLAYER_NAME, scorer.getPlayerName());
                val.put(ScorersTable.COL_TEAM_ID, scorer.getTeamID());
                val.put(ScorersTable.COL_HOME_GOALS, scorer.getHomeGoals());
                val.put(ScorersTable.COL_AWAY_GOALS, scorer.getAwayGoals());
                val.put(ScorersTable.COL_MINUTE, scorer.getMinute());

                // Create or update
                datasource.createOrUpdate(
                        ScorersTable.class,
                        val,
                        ScorersTable.COL_MATCH_ID + "=" + res.getMatchID()
                                + " AND " + ScorersTable.COL_SOURCE_SYSTEM
                                + "='" + res.getSourceSystem() + "' AND "
                                + ScorersTable.COL_PLAYER_ID + "="
                                + scorer.getPlayerID());

            }
        }

        if (res.getBookings() != null) {
            // Bookings
            for (Booking book : res.getBookings()) {

                ContentValues val = new ContentValues();
                val.put(BookingsTable.COL_MATCH_ID, res.getMatchID());
                val.put(BookingsTable.COL_SOURCE_SYSTEM, res.getSourceSystem());
                val.put(BookingsTable.COL_PLAYER_ID, book.getPlayerID());
                val.put(BookingsTable.COL_PLAYER_NAME, book.getPlayerName());
                val.put(BookingsTable.COL_TEAM_ID, book.getTeamID());
                val.put(BookingsTable.COL_TYPE, book.getType());
                val.put(BookingsTable.COL_MINUTE, book.getMinute());

                // Create or update
                datasource.createOrUpdate(
                        BookingsTable.class,
                        val,
                        BookingsTable.COL_MATCH_ID + "=" + res.getMatchID()
                                + " AND " + BookingsTable.COL_SOURCE_SYSTEM
                                + "='" + res.getSourceSystem() + "' AND "
                                + BookingsTable.COL_PLAYER_ID + "="
                                + book.getPlayerID());

            }
        }

        if (res.getInjuries() != null) {
            // Injuries
            for (Injury inj : res.getInjuries()) {

                ContentValues val = new ContentValues();
                val.put(InjuriesTable.COL_MATCH_ID, res.getMatchID());
                val.put(InjuriesTable.COL_SOURCE_SYSTEM, res.getSourceSystem());
                val.put(InjuriesTable.COL_PLAYER_ID, inj.getPlayerID());
                val.put(InjuriesTable.COL_PLAYER_NAME, inj.getPlayerName());
                val.put(InjuriesTable.COL_TEAM_ID, inj.getTeamID());
                val.put(InjuriesTable.COL_TYPE, inj.getType());
                val.put(InjuriesTable.COL_MINUTE, inj.getMinute());

                // Create or update
                datasource.createOrUpdate(
                        InjuriesTable.class,
                        val,
                        InjuriesTable.COL_MATCH_ID + "=" + res.getMatchID()
                                + " AND " + InjuriesTable.COL_SOURCE_SYSTEM
                                + "='" + res.getSourceSystem() + "' AND "
                                + InjuriesTable.COL_PLAYER_ID + "="
                                + inj.getPlayerID());

            }
        }

        // Events
        if (res.getEventList() != null) {
            for (Event event : res.getEventList()) {

                ContentValues val = new ContentValues();
                val.put(EventsTable.COL_MATCH_ID, res.getMatchID());
                val.put(EventsTable.COL_SOURCE_SYSTEM, res.getSourceSystem());
                val.put(EventsTable.COL_MINUTE, event.getMinute());
                val.put(EventsTable.COL_SUBJECT_PLAYER_ID,
                        event.getSubjectPlayerID());
                val.put(EventsTable.COL_SUBJECT_TEAM_ID,
                        event.getSubjectTeamID());
                val.put(EventsTable.COL_OBJECT_PLAYER_ID,
                        event.getObjectPlayerID());
                val.put(EventsTable.COL_EVENT_TYPE_ID, event.getEventTypeID());
                val.put(EventsTable.COL_EVENT_VARIATION,
                        event.getEventVariation());
                val.put(EventsTable.COL_EVENT_TEXT, event.getEventText());
                val.put(EventsTable.COL_INDEX, event.getIndex());

                // Create or update
                datasource.createOrUpdate(
                        EventsTable.class,
                        val,
                        EventsTable.COL_MATCH_ID + "=" + res.getMatchID()
                                + " AND " + EventsTable.COL_SOURCE_SYSTEM
                                + "='" + res.getSourceSystem() + "' AND "
                                + EventsTable.COL_INDEX + "="
                                + event.getIndex());

            }
        }

        // Send broadcast
        fireSuccess();
    }
}
