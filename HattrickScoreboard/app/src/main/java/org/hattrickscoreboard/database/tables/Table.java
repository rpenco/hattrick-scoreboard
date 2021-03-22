package org.hattrickscoreboard.database.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class Table {

    static final String TAG = (Table.class).getSimpleName();

    String TABLE;
    String[] ALL_COLUMNS;
    String TABLE_CREATE;

    public Table(String table, String[] allColumns, String tableCreate) {
        this.TABLE = table;
        this.ALL_COLUMNS = allColumns;
        this.TABLE_CREATE = tableCreate;
    }

    public String getTableName() {
        return TABLE;
    }

    public String[] getAllColumns() {
        return ALL_COLUMNS;
    }

    // /////////////////////////////////////////

    /**
     * Insert into table
     *
     * @param database
     * @param values
     * @return new id
     */
    public long create(SQLiteDatabase database, ContentValues values) {
        return database.insert(TABLE, null, values);
    }

    /**
     * Read a row
     *
     * @param database
     * @param values
     * @return object result
     */
    public Object read(SQLiteDatabase database, ContentValues values) {
        // database.query(table, columns, selection, selectionArgs, groupBy,
        // having, orderBy, limit)(null, null, values);
        return null;
    }

    /**
     * Update a row
     *
     * @param database
     * @param values
     * @return id updated
     */
    public long update(SQLiteDatabase database, ContentValues values,
                       String whereClause) {
        return database.update(TABLE, values, whereClause, null);
    }

    /**
     * Delete row
     *
     * @param database
     * @param values
     * @return
     */
    public long delete(SQLiteDatabase database, String whereClause) {
        return database.delete(TABLE, whereClause, null);
    }

    public Object cursorTo(Cursor cursor) {
        return new Object();
    }

}
