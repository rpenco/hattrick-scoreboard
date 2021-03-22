package org.hattrickscoreboardl.ui.abstracts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.utils.Preferences;

/**
 * Created by romain on 26/10/2014.
 */
public abstract class BaseFragment extends Fragment{

    private PagerAdapter pagerAdaptater;
    private ViewPager pager;
    private PagerSlidingTabStrip tabs;
    private int colorTheme;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract PagerAdapter getPagerAdaptater();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_viewpager_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Preferences pref = new Preferences(getActivity());

        //Get application color
        colorTheme = pref.get(Preferences.COLOR_RGB_1STTEAM, getResources().getColor(R.color.appTheme));

        //Set action tabs
        pagerAdaptater = getPagerAdaptater();
        if(pagerAdaptater != null) {

            pager = (ViewPager) view.findViewById(R.id.pager);
            if(pager != null) {
                pager.setAdapter(pagerAdaptater);
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
}
