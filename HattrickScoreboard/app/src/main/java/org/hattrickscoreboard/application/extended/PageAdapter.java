package org.hattrickscoreboard.application.extended;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;

import java.util.List;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class PageAdapter extends FragmentStatePagerAdapter {
    private List<HattrickFragment> fragments;
    private List<String> titles;

    public PageAdapter(FragmentManager fm, List<HattrickFragment> fragments,
                       List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}