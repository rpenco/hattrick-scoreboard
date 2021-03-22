package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DArena;

public class ArenaTable extends Table {

    // Table
    public static final String TABLE = "arenas";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_ARENA_ID = "ArenaID";
    public static final String COL_ARENA_NAME = "ArenaName";
    public static final String COL_TEAM_ID = "TeamID";
    public static final String COL_LEAGUE_ID = "LeagueID";
    public static final String COL_REGION_ID = "RegionID";
    public static final String COL_CUR_TERRACES = "CurrentTerraces";
    public static final String COL_CUR_BASIC = "CurrentBasic";
    public static final String COL_CUR_ROOF = "CurrentRoof";
    public static final String COL_CUR_VIP = "CurrentVIP";
    public static final String COL_CUR_TOTAL = "CurrentTotal";
    public static final String COL_REBUILT_DATE = "RebuiltDate";
    public static final String COL_EXPANSION_DATE = "ExpansionDate";
    public static final String COL_EXPANSION_TERRACES = "ExpansionTerraces";
    public static final String COL_EXPANSION_BASIC = "ExpansionBasic";
    public static final String COL_EXPANSION_ROOF = "ExpansionRoof";
    public static final String COL_EXPANSION_VIP = "ExpansionVIP";
    public static final String COL_EXPANSION_TOTAL = "ExpansionTotal";
    public static final String COL_FETCHED_DATE = "FetchedDate";
    public static final String COL_VALIDITY_TIME = "ValidityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_ARENA_ID,
            COL_ARENA_NAME, COL_TEAM_ID, COL_LEAGUE_ID, COL_REGION_ID,
            COL_CUR_TERRACES, COL_CUR_BASIC, COL_CUR_ROOF, COL_CUR_VIP,
            COL_CUR_TOTAL, COL_REBUILT_DATE, COL_EXPANSION_DATE,
            COL_EXPANSION_TERRACES, COL_EXPANSION_BASIC, COL_EXPANSION_ROOF,
            COL_EXPANSION_VIP, COL_EXPANSION_TOTAL,

            COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (ArenaTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_ARENA_ID
            + " integer not null, " + COL_ARENA_NAME + " text not null, "
            + COL_TEAM_ID + " integer not null, " + COL_LEAGUE_ID
            + " integer not null, " + COL_REGION_ID + " integer not null, "
            + COL_CUR_TERRACES + " integer, " + COL_CUR_BASIC + " integer, "
            + COL_CUR_ROOF + " integer, " + COL_CUR_VIP + " integer, "
            + COL_CUR_TOTAL + " integer, " + COL_REBUILT_DATE + " text, "
            + COL_EXPANSION_DATE + " text, " + COL_EXPANSION_TERRACES
            + " integer, " + COL_EXPANSION_BASIC + " integer, "
            + COL_EXPANSION_ROOF + " integer, " + COL_EXPANSION_VIP
            + " integer, " + COL_EXPANSION_TOTAL + " integer, "
            + COL_FETCHED_DATE + " text not null, " + COL_VALIDITY_TIME
            + " integer " + ");";

    // Super
    public ArenaTable() {
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
        DArena obj = new DArena();
        obj.setID(cursor.getLong(0));
        obj.setArenaID(cursor.getInt(1));
        obj.setArenaName(cursor.getString(2));
        obj.setTeamID(cursor.getInt(3));
        obj.setLeagueID(cursor.getInt(4));
        obj.setRegionID(cursor.getInt(5));
        obj.setCurrentTerraces(cursor.getInt(6));
        obj.setCurrentBasic(cursor.getInt(7));
        obj.setCurrentRoof(cursor.getInt(8));
        obj.setCurrentVIP(cursor.getInt(9));
        obj.setCurrentTotal(cursor.getInt(10));
        obj.setRebuiltDate(cursor.getString(11));
        obj.setExpansionDate(cursor.getString(12));
        obj.setExpansionTerraces(cursor.getInt(13));
        obj.setExpansionBasic(cursor.getInt(14));
        obj.setExpansionRoof(cursor.getInt(15));
        obj.setExpansionVIP(cursor.getInt(16));
        obj.setExpansionTotal(cursor.getInt(17));
        obj.setFetchedDate(cursor.getString(18));
        obj.setValidityTime(cursor.getInt(19));

        return obj;
    }
}
