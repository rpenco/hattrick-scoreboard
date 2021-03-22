package org.hattrickscoreboardl.ui.abstracts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hattrickscoreboardl.R;

/**
 * Created by romain on 26/10/2014.
 */
public abstract class BaseSimpleFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_simple, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager f = getFragmentManager();
        f.beginTransaction().replace(R.id.rlContainer,getFragment()).commit();
    }

    public abstract Fragment getFragment();
}
