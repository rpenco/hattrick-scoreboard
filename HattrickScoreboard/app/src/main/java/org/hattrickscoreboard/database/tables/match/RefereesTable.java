package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.Referee;
import org.hattrickscoreboard.database.tables.Table;

public class RefereesTable extends Table {

    // Table
    public static final String TABLE = "referees";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_REFEREE_ID = "RefereeId";
    public static final String COL_NAME = "Name";
    public static final String COL_COUNTRY_ID = "CountryId";
    public static final String COL_COUNTRY_NAME = "CountryName";
    public static final String COL_TEAM_ID = "TeamId";
    public static final String COL_TEAM_NAME = "Teamname";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID, COL_REFEREE_ID, COL_NAME, COL_COUNTRY_ID, COL_COUNTRY_NAME,
            COL_TEAM_ID, COL_TEAM_NAME

    };
    static final String TAG = (RefereesTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_REFEREE_ID
            + " integer, " + COL_NAME + " text, " + COL_COUNTRY_ID
            + " integer, " + COL_COUNTRY_NAME + " text, " + COL_TEAM_ID
            + " integer, " + COL_TEAM_NAME + " text " + ");";

    // Super
    public RefereesTable() {
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
        Referee obj = new Referee();

        obj.setID(cursor.getLong(0));
        obj.setId(cursor.getInt(1));
        obj.setName(cursor.getString(2));
        obj.setCountryId(cursor.getInt(3));
        obj.setCountryName(cursor.getString(4));
        obj.setTeamId(cursor.getInt(5));
        obj.setTeamname(cursor.getString(6));

        return obj;
    }
}
