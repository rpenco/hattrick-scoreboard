package org.hattrickscoreboard.application.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.drawer.HattrickConsultNavigationActivity;
import org.hattrickscoreboard.application.extended.fragments.PlaceHolderFragment;

public class ConsultActivity extends HattrickConsultNavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // Tablet format
        // Create right part if exist (Tablet!)
        View v = findViewById(R.id.content_right);
        if (v != null) {

            // Set team ID
            Bundle bundleRight = new Bundle();
            bundleRight.putInt("teamID", resultID);

            // Set tablet mode
            bundleRight.putBoolean("tablet", true);
            bundleRight.putBoolean("rightFragment", true);

            Fragment fright = PlaceHolderFragment.newRightInstance(position,
                    bundleRight);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_right, fright).commit();

        }

        // /////////////////////////////
        // Set left Fragment / only one fragment
        // update the main content by replacing fragments
        // Set team ID
        Bundle bundle = new Bundle();
        bundle.putInt("teamID", resultID);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
