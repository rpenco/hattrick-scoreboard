package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DClub;

public class ClubTable extends Table {

    // Table
    public static final String TABLE = "clubs";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_USER_ID = "userID";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_TEAM_NAME = "teamName";
    public static final String COL_ASSISTANT_TRAINER_LEVEL = "assistantTrainerLevels";
    public static final String COL_FINANCIAL_DIRECTOR_LEVEL = "financialDirectorLevels";
    public static final String COL_FORM_COACH_LEVEL = "formCoachLevels";
    public static final String COL_MEDIC_LEVEL = "medicLevels";
    public static final String COL_SPOKES_LEVEL = "spokespersonLevels";
    public static final String COL_PSYCHOLOGIST_LEVEL = "sportPsychologistLevels";
    public static final String COL_YOUTH_INVESTMENT = "youthInvestment";
    public static final String COL_HAS_PROMOTED = "hasPromoted";
    public static final String COL_YOUTH_LEVEL = "youthLevel";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_USER_ID,
            COL_TEAM_ID, COL_TEAM_NAME, COL_ASSISTANT_TRAINER_LEVEL, COL_FINANCIAL_DIRECTOR_LEVEL,
            COL_FORM_COACH_LEVEL, COL_MEDIC_LEVEL, COL_SPOKES_LEVEL, COL_PSYCHOLOGIST_LEVEL,
            COL_YOUTH_INVESTMENT, COL_HAS_PROMOTED, COL_YOUTH_LEVEL, COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (ClubTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "
            + COL_USER_ID + " integer not null, "
            + COL_TEAM_ID + " integer not null, "
            + COL_TEAM_NAME + " text not null, "
            + COL_ASSISTANT_TRAINER_LEVEL + " integer not null, "
            + COL_FINANCIAL_DIRECTOR_LEVEL + " integer not null, "
            + COL_FORM_COACH_LEVEL + " integer not null, "
            + COL_MEDIC_LEVEL + " integer not null, "
            + COL_SPOKES_LEVEL + " integer not null, "
            + COL_PSYCHOLOGIST_LEVEL + " integer not null, "
            + COL_YOUTH_INVESTMENT + " integer not null, "
            + COL_HAS_PROMOTED + " text not null, "
            + COL_YOUTH_LEVEL + " integer not null, "
            + COL_FETCHED_DATE + " text not null, "
            + COL_VALIDITY_TIME + " integer "
            + ");";

    // Super
    public ClubTable() {
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
        DClub obj = new DClub();
        obj.setId(cursor.getLong(0));
        obj.setUserID(cursor.getInt(1));
        obj.setTeamID(cursor.getInt(2));
        obj.setTeamName(cursor.getString(3));
        obj.setAssistantTrainerLevel(cursor.getInt(4));
        obj.setFinancialDirectorLevel(cursor.getInt(5));
        obj.setFormCoachLevel(cursor.getInt(6));
        obj.setMedicLevel(cursor.getInt(7));
        obj.setSpokesmenLevel(cursor.getInt(8));
        obj.setPsychologistLevel(cursor.getInt(9));
        obj.setYouthInvestment(cursor.getInt(10));
        obj.setHasPromoted(Boolean.parseBoolean(cursor.getString(11)));
        obj.setYouthLevel(cursor.getInt(12));
        obj.setFetchedDate(cursor.getString(13));
        obj.setValidityTime(cursor.getInt(14));
        return obj;
    }
}
