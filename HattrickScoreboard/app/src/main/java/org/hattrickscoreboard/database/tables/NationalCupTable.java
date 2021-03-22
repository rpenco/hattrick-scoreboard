package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DNationalCup;

public class NationalCupTable extends Table {

    // Table
    public static final String TABLE = "nationalCup";
    public static final String COL_ID = "_id";
    public static final String COL_LEAGUE_ID = "leagueID";
    public static final String COL_COUNTRY_ID = "countryID";
    public static final String COL_CUP_ID = "cupID";
    public static final String COL_CUP_NAME = "cupName";
    public static final String COL_CUP_LEAGUELEVEL = "cupLeagueLevel";
    public static final String COL_CUP_LEVEL = "cupLevel";
    public static final String COL_CUP_LEVEL_INDEX = "cupLevelIndex";
    public static final String COL_MATCH_ROUND = "matchRound";
    public static final String COL_MATCH_ROUNDS_LEFT = "matchRoundsLeft";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All
    public static final String[] ALL_COLUMNS = {COL_ID, COL_LEAGUE_ID,
            COL_COUNTRY_ID, COL_CUP_ID, COL_CUP_NAME, COL_CUP_LEAGUELEVEL,
            COL_CUP_LEVEL, COL_CUP_LEVEL_INDEX, COL_MATCH_ROUND,
            COL_MATCH_ROUNDS_LEFT, COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (NationalCupTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_LEAGUE_ID
            + " integer not null, " + COL_COUNTRY_ID + " integer not null, "
            + COL_CUP_ID + " integer not null, " + COL_CUP_NAME
            + " text not null, " + COL_CUP_LEAGUELEVEL + " integer, "
            + COL_CUP_LEVEL + " integer not null, " + COL_CUP_LEVEL_INDEX
            + " integer not null, " + COL_MATCH_ROUND + " integer, "
            + COL_MATCH_ROUNDS_LEFT + " integer, " + COL_FETCHED_DATE
            + " text not null, " + COL_VALIDITY_TIME + " integer not null "
            + ");";

    // Super
    public NationalCupTable() {
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
        DNationalCup obj = new DNationalCup();
        obj.setId(cursor.getLong(0));
        obj.setLeageID(cursor.getInt(1));
        obj.setCountryID(cursor.getInt(2));
        obj.setCupID(cursor.getInt(3));
        obj.setCupName(cursor.getString(4));
        obj.setCupLeagueLevel(cursor.getInt(5));
        obj.setCupLevel(cursor.getInt(6));
        obj.setMatchRound(cursor.getInt(7));
        obj.setMatchRoundsLeft(cursor.getInt(8));
        obj.setFetchedDate(cursor.getString(9));
        obj.setValidityTime(cursor.getInt(10));

        return obj;
    }
}
