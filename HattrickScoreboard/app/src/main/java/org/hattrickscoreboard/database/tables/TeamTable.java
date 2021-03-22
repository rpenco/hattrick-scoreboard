package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DTeam;

public class TeamTable extends Table {

    // Table
    public static final String TABLE = "teams";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_USER_ID = "userID";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_TEAM_NAME = "teamName";
    public static final String COL_TEAM_SHORT_NAME = "shortTeamName";
    public static final String COL_PRIMARY_CLUB = "isPrimaryClub";
    public static final String COL_FOUNDED_DATE = "foundedDate";
    public static final String COL_ARENA_ID = "arenaID";
    public static final String COL_ARENA_NAME = "arenaName";
    public static final String COL_LEAGUE_ID = "leagueID";
    public static final String COL_LEAGUE_NAME = "leagueName";
    public static final String COL_REGION_ID = "regionID";
    public static final String COL_REGION_NAME = "regionName";
    public static final String COL_TRAINER_ID = "playerID";
    public static final String COL_HOME_PAGE = "homePage";
    public static final String COL_DRESS_URI = "dressURI";
    public static final String COL_DRESS_ALT_URI = "dressAlternateURI";
    public static final String COL_LEAGUE_LEVEL_ID = "leagueLevelUnitID";
    public static final String COL_LEAGUE_LEVEL_NAME = "leagueLevelUnitName";
    public static final String COL_BOT = "isBot";
    public static final String COL_STILL_CUP = "stillInCup";
    public static final String COL_CUP_ID = "cupID";
    public static final String COL_CUP_NAME = "cupName";
    public static final String COL_FRIENDLY_ID = "friendlyTeamID";
    public static final String COL_VICTORIES = "numberOfVictories";
    public static final String COL_UNDEFEATED = "numberOfUndefeated";
    public static final String COL_RANK = "teamRank";
    public static final String COL_FAN_ID = "fanclubID";
    public static final String COL_FAN_NAME = "fanclubName";
    public static final String COL_FAN_SIZE = "fanclubSize";
    public static final String COL_LOGO_URL = "logoURL";
    public static final String COL_YOUTH_ID = "youthTeamID";
    public static final String COL_YOUTH_NAME = "youthTeamName";
    public static final String COL_VISITS = "numberOfVisits";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    public static final String COL_CUP_LEAGUE_LEVEL = "cupLeagueLevel";
    public static final String COL_CUP_LEVEL = "cupLevel";
    public static final String COL_CUP_LEVEL_INDEX = "cupLevelIndex";
    public static final String COL_CUP_MATCH_ROUND = "cupMatchRound";
    public static final String COL_CUP_MATCH_ROUNDS_LEFT = "cupMatchRoundsLeft";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_USER_ID,
            COL_TEAM_ID, COL_TEAM_NAME, COL_TEAM_SHORT_NAME, COL_PRIMARY_CLUB,
            COL_FOUNDED_DATE, COL_ARENA_ID, COL_ARENA_NAME, COL_LEAGUE_ID,
            COL_LEAGUE_NAME, COL_REGION_ID, COL_REGION_NAME, COL_TRAINER_ID,
            COL_HOME_PAGE, COL_DRESS_URI, COL_DRESS_ALT_URI,
            COL_LEAGUE_LEVEL_ID, COL_LEAGUE_LEVEL_NAME, COL_BOT, COL_STILL_CUP,
            COL_CUP_ID, COL_CUP_NAME, COL_FRIENDLY_ID, COL_VICTORIES,
            COL_UNDEFEATED, COL_RANK, COL_FAN_ID, COL_FAN_NAME, COL_FAN_SIZE,
            COL_LOGO_URL, COL_YOUTH_ID, COL_YOUTH_NAME, COL_VISITS,
            COL_FETCHED_DATE, COL_VALIDITY_TIME,

