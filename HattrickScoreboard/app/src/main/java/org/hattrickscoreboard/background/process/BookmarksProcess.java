package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.bookmarks.Bookmark;
import org.hattrick.models.bookmarks.Bookmarks;
import org.hattrick.providers.params.HQuery;
import org.hattrick.providers.params.HattrickParams;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.tables.BookmarksTable;
import org.hattrickscoreboard.database.tables.SeriesTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class BookmarksProcess extends HProcess {

    static final String TAG = (BookmarksProcess.class).getSimpleName();

    @Override
    public void perform() {

        super.perform();

        boolean needUpdate = datasource.needUpdate(BookmarksTable.class,
                forceUpdate, BookmarksTable.COL_ID + "= 1");

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Bookmarks.class);
        request.setParams(params);

        Bookmarks res;

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

        // Insert or update into DB
        for (Bookmark book : res.getBookmarkList()) {

            // Foreach staff member

            ContentValues values = new ContentValues();
            values.put(BookmarksTable.COL_BOOKMARK_ID, book.getBookmarkID());
            values.put(BookmarksTable.COL_BOOKMARK_TYPE_ID,
                    book.getBookmarkTypeID());
            values.put(BookmarksTable.COL_TEXT, book.getText());
            values.put(BookmarksTable.COL_TEXT2, book.getText2());
            values.put(BookmarksTable.COL_OBJECT_ID, book.getObjectID());
            values.put(BookmarksTable.COL_OBJECT_ID_2, book.getObjectID2());
            values.put(BookmarksTable.COL_OBJECT_ID_3, book.getObjectID3());
            values.put(BookmarksTable.COL_COMMENT, book.getBookmarkID());

            values.put(SeriesTable.COL_FETCHED_DATE, fetchedDate);
            values.put(SeriesTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_BOOKMARK);

            // Create or update
            datasource
                    .createOrUpdate(
                            BookmarksTable.class,
                            values,
                            BookmarksTable.COL_BOOKMARK_ID + "="
                                    + book.getBookmarkID());

            // UPDATE LEAGUE FIXTURES
            Log.v(TAG, "...Update team");

            IParams param = new HattrickParams();
            HQuery objTeam = new HQuery();
            objTeam.setTeamID(book.getObjectID());
            param.setObjectParam(objTeam);

            TeamUpdate tUpdate = new TeamUpdate();
            tUpdate.update(TAG, context, request, param, datasource);
            // TODO Add listener for this download
        }

        // Send broadcast
        fireSuccess();
    }
}
