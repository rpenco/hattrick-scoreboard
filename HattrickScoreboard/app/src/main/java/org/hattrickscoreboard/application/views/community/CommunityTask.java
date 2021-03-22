package org.hattrickscoreboard.application.views.community;

import android.content.Context;

import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.models.DBookmark;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RCommunity;
import org.hattrickscoreboard.database.tables.BookmarksTable;
import org.hattrickscoreboard.database.tables.TeamTable;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class CommunityTask extends AsyncFragmentTask implements UpdateListener {

    static final String TAG = (CommunityTask.class).getSimpleName();
    DTeam team;

    public CommunityTask(Context context, FragmentTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected RCommunity doInBackground(Object... params) {

        // Get bookmarks
        ArrayList<DBookmark> bookmarks = bdd.readAll(BookmarksTable.class,
                DBookmark.class, null);

        if (bookmarks == null)
            return null;

        // Get teams related
        ArrayList<DTeam> teams = new ArrayList<DTeam>();
        for (DBookmark bookmark : bookmarks) {

            DTeam team = (DTeam) bdd.read(TeamTable.class, TeamTable.COL_TEAM_ID
                    + "=" + bookmark.getObjectID());

            if (team != null)
                teams.add(team);
        }

        // Set result
        RCommunity comRes = new RCommunity();
        comRes.setBookmarks(bookmarks);
        comRes.setTeams(teams);
        return comRes;

    }

}
