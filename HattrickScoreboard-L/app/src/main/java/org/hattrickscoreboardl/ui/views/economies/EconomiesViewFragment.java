package org.hattrickscoreboardl.ui.views.economies;

import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutDoubleFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class EconomiesViewFragment extends LayoutDoubleFragment {
    static String TAG = (EconomiesViewFragment.class).getSimpleName();

    HTeam team;

    public static EconomiesViewFragment newInstance(HTeam team) {
        EconomiesViewFragment fragment = new EconomiesViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected Fragment onCreateFirstFragment() {
        return EconomiesFragment.newInstance(team, 0);
    }

    @Override
    protected Fragment onCreateSecondFragment() {
        return EconomiesFragment.newInstance(team, 1);
    }

    @Override
    protected Fragment onCreateFragment() {
        return null;
    }
}
