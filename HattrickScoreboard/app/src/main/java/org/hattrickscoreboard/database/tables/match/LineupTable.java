package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.tables.Table;

public class LineupTable extends Table {

    // Table
    public static final String TABLE = "lineup";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_PLAYER_ID = "PlayerID";
    public static final String COL_TEAM_ID = "TeamID";
    public static final String COL_PLAYER_FIRST_NAME = "FirstName";
    public static final String COL_PLAYER_LAST_NAME = "LastName";
    public static final String COL_PLAYER_NICKNAME = "NickName";
    public static final String COL_STARTING_ROLE_ID = "StartingRoleID";
    public static final String COL_ROLE_ID = "RoleID";
    public static final String COL_STARTING_BEHAVIOUR = "StartingBehaviour";
    public static final String COL_BEHAVIOUR = "Behaviour";
    public static final String COL_RATING_STARS = "RatingStars ";
    public static final String COL_RATING_STARS_END_OF_MATCH = "RatingStarsEndOfMatch";
    public static final String COL_CAPTAIN = "Captain";
    public static final String COL_SET_PIECES = "SetPieces";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID,
            COL_MATCH_ID,
            COL_SOURCE_SYSTEM,
            COL_PLAYER_ID,
            COL_TEAM_ID,
            COL_PLAYER_FIRST_NAME,
            COL_PLAYER_LAST_NAME,
            COL_PLAYER_NICKNAME,
            COL_STARTING_ROLE_ID,
            COL_ROLE_ID,
            COL_STARTING_BEHAVIOUR,
            COL_BEHAVIOUR,
            COL_RATING_STARS,
            COL_RATING_STARS_END_OF_MATCH,
            COL_CAPTAIN,
            COL_SET_PIECES,
    };
    static final String TAG = (LineupTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "
            + COL_MATCH_ID + " integer, "
            + COL_SOURCE_SYSTEM + " text, "
            + COL_PLAYER_ID + " integer, "
            + COL_TEAM_ID + " integer, "
            + COL_PLAYER_FIRST_NAME + " text, "
            + COL_PLAYER_LAST_NAME + " text, "
            + COL_PLAYER_NICKNAME + " text, "
            + COL_STARTING_ROLE_ID + " integer, "
            + COL_ROLE_ID + " integer, "
            + COL_STARTING_BEHAVIOUR + " integer, "
            + COL_BEHAVIOUR + " integer, "
            + COL_RATING_STARS + " text, "
            + COL_RATING_STARS_END_OF_MATCH + " text, "
            + COL_CAPTAIN + " integer, "
            + COL_SET_PIECES + " integer "
            + ");";

    // Super
    public LineupTable() {
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
        LineUp obj = new LineUp();

        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setPlayerID(cursor.getInt(3));
        obj.setTeamID(cursor.getInt(4));
        obj.setFirstName(cursor.getString(5));
        obj.setLastName(cursor.getString(6));
        obj.setNickName(cursor.getString(7));
        obj.setStartingRoleID(cursor.getInt(8));
        obj.setRoleID(cursor.getInt(9));
        obj.setStartingBehaviour(cursor.getInt(10));
        obj.setBehaviour(cursor.getInt(11));
        obj.setRatingStars(cursor.getString(12));
        obj.setRatingStarsEndOfMatch(cursor.getString(13));
        obj.setCaptain(cursor.getString(14));
        obj.setSetPieces(cursor.getString(15));

        return obj;
    }
}
