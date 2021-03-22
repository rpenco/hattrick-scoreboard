package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.Booking;
import org.hattrickscoreboard.database.tables.Table;

public class BookingsTable extends Table {

    // Table
    public static final String TABLE = "bookings";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_PLAYER_ID = "PlayerID";
    public static final String COL_PLAYER_NAME = "PlayerName ";
    public static final String COL_TEAM_ID = "TeamID";
    public static final String COL_TYPE = "Type";
    public static final String COL_MINUTE = "Minute";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID,
            COL_MATCH_ID,
            COL_SOURCE_SYSTEM,
            COL_PLAYER_ID,
            COL_PLAYER_NAME,
            COL_TEAM_ID,
            COL_TYPE,
            COL_MINUTE
    };
    static final String TAG = (BookingsTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "
            + COL_MATCH_ID + " integer, "
            + COL_SOURCE_SYSTEM + " text, "
            + COL_PLAYER_ID + " integer, "
            + COL_PLAYER_NAME + " text, "
            + COL_TEAM_ID + " integer, "
            + COL_TYPE + " integer, "
            + COL_MINUTE + " integer "
            + ");";

    // Super
    public BookingsTable() {
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
        Booking obj = new Booking();

        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setPlayerID(cursor.getInt(3));
        obj.setPlayerName(cursor.getString(4));
        obj.setTeamID(cursor.getInt(5));
        obj.setType(cursor.getInt(6));
        obj.setMinute(cursor.getInt(7));

        return obj;
    }
}
