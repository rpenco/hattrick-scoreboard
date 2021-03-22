package org.hattrickscoreboard.database.tables.match;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.tables.Table;

public class MatchesTable extends Table {

    // Table
    public static final String TABLE = "matches";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_MATCH_ID = "MatchID";
    public static final String COL_SOURCE_SYSTEM = "SourceSystem";
    public static final String COL_MATCH_YOUTH = "IsYouth";
    public static final String COL_MATCH_DATE = "MatchDate";
    public static final String COL_MATCH_TYPE = "MatchType";
    public static final String COL_MATCH_CONTEXT_ID = "MatchContext";
    public static final String COL_HOME_TEAM_ID = "HomeTeamID";
    public static final String COL_HOME_TEAM_NAME = "HomeTeamName";
    public static final String COL_HOME_TEAM_SHORT_NAME = "HomeTeamShortName";
    public static final String COL_HOME_TEAM_FORMATION = "HomeFormation";
    public static final String COL_HOME_TACTIC_TYPE = "HomeTacticType";
    public static final String COL_HOME_TACTIC_SKILL = "HomeTacticSkill";
    public static final String COL_HOME_EXPERIENCE_LEVEL = "HomeExperienceLevel";
    public static final String COL_HOME_DRESS_URI = "HomeDressURI";
    public static final String COL_HOME_TEAM_ATTITUDE = "HomeTeamAttitude";
    public static final String COL_HOME_RATING_MID_FIELD = "HomeRatingMidfield";
    public static final String COL_HOME_RATING_RIGHT_DEF = "HomeRatingRightDef";
    public static final String COL_HOME_RATING_MID_DEF = "HomeRatingMidDef";
    public static final String COL_HOME_RATING_LEFT_DEF = "HomeRatingLeftDef";
    public static final String COL_HOME_RATING_RIGHT_ATT = "HomeRatingRightAtt";
    public static final String COL_HOME_RATING_MID_ATT = "HomeRatingMidAtt";
    public static final String COL_HOME_RATING_LEFT_ATT = "HomeRatingLeftAtt";
    public static final String COL_HOME_RATING_INDIRECT_SET_PIECES_DEF = "HomeRatingIndirectSetPiecesDef";
    public static final String COL_HOME_RATING_INDIRECT_SET_PIECES_ATT = "HomeRatingIndirectSetPiecesAtt";
    public static final String COL_AWAY_TEAM_ID = "awayTeamId";
    public static final String COL_AWAY_TEAM_NAME = "awayTeamName";
    public static final String COL_AWAY_TEAM_SHORT_NAME = "awayTeamShortName";
    public static final String COL_AWAY_TEAM_FORMATION = "AwayFormation";
    public static final String COL_AWAY_TACTIC_TYPE = "AwayTacticType";
    public static final String COL_AWAY_TACTIC_SKILL = "AwayTacticSkill";
    public static final String COL_AWAY_EXPERIENCE_LEVEL = "AwayExperienceLevel";
    public static final String COL_AWAY_DRESS_URI = "AwayDressURI";
    public static final String COL_AWAY_TEAM_ATTITUDE = "AwayTeamAttitude";
    public static final String COL_AWAY_RATING_MID_FIELD = "AwayRatingMidfield";
    public static final String COL_AWAY_RATING_RIGHT_DEF = "AwayRatingRightDef";
    public static final String COL_AWAY_RATING_MID_DEF = "AwayRatingMidDef";
    public static final String COL_AWAY_RATING_LEFT_DEF = "AwayRatingLeftDef";
    public static final String COL_AWAY_RATING_RIGHT_ATT = "AwayRatingRightAtt";
    public static final String COL_AWAY_RATING_MID_ATT = "AwayRatingMidAtt";
    public static final String COL_AWAY_RATING_LEFT_ATT = "AwayRatingLeftAtt";
    public static final String COL_AWAY_RATING_INDIRECT_SET_PIECES_DEF = "AwayRatingIndirectSetPiecesDef";
    public static final String COL_AWAY_RATING_INDIRECT_SET_PIECES_ATT = "AwayRatingIndirectSetPiecesAtt";
    public static final String COL_ARENA_ID = "ArenaID";
    public static final String COL_ARENA_NAME = "ArenaName";
    public static final String COL_WEATHER_ID = "WeatherID";
    public static final String COL_SOLD_TOTAL = "SoldTotal";
    public static final String COL_SOLD_TERRACES = "SoldTerraces";
    public static final String COL_SOLD_BASIC = "SoldBasic";
    public static final String COL_SOLD_ROOF = "SoldRoof";
    public static final String COL_SOLD_VIP = "SoldVIP";
    public static final String COL_POSSESSION_FIRST_HALF_HOME = "PossessionFirstHalfHome";
    public static final String COL_POSSESSION_FIRST_HALF_AWAY = "PossessionFirstHalfAway";
    public static final String COL_POSSESSION_SECOND_HALF_HOME = "PossessionSecondHalfHome";
    public static final String COL_POSSESSION_SECOND_HALF_AWAY = "PossessionSecondHalfAway";
    public static final String COL_HOME_GOALS = "homeGoals";
    public static final String COL_AWAY_GOALS = "awayGoals";
    public static final String COL_MATCH_FINISHED_DATE = "MatchFinishedDate";
    public static final String COL_STATUS = "matchStatus";
    public static final String COL_ORDERS_GIVEN = "OrdersGiven";
    public static final String COL_REFEREE = "Referee";
    public static final String COL_REFEREE_ASSISTANT_1 = "RefereeAssistant1";
    public static final String COL_REFEREE_ASSISTANT_2 = "RefereeAssistant2";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID, COL_MATCH_ID, COL_SOURCE_SYSTEM, COL_MATCH_YOUTH, COL_MATCH_DATE,
            COL_MATCH_TYPE, COL_MATCH_CONTEXT_ID,

