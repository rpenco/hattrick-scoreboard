package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DBookmark;

public class BookmarksTable extends Table {

    // Table
    public static final String TABLE = "bookmarks";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_BOOKMARK_ID = "BookmarkID";
    public static final String COL_BOOKMARK_TYPE_ID = "BookmarkTypeID";
    public static final String COL_TEXT = "Text";
    public static final String COL_TEXT2 = "Text2";
    public static final String COL_OBJECT_ID = "ObjectID";
    public static final String COL_OBJECT_ID_2 = "ObjectID2";
    public static final String COL_OBJECT_ID_3 = "ObjectID3";
    public static final String COL_COMMENT = "Comment";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_BOOKMARK_ID,
            COL_BOOKMARK_TYPE_ID, COL_TEXT, COL_TEXT2, COL_OBJECT_ID,
            COL_OBJECT_ID_2, COL_OBJECT_ID_3, COL_COMMENT, COL_FETCHED_DATE,
            COL_VALIDITY_TIME

    };
    static final String TAG = (BookmarksTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_BOOKMARK_ID
            + " integer not null, " + COL_BOOKMARK_TYPE_ID
            + " integer not null, " + COL_TEXT + " text not null, " + COL_TEXT2
            + " text not null, " + COL_OBJECT_ID + " integer, "
            + COL_OBJECT_ID_2 + " integer, " + COL_OBJECT_ID_3 + " integer, "
            + COL_COMMENT + " text, " + COL_FETCHED_DATE + " text not null, "
            + COL_VALIDITY_TIME + " integer" + ");";

    // Super
    public BookmarksTable() {
        super(TABLE, ALL_COLUMNS, TABLE_CREATE);
    }

    // /////////////////////////////////////////
    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {

        Log.e(TAG, "Upgrade SQL");
        database.execSQL("DROP TABLE IF EXISTS \"" + TABLE + "\"");
        onCreate(database);
    }

    // Override cursorTo
    @Override
    public Object cursorTo(Cursor cursor) {

        if (cursor.getCount() == 0)
            return null;

        // Set values
        DBookmark obj = new DBookmark();
        obj.setId(cursor.getLong(0));
        obj.setBookmarkID(cursor.getInt(1));
        obj.setBookmarkTypeID(cursor.getInt(2));
        obj.setText(cursor.getString(3));
        obj.setText2(cursor.getString(4));
        obj.setObjectID(cursor.getInt(5));
        obj.setObjectID2(cursor.getInt(6));
        obj.setObjectID3(cursor.getInt(7));
        obj.setComment(cursor.getString(8));
        obj.setFetchedDate(cursor.getString(9));
        obj.setValidityTime(cursor.getInt(10));

        return obj;
    }
}
