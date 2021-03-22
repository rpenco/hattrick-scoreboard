package org.hattrickscoreboardl.ui.layout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.views.economies.EconomiesPager;

import java.util.ArrayList;
import java.util.List;

public abstract class LayoutDoubleFragment extends LayoutSimpleFragment {


    protected ViewPager pager;
    protected PagerSlidingTabStrip tabs;


    public LayoutDoubleFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_double, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Fragment f = onCreateFirstFragment();
        Fragment f2 = onCreateSecondFragment();

        if(view.findViewById(R.id.rlRightContainer) != null) {

            if (f != null)
                getFragmentManager().beginTransaction().replace(R.id.rlContainer, f).commit();

            if (f2 != null)
                getFragmentManager().beginTransaction().replace(R.id.rlRightContainer, f2).commit();

        }else{

            pager = (ViewPager) view.findViewById(R.id.pager);
            if(pager != null) {
                pager.removeAllViews();
                pager.removeAllViewsInLayout();
                pager.destroyDrawingCache();
                pager.invalidate();


                if ( pager.getAdapter() == null ){
                    List<Fragment> fragments = new ArrayList<Fragment>();
                    fragments.add(f);
                    fragments.add(f2);
                    pager.setAdapter(new EconomiesPager(getFragmentManager(), fragments,getActivity()));
                }

            }

            tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
            if(tabs != null) {
                tabs.setBackgroundColor(colorTheme);
                tabs.setTextColor(Color.WHITE);
                tabs.setDividerColor(colorTheme);
                tabs.setIndicatorColor(Color.WHITE);
                tabs.setIndicatorHeight(7);
                tabs.setUnderlineColor(colorTheme);
                tabs.setViewPager(pager);
            }
        }
    }

    //Get default fragment
    protected abstract Fragment onCreateFirstFragment();

    protected abstract Fragment onCreateSecondFragment();
}