            COL_HOME_TEAM_ID, COL_HOME_TEAM_NAME, COL_HOME_TEAM_SHORT_NAME,
            COL_HOME_TEAM_FORMATION, COL_HOME_TACTIC_TYPE,
            COL_HOME_TACTIC_SKILL, COL_HOME_EXPERIENCE_LEVEL,
            COL_HOME_DRESS_URI, COL_HOME_TEAM_ATTITUDE,
            COL_HOME_RATING_MID_FIELD, COL_HOME_RATING_RIGHT_DEF,
            COL_HOME_RATING_MID_DEF, COL_HOME_RATING_LEFT_DEF,
            COL_HOME_RATING_RIGHT_ATT, COL_HOME_RATING_MID_ATT,
            COL_HOME_RATING_LEFT_ATT, COL_HOME_RATING_INDIRECT_SET_PIECES_DEF,
            COL_HOME_RATING_INDIRECT_SET_PIECES_ATT,

            COL_AWAY_TEAM_ID, COL_AWAY_TEAM_NAME, COL_AWAY_TEAM_SHORT_NAME,
            COL_AWAY_TEAM_FORMATION, COL_AWAY_TACTIC_TYPE,
            COL_AWAY_TACTIC_SKILL, COL_AWAY_EXPERIENCE_LEVEL,
            COL_AWAY_DRESS_URI, COL_AWAY_TEAM_ATTITUDE,
            COL_AWAY_RATING_MID_FIELD, COL_AWAY_RATING_RIGHT_DEF,
            COL_AWAY_RATING_MID_DEF, COL_AWAY_RATING_LEFT_DEF,
            COL_AWAY_RATING_RIGHT_ATT, COL_AWAY_RATING_MID_ATT,
            COL_AWAY_RATING_LEFT_ATT, COL_AWAY_RATING_INDIRECT_SET_PIECES_DEF,
            COL_AWAY_RATING_INDIRECT_SET_PIECES_ATT,

            COL_ARENA_ID, COL_ARENA_NAME, COL_WEATHER_ID, COL_SOLD_TOTAL,
            COL_SOLD_TERRACES, COL_SOLD_BASIC, COL_SOLD_ROOF, COL_SOLD_VIP,

