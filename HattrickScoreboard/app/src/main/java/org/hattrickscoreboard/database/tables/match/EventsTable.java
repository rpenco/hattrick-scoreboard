package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.tables.Table;

public class EventsTable extends Table {

    // Table
    public static final String TABLE = "matchevents";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_INDEX = "EventIndex";
    public static final String COL_MINUTE = "Minute";
    public static final String COL_SUBJECT_PLAYER_ID = "SubjectPlayerID";
    public static final String COL_SUBJECT_TEAM_ID = "SubjectTeamID";
    public static final String COL_OBJECT_PLAYER_ID = "ObjectPlayerID";
    public static final String COL_EVENT_TYPE_ID = "EventTypeID";
    public static final String COL_EVENT_VARIATION = "EventVariation";
    public static final String COL_EVENT_TEXT = "EventText";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID,
            COL_MATCH_ID,
            COL_SOURCE_SYSTEM,

            COL_INDEX,
            COL_MINUTE,
            COL_SUBJECT_PLAYER_ID,
            COL_SUBJECT_TEAM_ID,
            COL_OBJECT_PLAYER_ID,
            COL_EVENT_TYPE_ID,
            COL_EVENT_VARIATION,
            COL_EVENT_TEXT
    };
    static final String TAG = (EventsTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "
            + COL_MATCH_ID + " integer, "
            + COL_SOURCE_SYSTEM + " text, "
            + COL_INDEX + " integer, "
            + COL_MINUTE + " integer, "
            + COL_SUBJECT_PLAYER_ID + " integer, "
            + COL_SUBJECT_TEAM_ID + " integer, "
            + COL_OBJECT_PLAYER_ID + " integer, "
            + COL_EVENT_TYPE_ID + " integer, "
            + COL_EVENT_VARIATION + " integer, "
            + COL_EVENT_TEXT + " text "
            + ");";

    // Super
    public EventsTable() {
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
        Event obj = new Event();

        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setIndex(cursor.getInt(3));
        obj.setMinute(cursor.getInt(4));
        obj.setSubjectPlayerID(cursor.getInt(5));
        obj.setSubjectTeamID(cursor.getInt(6));
        obj.setObjectPlayerID(cursor.getInt(7));
        obj.setEventTypeID(cursor.getInt(8));
        obj.setEventVariation(cursor.getInt(9));
        obj.setEventText(cursor.getString(10));

        return obj;
    }
}
