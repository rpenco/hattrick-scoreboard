package org.hattrickscoreboard.application.views.series;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.downloader.SeriesDownloader;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DSeriesFixtures;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.relations.RSeries;
import org.hattrickscoreboard.database.tables.WorldTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class SeriesTask extends AsyncFragmentTask implements UpdateListener {

    static final String TAG = (SeriesTask.class).getSimpleName();
    DTeam team;

    public SeriesTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RSeries doInBackground(Object... params) {

        int teamID = (int) params[0];

        if (teamID == 0)
            return null;

        // For download or update if need
        SeriesDownloader downloader = new SeriesDownloader(context, request,
                param, bdd, this);

        // If team details
        DTeam team = downloader.getTeam(teamID);

        if (team != null) {

            DSeries series = downloader.getSeries(team);

            if (series != null) {

                DWorld world = (DWorld) bdd.read(WorldTable.class,
                        WorldTable.COL_LEAGUE_ID + "=" + team.getLeagueID());

                if (world == null) {
                    return null;
                }

                ArrayList<DSeriesFixtures> fixtures = downloader
                        .getSeriesFixtures(series, team, world.getSeason());

                ArrayList<DSeries> seriesList = downloader.getSeriesList(team,
                        world);

                if (seriesList == null) {
                    downloader.updateWorld(world);
                }
                ArrayList<DLive> lives = downloader.getLiveMatches();

                if (series != null && fixtures != null) {
                    RSeries rSeries = new RSeries();
                    rSeries.setTeam(team);
                    rSeries.setWorld(world);

                    rSeries.setLeaguelist(seriesList);
                    rSeries.setMatches(fixtures);

                    rSeries.setLives(lives);
                    return rSeries;
                }
            }
        }

        return null;

    }
}
