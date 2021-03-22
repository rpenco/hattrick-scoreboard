package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DPlayer;

public class PlayersTable extends Table {

    // Table
    public static final String TABLE = "players";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_PLAYER_ID = "playerID";
    public static final String COL_PLAYER_FIRSTNAME = "firstName";
    public static final String COL_PLAYER_NICKNAME = "nickName";
    public static final String COL_PLAYER_LASTNAME = "lastName";
    public static final String COL_PLAYER_NUMBER = "playerNumber";
    public static final String COL_PLAYER_AGE = "age";
    public static final String COL_PLAYER_AGE_DAYS = "ageDays";
    public static final String COL_PLAYER_TSI = "TSI";
    public static final String COL_PLAYER_FORM = "playerForm";
    public static final String COL_PLAYER_STATEMENT = "statement";
    public static final String COL_PLAYER_EXPERIENCE = "experience";
    public static final String COL_PLAYER_LOYALTY = "loyalty";
    public static final String COL_PLAYER_MOTHERCLUB_BONUS = "motherClubBonus";
    public static final String COL_PLAYER_LEADERSHIP = "leadership";
    public static final String COL_PLAYER_SALARY = "salary";
    public static final String COL_PLAYER_ISABROAD = "isAbroad";
    public static final String COL_PLAYER_AGREEABILITY = "agreeability";
    public static final String COL_PLAYER_AGGRESSIVENESS = "aggressiveness";
    public static final String COL_PLAYER_HONESTY = "honesty";
    public static final String COL_PLAYER_LEAGUE_GOALS = "leagueGoals";
    public static final String COL_PLAYER_CUP_GOALS = "cupGoals";
    public static final String COL_PLAYER_FRIENDLIES_GOALS = "friendliesGoals";
    public static final String COL_PLAYER_CAREER_GOALS = "careerGoals";
    public static final String COL_PLAYER_CAREER_HATTRICKS = "careerHattricks";
    public static final String COL_PLAYER_SPECIALTY = "specialty";
    public static final String COL_PLAYER_TRANSFER_LISTED = "transferListed";
    public static final String COL_PLAYER_NATIONAL_TEAM_ID = "nationalTeamID";
    public static final String COL_PLAYER_COUNTRY_ID = "countryID";
    public static final String COL_PLAYER_CAPS = "caps";
    public static final String COL_PLAYER_CAPS_U20 = "capsU20";
    public static final String COL_PLAYER_CARDS = "cards";
    public static final String COL_PLAYER_INJURY_LEVEL = "injuryLevel";
    public static final String COL_PLAYER_STAMINA_SKILL = "staminaSkill";
    public static final String COL_PLAYER_KEEPER_SKILL = "keeperSkill";
    public static final String COL_PLAYER_PLAYMAKER_SKILL = "playmakerSkill";
    public static final String COL_PLAYER_SCORER_SKILL = "scorerSkill";
    public static final String COL_PLAYER_PASSING_SKILL = "passingSkill";
    public static final String COL_PLAYER_WINGER_SKILL = "wingerSkill";
    public static final String COL_PLAYER_DEFENDER_SKILL = "defenderSkill";
    public static final String COL_PLAYER_SETPIECES_SKILL = "setPiecesSkill";
    public static final String COL_PLAYER_CATEGORYID = "playerCategoryId";
    public static final String COL_LASTMATCH_DATE = "lastMatchDate";
    public static final String COL_LASTMATCH_MATCHID = "lastMatchMatchId";
    public static final String COL_LASTMATCH_POSITIONCODE = "lastMatchPositionCode";
    public static final String COL_LASTMATCH_PLAYEDMINUTES = "lastMatchPlayedMinutes";
    public static final String COL_LASTMATCH_RATING = "lastMatchRating";
    public static final String COL_LASTMATCH_RATING_ENDOFGAME = "lastMatchRatingEndOfGame";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_TEAM_ID,
            COL_PLAYER_ID, COL_PLAYER_FIRSTNAME, COL_PLAYER_NICKNAME,
            COL_PLAYER_LASTNAME, COL_PLAYER_NUMBER, COL_PLAYER_AGE,
            COL_PLAYER_AGE_DAYS, COL_PLAYER_TSI, COL_PLAYER_FORM,
            COL_PLAYER_STATEMENT, COL_PLAYER_EXPERIENCE, COL_PLAYER_LOYALTY,
            COL_PLAYER_MOTHERCLUB_BONUS, COL_PLAYER_LEADERSHIP,
            COL_PLAYER_SALARY, COL_PLAYER_ISABROAD, COL_PLAYER_AGREEABILITY,
            COL_PLAYER_AGGRESSIVENESS, COL_PLAYER_HONESTY,
            COL_PLAYER_LEAGUE_GOALS, COL_PLAYER_CUP_GOALS,
            COL_PLAYER_FRIENDLIES_GOALS, COL_PLAYER_CAREER_GOALS,
            COL_PLAYER_CAREER_HATTRICKS, COL_PLAYER_SPECIALTY,
            COL_PLAYER_TRANSFER_LISTED, COL_PLAYER_NATIONAL_TEAM_ID,
            COL_PLAYER_COUNTRY_ID, COL_PLAYER_CAPS, COL_PLAYER_CAPS_U20,
            COL_PLAYER_CARDS, COL_PLAYER_INJURY_LEVEL,
            COL_PLAYER_STAMINA_SKILL, COL_PLAYER_KEEPER_SKILL,
            COL_PLAYER_PLAYMAKER_SKILL, COL_PLAYER_SCORER_SKILL,
            COL_PLAYER_PASSING_SKILL, COL_PLAYER_WINGER_SKILL,
            COL_PLAYER_DEFENDER_SKILL, COL_PLAYER_SETPIECES_SKILL,
            COL_PLAYER_CATEGORYID, COL_LASTMATCH_DATE, COL_LASTMATCH_MATCHID,
            COL_LASTMATCH_POSITIONCODE, COL_LASTMATCH_PLAYEDMINUTES,
            COL_LASTMATCH_RATING, COL_LASTMATCH_RATING_ENDOFGAME,
            COL_FETCHED_DATE, COL_VALIDITY_TIME};
    static final String TAG = (PlayersTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_TEAM_ID
            + " integer not null, " + COL_PLAYER_ID + " integer not null, "
            + COL_PLAYER_FIRSTNAME + " text not null, " + COL_PLAYER_NICKNAME
            + " text, " + COL_PLAYER_LASTNAME + " text not null, "
            + COL_PLAYER_NUMBER + " integer, " + COL_PLAYER_AGE
            + " integer not null, " + COL_PLAYER_AGE_DAYS
            + " integer not null, " + COL_PLAYER_TSI + " integer, "
            + COL_PLAYER_FORM + " integer, " + COL_PLAYER_STATEMENT + " text, "
            + COL_PLAYER_EXPERIENCE + " integer, " + COL_PLAYER_LOYALTY
            + " integer, " + COL_PLAYER_MOTHERCLUB_BONUS + " text not null, "
            + COL_PLAYER_LEADERSHIP + " integer, " + COL_PLAYER_SALARY
            + " integer not null, " + COL_PLAYER_ISABROAD + " text, "
            + COL_PLAYER_AGREEABILITY + " integer, "
            + COL_PLAYER_AGGRESSIVENESS + " integer, " + COL_PLAYER_HONESTY
            + " integer, " + COL_PLAYER_LEAGUE_GOALS + " integer, "
            + COL_PLAYER_CUP_GOALS + " integer, " + COL_PLAYER_FRIENDLIES_GOALS
            + " integer, " + COL_PLAYER_CAREER_GOALS + " integer, "
            + COL_PLAYER_CAREER_HATTRICKS + " integer, " + COL_PLAYER_SPECIALTY
            + " integer, " + COL_PLAYER_TRANSFER_LISTED + " text, "
            + COL_PLAYER_NATIONAL_TEAM_ID + " integer not null, "
            + COL_PLAYER_COUNTRY_ID + " integer not null, " + COL_PLAYER_CAPS
            + " integer, " + COL_PLAYER_CAPS_U20 + " integer, "
            + COL_PLAYER_CARDS + " integer, " + COL_PLAYER_INJURY_LEVEL
            + " integer, " + COL_PLAYER_STAMINA_SKILL + " integer, "
            + COL_PLAYER_KEEPER_SKILL + " integer, "
            + COL_PLAYER_PLAYMAKER_SKILL + " integer, "
            + COL_PLAYER_SCORER_SKILL + " integer , "
            + COL_PLAYER_PASSING_SKILL + " integer, " + COL_PLAYER_WINGER_SKILL
            + " integer , " + COL_PLAYER_DEFENDER_SKILL + " integer, "
            + COL_PLAYER_SETPIECES_SKILL + " integer , "
            + COL_PLAYER_CATEGORYID + " integer, " + COL_LASTMATCH_DATE
            + " text, " + COL_LASTMATCH_MATCHID + " integer, "
            + COL_LASTMATCH_POSITIONCODE + " integer, "
            + COL_LASTMATCH_PLAYEDMINUTES + " integer, " + COL_LASTMATCH_RATING
            + " integer, " + COL_LASTMATCH_RATING_ENDOFGAME + " integer, "
            + COL_FETCHED_DATE + " text not null, " + COL_VALIDITY_TIME
            + " integer " + ");";

    // Super
    public PlayersTable() {
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
        DPlayer obj = new DPlayer();
        obj.setId(cursor.getLong(0));
        obj.setTeamId(cursor.getInt(1));
        obj.setPlayerId(cursor.getInt(2));
        obj.setFirstname(cursor.getString(3));
        obj.setNickname(cursor.getString(4));
        obj.setLastname(cursor.getString(5));
        obj.setNumber(cursor.getInt(6));
        obj.setAge(cursor.getInt(7));
        obj.setAgeDays(cursor.getInt(8));
        obj.setTSI(cursor.getInt(9));
        obj.setForm(cursor.getInt(10));
        obj.setStatement(cursor.getString(11));
        obj.setExperience(cursor.getInt(12));
        obj.setLoyalty(cursor.getInt(13));
        obj.setMotherclubBonus(Boolean.parseBoolean(cursor.getString(14)));
        obj.setLeadership(cursor.getInt(15));
        obj.setSalary(cursor.getInt(16));
        obj.setAbroad(Boolean.parseBoolean(cursor.getString(17)));
        obj.setAgreeability(cursor.getInt(18));
        obj.setAggressiveness(cursor.getInt(19));
        obj.setHonesty(cursor.getInt(20));
        obj.setLeaguegoals(cursor.getInt(21));
        obj.setCupgoals(cursor.getInt(22));
        obj.setFriendliesGoals(cursor.getInt(23));
        obj.setCareerGoals(cursor.getInt(24));
        obj.setCareerHattricks(cursor.getInt(25));
        obj.setSpecialty(cursor.getInt(26));
        obj.setTransferListed(Boolean.parseBoolean(cursor.getString(27)));
        obj.setNationalteamId(cursor.getInt(28));
        obj.setCountryId(cursor.getInt(29));
        obj.setCaps(cursor.getInt(30));
        obj.setCapsU20(cursor.getInt(31));
        obj.setCards(cursor.getInt(32));
        obj.setInjuryLevel(cursor.getInt(33));
        obj.setStaminaSkill(cursor.getInt(34));
        obj.setKeeperSkill(cursor.getInt(35));
        obj.setPlaymakerSkill(cursor.getInt(36));
        obj.setScorerSkill(cursor.getInt(37));
        obj.setPassingSkill(cursor.getInt(38));
        obj.setWingerSkill(cursor.getInt(39));
        obj.setDefenderSkill(cursor.getInt(40));
        obj.setSetpiecesSkill(cursor.getInt(41));
        obj.setCategoryId(cursor.getInt(42));
        obj.setLastMatchDate(cursor.getString(43));
        obj.setLastMatchId(cursor.getInt(44));
        obj.setLastMatchPositionCode(cursor.getInt(45));
        obj.setLastMatchPlayedMinutes(cursor.getInt(46));
        obj.setLastMatchRating(cursor.getInt(47));
        obj.setLastMatchRatingEndOfGame(cursor.getInt(48));
        obj.setFetchedDate(cursor.getString(49));
        obj.setValidityTime(cursor.getInt(50));

        return obj;
    }
}
