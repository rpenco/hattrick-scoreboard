package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DStaff;

public class StaffTable extends Table {

    // Table
    public static final String TABLE = "staffs";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_NAME = "name";
    public static final String COL_STAFF_ID = "staffID";
    public static final String COL_STAFF_TYPE = "staffType";
    public static final String COL_STAFF_LEVEL = "staffLevel";
    public static final String COL_HIRED_DATE = "hiredDate";
    public static final String COL_COST = "cost";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_TEAM_ID, COL_NAME,
            COL_STAFF_ID, COL_STAFF_TYPE, COL_STAFF_LEVEL, COL_HIRED_DATE,
            COL_COST, COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (StaffTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_TEAM_ID
            + " integer not null, " + COL_NAME + " text not null, "
            + COL_STAFF_ID + " integer not null, " + COL_STAFF_TYPE
            + " integer not null, " + COL_STAFF_LEVEL + " integer not null, "
            + COL_HIRED_DATE + " text not null, " + COL_COST
            + " integer not null, " + COL_FETCHED_DATE + " text not null, "
            + COL_VALIDITY_TIME + " integer " + ");";

    // Super
    public StaffTable() {
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
        DStaff obj = new DStaff();
        obj.setTeamID(cursor.getInt(1));
        obj.setName(cursor.getString(2));
        obj.setStaffID(cursor.getInt(3));
        obj.setStaffType(cursor.getInt(4));
        obj.setStaffLevel(cursor.getInt(5));
        obj.setHiredDate(cursor.getString(6));
        obj.setCost(cursor.getInt(7));
        obj.setFetchedDate(cursor.getString(8));
        obj.setValidityTime(cursor.getInt(9));

        return obj;
    }
}
