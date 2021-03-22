package org.hattrickscoreboardl.ui.views.transfers;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.BasePager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 mars 2014
 */
public class TransfersPager extends BasePager {

    static String TAG = (TransfersPager.class).getSimpleName();

    public TransfersPager(FragmentManager fm, HTeam team, Context ctx) {
        super(fm, team, ctx);
    }


    @Override
    public List<String> getTitles() {
        List<String> title = new ArrayList<String>();
        title.add("Rechercher");/*
        title.add("Historique");
        title.add("Statistiques");*/
        return title;
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(TransfersSearchFragment.newInstance((HTeam) getParam()));/*
        fragments.add(TransfersSearchFragment.newInstance((HTeam) getParam()));
        fragments.add(TransfersListFragment.newInstance((HTeam) getParam()));*/
        return fragments;
    }

}