package org.hattrickscoreboard.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.database.models.DModel;
import org.hattrickscoreboard.database.tables.Table;

import java.util.ArrayList;

public class HattrickBDD {

    public static final String TAG = (HattrickBDD.class).getSimpleName();

    public static final int DATABASE_VERSION = 41;
    public static final String DATABASE_NAME = "scoreboard.db";

    // Database fields
    private SQLiteDatabase database;
    private HattrickBDDHelper dbHelper;

    public HattrickBDD(Context context) {
        dbHelper = new HattrickBDDHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // ////////////////////////////////////////

    public long create(Class<? extends Table> table, ContentValues values) {

        try {
            Table tab = table.newInstance();
            return tab.create(database, values);
        } catch (InstantiationException | IllegalAccessException e) {
            Log.e(TAG, "create ", e);
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public <T, U> ArrayList<U> readAll(Class<T> table, Class<U> cls,
                                       String whereClause) {

        Cursor cursor = null;
        try {

            T tab = table.newInstance();

            ArrayList<U> result = new ArrayList<>();

            cursor = database.query(((Table) tab).getTableName(),
                    ((Table) tab).getAllColumns(), whereClause, null, null,
                    null, null);

            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                while (!cursor.isAfterLast()) {
                    U obj = (U) ((Table) tab).cursorTo(cursor);
                    result.add(obj);
                    cursor.moveToNext();
                }
                // make sure to close the cursor
                cursor.close();

                return result;
            } else {
                return null;
            }

        } catch (InstantiationException | IllegalAccessException e) {
            Log.e(TAG, "readAll", e);
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return new ArrayList<U>();
    }

    public <T> Object read(Class<T> table, String whereClause) {

        Cursor cursor = null;

        try {

            T tab = table.newInstance();

            cursor = database.query(((Table) tab).getTableName(),
                    ((Table) tab).getAllColumns(), whereClause, null, null,
                    null, null);
            cursor.moveToFirst();

            Object result = null;
            if (cursor.getCount() != 0) {
                result = ((Table) tab).cursorTo(cursor);
            }
            cursor.close();
            return result;

        } catch (InstantiationException | IllegalAccessException e) {
            Log.e(TAG, "read", e);
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public <T> int delete(Class<T> table, String whereClause) {
        try {
            T tab = table.newInstance();
            return database.delete(((Table) tab).getTableName(), whereClause,
                    null);

        } catch (InstantiationException | IllegalAccessException e) {
            Log.e(TAG, "delete", e);
        }

        return -1;
    }

    public <T> long update(Class<T> table, ContentValues values,
                           String whereClause) {
        try {
            T tab = table.newInstance();
            return ((Table) tab).update(database, values, whereClause);
        } catch (InstantiationException | IllegalAccessException e) {
            Log.e(TAG, "update", e);
        }
        return -1;
    }

    // ////////////////////////////////////////

    public <T> long createOrUpdate(Class<? extends Table> table,
                                   ContentValues values, String whereClause) {

        long id = update(table, values, whereClause);
        if (id > 0) {
            Log.i(TAG, "Update '" + table.getSimpleName() + "' :  [" + id
                    + "] ");
        } else if (id == 0) {
            id = create(table, values);
            Log.i(TAG, "Create row into '" + table.getSimpleName() + "' :  ["
                    + id + "] ");

        }
        return id;
    }

    /**
     * Check if row need update. Row must have column "fetchedDate" and
     * "validdityTime" and model must extend DModel to check fetched and
     * validity date time.
     *
     * @param table
     * @param forceUpdate
     * @param whereClause
     * @return
     */
    public <T> boolean needUpdate(Class<? extends Table> table,
                                  boolean forceUpdate, String whereClause) {

        // Check if need update...
        DModel obj = (DModel) read(table, whereClause);

        // Check if need update
        if (obj != null // obj exist
                && !forceUpdate// not forced
                && !HattrickDate.needUpdate(obj.getFetchedDate(), // Valid
                obj.getValidityTime())) {
            return false;
        }
        return true;
    }

}
