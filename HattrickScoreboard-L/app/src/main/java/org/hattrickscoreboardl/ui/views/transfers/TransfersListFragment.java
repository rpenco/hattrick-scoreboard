package org.hattrickscoreboardl.ui.views.transfers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.players.HPlayer;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.utils.tables.StatsTableView;
import org.hattrickscoreboardl.utils.statistics.PlayersStats;

import java.util.List;


public final class TransfersListFragment extends HFragment {

    static final String TAG = (TransfersListFragment.class).getSimpleName();

    HTeam team;
    List<HPlayer> players;
    HPlayer trainer;

    public static TransfersListFragment newInstance(HTeam team) {
        TransfersListFragment fragment = new TransfersListFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            players = HPlayer.find(HPlayer.class, "TEAM_ID = ? and PLAYER_ID <> ?",
                    new String[]{String.valueOf(team.getTeamID()), String.valueOf(team.getTrainerID())});
            if(players == null){
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

        StatsTableView statsTableView = new StatsTableView(getActivity());
        TableLayout layout = statsTableView.createTableLayout();
        layout.setBackgroundResource(R.color.contentBackground);
        layout.setPadding(p,p,p,p);
        llContainer.addView(layout);

        statsTableView.createHeaders("Général","");

        statsTableView.createRow("Joueurs", formatNumber(players.size()));
        statsTableView.createRow("TSI", formatNumber(PlayersStats.TSITotal(players)));
        statsTableView.createRow("Salaire", formatNumber(PlayersStats.SalaryTotal(players)));
        statsTableView.createRow("Age", PlayersStats.AgeAverage(players)+"."+PlayersStats.AgeDayAverage(players));
        statsTableView.createRow("Blessés légers", String.valueOf(PlayersStats.InjuriesBruised(players).size()));
        statsTableView.createRow("Blessés", String.valueOf(PlayersStats.InjuriesBadly(players).size()));
        statsTableView.createRow("Cartons jaunes", String.valueOf(PlayersStats.YellowCards(players).size()));
        statsTableView.createRow("Cartons rouges", String.valueOf(PlayersStats.RedCards(players).size()));

        statsTableView.createHeaders("Caractéristiques", "");

        if(PlayersStats.PassingAverage(players) != 0) {
            statsTableView.createRow("Gardien", String.valueOf(PlayersStats.KeeperAverage(players)));
            statsTableView.createRow("Défense", String.valueOf(PlayersStats.DefenderAverage(players)));
            statsTableView.createRow("Construction", String.valueOf(PlayersStats.PlaymakerAverage(players)));
            statsTableView.createRow("Ailier", String.valueOf(PlayersStats.WingerAverage(players)));
            statsTableView.createRow("Passe", String.valueOf(PlayersStats.PassingAverage(players)));
            statsTableView.createRow("Buteur", String.valueOf(PlayersStats.ScorerAverage(players)));
            statsTableView.createRow("Coup franc", String.valueOf(PlayersStats.SetPiecesAverage(players)));
        }
        statsTableView.createRow("Etoiles (debut/fin du match)", String.format("%.2f", PlayersStats.StarsAverage(players))+"/"+String.format("%.2f", PlayersStats.StarsEndOfGameAverage(players)));

        statsTableView.createHeaders("Spécialités", "");

        statsTableView.createRow("Techniques", String.valueOf(PlayersStats.Technicians(players).size()));
        statsTableView.createRow("Imprévisibles", String.valueOf(PlayersStats.Unpredictables(players).size()));
        statsTableView.createRow("Costauds", String.valueOf(PlayersStats.Powerfull(players).size()));
        statsTableView.createRow("Joueurs de tête", String.valueOf(PlayersStats.HeadPlayers(players).size()));
        statsTableView.createRow("Rapides", String.valueOf(PlayersStats.QuickPlayers(players).size()));

        return  sv;
    }


}
