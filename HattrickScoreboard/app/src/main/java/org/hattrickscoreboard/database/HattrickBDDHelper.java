package org.hattrickscoreboard.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.hattrickscoreboard.database.tables.ArenaTable;
import org.hattrickscoreboard.database.tables.BookmarksTable;
import org.hattrickscoreboard.database.tables.ClubTable;
import org.hattrickscoreboard.database.tables.EconomyTable;
import org.hattrickscoreboard.database.tables.LanguagesTable;
import org.hattrickscoreboard.database.tables.LiveTable;
import org.hattrickscoreboard.database.tables.NationalCupTable;
import org.hattrickscoreboard.database.tables.PlayersTable;
import org.hattrickscoreboard.database.tables.SeriesFixturesTable;
import org.hattrickscoreboard.database.tables.SeriesTable;
import org.hattrickscoreboard.database.tables.StaffTable;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.TrainingTable;
import org.hattrickscoreboard.database.tables.TransfersTable;
import org.hattrickscoreboard.database.tables.WorldTable;
import org.hattrickscoreboard.database.tables.match.BookingsTable;
import org.hattrickscoreboard.database.tables.match.EventsTable;
import org.hattrickscoreboard.database.tables.match.InjuriesTable;
import org.hattrickscoreboard.database.tables.match.LineupTable;
import org.hattrickscoreboard.database.tables.match.MatchesTable;
import org.hattrickscoreboard.database.tables.match.RefereesTable;
import org.hattrickscoreboard.database.tables.match.ScorersTable;
import org.hattrickscoreboard.database.tables.match.SubstitutionsTable;

public class HattrickBDDHelper extends SQLiteOpenHelper {

    private static final String TAG = (HattrickBDDHelper.class).getSimpleName();

    public HattrickBDDHelper(Context context) {
        super(context, HattrickBDD.DATABASE_NAME, null,
                HattrickBDD.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        // Creation
        LanguagesTable.onCreate(database);
        ArenaTable.onCreate(database);
        TeamTable.onCreate(database);
        StaffTable.onCreate(database);
        ClubTable.onCreate(database);
        SeriesTable.onCreate(database);
        PlayersTable.onCreate(database);
        TransfersTable.onCreate(database);
        MatchesTable.onCreate(database);
        EconomyTable.onCreate(database);
        TrainingTable.onCreate(database);
        WorldTable.onCreate(database);
        NationalCupTable.onCreate(database);
        SeriesFixturesTable.onCreate(database);
        BookmarksTable.onCreate(database);
        RefereesTable.onCreate(database);
        ScorersTable.onCreate(database);
        BookingsTable.onCreate(database);
        InjuriesTable.onCreate(database);
        LineupTable.onCreate(database);
        SubstitutionsTable.onCreate(database);
        EventsTable.onCreate(database);
        LiveTable.onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {

        Log.e(TAG, "Upgrade SQL");

        // Upgrade
        LanguagesTable.onUpgrade(database, oldVersion, newVersion);
        ArenaTable.onUpgrade(database, oldVersion, newVersion);
        TeamTable.onUpgrade(database, oldVersion, newVersion);
        StaffTable.onUpgrade(database, oldVersion, newVersion);
        ClubTable.onUpgrade(database, oldVersion, newVersion);
        SeriesTable.onUpgrade(database, oldVersion, newVersion);
        PlayersTable.onUpgrade(database, oldVersion, newVersion);
        TransfersTable.onUpgrade(database, oldVersion, newVersion);
        MatchesTable.onUpgrade(database, oldVersion, newVersion);
        EconomyTable.onUpgrade(database, oldVersion, newVersion);
        TrainingTable.onUpgrade(database, oldVersion, newVersion);
        WorldTable.onUpgrade(database, oldVersion, newVersion);
        NationalCupTable.onUpgrade(database, oldVersion, newVersion);
        SeriesFixturesTable.onUpgrade(database, oldVersion, newVersion);
        BookmarksTable.onUpgrade(database, oldVersion, newVersion);
        RefereesTable.onUpgrade(database, oldVersion, newVersion);
        ScorersTable.onUpgrade(database, oldVersion, newVersion);
        BookingsTable.onUpgrade(database, oldVersion, newVersion);
        InjuriesTable.onUpgrade(database, oldVersion, newVersion);
        LineupTable.onUpgrade(database, oldVersion, newVersion);
        SubstitutionsTable.onUpgrade(database, oldVersion, newVersion);
        EventsTable.onUpgrade(database, oldVersion, newVersion);
        LiveTable.onUpgrade(database, oldVersion, newVersion);
    }

}
