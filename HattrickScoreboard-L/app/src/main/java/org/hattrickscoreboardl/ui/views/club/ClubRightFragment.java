package org.hattrickscoreboardl.ui.views.club;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.database.models.series.HSeries;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.utils.tables.MatchesTableView;
import org.hattrickscoreboardl.ui.utils.tables.SeriesTableView;

import java.util.List;


public final class ClubRightFragment extends HFragment {

    static final String TAG = (ClubRightFragment.class).getSimpleName();
    HTeam team;

    //From DB
    HSeries series;
    List<HMatch> matchesUpcoming;
    List<HMatch> matchesFinished;
    List<HTeam> teams;

    public static ClubRightFragment newInstance(HTeam team) {
        ClubRightFragment fragment = new ClubRightFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            //Get team series
            series = HSeries.findOne(HSeries.class, "LEAGUE_LEVEL_UNIT_ID = ?", String.valueOf(team.getLeagueLevelUnitID()));

            //Get teams in series
            teams = HTeam.find(HTeam.class, "LEAGUE_LEVEL_UNIT_ID = ?", new String[]{String.valueOf(team.getLeagueLevelUnitID())}, null, "POSITION ASC", "");

            //Get team matchesUpcoming
            matchesUpcoming = HMatch.findSeries(team.getTeamID(), "STATUS == 'UPCOMING'", "MATCH_DATE DESC", 20);

            //Matches finished
            matchesFinished = HMatch.findSeries(team.getTeamID(), "STATUS == 'FINISHED'", "MATCH_DATE DESC", 2);
            if(series == null || matchesUpcoming == null || matchesFinished == null || teams == null){
                return false;
            }
        }else{
            return false;
        }

        return true;
    }

    @Override
    protected View onDisplayData() {



        //////////////////////////////////////////
        //Layout Container

        ScrollView sv = new ScrollView(getActivity());
        LinearLayout llContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        llContainer.setLayoutParams(params);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(llContainer);



        LinearLayout llBackground = new LinearLayout(getActivity());
        llBackground.setOrientation(LinearLayout.VERTICAL);
        llBackground.setLayoutParams(params);
        llBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        llContainer.addView(llBackground);


        //////////////////////////////////////////
        //Classment

        SeriesTableView seriesTableView = new SeriesTableView(getActivity());
        TableLayout viewSeries = seriesTableView.createTableLayout();
        llContainer.addView(viewSeries);
        seriesTableView.createRows(teams,team,series);

        //////////////////////////////////////////
        //Matches

        MatchesTableView matchesTableView = new MatchesTableView(getActivity());
        TableLayout viewMatches = matchesTableView.createTableLayout();
        llContainer.addView(viewMatches);
        matchesTableView.createRows(matchesFinished,team, series);
        matchesTableView.createRows(matchesUpcoming,team, series);

        return sv;
    }

}
