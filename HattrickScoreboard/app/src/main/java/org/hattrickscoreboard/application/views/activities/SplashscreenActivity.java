package org.hattrickscoreboard.application.views.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.MainActivity;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.HattrickActivity;
import org.hattrickscoreboard.application.extended.BackgroundDrawable;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.views.chpp.CHPPActivity;
import org.hattrickscoreboard.background.services.BackgroundService;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.tables.TeamTable;
import org.hattrickscoreboard.database.tables.WorldTable;
import org.khips.extensions.KDialog;

import java.util.ArrayList;

/**
 * First screen displayed
 *
 * @author Khips
 * @since 4 august 2014
 */
public class SplashscreenActivity extends HattrickActivity {

    static final String TAG = (SplashscreenActivity.class).getSimpleName();

    TextView tvLoading;
    ImageView ivBackground;

    ArrayList<DTeam> myTeams;
    DWorld myWorld;
    HattrickBDD bdd;
    Preferences pref;
    long startTime = 0;
    private Dialog dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startTime = System.currentTimeMillis();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_activity);

        ivBackground = (ImageView) findViewById(R.id.ivBackground);

        // Set custom colors
        BackgroundDrawable.draw(this, colorTheme, ivBackground);


        // if not authorized -> CHPP page
        if (!((HattrickApplication) getApplication())
                .hasCHPPAuthorization(this)) {

            // CHPP page
            startActivity(new Intent(SplashscreenActivity.this,
                    CHPPActivity.class));

            finish();
            return;
        }

        // Not first launch, get all his teams

        // Open database
        bdd = ((HattrickApplication) getApplication()).getBDD(this);

        pref = new Preferences(this);

        // If authorized, start background service
        Intent i = new Intent(SplashscreenActivity.this,
                BackgroundService.class);
        startService(i);

    }

    @Override
    public void onServiceStartUpdate(int code, String from) {
        super.onServiceStartUpdate(code, from);

        Preferences pref = new Preferences(this);
        boolean firstLaunch = pref.isFirstLaunch();
        if (firstLaunch && dial == null) {
            dial = KDialog.progress(this,
                    getString(R.string.label_first_loading));
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        // Get first team, normaly my team
        DTeam fTeam = (DTeam) bdd
                .read(TeamTable.class, TeamTable.COL_ID + "=1");

        // No teams available
        if (fTeam == null) {
            return;
        }
        // Get all my teams
        myTeams = bdd.readAll(TeamTable.class, DTeam.class,
                TeamTable.COL_USER_ID + "=" + fTeam.getUserID());

        // Save my UserID
        ((HattrickApplication) getApplication()).setMyUserID(fTeam.getUserID());

        // Save my teams
        ((HattrickApplication) getApplication()).setMyTeams(myTeams);

        // Get selected team ID
        int selectedTeamID = pref.getSelectedTeamID();

        // If not selected team, default is first team
        if (selectedTeamID == 0) {
            pref.setSelectedTeamID(fTeam.getTeamID());
        }

        // Get selected team ID
        int selectedWorld = pref.getSelectedWorldID();

        // Get default world relative to team
        if (selectedWorld == 0) {

            // Get my selected team
            DTeam myTeam = ((HattrickApplication) getApplication())
                    .getSelectedTeam();

            selectedWorld = myTeam.getLeagueID();
        }

        // Get my world information
        myWorld = (DWorld) bdd.read(WorldTable.class, WorldTable.COL_LEAGUE_ID
                + "=" + selectedWorld);

        // Save my world
        ((HattrickApplication) getApplication()).setMyWorld(myWorld);

        if (myWorld != null && myTeams != null) {

            // Unregister for no more notifications
            unregisterServiceReceiver();

            if (dial != null) {
                dial.dismiss();

                // No display long loading popup
                Preferences pref = new Preferences(this);
                pref.setFirstLaunch(false);
            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {

                    long time = System.currentTimeMillis() - startTime;

                    Log.v(TAG, "loading time: " + time);

                    //Start activity
                    startActivity(new Intent(SplashscreenActivity.this,
                            MainActivity.class));
                    finish();
                }
            }, 5000);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