            COL_POSSESSION_FIRST_HALF_HOME, COL_POSSESSION_FIRST_HALF_AWAY,
            COL_POSSESSION_SECOND_HALF_HOME, COL_POSSESSION_SECOND_HALF_AWAY,
            COL_HOME_GOALS, COL_AWAY_GOALS, COL_MATCH_FINISHED_DATE,
            COL_STATUS, COL_ORDERS_GIVEN, COL_REFEREE, COL_REFEREE_ASSISTANT_1,
            COL_REFEREE_ASSISTANT_2, COL_FETCHED_DATE, COL_VALIDITY_TIME

    };
    static final String TAG = (MatchesTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_MATCH_ID
            + " integer not null, " + COL_SOURCE_SYSTEM + " integer, "
            + COL_MATCH_YOUTH + " text, " + COL_MATCH_DATE + " text, "
            + COL_MATCH_TYPE + " integer, " + COL_MATCH_CONTEXT_ID
            + " integer, " + COL_HOME_TEAM_ID + " integer, "
            + COL_HOME_TEAM_NAME + " text, " + COL_HOME_TEAM_SHORT_NAME
            + " text, " + COL_HOME_TEAM_FORMATION + " text, "
            + COL_HOME_TACTIC_TYPE + " integer, " + COL_HOME_TACTIC_SKILL
            + " integer, " + COL_HOME_EXPERIENCE_LEVEL + " integer, "
            + COL_HOME_DRESS_URI + " text, " + COL_HOME_TEAM_ATTITUDE
            + " integer, " + COL_HOME_RATING_MID_FIELD + " integer, "
            + COL_HOME_RATING_RIGHT_DEF + " integer, "
            + COL_HOME_RATING_MID_DEF + " integer, " + COL_HOME_RATING_LEFT_DEF
            + " integer, " + COL_HOME_RATING_RIGHT_ATT + " integer, "
            + COL_HOME_RATING_MID_ATT + " integer, " + COL_HOME_RATING_LEFT_ATT
            + " integer, " + COL_HOME_RATING_INDIRECT_SET_PIECES_DEF
            + " integer, " + COL_HOME_RATING_INDIRECT_SET_PIECES_ATT
            + " integer, "

            + COL_AWAY_TEAM_ID + " integer, " + COL_AWAY_TEAM_NAME + " text, "
            + COL_AWAY_TEAM_SHORT_NAME + " text, " + COL_AWAY_TEAM_FORMATION
            + " text, " + COL_AWAY_TACTIC_TYPE + " integer, "
            + COL_AWAY_TACTIC_SKILL + " integer, " + COL_AWAY_EXPERIENCE_LEVEL
            + " integer, " + COL_AWAY_DRESS_URI + " text, "
            + COL_AWAY_TEAM_ATTITUDE + " integer, " + COL_AWAY_RATING_MID_FIELD
            + " integer, " + COL_AWAY_RATING_RIGHT_DEF + " integer, "
            + COL_AWAY_RATING_MID_DEF + " integer, " + COL_AWAY_RATING_LEFT_DEF
            + " integer, " + COL_AWAY_RATING_RIGHT_ATT + " integer, "
            + COL_AWAY_RATING_MID_ATT + " integer, " + COL_AWAY_RATING_LEFT_ATT
            + " integer, " + COL_AWAY_RATING_INDIRECT_SET_PIECES_DEF
            + " integer, " + COL_AWAY_RATING_INDIRECT_SET_PIECES_ATT
            + " integer, "

            + COL_ARENA_ID + " integer, " + COL_ARENA_NAME + " text, "
            + COL_WEATHER_ID + " integer, " + COL_SOLD_TOTAL + " integer, "
            + COL_SOLD_TERRACES + " integer, " + COL_SOLD_BASIC + " integer, "
            + COL_SOLD_ROOF + " integer, " + COL_SOLD_VIP + " integer, "

            + COL_POSSESSION_FIRST_HALF_HOME + " integer, "
            + COL_POSSESSION_FIRST_HALF_AWAY + " integer, "
            + COL_POSSESSION_SECOND_HALF_HOME + " integer, "
            + COL_POSSESSION_SECOND_HALF_AWAY + " integer, " + COL_HOME_GOALS
            + " integer, " + COL_AWAY_GOALS + " integer, "
            + COL_MATCH_FINISHED_DATE + " text, " + COL_STATUS + " text, "
            + COL_ORDERS_GIVEN + " text, " + COL_REFEREE + " integer, "
            + COL_REFEREE_ASSISTANT_1 + " integer, " + COL_REFEREE_ASSISTANT_2
            + " integer, " + COL_FETCHED_DATE + " text, " + COL_VALIDITY_TIME
            + " integer "

            + ");";

    // Super
    public MatchesTable() {
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
        Match obj = new Match();
        obj.setID(cursor.getLong(0));
        obj.setMatchID(cursor.getInt(1));
        obj.setSourceSystem(cursor.getString(2));
        obj.setMatchYouth(cursor.getString(3));
        obj.setMatchDate(cursor.getString(4));
        obj.setMatchType(cursor.getInt(5));
        obj.setMatchContext(cursor.getInt(6));

        obj.setHomeTeamID(cursor.getInt(7));
        obj.setHomeTeamName(cursor.getString(8));
        obj.setHomeTeamShortName(cursor.getString(9));
        obj.setHomeFormation(cursor.getString(10));
        obj.setHomeTacticType(cursor.getInt(11));
        obj.setHomeTacticSkill(cursor.getInt(12));
        obj.setHomeExperienceLevel(cursor.getInt(13));
        obj.setHomeDressURI(cursor.getString(14));
        obj.setHomeTeamAttitude(cursor.getInt(15));
        obj.setHomeRatingMidfield(cursor.getInt(16));
        obj.setHomeRatingRightDef(cursor.getInt(17));
        obj.setHomeRatingMidDef(cursor.getInt(18));
        obj.setHomeRatingLeftDef(cursor.getInt(19));
        obj.setHomeRatingRightAtt(cursor.getInt(20));
        obj.setHomeRatingMidAtt(cursor.getInt(21));
        obj.setHomeRatingLeftAtt(cursor.getInt(22));
        obj.setHomeRatingIndirectSetPiecesDef(cursor.getInt(23));
        obj.setHomeRatingIndirectSetPiecesAtt(cursor.getInt(24));

        obj.setAwayTeamID(cursor.getInt(25));
        obj.setAwayTeamName(cursor.getString(26));
        obj.setAwayTeamShortName(cursor.getString(27));
        obj.setAwayFormation(cursor.getString(28));
        obj.setAwayTacticType(cursor.getInt(29));
        obj.setAwayTacticSkill(cursor.getInt(30));
        obj.setAwayExperienceLevel(cursor.getInt(31));
        obj.setAwayDressURI(cursor.getString(32));
        obj.setAwayTeamAttitude(cursor.getInt(33));
        obj.setAwayRatingMidfield(cursor.getInt(34));
        obj.setAwayRatingRightDef(cursor.getInt(35));
        obj.setAwayRatingMidDef(cursor.getInt(36));
        obj.setAwayRatingLeftDef(cursor.getInt(37));
        obj.setAwayRatingRightAtt(cursor.getInt(38));
        obj.setAwayRatingMidAtt(cursor.getInt(39));
        obj.setAwayRatingLeftAtt(cursor.getInt(40));
        obj.setAwayRatingIndirectSetPiecesDef(cursor.getInt(41));
        obj.setAwayRatingIndirectSetPiecesAtt(cursor.getInt(42));

        obj.setArenaID(cursor.getInt(43));
        obj.setArenaName(cursor.getString(44));
        obj.setWeatherID(cursor.getInt(45));
        obj.setSoldTotal(cursor.getInt(46));
        obj.setSoldTerraces(cursor.getInt(47));
        obj.setSoldBasic(cursor.getInt(48));
        obj.setSoldRoof(cursor.getInt(49));
        obj.setSoldVIP(cursor.getInt(50));

        obj.setPossessionFirstHalfHome(cursor.getInt(51));
        obj.setPossessionFirstHalfAway(cursor.getInt(52));
        obj.setPossessionSecondHalfHome(cursor.getInt(53));
        obj.setPossessionSecondHalfAway(cursor.getInt(54));
        obj.setHomeGoals(cursor.getInt(55));
        obj.setAwayGoals(cursor.getInt(56));
        obj.setMatchFinishedDate(cursor.getString(57));
        obj.setMatchStatus(cursor.getString(58));
        obj.setOrdersGiven(cursor.getString(59));

        obj.setReferee(cursor.getInt(60));
        obj.setRefereeAssistant1(cursor.getInt(61));
        obj.setRefereeAssistant2(cursor.getInt(62));
        obj.setFetchedDate(cursor.getString(63));
        obj.setValidityTime(cursor.getInt(64));
        return obj;
    }
}
