package org.hattrickscoreboardl.ui.views.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.abstracts.HFragment;


public final class SettingFragment extends HFragment {

    static final String TAG = (SettingFragment.class).getSimpleName();

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }


    @Override
    protected boolean onPrepareData() {
        return true;
    }

    @Override
    protected View onDisplayData() {

        LayoutInflater inflater = getLayoutInflater(getArguments());
        ScrollView sv = (ScrollView) inflater.inflate(R.layout.fragment_settings,null);


        return sv;
    }


}
