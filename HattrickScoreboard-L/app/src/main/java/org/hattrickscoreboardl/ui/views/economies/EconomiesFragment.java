package org.hattrickscoreboardl.ui.views.economies;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.economy.HEconomy;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.utils.tables.StatsTableView;
import org.hattrickscoreboardl.ui.utils.titles.TitleView;


public final class EconomiesFragment extends HFragment {

    static final String TAG = (EconomiesFragment.class).getSimpleName();

    HTeam team;
    int week;
    HEconomy economy;

    public static EconomiesFragment newInstance(HTeam team, int week) {
        EconomiesFragment fragment = new EconomiesFragment();
        fragment.team = team;
        fragment.week = week;
        return fragment;
    }


    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {
            economy = HEconomy.findOne(HEconomy.class, "TEAM_ID = ?", String.valueOf(/*team.getTeamID()*/ 177327));
            if(economy == null){
                return false;
            }
        }else{
            return false;
        }

        return true;
    }

    @Override
    protected View onDisplayData() {

        int p = (int) getResources().getDimension(R.dimen.contentPadding);

        //////////////////////////////////////////
        //Layout Container

        ScrollView sv = new ScrollView(getActivity());
        LinearLayout llContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        llContainer.setLayoutParams(params);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(llContainer);

        //////////////////////////////////////////
        //Statistiques

        TitleView title = new TitleView(getActivity());
        title.setText("Semaine en cours");
        llContainer.addView(title);

        StatsTableView statsTableView = new StatsTableView(getActivity());
        TableLayout layout = statsTableView.createTableLayout();
        layout.setBackgroundResource(R.color.contentBackground);
        layout.setPadding(p,p,p,p);
        llContainer.addView(layout);

        statsTableView.createHeaders((week == 0)? "Semaine en cours":"La semaine dernière","");

        statsTableView.createHeaders("","Dépenses");

        statsTableView.createRow("Salaires des joueurs", formatNumber(economy.getCostsPlayers()));
        statsTableView.createRow("Entretien du stade", formatNumber(economy.getCostsArena()));
        statsTableView.createRow("Travaux du stade", formatNumber(economy.getCostsArenaBuilding()));
        statsTableView.createRow("Employés", formatNumber(economy.getCostsStaff()));
        statsTableView.createRow("Formation des jeunes", formatNumber(economy.getCostsYouth()));
        statsTableView.createRow("Achats de joueurs", formatNumber(economy.getCostsBoughtPlayers()));
        statsTableView.createRow("Autre", formatNumber(economy.getCostsTemporary()));
        statsTableView.createRow("Intérêts", formatNumber(economy.getCostsFinancial()));

        statsTableView.createHeaders("", "Recette");

        statsTableView.createRow("Recettes des matchs", formatNumber(economy.getIncomeSpectators()));
        statsTableView.createRow("Sponsors", formatNumber(economy.getIncomeSponsors()));
        statsTableView.createRow("Ventes de joueurs", formatNumber(economy.getIncomeSoldPlayers()));
        statsTableView.createRow("Commission", formatNumber(economy.getIncomeSoldPlayersCommission()));
        statsTableView.createRow("Autre", formatNumber(economy.getIncomeTemporary()));

        statsTableView.createHeaders("Total des dépenses",formatNumber(economy.getCostsSum()));
        statsTableView.createHeaders("Total des recettes",formatNumber(economy.getIncomeSum()));
        statsTableView.createHeaders("Résultat prévisionnel",formatNumber(economy.getExpectedWeeksTotal()));

        return  sv;
    }


}
