package org.hattrickscoreboardl.ui.views.arena;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutSimpleFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class ArenaViewFragment extends LayoutSimpleFragment {
    static String TAG = (ArenaViewFragment.class).getSimpleName();

    HTeam team;

    public ArenaViewFragment(){
        super();
    }

    public static ArenaViewFragment newInstance(HTeam team) {
        ArenaViewFragment fragment = new ArenaViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment onCreateFragment() {
        return ArenaFragment.newInstance(team);
    }
}
