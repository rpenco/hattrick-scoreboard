package org.hattrickscoreboardl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.gc.materialdesign.widgets.SnackBar;

import org.hattrick.chpp.CHPPToken;
import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.arena.HArena;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.world.HWorldLeague;
import org.hattrickscoreboardl.services.MainService;
import org.hattrickscoreboardl.ui.abstracts.activity.BaseActivity;
import org.hattrickscoreboardl.ui.views.chpp.CHPPActivity;
import org.hattrickscoreboardl.utils.Preferences;

/**
 * First screen displayed
 *
 * @author Khips
 * @since 4 aout 2014
 */
public class SplashscreenActivity extends BaseActivity {

    static final String TAG = (SplashscreenActivity.class).getSimpleName();


    @Override
    protected int setContentView() {
        return R.layout.activity_splashscreen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Custom background
        FrameLayout flsplashscreen = (FrameLayout) findViewById(R.id.flsplashscreen);
        if(flsplashscreen != null && getPref() != null){
            flsplashscreen.setBackgroundColor(getColorTheme());
        }

        //Set progress bar
        NumberProgressBar progress = (NumberProgressBar) flsplashscreen.findViewById(R.id.progress_bar);
        setProgressBar(progress);
        pb.setVisibility(View.VISIBLE);

        CHPPToken token = ((HattrickApplication) getApplication()).getCHPPToken(this);
        if(token != null) {

                Intent intent = new Intent(SplashscreenActivity.this, MainService.class);
                startService(intent);
          }else{
            startActivity(new Intent(SplashscreenActivity.this, CHPPActivity.class));
            finish();
        }
    }

    @Override
    protected void onProgressFinish() {

        Preferences pref = new Preferences(this);

        HTeam team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", String.valueOf(pref.get(Preferences.SELECTED_TEAM_ID, 0)));

        if(team != null) {

            HArena arena = HArena.findOne(HArena.class, "ARENA_ID = ?", String.valueOf(team.getArenaID()));
            if(arena != null) {

                HWorldLeague league = HWorldLeague.findOne(HWorldLeague.class, "LEAGUE_ID = ?", String.valueOf(team.getLeagueID()));

                if(league != null) {
                    //Start activity
                    startActivity(new Intent(SplashscreenActivity.this, HomeActivity.class));
                    finish();
                }
            }
        }else{
            SnackBar snackbar = new SnackBar(SplashscreenActivity.this, "Le chargement peut être long...", "", null);
            snackbar.show();
        }

    }

}
