package org.hattrickscoreboard.application.views.economies;

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
import org.hattrickscoreboard.background.tasks.tables.EconomyUpdate;
import org.hattrickscoreboard.database.models.DEconomy;

/**
 * @author Khips
 * @since 5 august 2014
 */
public final class EconomiesFragment extends HattrickFragment {

    static final String TAG = (EconomiesFragment.class).getSimpleName();

    int teamID;
    int fragID;

    DEconomy rlEconomy;

    public EconomiesFragment newInstance(int teamID, int fragID) {
        EconomiesFragment fragment = new EconomiesFragment();
        fragment.teamID = teamID;
        fragment.fragID = fragID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        EconomiesTask task = new EconomiesTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        rlEconomy = (DEconomy) result;

        if (rlEconomy == null)
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

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        llContainer.removeAllViews();

        // Get layout parameters
        DEconomy eco = rlEconomy;

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

        if (fragID == 0) {

            // Cash & sponsors
            KTableView tbHead = new KTableView();
            tbHead.createTableView(getActivity(), pref.getRGBColor(), container);
            tbHead.addTitle(toUpperCase(R.string.finances_title_current));

            if (eco.getCurrentCash() >= 0) {
                tbHead.addRowColor(getString(R.string.finances_label_cash),
                        formatCurrency(eco.getCurrentCash()) + " ("
                                + formatCurrency(eco.getExpectedCash()) + ")",
                        R.color.default_green);
            } else {
                tbHead.addRowColor(getString(R.string.finances_label_cash),
                        formatCurrency(eco.getCurrentCash()) + " ("
                                + formatCurrency(eco.getExpectedCash()) + ")",
                        R.color.default_red);
            }

            String[] sponsors = getResources().getStringArray(
                    R.array.hattrick_sponsors);

            tbHead.addRowColored(
                    getString(R.string.finances_label_sponsorspopularity),
                    sponsors[eco.getSponsorsPopularity()] + " ("
                            + eco.getSponsorsPopularity() + ")");

            KTableView tb = new KTableView();
            tb.createTableView(getActivity(), pref.getRGBColor(), container);

            // Income
            tb.addTitle(toUpperCase(R.string.finances_title_income));
            tb.addRow(getString(R.string.finances_label_incomespectators),
                    formatCurrency(eco.getIncomeSpectators()));
            tb.addRow(getString(R.string.finances_label_incomesponsors),
                    formatCurrency(eco.getIncomeSponsors()));

            if (eco.getIncomeFinancial() != 0) {
                tb.addRow(getString(R.string.finances_label_incomefinancial),
                        formatCurrency(eco.getIncomeFinancial()));
            }

            tb.addRow(getString(R.string.finances_label_incomesoldplayers),
                    formatCurrency(eco.getIncomeSoldPlayers()));
            tb.addRow(
                    getString(R.string.finances_label_incomesoldplayerscommission),
                    formatCurrency(eco.getIncomeSoldPlayersCommission()));
            tb.addRow(getString(R.string.finances_label_incometemporary),
                    formatCurrency(eco.getIncomeTemporary()));

            tb.addTitle(toUpperCase(R.string.finances_title_costs));

            tb.addRow(getString(R.string.finances_label_costs_players),
                    formatCurrency(eco.getCostsPlayers()));
            tb.addRow(getString(R.string.finances_label_costs_arena),
                    formatCurrency(eco.getCostsArena()));

            if (eco.getCostsArenaBuilding() != 0) {
                tb.addRow(
                        getString(R.string.finances_label_costs_arenabuilding),
                        formatCurrency(eco.getCostsArenaBuilding()));
            }

            tb.addRow(getString(R.string.finances_label_costs_staff),
                    formatCurrency(eco.getCostsStaff()));
            tb.addRow(getString(R.string.finances_label_costs_youth),
                    formatCurrency(eco.getCostsYouth()));
            tb.addRow(getString(R.string.finances_label_costs_boughtplayers),
                    formatCurrency(eco.getCostsBoughtPlayers()));
            tb.addRow(getString(R.string.finances_label_costs_temporary),
                    formatCurrency(eco.getCostsTemporary()));
            tb.addRow(getString(R.string.finances_label_costs_financial),
                    formatCurrency(eco.getCostsFinancial()));

            tb.addTitle(toUpperCase(R.string.label_total));
            tb.addRow(getString(R.string.finances_label_incomesum),
                    formatCurrency(eco.getIncomeSum()));
            tb.addRow(getString(R.string.finances_label_costs_sum),
                    formatCurrency(eco.getCostsSum()));

            if (eco.getExpectedWeeksTotal() >= 0) {
                tb.addRowColor(getString(R.string.finances_label_expectedcash),
                        formatCurrency(eco.getExpectedWeeksTotal()),
                        R.color.default_green);
            } else {
                tb.addRowColor(getString(R.string.finances_label_expectedcash),
                        formatCurrency(eco.getExpectedWeeksTotal()),
                        R.color.default_red);
            }

            return;
        }

        // Last week
        if (fragID == 1) {

            KTableView tb = new KTableView();
            tb.createTableView(getActivity(), pref.getRGBColor(), container);

            // Income
            tb.addTitle(toUpperCase(R.string.finances_title_income));
            tb.addRow(getString(R.string.finances_label_incomespectators),
                    formatCurrency(eco.getLastIncomeSpectators()));
            tb.addRow(getString(R.string.finances_label_incomesponsors),
                    formatCurrency(eco.getLastIncomeSponsors()));

            if (eco.getLastIncomeFinancial() != 0) {
                tb.addRow(getString(R.string.finances_label_incomefinancial),
                        formatCurrency(eco.getLastIncomeFinancial()));
            }

            tb.addRow(getString(R.string.finances_label_incomesoldplayers),
                    formatCurrency(eco.getLastIncomeSoldPlayers()));
            tb.addRow(
                    getString(R.string.finances_label_incomesoldplayerscommission),
                    formatCurrency(eco.getLastIncomeSoldPlayersCommission()));
            tb.addRow(getString(R.string.finances_label_incometemporary),
                    formatCurrency(eco.getLastIncomeTemporary()));

            tb.addTitle(toUpperCase(R.string.finances_title_costs));

            tb.addRow(getString(R.string.finances_label_costs_players),
                    formatCurrency(eco.getLastCostsPlayers()));
            tb.addRow(getString(R.string.finances_label_costs_arena),
                    formatCurrency(eco.getLastCostsArena()));

            if (eco.getLastCostsArenaBuilding() != 0) {
                tb.addRow(
                        getString(R.string.finances_label_costs_arenabuilding),
                        formatCurrency(eco.getLastCostsArenaBuilding()));
            }

            tb.addRow(getString(R.string.finances_label_costs_staff),
                    formatCurrency(eco.getLastCostsStaff()));
            tb.addRow(getString(R.string.finances_label_costs_youth),
                    formatCurrency(eco.getLastCostsYouth()));
            tb.addRow(getString(R.string.finances_label_costs_boughtplayers),
                    formatCurrency(eco.getLastCostsBoughtPlayers()));
            tb.addRow(getString(R.string.finances_label_costs_temporary),
                    formatCurrency(eco.getLastCostsTemporary()));
            tb.addRow(getString(R.string.finances_label_costs_financial),
                    formatCurrency(eco.getLastCostsFinancial()));

            tb.addTitle(toUpperCase(R.string.label_total));
            tb.addRow(getString(R.string.finances_label_incomesum),
                    formatCurrency(eco.getLastIncomeSum()));
            tb.addRow(getString(R.string.finances_label_costs_sum),
                    formatCurrency(eco.getLastCostsSum()));

            if (eco.getLastWeeksTotal() >= 0) {
                tb.addRowColor(getString(R.string.finances_label_expectedcash),
                        formatCurrency(eco.getLastWeeksTotal()),
                        R.color.default_green);
            } else {
                tb.addRowColor(getString(R.string.finances_label_expectedcash),
                        formatCurrency(eco.getLastWeeksTotal()),
                        R.color.default_red);
            }

            return;
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        Log.v(TAG, "Receive broadcast: [" + code + "] from '" + from + "'.");

        if (from.equals(EconomyUpdate.FROM)) {
            EconomiesTask task = new EconomiesTask(getActivity(), this);
            task.execute(teamID);
        }
    }

}