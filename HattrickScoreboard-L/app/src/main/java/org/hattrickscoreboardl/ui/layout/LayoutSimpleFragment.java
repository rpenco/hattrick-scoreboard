package org.hattrickscoreboardl.ui.layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.utils.Preferences;

public abstract class LayoutSimpleFragment extends Fragment {

    protected int colorTheme;

    public LayoutSimpleFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Preferences pref = new Preferences(getActivity());
        colorTheme = pref.get(Preferences.COLOR_RGB_1STTEAM, getResources().getColor(R.color.appTheme));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Fragment f = onCreateFragment();
        if(f != null)
            getFragmentManager().beginTransaction().replace(R.id.rlContainer, f).commit();
    }

    //Get default fragment
    protected abstract Fragment onCreateFragment();
}
