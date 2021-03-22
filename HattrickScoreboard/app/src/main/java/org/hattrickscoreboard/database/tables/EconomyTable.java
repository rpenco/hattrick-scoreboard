package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DEconomy;

public class EconomyTable extends Table {

    // Table
    public static final String TABLE = "economy";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_CURRENT_CASH = "cash";
    public static final String COL_EXPECTED_CASH = "expectedCash";
    public static final String COL_SPONSORS_POPULARITY = "sponsorsPopularity";
    public static final String COL_SUPPORTERS_POPULARITY = "supportersPopularity";
    public static final String COL_INCOME_SPECTATORS = "incomeSpectators";
    public static final String COL_INCOME_SPONSORS = "incomeSponsors";
    public static final String COL_INCOME_FINANCIAL = "incomeFinancial";
    public static final String COL_INCOME_SOLD_PLAYERS = "incomeSoldPlayers";
    public static final String COL_INCOME_SOLD_PLAYERS_COMMISSION = "incomeSoldPlayersCommission";
    public static final String COL_INCOME_TEMPORARY = "incomeTemprary";
    public static final String COL_INCOME_SUM = "incomeSum";
    public static final String COL_COSTS_ARENA = "costsArena";
    public static final String COL_COSTS_PLAYERS = "costsPlayers";
    public static final String COL_COSTS_FINANCIAL = "ostsFinancial";
    public static final String COL_COSTS_STAFF = "costcsStaff";
    public static final String COL_COSTS_BOUGHTPLAYERS = "costsBoughtPlayers";
    public static final String COL_COSTS_ARENABUILDING = "costsArenaBuilding";
    public static final String COL_COSTS_TEMPORARY = "costsTemporary";
    public static final String COL_COSTS_YOUTH = "costsYouth";
    public static final String COL_COSTS_SUM = "costsSum";
    public static final String COL_EXPECTED_WEEKS_TOTAL = "expectedWeeksTotal";
    public static final String COL_LAST_INCOME_SPECTATORS = "lastIncomeSpectators";
    public static final String COL_LAST_INCOME_SPONSORS = "lastIncomeSponsors";
    public static final String COL_LAST_INCOME_FINANCIAL = "lastIncomeFinancial";
    public static final String COL_LAST_INCOME_SOLDPLAYERS = "lastIncomeSoldPlayers";
    public static final String COL_LAST_INCOME_SOLD_PLAYERS_COMMISSION = "lastIncomeSoldPlayersCommission";
    public static final String COL_LAST_INCOME_TEMPORARY = "lastIncomeTemporary";
    public static final String COL_LAST_INCOME_SUM = "lastIncomeSum";
    public static final String COL_LAST_COSTS_ARENA = "lastCostsArena";
    public static final String COL_LAST_COSTS_PLAYERS = "lastCostsPlayers";
    public static final String COL_LAST_COSTS_FINANCIAL = "lastCostsFinancial";
    public static final String COL_LAST_COSTS_STAFF = "lastCostsStaff";
    public static final String COL_LAST_COSTS_BOUGHT_PLAYERS = "lastCostsBoughtPlayers";
    public static final String COL_LAST_COSTS_ARENA_BUILDING = "lastCostsArenaBuilding";
    public static final String COL_LAST_COSTS_TEMPORARY = "lastCostsTemporary";
    public static final String COL_LAST_COSTS_YOUTH = "lastCostsYouth";
    public static final String COL_LAST_COSTS_SUM = "lastCostsSum";
    public static final String COL_LAST_WEEKS_TOTAL = "lastWeeksTotal";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {

            COL_ID, COL_TEAM_ID, COL_CURRENT_CASH, COL_EXPECTED_CASH,
            COL_SPONSORS_POPULARITY, COL_SUPPORTERS_POPULARITY,
            COL_INCOME_SPECTATORS, COL_INCOME_SPONSORS, COL_INCOME_FINANCIAL,
            COL_INCOME_SOLD_PLAYERS, COL_INCOME_SOLD_PLAYERS_COMMISSION,
            COL_INCOME_TEMPORARY, COL_INCOME_SUM, COL_COSTS_ARENA,
            COL_COSTS_PLAYERS, COL_COSTS_FINANCIAL, COL_COSTS_STAFF,
            COL_COSTS_BOUGHTPLAYERS, COL_COSTS_ARENABUILDING,
            COL_COSTS_TEMPORARY, COL_COSTS_YOUTH, COL_COSTS_SUM,
            COL_EXPECTED_WEEKS_TOTAL, COL_LAST_INCOME_SPECTATORS,
            COL_LAST_INCOME_SPONSORS, COL_LAST_INCOME_FINANCIAL,
            COL_LAST_INCOME_SOLDPLAYERS,
            COL_LAST_INCOME_SOLD_PLAYERS_COMMISSION, COL_LAST_INCOME_TEMPORARY,
            COL_LAST_INCOME_SUM, COL_LAST_COSTS_ARENA, COL_LAST_COSTS_PLAYERS,
            COL_LAST_COSTS_FINANCIAL, COL_LAST_COSTS_STAFF,
            COL_LAST_COSTS_BOUGHT_PLAYERS, COL_LAST_COSTS_ARENA_BUILDING,
            COL_LAST_COSTS_TEMPORARY, COL_LAST_COSTS_YOUTH, COL_LAST_COSTS_SUM,
            COL_LAST_WEEKS_TOTAL, COL_FETCHED_DATE, COL_VALIDITY_TIME

    };
    static final String TAG = (EconomyTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, "

            + COL_TEAM_ID + " integer not null, " + COL_CURRENT_CASH
            + " text, " + COL_EXPECTED_CASH + " text, "
            + COL_SPONSORS_POPULARITY + " integer, "
            + COL_SUPPORTERS_POPULARITY + " integer, " + COL_INCOME_SPECTATORS
            + " text, " + COL_INCOME_SPONSORS + " text, "
            + COL_INCOME_FINANCIAL + " text, " + COL_INCOME_SOLD_PLAYERS
            + " text, " + COL_INCOME_SOLD_PLAYERS_COMMISSION + " text, "
            + COL_INCOME_TEMPORARY + " text, " + COL_INCOME_SUM + " text, "
            + COL_COSTS_ARENA + " text, " + COL_COSTS_PLAYERS + " text, "
            + COL_COSTS_FINANCIAL + " text, " + COL_COSTS_STAFF + " text, "
            + COL_COSTS_BOUGHTPLAYERS + " text, " + COL_COSTS_ARENABUILDING
            + " text, " + COL_COSTS_TEMPORARY + " text, " + COL_COSTS_YOUTH
            + " text, " + COL_COSTS_SUM + " text, " + COL_EXPECTED_WEEKS_TOTAL
            + " text, " + COL_LAST_INCOME_SPECTATORS + " text, "
            + COL_LAST_INCOME_SPONSORS + " text, " + COL_LAST_INCOME_FINANCIAL
            + " text, " + COL_LAST_INCOME_SOLDPLAYERS + " text, "
            + COL_LAST_INCOME_SOLD_PLAYERS_COMMISSION + " text, "
            + COL_LAST_INCOME_TEMPORARY + " text, " + COL_LAST_INCOME_SUM
            + " text, " + COL_LAST_COSTS_ARENA + " text, "
            + COL_LAST_COSTS_PLAYERS + " text, " + COL_LAST_COSTS_FINANCIAL
            + " text, " + COL_LAST_COSTS_STAFF + " text, "
            + COL_LAST_COSTS_BOUGHT_PLAYERS + " text, "
            + COL_LAST_COSTS_ARENA_BUILDING + " text, "
            + COL_LAST_COSTS_TEMPORARY + " text, " + COL_LAST_COSTS_YOUTH
            + " text, " + COL_LAST_COSTS_SUM + " text, " + COL_LAST_WEEKS_TOTAL
            + " text, "
            + COL_FETCHED_DATE + " text not null, "
            + COL_VALIDITY_TIME + " int "
            + ");";

    // Super
    public EconomyTable() {
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
        DEconomy obj = new DEconomy();
        obj.setTeamID(cursor.getInt(1));

        obj.setCurrentCash(Double.parseDouble(cursor.getString(2)));
        obj.setExpectedCash(Double.parseDouble(cursor.getString(3)));
        obj.setSponsorsPopularity(cursor.getInt(4));
        obj.setSupportersPopularity(cursor.getInt(5));
        obj.setIncomeSpectators(Double.parseDouble(cursor.getString(6)));
        obj.setIncomeSponsors(Double.parseDouble(cursor.getString(7)));
        obj.setIncomeFinancial(Double.parseDouble(cursor.getString(8)));
        obj.setIncomeSold_players(Double.parseDouble(cursor.getString(9)));
        obj.setIncomeSold_playersCommission(Double.parseDouble(cursor
                .getString(10)));
        obj.setIncomeTemporary(Double.parseDouble(cursor.getString(11)));
        obj.setIncomeSum(Double.parseDouble(cursor.getString(12)));
        obj.setCostsArena(Double.parseDouble(cursor.getString(13)));
        obj.setCostsPlayers(Double.parseDouble(cursor.getString(14)));
        obj.setCostsFinancial(Double.parseDouble(cursor.getString(15)));
        obj.setCostsStaff(Double.parseDouble(cursor.getString(16)));
        obj.setCostsBoughtplayers(Double.parseDouble(cursor.getString(17)));
        obj.setCostsArenabuilding(Double.parseDouble(cursor.getString(18)));
        obj.setCostsTemporary(Double.parseDouble(cursor.getString(19)));
        obj.setCostsYouth(Double.parseDouble(cursor.getString(20)));
        obj.setCostsSum(Double.parseDouble(cursor.getString(21)));
        obj.setExpectedWeeksTotal(Double.parseDouble(cursor.getString(22)));
        obj.setLastIncomeSpectators(cursor.getInt(23));
        obj.setLastIncomeSponsors(cursor.getInt(24));
        obj.setLastIncomeFinancial(Double.parseDouble(cursor.getString(25)));
        obj.setLastIncomeSoldplayers(Double.parseDouble(cursor.getString(26)));
        obj.setLastIncomeSoldPlayersCommission(Double.parseDouble(cursor
                .getString(27)));
        obj.setLastIncomeTemporary(Double.parseDouble(cursor.getString(28)));
        obj.setLastIncomeSum(Double.parseDouble(cursor.getString(29)));
        obj.setLastCostsArena(Double.parseDouble(cursor.getString(30)));
        obj.setLastCostsPlayers(Double.parseDouble(cursor.getString(31)));
        obj.setLastCostsFinancial(Double.parseDouble(cursor.getString(32)));
        obj.setLastCostsStaff(Double.parseDouble(cursor.getString(33)));
        obj.setLastCostsBought_players(Double.parseDouble(cursor.getString(34)));
        obj.setLastCostsArena_building(Double.parseDouble(cursor.getString(35)));
        obj.setLastCostsTemporary(Double.parseDouble(cursor.getString(36)));
        obj.setLastCostsYouth(Double.parseDouble(cursor.getString(37)));
        obj.setLastCostsSum(Double.parseDouble(cursor.getString(38)));
        obj.setLastWeeksTotal(Double.parseDouble(cursor.getString(39)));
        obj.setFetchedDate(cursor.getString(40));
        obj.setValidityTime(cursor.getInt(41));
        return obj;
    }
}
