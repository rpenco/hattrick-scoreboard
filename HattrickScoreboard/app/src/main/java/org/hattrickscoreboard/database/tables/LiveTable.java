package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DLive;

public class LiveTable extends Table {

    // Table
    public static final String TABLE = "htlive";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_MATCH_DATE = "MatchDate";
    public static final String COL_HOME_GOALS = "HomeGoals";
    public static final String COL_AWAY_GOALS = "AwayGoals";
    public static final String COL_LAST_SHOWN_EVENT_INDEX = "LastShownEventIndex";
    public static final String COL_LAST_READ_EVENT_INDEX = "LastReadEventIndex";
    public static final String COL_NEXT_EVENT_MINUTE = "NextEventMinute";
    public static final String COL_STATUS = "MatchStatus";
    public static final String COL_FETCHED_DATE = "FetchedDate";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID, COL_MATCH_ID, COL_SOURCE_SYSTEM, COL_MATCH_DATE, COL_HOME_GOALS,
            COL_AWAY_GOALS, COL_LAST_SHOWN_EVENT_INDEX,
            COL_LAST_READ_EVENT_INDEX, COL_NEXT_EVENT_MINUTE, COL_STATUS,
            COL_FETCHED_DATE,};
    static final String TAG = (LiveTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_MATCH_ID
            + " integer not null, " + COL_SOURCE_SYSTEM + " integer, "
            + COL_MATCH_DATE + " text," + COL_HOME_GOALS + " integer, "
            + COL_AWAY_GOALS + " integer, " + COL_LAST_SHOWN_EVENT_INDEX
            + " integer, " + COL_LAST_READ_EVENT_INDEX + " integer, "
            + COL_NEXT_EVENT_MINUTE + " integer, " + COL_STATUS + " text, "
            + COL_FETCHED_DATE + " text " + ");";

    // Super
    public LiveTable() {
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

        // Set values
        DLive obj = new DLive();
        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setMatchDate(cursor.getString(3));
        obj.setHomeGoals(cursor.getInt(4));
        obj.setAwayGoals(cursor.getInt(5));
        obj.setLastShownEventIndex(cursor.getInt(6));
        obj.setLastReadEventIndex(cursor.getInt(7));
        obj.setNextEventMinute(cursor.getInt(8));
        obj.setMatchStatus(cursor.getString(9));
        obj.setFetchedDate(cursor.getString(10));
        return obj;
    }
}
