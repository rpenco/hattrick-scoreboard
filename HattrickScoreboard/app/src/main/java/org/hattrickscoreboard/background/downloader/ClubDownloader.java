package org.hattrickscoreboard.background.downloader;

import android.content.Context;

import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.ArenaUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.background.tasks.tables.WorldUpdate;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.tables.ArenaTable;
import org.hattrickscoreboard.database.tables.SeriesTable;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.WorldTable;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class ClubDownloader extends Downloader {

    static final String TAG = (ClubDownloader.class).getSimpleName();

    public ClubDownloader(Context context, IRequest request, IParams param,
                          HattrickBDD bdd, UpdateListener listener) {
        super(context, request, param, bdd, listener);
    }

    public DTeam getTeam(int teamID) {

        // Get object if is valid
        DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_TEAM_ID
                + "=" + teamID);

        // If object is not null, return. (Object valid)
        if (isValid(team)) {
            return team;
        }

        // Download object and return null
        TeamUpdate update = new TeamUpdate();
        update.addListener(listener);

        // Create params
        HQuery obj = new HQuery();
        obj.setTeamID(teamID);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return team;
    }

    public DArena getArena(DTeam team) {

        // Get object if is valid
        DArena arena = (DArena) bdd.read(ArenaTable.class,
                ArenaTable.COL_ARENA_ID + "=" + team.getArenaID());

        // If object is not null, return. (Object valid)
        if (isValid(arena)) {
            return arena;
        }

        // Download object and return null
        ArenaUpdate update = new ArenaUpdate();
        update.addListener(listener);

        // Create params
        HQuery obj = new HQuery();
        obj.setSubjectTeam(team);
        obj.setTeamID(team.getTeamID());
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd);

        return arena;
    }

    public DWorld getWorld(DTeam team) {

        // Get object if is valid
        DWorld world = (DWorld) bdd.read(WorldTable.class,
                WorldTable.COL_LEAGUE_ID + "=" + team.getLeagueID());

        // If object is not null, return. (Object valid)
        if (isValid(world)) {
            return world;
        }

        // Download object and return null
        WorldUpdate update = new WorldUpdate();
        update.addListener(listener);

        // Create params
        HQuery obj = new HQuery();
        obj.setSubjectTeam(team);
        param.setObjectParam(obj);

        update.update(TAG, context, request, param, bdd, true);

        return world;
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

}