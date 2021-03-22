package org.hattrickscoreboard.database.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.database.models.DTransfer;

public class TransfersTable extends Table {

    // Table
    public static final String TABLE = "transfers";
    // Columns
    public static final String COL_ID = "_id";
    public static final String COL_TEAM_ID = "teamID";
    public static final String COL_TRANSFER_ID = "transferID";
    public static final String COL_DEAD_LINE = "deadLine";
    public static final String COL_TYPE = "transferType";
    public static final String COL_PRICE = "price";
    public static final String COL_PLAYER_ID = "playerID";
    public static final String COL_PLAYER_NAME = "playerName";
    public static final String COL_TSI = "playerTSI";
    public static final String COL_BUYER_TEAM_ID = "buyerID";
    public static final String COL_BUYER_TEAM_NAME = "buyerName";
    public static final String COL_SELLER_TEAM_ID = "sellerID";
    public static final String COL_SELLER_TEAM_NAME = "sellerName";
    public static final String COL_FETCHED_DATE = "fetchedDate";
    public static final String COL_VALIDITY_TIME = "validityTime";
    // All in One
    public static final String[] ALL_COLUMNS = {COL_ID, COL_TEAM_ID,
            COL_TRANSFER_ID, COL_DEAD_LINE, COL_TYPE, COL_PRICE, COL_PLAYER_ID,
            COL_PLAYER_NAME, COL_TSI, COL_BUYER_TEAM_ID, COL_BUYER_TEAM_NAME,
            COL_SELLER_TEAM_ID, COL_SELLER_TEAM_NAME, COL_FETCHED_DATE,
            COL_VALIDITY_TIME};
    static final String TAG = (TransfersTable.class).getSimpleName();
    // Table creation SQL statement
    private static final String TABLE_CREATE = "create table " + TABLE + "("
            + COL_ID + " integer primary key autoincrement, " + COL_TEAM_ID
            + " integer not null, " + COL_TRANSFER_ID + " integer not null, "
            + COL_DEAD_LINE + " text not null, " + COL_TYPE
            + " text not null, " + COL_PRICE + " text not null, "
            + COL_PLAYER_ID + " integer not null, " + COL_PLAYER_NAME
            + " text not null, " + COL_TSI + " integer not null, "
            + COL_BUYER_TEAM_ID + " integer, " + COL_BUYER_TEAM_NAME
            + " text, " + COL_SELLER_TEAM_ID + " integer, "
            + COL_SELLER_TEAM_NAME + " text, " + COL_FETCHED_DATE + " text, "
            + COL_VALIDITY_TIME + " integer " + ");";

    // Super
    public TransfersTable() {
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
        DTransfer obj = new DTransfer();
        obj.setTeamID(cursor.getInt(1));
        obj.setTransferID(cursor.getInt(2));
        obj.setDeadLine(cursor.getString(3));
        obj.setTransferType(cursor.getString(4));
        obj.setPrice(Double.parseDouble(cursor.getString(5)));
        obj.setPlayerID(cursor.getInt(6));
        obj.setPlayerName(cursor.getString(7));
        obj.setPlayerTSI(cursor.getInt(8));
        obj.setBuyerID(cursor.getInt(9));
        obj.setBuyerName(cursor.getString(10));
        obj.setSellerID(cursor.getInt(11));
        obj.setSellerName(cursor.getString(12));
        obj.setFetchedDate(cursor.getString(13));
        obj.setValidityTime(cursor.getInt(14));

        return obj;
    }
}
