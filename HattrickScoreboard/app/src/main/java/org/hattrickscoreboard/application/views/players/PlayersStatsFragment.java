package org.hattrickscoreboard.application.views.players;

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
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.database.relations.RPlayers;

/**
 * @author Khips
 * @since 14 aot 2014
 */
public class PlayersStatsFragment extends HattrickFragment {

    static final String TAG = (PlayersStatsFragment.class).getSimpleName();

    int teamID;
    RPlayers rlPlayers;

    public PlayersStatsFragment newInstance(int teamID, boolean youth) {
        PlayersStatsFragment fragment = new PlayersStatsFragment();
        fragment.teamID = teamID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        PlayersTask task = new PlayersTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rlPlayers = (RPlayers) result;

        if (rlPlayers == null)
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

        // Get layout parameters
        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        // for after update...
        if (llContainer == null) {
            return;
        }

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

        // Get player stats
        PlayersFunction plf = new PlayersFunction(rlPlayers.getPlayerlist(),
                rlPlayers.getTeam());

        Preferences pref = new Preferences(getActivity());

        // Create table
        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);

        tb.addTitle(toUpperCase(R.string.players_label_stats_team_total));
        tb.addRow(R.string.players_label_stats_TSI,
                formatNumber(plf.getTotalTSI()));
        tb.addRow(R.string.player_label_stats_costs,
                formatCurrency(plf.getTotalSalary()));
        tb.addRow(R.string.player_label_stats_nationalities, ""
                + plf.getTotalNationalities().size());
        tb.addRow(R.string.player_label_stats_injuries, ""
                + plf.getTotalInjuries().size());
        tb.addRow(R.string.player_label_stats_specialities, ""
                + plf.getTotalSpeciality().size());
        tb.addRow(R.string.player_label_stats_red_cards, ""
                + plf.getTotalReds().size());
        tb.addRow(R.string.player_label_stats_yellow_cards, ""
                + plf.getTotalYellows().size());

        tb.addTitle(toUpperCase(R.string.player_label_stats_team_average));
        tb.addRow(R.string.players_label_stats_TSI,
                "" + formatNumber(plf.getAverageTSI()));
        tb.addRow(R.string.player_label_stats_costs,
                formatCurrency(plf.getAverageSalary()));
        tb.addRow(
                R.string.player_label_stats_age,
                +(int) plf.getAverageAgeYears() + " ("
                        + (int) plf.getAverageAgeDays() + ")");

        String[] skills = getResources()
                .getStringArray(R.array.hattrick_skills);

        tb.addRow(
                R.string.player_label_stats_form,
                skills[(int) plf.getAverageForme()] + " ("
                        + (int) plf.getAverageForme() + ")");

        tb.addRow(
                R.string.player_label_stats_endurance,
                skills[(int) plf.getAverageEndurance()] + " ("
                        + (int) plf.getAverageEndurance() + ")");
        tb.addRow(
                R.string.player_label_stats_experience,
                skills[(int) plf.getAverageExperience()] + " ("
                        + (int) plf.getAverageExperience() + ")");

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(PlayersUpdate.FROM)) {

            PlayersTask task = new PlayersTask(getActivity(), this);
            task.execute(teamID);
        }
    }

}