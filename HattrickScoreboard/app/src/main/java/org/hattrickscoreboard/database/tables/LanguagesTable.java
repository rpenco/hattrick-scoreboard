package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DLanguage;

public class LanguagesTable extends Table {

    // Table
    public static final String TABLE = "languages";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_LANGUE_ID = "langueID";
    public static final String COL_LANGUE_NAME = "langueName";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_LANGUE_ID,
            COL_LANGUE_NAME, COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (LanguagesTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_LANGUE_ID
            + " integer not null, " + COL_LANGUE_NAME + " text not null, "
            + COL_FETCHED_DATE + " text not null, " + COL_VALIDITY_TIME
            + " integer " + ");";

    // Super
    public LanguagesTable() {
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
        DLanguage lang = new DLanguage();
        lang.setId((int) cursor.getLong(1));
        lang.setName(cursor.getString(2));
        lang.setFetchedDate(cursor.getString(3));
        lang.setValidityTime(cursor.getInt(4));

        return lang;
    }

}