            COL_CUP_LEAGUE_LEVEL, COL_CUP_LEVEL, COL_CUP_LEVEL_INDEX,
            COL_CUP_MATCH_ROUND, COL_CUP_MATCH_ROUNDS_LEFT

    };
    static final String TAG = (TeamTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_USER_ID
            + " integer not null, " + COL_TEAM_ID + " integer not null, "
            + COL_TEAM_NAME + " text not null, " + COL_TEAM_SHORT_NAME
            + " text not null, " + COL_PRIMARY_CLUB + " text not null, "
            + COL_FOUNDED_DATE + " text not null, " + COL_ARENA_ID
            + " integer not null, " + COL_ARENA_NAME + " text not null, "
            + COL_LEAGUE_ID + " integer not null, " + COL_LEAGUE_NAME
            + " text not null, " + COL_REGION_ID + " integer not null, "
            + COL_REGION_NAME + " text not null, " + COL_TRAINER_ID
            + " integer not null, " + COL_HOME_PAGE + " text, " + COL_DRESS_URI
            + " text not null, " + COL_DRESS_ALT_URI + " text not null, "
            + COL_LEAGUE_LEVEL_ID + " integer not null, "
            + COL_LEAGUE_LEVEL_NAME + " text not null, " + COL_BOT
            + " text not null, " + COL_STILL_CUP + " text not null, "
            + COL_CUP_ID + " integer, " + COL_CUP_NAME + " text, "
            + COL_FRIENDLY_ID + " integer, " + COL_VICTORIES + " integer, "
            + COL_UNDEFEATED + " integer, " + COL_RANK + " integer not null, "
            + COL_FAN_ID + " integer, " + COL_FAN_NAME + " text, "
            + COL_FAN_SIZE + " integer not null, " + COL_LOGO_URL + " text, "
            + COL_YOUTH_ID + " integer , " + COL_YOUTH_NAME + " text, "
            + COL_VISITS + " integer, " + COL_FETCHED_DATE + " text not null, "
            + COL_VALIDITY_TIME + " integer, " + COL_CUP_LEAGUE_LEVEL
            + " integer, " + COL_CUP_LEVEL + " integer, " + COL_CUP_LEVEL_INDEX
            + " integer, " + COL_CUP_MATCH_ROUND + " integer, "
            + COL_CUP_MATCH_ROUNDS_LEFT + " integer " + ");";

    // Super
    public TeamTable() {
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

        if (cursor.getCount() == 0)
            return null;

        // Set values
        DTeam obj = new DTeam();
        obj.setId(cursor.getLong(0));
        obj.setUserID(cursor.getInt(1));
        obj.setTeamID(cursor.getInt(2));
        obj.setTeamName(cursor.getString(3));
        obj.setShortTeamName(cursor.getString(4));
        obj.setIsPrimaryClub(cursor.getString(5));
        obj.setFoundedDate(cursor.getString(6));
        obj.setArenaID(cursor.getInt(7));
        obj.setArenaName(cursor.getString(8));
        obj.setLeagueID(cursor.getInt(9));
        obj.setLeagueName(cursor.getString(10));
        obj.setRegionID(cursor.getInt(11));
        obj.setRegionName(cursor.getString(12));
        obj.setTrainerID(cursor.getInt(13));
        obj.setHomePage(cursor.getString(14));
        obj.setDressURI(cursor.getString(15));
        obj.setDressAlternateURI(cursor.getString(16));
        obj.setLeagueLevelUnitID(cursor.getInt(17));
        obj.setLeagueLevelUnitName(cursor.getString(18));
        obj.setBot(cursor.getString(19));
        obj.setStillInCup(cursor.getString(20));
        obj.setCupID(cursor.getInt(21));
        obj.setCupName(cursor.getString(22));
        obj.setFriendlyTeamID(cursor.getInt(23));
        obj.setNumberOfVictories(cursor.getInt(24));
        obj.setNumberOfUndefeated(cursor.getInt(25));
        obj.setTeamRank(cursor.getInt(26));
        obj.setFanclubID(cursor.getInt(27));
        obj.setFanclubName(cursor.getString(28));
        obj.setFanclubSize(cursor.getInt(29));
        obj.setLogoURL(cursor.getString(30));
        obj.setYouthTeamID(cursor.getInt(31));
        obj.setYouthTeamName(cursor.getString(32));
        obj.setNumberOfVisits(cursor.getInt(33));
        obj.setFetchedDate(cursor.getString(34));
        obj.setValidityTime(Integer.parseInt(cursor.getString(35)));
        obj.setCupLeagueLevel(cursor.getInt(36));
        obj.setCupLevel(cursor.getInt(37));
        obj.setCupLevelIndex(cursor.getInt(38));
        obj.setCupMatchRound(cursor.getInt(39));
        obj.setCupMatchRoundsLeft(cursor.getInt(40));

        return obj;
    }
}
