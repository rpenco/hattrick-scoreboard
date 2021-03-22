package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DWorld;

/**
 * @author Khips
 * @since 4 aot 2014
 */
public class WorldTable extends Table {

    // Table
    public static final String TABLE = "world";
    public static final String COL_ID = "_id";
    public static final String COL_LEAGUE_ID = "leageID";
    public static final String COL_LEAGUE_NAME = "leagueName";
    public static final String COL_SEASON = "season";
    public static final String COL_SEASON_OFFSET = "seasonOffset";
    public static final String COL_MATCH_ROUND = "matchRound";
    public static final String COL_SHORT_NAME = "shortName";
    public static final String COL_CONTINENT = "continent";
    public static final String COL_ZONENAME = "zoneName";
    public static final String COL_ENGLISH_NAME = "englishName";
    public static final String COL_COUNTRY_ID = "countryID";
    public static final String COL_COUNTRY_NAME = "countryName";
    public static final String COL_CURRENCY_NAME = "currencyName";
    public static final String COL_CURRENCY_RATE = "currencyRate";
    public static final String COL_DATE_FORMAT = "dateFormat";
    public static final String COL_TIME_FORMAT = "timeFormat";
    public static final String COL_NATIONAL_TEAM_ID = "nationalTeamID";
    public static final String COL_U20_TEAM_ID = "U20TeamID";
    public static final String COL_ACTIVE_TEAMS = "activeTeams";
    public static final String COL_ACTIVE_USERS = "activeUsers";
    public static final String COL_WAITING_USERS = "waitingUsers";
    public static final String COL_TRAINING_DATE = "trainingDate";
    public static final String COL_ECONOMY_DATE = "economyDate";
    public static final String COL_CUP_MATCH_DATE = "cupMatchDate";
    public static final String COL_SERIES_MATCH_DATE = "seriesMatchDate";
    public static final String COL_NUMBER_OF_LEVELS = "numberOfLevels";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All
    public static final String[] ALL_COLUMNS = {COL_ID, COL_LEAGUE_ID,
            COL_LEAGUE_NAME, COL_SEASON, COL_SEASON_OFFSET, COL_MATCH_ROUND,
            COL_SHORT_NAME, COL_CONTINENT, COL_ZONENAME, COL_ENGLISH_NAME,
            COL_COUNTRY_ID, COL_COUNTRY_NAME, COL_CURRENCY_NAME,
            COL_CURRENCY_RATE, COL_DATE_FORMAT, COL_TIME_FORMAT,
            COL_NATIONAL_TEAM_ID, COL_U20_TEAM_ID, COL_ACTIVE_TEAMS,
            COL_ACTIVE_USERS, COL_WAITING_USERS, COL_TRAINING_DATE,
            COL_ECONOMY_DATE, COL_CUP_MATCH_DATE, COL_SERIES_MATCH_DATE,
            COL_NUMBER_OF_LEVELS, COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (WorldTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_LEAGUE_ID
            + " integer not null, " + COL_LEAGUE_NAME + " text not null, "
            + COL_SEASON + " integer not null, " + COL_SEASON_OFFSET
            + " integer, " + COL_MATCH_ROUND + " integer not null, "
            + COL_SHORT_NAME + " text not null, " + COL_CONTINENT
            + " text not null, " + COL_ZONENAME + " text not null, "
            + COL_ENGLISH_NAME + " text not null, " + COL_COUNTRY_ID
            + " integer not null, " + COL_COUNTRY_NAME + " text not null, "
            + COL_CURRENCY_NAME + " text not null, " + COL_CURRENCY_RATE
            + " float not null, " + COL_DATE_FORMAT + " text not null, "
            + COL_TIME_FORMAT + " text not null, " + COL_NATIONAL_TEAM_ID
            + " integer not null, " + COL_U20_TEAM_ID + " integer not null, "
            + COL_ACTIVE_TEAMS + " integer, " + COL_ACTIVE_USERS + " integer, "
            + COL_WAITING_USERS + " integer, " + COL_TRAINING_DATE
            + " text not null, " + COL_ECONOMY_DATE + " text not null, "
            + COL_CUP_MATCH_DATE + " text not null, " + COL_SERIES_MATCH_DATE
            + " text not null, " + COL_NUMBER_OF_LEVELS + " integer not null, "
            + COL_FETCHED_DATE + " text not null, " + COL_VALIDITY_TIME
            + " integer not null );";

    // Super
    public WorldTable() {
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
        DWorld obj = new DWorld();

        obj.setId(cursor.getLong(0));
        obj.setLeagueID(cursor.getInt(1));
        obj.setLeagueName(cursor.getString(2));
        obj.setSeason(cursor.getInt(3));
        obj.setSeasonOffset(cursor.getInt(4));
        obj.setMatchRound(cursor.getInt(5));
        obj.setShortName(cursor.getString(6));
        obj.setContinent(cursor.getString(7));
        obj.setZoneName(cursor.getString(8));
        obj.setEnglishName(cursor.getString(9));
        obj.setCountryID(cursor.getInt(10));
        obj.setCountryName(cursor.getString(11));
        obj.setCurrencyName(cursor.getString(12));
        obj.setCurrencyRate(cursor.getFloat(13));
        obj.setDateFormat(cursor.getString(14));
        obj.setTimeFormat(cursor.getString(15));
        obj.setNationalTeamId(cursor.getInt(16));
        obj.setU20TeamId(cursor.getInt(17));
        obj.setActiveTeams(cursor.getInt(18));
        obj.setActiveUsers(cursor.getInt(19));
        obj.setWaitingUsers(cursor.getInt(20));
        obj.setTrainingDate(cursor.getString(21));
        obj.setEconomyDate(cursor.getString(22));
        obj.setCupMatchDate(cursor.getString(23));
        obj.setSeriesMatchDate(cursor.getString(24));
        obj.setNumberOfLevels(cursor.getInt(25));
        obj.setFetchedDate(cursor.getString(26));
        obj.setValidityTime(cursor.getInt(27));

        return obj;
    }
}
