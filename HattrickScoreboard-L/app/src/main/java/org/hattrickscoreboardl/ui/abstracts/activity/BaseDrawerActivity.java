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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.numberprogressbar.NumberProgressBar;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.drawer.DrawerAdapter;
import org.hattrickscoreboardl.ui.drawer.DrawerFragmentSelection;
import org.hattrickscoreboardl.ui.drawer.componants.Drawer;

import java.util.List;

public abstract class BaseDrawerActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    static String TAG = (BaseDrawerActivity.class).getSimpleName();

    private static final String STATE_SELECTED_POSITION = "SELECTED_POSITION";

    private int mCurrentPosition = 3; //0 for default position
    private DrawerLayout drawer;
    private List<Drawer> drawers;
    private ListView lvDrawer;

    protected abstract List<Drawer> getDrawerItems();

    protected abstract HTeam getTeam();

    @Override
    protected int setContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

        //Set drawer list view
        lvDrawer = (ListView) findViewById(R.id.lvDrawer);
        lvDrawer.setOnItemClickListener(this);
        lvDrawer.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //Set items
        drawers = getDrawerItems();
        lvDrawer.setAdapter(new DrawerAdapter(this, R.layout.drawer_item, drawers));

        //On Orientation Change..
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState
                    .getInt(STATE_SELECTED_POSITION);
        }


        //Set default item
        setSelectedItem(mCurrentPosition, drawers.get(mCurrentPosition));

        NumberProgressBar progressBar = (NumberProgressBar) findViewById(R.id.progress_bar);
        setProgressBar(progressBar);
    }

    private void setSelectedItem(int position, Drawer drawer) {
        if(position == 0) {
            onSelectionTeamItem();
            return;
        }

        mCurrentPosition = position;

        //Get fragment
        Fragment newFragment = DrawerFragmentSelection.getFragment(isTabletMode(), drawer, getTeam());


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(R.id.fContainer, newFragment)
          .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//          .addToBackStack(null)
          .commit();
    }

    protected  abstract void onSelectionTeamItem();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Remove old selection
        if(parent != null) {
            if(parent.getChildAt(mCurrentPosition) != null) {
                parent.getChildAt(mCurrentPosition).setBackgroundColor(0);
                view.setBackgroundColor(getResources().getColor(R.color.drawerItemSelected));
            }
        }

        drawer.closeDrawers();
        setSelectedItem(position, ((Drawer) view.getTag()));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentPosition);
    }


}
