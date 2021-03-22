package org.hattrickscoreboard.background.downloader;

import android.content.Context;
import android.util.Log;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.providers.params.HMatchQuery;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.SeriesTable;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.match.LineupTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class MatchDownloader extends Downloader {

    static final String TAG = (MatchDownloader.class).getSimpleName();

    public MatchDownloader(Context context, IRequest request, IParams param,
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

            // Download rest informations of match
            if (!(HMatchStatus.FINISHED.equals(match.getStatus()) && match
                    .getMatchFinishedDate() == null)) {
                return match;
            }
        }

        // Download object and return null
        MatchUpdate update = new MatchUpdate();
        update.addListener(listener);

        // Create params

        // Prepare query
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

    public ArrayList<LineUp> getLineUp(Match match, int teamID) {

        // Get object if is valid
        ArrayList<LineUp> lineUp = bdd.readAll(
                LineupTable.class,
                LineUp.class,
                LineupTable.COL_MATCH_ID + "=" + match.getMatchID() + " AND "
                        + LineupTable.COL_SOURCE_SYSTEM + "='"
                        + match.getSourceSystem() + "'" + " AND "
                        + LineupTable.COL_TEAM_ID + "=" + teamID);

        // If object is not null, return. (Object valid)
        if (lineUp != null) {
            return lineUp;
        }

        // Download object and return null
        LineUpUpdate update = new LineUpUpdate();
        update.addListener(listener);

        // Prepare query
        HMatchQuery query = new HMatchQuery();
        query.setMatchID(match.getMatchID());
        query.setSourceSystem(match.getSourceSystem());

        // Prepare home team update
        HQuery obj = new HQuery();
        obj.setCustomObject(query);
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return lineUp;
    }

    public DSeries getSeries(DTeam team) {

        // Get object if is valid
        DSeries series = (DSeries) bdd.read(SeriesTable.class,
                SeriesTable.COL_TEAM_ID + "=" + team.getTeamID());

        // If object is not null, return. (Object valid)
        if (isValid(series)) {
            return series;
        }

        // Download object and return null
        SeriesUpdate update = new SeriesUpdate();
        update.addListener(listener);

        // Create params
        HQuery obj = new HQuery();
        obj.setSubjectTeam(team);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return series;
    }

    public DLive getLive(Match match) {

        // Get object if is valid
        DLive live = (DLive) bdd.read(LiveTable.class, LiveTable.COL_MATCH_ID
                + "=" + match.getMatchID() + " AND "
                + LiveTable.COL_SOURCE_SYSTEM + "='" + match.getSourceSystem()
                + "'");

        return live;
    }

}