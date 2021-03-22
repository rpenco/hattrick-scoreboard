package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DSeries;

public class SeriesTable extends Table {

    // Table
    public static final String TABLE = "leagues";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_LEAGUE_ID = "leagueID";
    public static final String COL_LEAGUE_LEVEL = "leagueLevel";
    public static final String COL_LEAGUE_MAX_LEVEL = "maxLevel";
    public static final String COL_LEAGUE_LEVEL_UNIT_ID = "leagueLevelUnitID";
    public static final String COL_LEAGUE_LEVEL_UNIT_NAME = "leagueLevelUnitName";
    public static final String COL_CURRENT_ROUND = "currentMatchRound";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_TEAM_NAME = "teamName";
    public static final String COL_TEAM_POSITION = "position";
    public static final String COL_TEAM_POSITION_CHANGE = "positionChange";
    public static final String COL_TEAM_MATCHES = "matches";
    public static final String COL_TEAM_GOALS_FOR = "goalsFor";
    public static final String COL_TEAM_GOALS_AGAINST = "goalsAgainst";
    public static final String COL_TEAM_POINTS = "points";
    public static final String COL_TEAM_WON = "won";
    public static final String COL_TEAM_DRAWS = "draws";
    public static final String COL_TEAM_LOST = "lost";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_LEAGUE_ID,
            COL_LEAGUE_LEVEL, COL_LEAGUE_MAX_LEVEL, COL_LEAGUE_LEVEL_UNIT_ID,
            COL_LEAGUE_LEVEL_UNIT_NAME, COL_CURRENT_ROUND, COL_TEAM_ID,
            COL_TEAM_NAME, COL_TEAM_POSITION, COL_TEAM_POSITION_CHANGE,
            COL_TEAM_MATCHES, COL_TEAM_GOALS_FOR, COL_TEAM_GOALS_AGAINST,
            COL_TEAM_POINTS, COL_TEAM_WON, COL_TEAM_DRAWS, COL_TEAM_LOST,
            COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (SeriesTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_LEAGUE_ID
            + " integer not null, " + COL_LEAGUE_LEVEL + " integer not null, "
            + COL_LEAGUE_MAX_LEVEL + " integer not null, "
            + COL_LEAGUE_LEVEL_UNIT_ID + " integer not null, "
            + COL_LEAGUE_LEVEL_UNIT_NAME + " text not null, "
            + COL_CURRENT_ROUND + " integer, " + COL_TEAM_ID
            + " integer not null, " + COL_TEAM_NAME + " text not null, "
            + COL_TEAM_POSITION + " integer not null, "
            + COL_TEAM_POSITION_CHANGE + " integer, " + COL_TEAM_MATCHES
            + " integer, " + COL_TEAM_GOALS_FOR + " integer, "
            + COL_TEAM_GOALS_AGAINST + " integer, " + COL_TEAM_POINTS
            + " integer, " + COL_TEAM_WON + " integer, " + COL_TEAM_DRAWS
            + " integer, " + COL_TEAM_LOST + " integer, " + COL_FETCHED_DATE
            + " text not null, " + COL_VALIDITY_TIME + " integer " + ");";

    // Super
    public SeriesTable() {
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
        DSeries obj = new DSeries();
        obj.setId(cursor.getLong(0));
        obj.setLeagueID(cursor.getInt(1));
        obj.setLeagueLevel(cursor.getInt(2));
        obj.setMaxLevel(cursor.getInt(3));
        obj.setLeagueLevelUnitID(cursor.getInt(4));
        obj.setLeagueLevelUnitName(cursor.getString(5));
        obj.setCurrentMatchRound(cursor.getInt(6));
        obj.setTeamID(cursor.getInt(7));
        obj.setTeamName(cursor.getString(8));
        obj.setPosition(cursor.getInt(9));
        obj.setPositionChange(cursor.getInt(10));
        obj.setMatches(cursor.getInt(11));
        obj.setGoalsFor(cursor.getInt(12));
        obj.setGoalsAgainst(cursor.getInt(13));
        obj.setPoints(cursor.getInt(14));
        obj.setWon(cursor.getInt(15));
        obj.setDraws(cursor.getInt(16));
        obj.setLost(cursor.getInt(17));
        obj.setFetchedDate(cursor.getString(18));
        obj.setValidityTime(cursor.getInt(19));

        return obj;
    }
}
