package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DSeriesFixtures;

public class SeriesFixturesTable extends Table {

    // Table
    public static final String TABLE = "leaguesfixtures";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_LEAGUE_LEVEL_UNIT_ID = "leagueLevelUnitID";
    public static final String COL_LEAGUE_LEVEL_UNIT_NAME = "leagueLevelUnitName";
    public static final String COL_SEASON = "season";
    public static final String COL_MATCH_ID = "matchID";
    public static final String COL_MATCH_ROUND = "matchRound";
    public static final String COL_HOME_TEAM_ID = "homeTeamID";
    public static final String COL_HOME_TEAM_NAME = "homeTeamName";
    public static final String COL_AWAY_TEAM_ID = "awayTeamID";
    public static final String COL_AWAY_TEAM_NAME = "awayTeamName";
    public static final String COL_MATCH_DATE = "matchDate";
    public static final String COL_HOME_GOALS = "homeGoals";
    public static final String COL_AWAY_GOALS = "awayGoals";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID,
            COL_LEAGUE_LEVEL_UNIT_ID, COL_LEAGUE_LEVEL_UNIT_NAME, COL_SEASON,
            COL_MATCH_ID, COL_MATCH_ROUND, COL_HOME_TEAM_ID,
            COL_HOME_TEAM_NAME, COL_AWAY_TEAM_ID, COL_AWAY_TEAM_NAME,
            COL_MATCH_DATE, COL_HOME_GOALS, COL_AWAY_GOALS, COL_FETCHED_DATE,
            COL_VALIDITY_TIME

    };
    static final String TAG = (SeriesFixturesTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "
            + COL_LEAGUE_LEVEL_UNIT_ID + " integer not null, "
            + COL_LEAGUE_LEVEL_UNIT_NAME + " text not null, " + COL_SEASON
            + " integer not null, " + COL_MATCH_ID + " integer not null, "
            + COL_MATCH_ROUND + " integer not null, " + COL_HOME_TEAM_ID
            + " integer not null, " + COL_HOME_TEAM_NAME + " text not null, "
            + COL_AWAY_TEAM_ID + " integer not null, " + COL_AWAY_TEAM_NAME
            + " text not null, " + COL_MATCH_DATE + " text not null, "
            + COL_HOME_GOALS + " integer, " + COL_AWAY_GOALS + " integer, "
            + COL_FETCHED_DATE + " text not null, " + COL_VALIDITY_TIME
            + " integer " + ");";

    // Super
    public SeriesFixturesTable() {
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
        DSeriesFixtures obj = new DSeriesFixtures();
        obj.setId(cursor.getLong(0));
        obj.setLeagueLevelUnitID(cursor.getInt(1));
        obj.setLeagueLevelUnitName(cursor.getString(2));
        obj.setSaison(cursor.getInt(3));
        obj.setMatchID(cursor.getInt(4));
        obj.setMatchRound(cursor.getInt(5));
        obj.setHomeTeamID(cursor.getInt(6));
        obj.setHomeTeamName(cursor.getString(7));
        obj.setAwayTeamID(cursor.getInt(8));
        obj.setAwayTeamName(cursor.getString(9));
        obj.setMatchDate(cursor.getString(10));
        obj.setHomeGoals(cursor.getInt(11));
        obj.setAwayGoals(cursor.getInt(12));
        obj.setFetchedDate(cursor.getString(13));
        obj.setValidityTime(cursor.getInt(14));

        return obj;
    }
}
