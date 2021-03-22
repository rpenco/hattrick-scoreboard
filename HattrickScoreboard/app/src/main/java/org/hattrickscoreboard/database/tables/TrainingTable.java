package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DTraining;

public class TrainingTable extends Table {

    // Table
    public static final String TABLE = "training";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_TRAININGLEVEL = "trainingLevel";
    public static final String COL_TRAINING_TYPE = "trainingType";
    public static final String COL_STAMINA_PART = "staminaTrainingPart";
    public static final String COL_LAST_TRAINING_TYPE = "lastTrainingTrainingType";
    public static final String COL_LAST_TRAINING_LEVEL = "lastTrainingTrainingLevel";
    public static final String COL_LAST_STAMINA_PART = "lastTrainingStaminaTrainingPart";
    public static final String COL_TRAINER_ID = "trainerID";
    public static final String COL_TRAINER_ARRIVAL_DATE = "arrivalDate";
    public static final String COL_MORALE = "morale";
    public static final String COL_SELF_CONFIDENCE = "selfConfidence";
    public static final String COL_EXPERIENCE_442 = "experience442";
    public static final String COL_EXPERIENCE_433 = "experience433";
    public static final String COL_EXPERIENCE_451 = "experience451";
    public static final String COL_EXPERIENCE_352 = "experience352";
    public static final String COL_EXPERIENCE_532 = "experience532";
    public static final String COL_EXPERIENCE_343 = "experience343";
    public static final String COL_EXPERIENCE_541 = "experience541";
    public static final String COL_EXPERIENCE_523 = "experience523";
    public static final String COL_EXPERIENCE_550 = "experience550";
    public static final String COL_EXPERIENCE_253 = "experience253";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TRAINING = "validityTraining";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_TEAM_ID,
            COL_TRAININGLEVEL, COL_TRAINING_TYPE, COL_STAMINA_PART,
            COL_LAST_TRAINING_TYPE, COL_LAST_TRAINING_LEVEL,
            COL_LAST_STAMINA_PART, COL_TRAINER_ID, COL_TRAINER_ARRIVAL_DATE,
            COL_MORALE, COL_SELF_CONFIDENCE, COL_EXPERIENCE_442,
            COL_EXPERIENCE_433, COL_EXPERIENCE_451, COL_EXPERIENCE_352,
            COL_EXPERIENCE_532, COL_EXPERIENCE_343, COL_EXPERIENCE_541,
            COL_EXPERIENCE_523, COL_EXPERIENCE_550, COL_EXPERIENCE_253,
            COL_FETCHED_DATE, COL_VALIDITY_TRAINING};
    static final String TAG = (TrainingTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_TEAM_ID
            + " integer not null, " + COL_TRAININGLEVEL + " integer not null, "
            + COL_TRAINING_TYPE + " integer, " + COL_STAMINA_PART
            + " integer, " + COL_LAST_TRAINING_TYPE + " integer, "
            + COL_LAST_TRAINING_LEVEL + " integer, " + COL_LAST_STAMINA_PART
            + " integer, " + COL_TRAINER_ID + " integer, "
            + COL_TRAINER_ARRIVAL_DATE + " text, " + COL_MORALE + " integer, "
            + COL_SELF_CONFIDENCE + " integer, " + COL_EXPERIENCE_442
            + " integer, " + COL_EXPERIENCE_433 + " integer, "
            + COL_EXPERIENCE_451 + " integer, " + COL_EXPERIENCE_352
            + " integer, " + COL_EXPERIENCE_532 + " integer, "
            + COL_EXPERIENCE_343 + " integer, " + COL_EXPERIENCE_541
            + " integer, " + COL_EXPERIENCE_523 + " integer, "
            + COL_EXPERIENCE_550 + " integer, " + COL_EXPERIENCE_253
            + " integer, " + COL_FETCHED_DATE + " text, "
            + COL_VALIDITY_TRAINING + " integer " + ");";

    // Super
    public TrainingTable() {
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
        DTraining obj = new DTraining();
        obj.setTeamID(cursor.getInt(1));

        obj.setTrainingLevel(cursor.getInt(2));
        obj.setTrainingType(cursor.getInt(3));
        obj.setStaminaPart(cursor.getInt(4));
        obj.setLastTrainingType(cursor.getInt(5));
        obj.setLastTrainingLevel(cursor.getInt(6));
        obj.setLast_staminaPart(cursor.getInt(7));
        obj.setTrainerID(cursor.getInt(8));
        obj.setTrainerArrivalDate(cursor.getString(9));
        obj.setMorale(cursor.getInt(10));
        obj.setSelfConfidence(cursor.getInt(11));
        obj.setExperience442(cursor.getInt(12));
        obj.setExperience433(cursor.getInt(13));
        obj.setExperience451(cursor.getInt(14));
        obj.setExperience352(cursor.getInt(15));
        obj.setExperience532(cursor.getInt(16));
        obj.setExperience343(cursor.getInt(17));
        obj.setExperience541(cursor.getInt(18));
        obj.setExperience523(cursor.getInt(19));
        obj.setExperience550(cursor.getInt(20));
        obj.setExperience253(cursor.getInt(21));
        obj.setFetchedDate(cursor.getString(22));
        obj.setValidityTime(cursor.getInt(23));

        return obj;
    }
}
