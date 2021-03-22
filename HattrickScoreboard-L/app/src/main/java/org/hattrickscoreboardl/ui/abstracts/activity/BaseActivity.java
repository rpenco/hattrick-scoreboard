/*
 * Copyright (C) 2014 Antonio Leiva Gordillo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hattrickscoreboardl.ui.abstracts.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.daimajia.numberprogressbar.NumberProgressBar;

import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.services.MainService;
import org.hattrickscoreboardl.ui.utils.ColorTheme;
import org.hattrickscoreboardl.utils.Preferences;

public abstract class BaseActivity extends ActionBarActivity  {

    static String TAG = (BaseActivity.class).getSimpleName();

    private Toolbar toolbar;
    private Preferences pref;
    private RelativeLayout rlBackground;
    private RelativeLayout rlRightContainer;
    private int colorTheme;
    private boolean tabletMode;
    protected NumberProgressBar pb;

    //Abstracts
    protected abstract int setContentView();

    //Gettters
    public Preferences getPref(){
        return pref;
    }

    public int getColorTheme(){return colorTheme;}

    public Toolbar getToolbar(){
        return toolbar;
    }

    public RelativeLayout getBackgroundLayout(){
        return rlBackground;
    }

    public RelativeLayout getRightLayout(){
        return rlRightContainer;
    }

    public boolean isTabletMode(){
        return tabletMode;
    }

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());

        //Load preferences
        pref = new Preferences(this);

        //Set background color
        rlBackground = (RelativeLayout) findViewById(R.id.rlBackground);
        if(rlBackground != null){
            rlBackground.setBackgroundResource(R.color.backgroundColor);
        }

        //Set toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Get Theme color
        colorTheme = pref.get(Preferences.COLOR_RGB_1STTEAM, getResources().getColor(R.color.appTheme));

        //Set action bar
        if (toolbar != null) {

            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            //Set color theme
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(colorTheme));

            //Set status bar color (Lollipop)
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP){
                Window v = getWindow();

                ColorTheme t = new ColorTheme(colorTheme);
                v.setStatusBarColor(t.get700().getRGB());
            }

            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setSubtitleTextColor(Color.WHITE);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }

        //Tablet/Smartphone mode
        rlRightContainer = (RelativeLayout) findViewById(R.id.rlRightContainer);
        if(rlRightContainer != null){
            tabletMode = true;
        }

    }


    /**
     * Set progress bar
     * @param progressBar
     */
    protected void setProgressBar(NumberProgressBar progressBar){
        //Loading bar
        pb = progressBar;
        if(pb != null){
            pb.setProgressTextColor(Color.WHITE);
            pb.setReachedBarColor(Color.WHITE);
            pb.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null) {
                if (intent.getExtras() != null) {

                    // Get Code
                    int code = intent.getExtras().getInt(
                            MainService.UPDATECODE);

                    // Get process from
                    String from = intent.getExtras().getString(
                            MainService.UPDATEFROM);

                    int progress = (int) (((HattrickApplication) getApplication()).getLoader().getProgress()*100);
                    if(progress > 0) {
                        pb.setVisibility(View.VISIBLE);
                        pb.setProgress(progress);
                    }

                    if(progress == 100){
                        pb.setVisibility(View.INVISIBLE);
                        onProgressFinish();
                    }
                }
            }

        }
    };

    /**
     * Action to do on progress bar reach 100%
     */
    protected abstract void onProgressFinish();

    @Override
    public void onResume() {
        super.onResume();

        if (receiver != null) {
            registerReceiver(receiver, new IntentFilter(
                    MainService.INTENT));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }
}
