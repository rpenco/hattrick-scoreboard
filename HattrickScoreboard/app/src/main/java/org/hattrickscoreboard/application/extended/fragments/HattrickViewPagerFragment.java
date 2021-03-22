package org.hattrickscoreboard.application.extended.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitlePageIndicator.IndicatorStyle;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.PageAdapter;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class HattrickViewPagerFragment extends Fragment {

    static final String TAG = (HattrickViewPagerFragment.class).getSimpleName();

    public static String TEAMID = "teamID";

    protected List<String> titles;
    protected View view;

    // Selected team ID
    int teamID;

    ViewPager mPager;
    int page;

    private boolean rightFragment;

    public HattrickViewPagerFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        createPager(page);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get team ID from activity
        teamID = getArguments().getInt("teamID");
        rightFragment = getArguments().getBoolean("rightFragment");

        // Inflate view and save in attribute for use in fragment
        view = inflater.inflate(R.layout.viewpager, container, false);
        return view;
    }

    public boolean isTablet() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            return bundle.getBoolean("tablet");

        }
        return false;
    }

    public boolean isRightFragment() {
        return rightFragment;
    }

    /**
     * Override this method to set your fragment
     *
     * @return
     */
    public List<HattrickFragment> getFragments() {
        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();
        return fList;
    }

    public void createPager() {
        createPager(0);
    }

    /**
     * Call this method to create pager, override getfragments before.
     */
    public void createPager(int page) {
        titles = new ArrayList<String>();

        this.page = page;

        // Title
        TitlePageIndicator mIndicator = (TitlePageIndicator) view
                .findViewById(R.id.indicator);

        // Pager
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setOffscreenPageLimit(4);

        List<HattrickFragment> fragments = getFragments();
        PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager(),
                fragments, titles);

        // Theme
        Preferences pref = new Preferences(getActivity());
        ColorTheme theme = new ColorTheme(pref.getRGBColor());

        // Set
        mPager.setAdapter(pageAdapter);
        mIndicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;

        mIndicator.setFooterColor(theme.getColorDusky());
        mIndicator.setFooterLineHeight(2 * density);
        mIndicator.setFooterIndicatorHeight(3 * density); // 3dp
        mIndicator.setFooterIndicatorStyle(IndicatorStyle.Underline);
        mIndicator.setTextColor(Color.rgb(255, 255, 255));
        mIndicator.setSelectedColor(Color.rgb(255, 255, 255));
        mIndicator.setSelectedBold(true);

        // Set default page
        mPager.setCurrentItem(page);

    }

    protected int getTeamID() {
        return teamID;
    }

    /**
     * UpperCase string
     *
     * @param resource
     * @return
     */
    protected String toUpperCase(int resource) {
        return getString(resource).toUpperCase(Locale.ENGLISH);
    }

}