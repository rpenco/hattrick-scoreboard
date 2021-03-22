package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.Substitution;
import org.hattrickscoreboard.database.tables.Table;

public class SubstitutionsTable extends Table {

    // Table
    public static final String TABLE = "substitutions";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_TEAM_ID = "TeamID";
    public static final String COL_SUBJECT_ID = "SubjectPlayerID";
    public static final String COL_OBJECT_ID = "ObjectPlayerID";
    public static final String COL_ORDER_TYPE = "OrderType";
    public static final String COL_NEW_POSITION_ID = "NewPositionId";
    public static final String COL_NEW_POSITION_BEHAVIOUR = "NewPositionBehaviour";
    public static final String COL_MATCH_MINUTE = "MatchMinute";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID, COL_MATCH_ID, COL_SOURCE_SYSTEM, COL_TEAM_ID, COL_SUBJECT_ID,
            COL_OBJECT_ID, COL_ORDER_TYPE, COL_NEW_POSITION_ID,
            COL_NEW_POSITION_BEHAVIOUR, COL_MATCH_MINUTE};
    static final String TAG = (SubstitutionsTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_MATCH_ID
            + " integer, " + COL_SOURCE_SYSTEM + " text, " + COL_TEAM_ID
            + " integer, " + COL_SUBJECT_ID + " integer, " + COL_OBJECT_ID
            + " integer, " + COL_ORDER_TYPE + " integer, "
            + COL_NEW_POSITION_ID + " integer, " + COL_NEW_POSITION_BEHAVIOUR
            + " integer, " + COL_MATCH_MINUTE + " integer " + ");";

    // Super
    public SubstitutionsTable() {
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
        Substitution obj = new Substitution();

        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setTeamID(cursor.getInt(3));
        obj.setSubjectPlayerID(cursor.getInt(4));
        obj.setObjectPlayerID(cursor.getInt(5));
        obj.setOrderType(cursor.getInt(6));
        obj.setNewPositionId(cursor.getInt(7));
        obj.setNewPositionBehaviour(cursor.getInt(8));
        obj.setMatchMinute(cursor.getInt(9));

        return obj;
    }
}
