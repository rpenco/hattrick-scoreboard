package org.hattrickscoreboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.hattrickscoreboard.application.drawer.HattrickNavigationActivity;
import org.hattrickscoreboard.application.extended.fragments.PlaceHolderFragment;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.views.dialogs.SearchDialog;
import org.hattrickscoreboard.application.views.matches.MatchesViewPager;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.tables.TeamTable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends HattrickNavigationActivity {
    static String TAG = (MainActivity.class).getSimpleName();

    private Toast toast;
    private long lastBackPressTime = 0;
    private ArrayList<DTeam> myTeams;
    private HattrickApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        application = ((HattrickApplication) getApplication()).getInstance();
        Log.e(TAG, "Selected team: " + application.getSelectedTeamID());

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
            toast = Toast.makeText(this, R.string.label_press_again_exit,
                    Toast.LENGTH_SHORT);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            super.onBackPressed();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // Change team...
        if (position == 0) {

            // Select team
            List<String> list = new ArrayList<String>();

            HattrickBDD bdd = new HattrickBDD(this);

            myTeams = bdd.readAll(
                    TeamTable.class,
                    DTeam.class,
                    TeamTable.COL_USER_ID
                            + "="
                            + ((HattrickApplication) getApplication())
                            .getMyUserID());

            for (DTeam team : myTeams) {
                list.add(team.getTeamName());
            }
            CharSequence[] teams = list.toArray(new CharSequence[list.size()]);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(teams, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {


                    application.setSelectedTeamID(myTeams.get(which)
                            .getTeamID());

                    // Redraw activity
                    dialog.dismiss();
                    selectItem(1, 2);
                    recreate();

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        } else {

            // Tablet format
            // Create right part if exist (Tablet!)
            View v = findViewById(R.id.content_right);
            if (v != null) {

                // Set team ID
                Bundle bundleRight = new Bundle();
                bundleRight.putInt("teamID", application.getSelectedTeamID());

                // Set tablet mode
                bundleRight.putBoolean("tablet", true);
                bundleRight.putBoolean("rightFragment", true);

                Fragment fright = PlaceHolderFragment.newRightInstance(
                        position, bundleRight);

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_right, fright).commit();

            }

            // /////////////////////////////
            // Set left Fragment / only one fragment
            // update the main content by replacing fragments
            // Set team ID
            Bundle bundle = new Bundle();
            bundle.putInt("teamID", application.getSelectedTeamID());
            if (v != null) {
                bundle.putBoolean("tablet", true);
            }
            // Set tablet mode
            bundle.putBoolean("rightFragment", false);
            Fragment f = PlaceHolderFragment.newInstance(position, bundle);

            if (f != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, f)
                        .commit();
            }

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {


            FragmentManager fm = getSupportFragmentManager();
            SearchDialog dialog = new SearchDialog();
            Preferences pref = new Preferences(this);
            dialog.setColoredTheme(new ColorTheme(pref.getRGBColor()));
            dialog.show(fm, "fragment_search");
            return true;
        }

        if (id == R.id.action_live) {


            Bundle b = new Bundle();
            b.putInt("teamID", application.getSelectedTeamID());
            // Show live fragment
            b.putBoolean(MatchesViewPager.VIEW_LIVE, true);

            // update the main content by replacing fragments
            Fragment f = PlaceHolderFragment.newInstance(8, b);
            if (f != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, f)
                        .commit();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
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
