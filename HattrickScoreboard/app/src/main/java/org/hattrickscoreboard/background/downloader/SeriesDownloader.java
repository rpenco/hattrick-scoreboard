package org.hattrickscoreboard.background.downloader;

import android.content.Context;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.providers.params.HMatchQuery;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.background.tasks.tables.WorldUpdate;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DSeriesFixtures;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.SeriesFixturesTable;
import org.hattrickscoreboard.database.tables.SeriesTable;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class SeriesDownloader extends Downloader {

    static final String TAG = (SeriesDownloader.class).getSimpleName();

    public SeriesDownloader(Context context, IRequest request, IParams param,
                            HattrickBDD bdd, UpdateListener listener) {
        super(context, request, param, bdd, listener);
    }

    public Match getMatch(int matchID, String sourceSystem) {

        // Get object if is valid
        Match match = (Match) bdd.read(MatchesTable.class,
                MatchesTable.COL_MATCH_ID + "=" + matchID + " AND "
                        + MatchesTable.COL_SOURCE_SYSTEM + "='" + sourceSystem
                        + "'");

        // If object is not null, return. (Object valid)
        if (isValid(match)) {
            Log.w(TAG, "Match valid, no update..");
            return match;
        }

        // Download object and return null
        MatchUpdate update = new MatchUpdate();
        update.addListener(listener);

        // Create params
        HMatchQuery query = new HMatchQuery();
        query.setEvent(true);
        query.setMatchID(matchID);
        query.setSourceSystem(sourceSystem);

        // Set params
        param.setObjectParam(query);

        update.update(TAG, context, request, param, bdd);

        return match;
    }

    public DTeam getTeam(int teamID) {

        // Get object if is valid
        DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_TEAM_ID
                + "=" + teamID);

        // If object is not null, return. (Object valid)
        if (isValid(team)) {
            Log.w(TAG, "Team '" + teamID + "' valid, no update..");
            return team;
        }

        // Download object and return null
        TeamUpdate update = new TeamUpdate();

        // Create params
        HQuery obj = new HQuery();
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return team;
    }

    public ArrayList<DSeriesFixtures> getSeriesFixtures(DSeries series,
                                                        DTeam team, int saison) {

        // Get object if is valid
        ArrayList<DSeriesFixtures> fixtures = bdd.readAll(
                SeriesFixturesTable.class,
                DSeriesFixtures.class,
                SeriesFixturesTable.COL_LEAGUE_LEVEL_UNIT_ID + "="
                        + series.getLeagueLevelUnitID() + " AND "
                        + SeriesFixturesTable.COL_SEASON + "=" + saison
                        + " ORDER BY " + SeriesFixturesTable.COL_MATCH_ROUND
                        + " ASC");

        // If object is not null, return. (Object valid)
        if (fixtures != null) {

            if (fixtures.size() > 0) {
                if (!HattrickDate.needUpdate(fixtures.get(fixtures.size() - 1)
                        .getFetchedDate(), fixtures.get(fixtures.size() - 1)
                        .getValidityTime())) {
                    return fixtures;
                }
            }
        }

        // Download object and return null
        SeriesUpdate update = new SeriesUpdate();
        update.addListener(listener);

        // Prepare home team update
        HQuery obj = new HQuery(team, team);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return fixtures;

    }

    public ArrayList<Match> getMatches(int teamID, boolean youth) {

        // Get object if is valid
        ArrayList<Match> matches = bdd.readAll(MatchesTable.class, Match.class,
                MatchesTable.COL_HOME_TEAM_ID + "=" + teamID + " or "
                        + MatchesTable.COL_AWAY_TEAM_ID + "=" + teamID
                        + " ORDER BY " + MatchesTable.COL_MATCH_DATE + " ASC ");

        // If object is not null, return. (Object valid)
        if (matches != null) {

            if (matches.size() > 0) {
                if (!HattrickDate.needUpdate(matches.get(matches.size() - 1)
                        .getFetchedDate(), matches.get(matches.size() - 1)
                        .getValidityTime())) {
                    return matches;
                }
            }
        }

        // Download object and return null
        MatchesUpdate update = new MatchesUpdate();
        update.addListener(listener);

        // Prepare home team update
        HQuery obj = new HQuery();
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return matches;
    }

    public DSeries getSeries(DTeam team) {

        // Get object if is valid
        DSeries series = (DSeries) bdd.read(SeriesTable.class,
                SeriesTable.COL_TEAM_ID + "=" + team.getTeamID());

        // If object is not null, return. (Object valid)
        if (isValid(series)) {
            Log.i(TAG, "Series are valid.");
            return series;
        }

        // Download object and return null
        SeriesUpdate update = new SeriesUpdate();
        update.addListener(listener);

        // Create params
        HQuery obj = new HQuery();
        obj.setTeamID(team.getTeamID());
        obj.setSubjectTeam(team);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return series;
    }

    public ArrayList<DLive> getLiveMatches() {

        // Get object if is valid
        ArrayList<DLive> lives = bdd.readAll(LiveTable.class, DLive.class,
                LiveTable.COL_STATUS + "!='" + HMatchStatus.FINISHED
                        + "'");

        return lives;
    }

    public ArrayList<DSeries> getSeriesList(DTeam team, DWorld world) {

        ArrayList<DSeries> league = bdd.readAll(
                SeriesTable.class,
                DSeries.class,
                SeriesTable.COL_LEAGUE_LEVEL_UNIT_ID + "="
                        + team.getLeagueLevelUnitID() + " AND "
                        + SeriesTable.COL_CURRENT_ROUND + "="
                        + world.getMatchRound() + " ORDER BY "
                        + SeriesTable.COL_TEAM_POSITION + " ASC");

        // If object is not null, return. (Object valid)
        if (league != null) {

            if (league.size() > 0) {
                if (!HattrickDate.needUpdate(league.get(league.size() - 1)
                        .getFetchedDate(), league.get(league.size() - 1)
                        .getValidityTime())) {
                    return league;
                }
            }
        }

        // Download object and return null
        SeriesUpdate update = new SeriesUpdate();
        update.addListener(listener);

        // Prepare home team update
        HQuery obj = new HQuery(team, team);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return league;
    }

    public void updateWorld(DWorld world) {
        // Download object and return null
        WorldUpdate update = new WorldUpdate();
        update.addListener(listener);

        // Prepare home team update
        HQuery obj = new HQuery();
        param.setObjectParam(obj);
        update.update(TAG, context, request, param, bdd, true);
    }

}