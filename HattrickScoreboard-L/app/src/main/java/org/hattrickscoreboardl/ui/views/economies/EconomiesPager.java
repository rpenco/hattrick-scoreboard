package org.hattrickscoreboardl.ui.views.economies;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.abstracts.BasePager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 mars 2014
 */
public class EconomiesPager extends BasePager {

    static String TAG = (EconomiesPager.class).getSimpleName();

    public EconomiesPager(FragmentManager fm, List<Fragment> fragments, Context ctx) {
        super(fm, fragments, ctx);
    }

    @Override
    protected List<Fragment> getFragments() {
        return ((List<Fragment>) getParam());
    }

    @Override
    public List<String> getTitles() {
        List<String> title = new ArrayList<String>();
        title.add(getString(R.string.tab_economy_current));
        title.add(getString(R.string.tab_economy_last));
        return title;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }
}