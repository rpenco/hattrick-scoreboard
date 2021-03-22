package org.hattrickscoreboardl.ui.abstracts;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by romain on 26/10/2014.
 */
public abstract class BasePager extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List<String> titles;
    private Object param;
    private Context ctx;

    public BasePager(FragmentManager fm, Object param, Context ctx) {
        super(fm);
        this.ctx = ctx;
        this.param = param;
        this.fragments = getFragments();
        this.titles = getTitles();
    }


    protected String getString(int res){
        if(ctx != null)
        return ctx.getString(res);

        return "UNAVAIBLE";
    }

    protected Object getParam(){return param;}

    protected abstract List<String> getTitles();

    protected abstract List<Fragment> getFragments();

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

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        if (observer != null) {
            super.unregisterDataSetObserver(observer);
        }
    }
}