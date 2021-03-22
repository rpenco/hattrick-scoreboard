package org.hattrickscoreboardl.ui.layout;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.astuetz.PagerSlidingTabStrip;

import org.hattrickscoreboardl.R;

public class LayoutListFragment extends LayoutSimpleFragment {

    static String TAG = (LayoutListFragment.class).getSimpleName();

    private View view;
    protected PagerAdapter pagerAdapter;
    protected ViewPager pager;
    protected PagerSlidingTabStrip tabs;
    protected RelativeLayout rlRight;

    public LayoutListFragment(){
        super();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_viewpager_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;


        //Set action tabs
        if(pagerAdapter != null) {

            pager = (ViewPager) view.findViewById(R.id.pager);
            if(pager != null) {
                pager.removeAllViews();
                pager.removeAllViewsInLayout();
                pager.destroyDrawingCache();
                pager.invalidate();


                if ( pager.getAdapter() == null ){
                    pager.setAdapter(pagerAdapter);
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

        rlRight = (RelativeLayout) view.findViewById(R.id.rlRightContainer);
        if(rlRight != null){
            Fragment rFragment = onCreateRightFragment();
            if(rFragment != null)
                getFragmentManager().beginTransaction().replace(R.id.rlRightContainer, rFragment).commit();
        }
    }

    protected Fragment onCreateRightFragment() {
        return null;
    }

    @Override
    protected Fragment onCreateFragment() {
        return null;
    }


    @Override
    public void onStart() {
        super.onStart();

        Log.e(TAG, "On onStart");


    }

}
