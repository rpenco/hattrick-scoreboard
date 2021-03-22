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

package org.hattrickscoreboardl.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.services.MainService;
import org.hattrickscoreboardl.ui.abstracts.activity.BaseDrawerActivity;
import org.hattrickscoreboardl.ui.drawer.componants.Drawer;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerItem;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerNationalTeam;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerTeam;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerTitle;
import org.hattrickscoreboardl.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseDrawerActivity {

    HattrickApplication application;
    HTeam team;
    HNationalTeam nTeam;
    HNationalTeam nTeamU20;
    Preferences pref;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        application = ((HattrickApplication) getApplication());

        pref = new Preferences(this);

        int selectedTeamID = pref.get(Preferences.SELECTED_TEAM_ID, 0);
        int nationalLeagueID = pref.get(Preferences.NATIONAL_LEAGUE_ID, 0);

        team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", String.valueOf(selectedTeamID));
        nTeam = HNationalTeam.findOne(HNationalTeam.class,
                "LEAGUE_OFFICE_TYPE_ID = 2 and LEAGUE_ID = ?", String.valueOf(nationalLeagueID));
        nTeamU20 = HNationalTeam.findOne(HNationalTeam.class,
                "LEAGUE_OFFICE_TYPE_ID = 4 and LEAGUE_ID = ?", String.valueOf(nationalLeagueID));

        //getSupportActionBar().setTitle(team.getTeamName());
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onSelectionTeamItem() {
        final List<HTeam> teams = HTeam.find(HTeam.class, "USER_ID = ?", String.valueOf(pref.get(Preferences.USER_ID,0)));

        List<String> list = new ArrayList<String>();
        for (HTeam team : teams) {
            list.add(team.getTeamName());
        }

        CharSequence[] t = list.toArray(new CharSequence[list.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(t, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                //Save changing team
                pref.save(Preferences.SELECTED_TEAM_ID, teams.get(which).getTeamID());

                /*GTracker.TrackEvent(getApplicationContext(),
                        HTracker.CATEGORY_EVENT, HTracker.ACTION_PRESS,
                        HTracker.LABEL_CHANGE_TEAM);*/

                /*application.setSelectedTeamID(myTeams.get(which)
                        .getTeamID());*/

                // Redraw activity
                dialog.dismiss();
                recreate();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected List<Drawer> getDrawerItems() {

        //Set items
        ArrayList<Drawer> drawers = new ArrayList<Drawer>();


        drawers.add(new DrawerTeam(0, team));

        //General
        drawers.add(new DrawerItem(-1, "Actualités", R.drawable.ic_menu_news));

        drawers.add(new DrawerTitle(getString(R.string.menu_header_club)));
        drawers.add(new DrawerItem(1, getString(R.string.menu_overview), R.drawable.ic_menu_team));
        drawers.add(new DrawerItem(2, getString(R.string.menu_arena), R.drawable.ic_menu_arena));
        drawers.add(new DrawerItem(3, getString(R.string.menu_staff), R.drawable.ic_menu_staff));
        drawers.add(new DrawerItem(4, getString(R.string.menu_fans), R.drawable.ic_menu_supporters));
        drawers.add(new DrawerItem(5, getString(R.string.menu_transfers), R.drawable.ic_menu_transfers));
        drawers.add(new DrawerItem(6, getString(R.string.menu_finances), R.drawable.ic_menu_economies));

        //Senion
        drawers.add(new DrawerTitle(getString(R.string.menu_header_senior)));
        drawers.add(new DrawerItem(7, getString(R.string.menu_players), R.drawable.ic_menu_players));
        drawers.add(new DrawerItem(8, getString(R.string.menu_matches), R.drawable.ic_menu_matches));
        drawers.add(new DrawerItem(9, getString(R.string.menu_series), R.drawable.ic_menu_series));
        drawers.add(new DrawerItem(10, getString(R.string.menu_training), R.drawable.ic_menu_training));

        //Youth
        if(team.getYouthTeamID() > 0) {
            drawers.add(new DrawerTitle(getString(R.string.menu_header_youth)));
            drawers.add(new DrawerItem(12, getString(R.string.menu_players), R.drawable.ic_menu_players));
            drawers.add(new DrawerItem(13, getString(R.string.menu_matches), R.drawable.ic_menu_matches));
            drawers.add(new DrawerItem(14, getString(R.string.menu_series), R.drawable.ic_menu_series));
        }

        //Nationnal teams
        if(nTeam != null && nTeamU20!= null) {
            drawers.add(new DrawerTitle(getString(R.string.menu_header_national)));

            drawers.add(new DrawerNationalTeam(15, nTeam));
            drawers.add(new DrawerNationalTeam(16, nTeamU20));
            drawers.add(new DrawerItem(17, getString(R.string.menu_worldcup), R.drawable.ic_menu_series));
        }

        //Community (friends, ladders....)
        drawers.add(new DrawerTitle(getString(R.string.menu_community)));
        drawers.add(new DrawerItem(18, getString(R.string.menu_community), R.drawable.ic_menu_community));
        drawers.add(new DrawerItem(19, getString(R.string.menu_alliances), R.drawable.ic_menu_team));
        drawers.add(new DrawerItem(20, getString(R.string.menu_ladders), R.drawable.ic_menu_ladder));
        drawers.add(new DrawerItem(21, getString(R.string.menu_tournaments), R.drawable.ic_menu_tournament));

        //Settings
        drawers.add(new DrawerTitle(getString(R.string.menu_settings)));
        drawers.add(new DrawerItem(22, getString(R.string.menu_notifications), R.drawable.ic_menu_notifications));
        drawers.add(new DrawerItem(23, getString(R.string.menu_settings), R.drawable.ic_menu_settings));


        return drawers;
    }

    @Override
    protected HTeam getTeam() {
        return team;
    }


    @Override
    protected void onProgressFinish() {
            Toast.makeText(this, "Application mise à jour!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_reload:

                Intent intent = new Intent(HomeActivity.this, MainService.class);
                intent.putExtra(MainService.FORCE_LOAD, true);

                //Reset loading counter
                ((HattrickApplication) getApplication()).getLoader().reset();

                //Start service
                startService(intent);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
