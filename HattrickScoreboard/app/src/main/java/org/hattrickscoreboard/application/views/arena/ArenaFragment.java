package org.hattrickscoreboard.application.views.arena;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.application.views.club.ClubTask;
import org.hattrickscoreboard.background.tasks.tables.ArenaUpdate;
import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RClub;

/**
 * @author Khips
 * @since 4 august 2014
 */
public final class ArenaFragment extends HattrickFragment {

    static final String TAG = (ArenaFragment.class).getSimpleName();

    // selected team
    int teamID;

    // Result from task
    private RClub rteam;

    public ArenaFragment newInstance(int teamID) {
        ArenaFragment fragment = new ArenaFragment();
        fragment.teamID = teamID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        ClubTask task = new ClubTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rteam = (RClub) result;
        if (rteam == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

        DTeam team = rteam.getTeam();
        DArena arena = rteam.getArena();

        // Get layout parameters
        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);
        if (llContainer == null) {
            return;
        }
        // for after update...
        llContainer.removeAllViews();

        // Create background container
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View container = inflater.inflate(R.layout.view_container, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        applyMarginLayout(layoutParams);
        llContainer.addView(container, layoutParams);

        // Create table

        Preferences pref = new Preferences(getActivity());
        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);

        tb.addTitle(toUpperCase(arena.getArenaName()));

        tb.addRow(getString(R.string.arena_label_owner), team.getTeamName());
        tb.addRow(getString(R.string.arena_label_lastbuild),
                formatDate(arena.getRebuiltDate()));

        tb.addRow(
                getString(R.string.arena_label_basic),
                getString(R.string.arena_seats,
                        formatNumber(arena.getCurrentBasic())));
        tb.addRow(
                getString(R.string.arena_label_terraces),
                getString(R.string.arena_seats,
                        formatNumber(arena.getCurrentTerraces())));
        tb.addRow(
                getString(R.string.arena_label_roof),
                getString(R.string.arena_seats,
                        formatNumber(arena.getCurrentRoof())));
        tb.addRow(
                getString(R.string.arena_label_VIP),
                getString(R.string.arena_seats,
                        formatNumber(arena.getCurrentVIP())));

        tb.addTitle(toUpperCase(getString(R.string.label_total)));
        tb.addRow(
                getString(R.string.arena_label_total),
                getString(R.string.arena_seats,
                        formatNumber(arena.getCurrentTotal())));
    }

    @Override
    public void onServiceUpdated(int code, String from) {

        if (from.equals(ArenaUpdate.FROM)) {

            ClubTask task = new ClubTask(getActivity(), this);
            task.execute(teamID);
        }
    }

}