package org.hattrickscoreboard.application.views.player;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.TitlePageIndicator.IndicatorStyle;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.PageAdapter;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.khips.extensions.progressbars.ButteryProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlayerActivity extends FragmentActivity {

    public static final String PLAYERID = "playerID";
    static final String TAG = (PlayerActivity.class).getSimpleName();
    public int playerID;
    protected List<String> titles;
    protected View view;
    ButteryProgressBar progressBar;
    private RelativeLayout rlLeftTablet;
    private RelativeLayout rlMiddleTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_player);

        // Get params
        if (getIntent() != null) {
            playerID = (int) getIntent().getExtras().get(PLAYERID);

        }

        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Set custom colors
        LinearLayout llBackground = (LinearLayout) findViewById(R.id.llBackground);
        if (llBackground != null) {

            Preferences pref = new Preferences(this);
            ColorTheme colorTheme = new ColorTheme(pref.getRGBColor());
            llBackground.setBackgroundColor(colorTheme.getRGB());
        }

        // ////////////////////////////////////////////////////////////////
        // PROGRESS ACTION BAR

        progressBar = new ButteryProgressBar(this);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                24));
        progressBar.setId(R.id.action_progressbar);

        // retrieve the top view of our application
        final FrameLayout decorView = (FrameLayout) getWindow().getDecorView();
        decorView.addView(progressBar);

        ViewTreeObserver observer = progressBar.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                View contentView = decorView.findViewById(android.R.id.content);
                progressBar.setY(contentView.getY() - 10);

                ViewTreeObserver observer = progressBar.getViewTreeObserver();
                observer.removeGlobalOnLayoutListener(this);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        rlLeftTablet = (RelativeLayout) findViewById(R.id.rlLeftTablet);
        rlMiddleTablet = (RelativeLayout) findViewById(R.id.rlMiddleTablet);

        Fragment f = new PlayerHeadFragment().newInstance(playerID);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flScore, f).commit();

        // if tablet, reorganized
        if (rlLeftTablet != null && rlMiddleTablet != null) {

            Fragment f1 = new PlayerHomeFragment().newInstance(playerID);
            fragmentManager.beginTransaction().replace(R.id.rlLeftTablet, f1)
                    .commit();

            Fragment f2 = new PlayerStatsFragment().newInstance(playerID);
            fragmentManager.beginTransaction().replace(R.id.rlMiddleTablet, f2)
                    .commit();

        } else {
            createPager();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.th_background_actionbar));

        actionBar.setTitle(R.string.app_name);

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public List<HattrickFragment> getFragments() {
        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        fList.add(new PlayerHomeFragment().newInstance(playerID));
        titles.add(toUpperCase(R.string.player_label_overview));

        fList.add(new PlayerStatsFragment().newInstance(playerID));
        titles.add(toUpperCase(R.string.player_label_statistics));

        return fList;
    }

    /**
     * Call this method to create pager, override getfragments before.
     */
    public void createPager() {
        titles = new ArrayList<String>();

        // Title
        TitlePageIndicator mIndicator = (TitlePageIndicator) findViewById(R.id.indicator);

        // Pager
        ViewPager mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setOffscreenPageLimit(4);

        List<HattrickFragment> fragments = getFragments();
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),
                fragments, titles);

        // Theme
        Preferences pref = new Preferences(this);
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

    }

    protected String toUpperCase(int resource) {
        return getString(resource).toUpperCase(Locale.ENGLISH);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
