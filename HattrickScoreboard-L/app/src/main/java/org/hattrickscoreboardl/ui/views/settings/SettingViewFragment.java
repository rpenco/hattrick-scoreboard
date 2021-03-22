package org.hattrickscoreboardl.ui.views.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.layout.LayoutSimpleFragment;

/**
 * Created by romain on 26/10/2014.
 */
public class SettingViewFragment extends LayoutSimpleFragment {
    static String TAG = (SettingViewFragment.class).getSimpleName();

    HTeam team;

    public SettingViewFragment(){
        super();
    }

    public static SettingViewFragment newInstance(HTeam team) {
        SettingViewFragment fragment = new SettingViewFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment onCreateFragment() {
        return SettingFragment.newInstance();
    }
}
