package org.hattrickscoreboard.application.drawer;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.HattrickSupportScreen;
import org.hattrickscoreboard.application.extended.fragments.PlaceHolderFragment;

public class HattrickConsultNavigationActivity extends FragmentActivity
        implements ConsultNavigationDrawerFragment.NavigationDrawerCallbacks {

    public static final String RESULTID = "resultID";
    public static final String RESULTTYPE = "resultType";
    protected int resultID;
    int resultType;
    private ConsultNavigationDrawerFragment mNavigationDrawerFragment;
    private int teamID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            resultID = extras.getInt(RESULTID);
            resultType = extras.getInt(RESULTID);
        }

        mNavigationDrawerFragment = (ConsultNavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        mNavigationDrawerFragment.selectItem(1, 1);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        HattrickSupportScreen supportScreen = new HattrickSupportScreen(this);

        supportScreen.putInt("teamID", teamID);
        supportScreen.evalTablet(R.id.content_right);
        supportScreen.setRightFragment(true);
        Bundle bundle = supportScreen.getSupportBundle();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container,
                        PlaceHolderFragment.newInstance(position + 1, bundle))
                .commit();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.th_background_actionbar));

        actionBar.setTitle(R.string.app_name);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();
        // if (id == R.id.action_settings) {
        // return true;
        // }
        return super.onOptionsItemSelected(item);
    }

}
