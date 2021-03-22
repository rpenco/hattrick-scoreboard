package org.hattrickscoreboardl.ui.views.arena;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.arena.HArena;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.componants.HColumnsView;
import org.hattrickscoreboardl.ui.componants.HListButton;
import org.hattrickscoreboardl.utils.HattrickDate;

import java.util.ArrayList;
import java.util.List;


public final class ArenaFragment extends HFragment {

    static final String TAG = (ArenaFragment.class).getSimpleName();

    HTeam team;
    HArena arena;

    public static ArenaFragment newInstance(HTeam team) {
        ArenaFragment fragment = new ArenaFragment();
        fragment.team = team;
        return fragment;
    }


    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            arena = HArena.findOne(HArena.class, "ARENA_ID = ?", String.valueOf(team.getArenaID()));
            team = HTeam.findOne(HTeam.class, "TEAM_ID = ?", String.valueOf(arena.getTeamID()));
            if(arena == null || arena == null){
                return false;
            }
        }else{
            return false;
        }

        return true;
    }

    @Override
    protected View onDisplayData() {

        LayoutInflater inflater = getLayoutInflater(getArguments());

        //////////////////////////////////////////
        //Container

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        ScrollView sv = new ScrollView(getActivity());
        sv.setLayoutParams(params);
        LinearLayout llContainer = new LinearLayout(getActivity());
        llContainer.setLayoutParams(params);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(llContainer);


        //////////////////////////////////////////
        //Supporter & teamID

        LinearLayout llBackground = new LinearLayout(getActivity());
        llBackground.setLayoutParams(params);
        llBackground.setOrientation(LinearLayout.VERTICAL);
        llBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        llContainer.addView(llBackground);

        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(params);
        tv.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        tv.setText(arena.getArenaID()+"");
        llBackground.addView(tv);


        //////////////////////////////////////////
        //Arena Name

        TextView tvArena = new TextView(getActivity());
        tvArena.setLayoutParams(params);
        tvArena.setGravity(Gravity.CENTER);
        tvArena.setText(arena.getArenaName());
        tvArena.setTextSize(40);
        llBackground.addView(tvArena);


        TextView tvArenaCapactiy = new TextView(getActivity());
        params.bottomMargin = 25;
        tvArenaCapactiy.setLayoutParams(params);
        tvArenaCapactiy.setGravity(Gravity.CENTER);
        if(arena.getExpansionDate() == null) {
            tvArenaCapactiy.setText(getString(R.string.arena_seats, formatNumber(arena.getCurrentTotal())));
        }else{
            tvArenaCapactiy.setText(getString(R.string.arena_after_building, formatNumber(arena.getExpandedTotal())));
        }
        tvArenaCapactiy.setTextSize(25);
        llBackground.addView(tvArenaCapactiy);

        //////////////////////////////////////////
        //Arena Building

        if(arena.getExpansionDate() != null) {

            LinearLayout llBuilding = new LinearLayout(getActivity());
            llBuilding.setPadding(10,10,10,10);
            llBuilding.setLayoutParams(params);
            llBuilding.setBackgroundColor(getResources().getColor(R.color.orange));

            TextView tvBuilding = new TextView(getActivity());
            tvBuilding.setLayoutParams(params);
            tvBuilding.setGravity(Gravity.CENTER);
            tvBuilding.setText(toUpperCase(R.string.arena_building_in_progress));
            llBuilding.addView(tvBuilding);
            llContainer.addView(llBuilding);
        }
        //////////////////////////////////////////
        //List infos

        //Team
        HListButton lbTeam = new HListButton(getActivity(),inflater);
        lbTeam.setText(team.getTeamName());
        lbTeam.setArrow(0);
        lbTeam.setIcon(R.drawable.ic_menu_team);
        llContainer.addView(lbTeam.getView());

        //Arena details
        HColumnsView columns = new HColumnsView(getActivity());
        llContainer.addView(columns);

        List<String> title;
        List<String> value;

        if(arena.getExpansionDate() == null) {
            title = new ArrayList<String>();
            title.add(getString(R.string.arena_last_build));
            title.add(getString(R.string.arena_basics));
            title.add(getString(R.string.arena_terraces));
            title.add(getString(R.string.arena_roof));
            title.add(getString(R.string.arena_vip));

            value = new ArrayList<String>();
            value.add(HattrickDate.formatDate(getActivity(), arena.getRebuiltDate()));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getCurrentBasic())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getCurrentTerraces())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getCurrentRoof())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getCurrentVIP())));

        }else{

            title = new ArrayList<String>();
            title.add(getString(R.string.arena_end_date));
            title.add(getString(R.string.arena_basics_expected));
            title.add(getString(R.string.arena_terraces_expected));
            title.add(getString(R.string.arena_roof_expected));
            title.add(getString(R.string.arena_vip_expected));

            value = new ArrayList<String>();
            value.add(arena.getExpansionDate());
            value.add(getString(R.string.arena_seats, formatNumber(arena.getExpandedBasic())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getExpandedTerraces())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getExpandedRoof())));
            value.add(getString(R.string.arena_seats, formatNumber(arena.getExpandedVIP())));
        }

        columns.populate(title, value);
        columns.separatorBottom();

        ////////////////////////////
        //Supporter Only - Arena Average

        if(arena.getAverageTotal() > 0) {

            //Average
            HColumnsView columnsAverage = new HColumnsView(getActivity());
            llContainer.addView(columnsAverage);

            List<String> titleAverage;
            List<String> valueAverage;

            titleAverage = new ArrayList<String>();
            titleAverage.add(toUpperCase(R.string.statistiques));
            titleAverage.add(getString(R.string.total));
            titleAverage.add(getString(R.string.arena_basics));
            titleAverage.add(getString(R.string.arena_terraces));
            titleAverage.add(getString(R.string.arena_roof));
            titleAverage.add(getString(R.string.arena_vip));

            valueAverage = new ArrayList<String>();
            valueAverage.add(getString(R.string.arena_min_average_max));
            valueAverage.add(formatNumber(arena.getLeastTotal())+" - "+ formatNumber(arena.getAverageTotal())+" - "+formatNumber(arena.getMostTotal()));
            valueAverage.add(formatNumber(arena.getLeastBasic())+" - "+ formatNumber(arena.getAverageBasic())+" - "+formatNumber(arena.getMostBasic()));
            valueAverage.add(formatNumber(arena.getLeastTerraces())+" - "+ formatNumber(arena.getAverageTerraces())+" - "+formatNumber(arena.getMostTerraces()));
            valueAverage.add(formatNumber(arena.getLeastRoof())+" - "+ formatNumber(arena.getAverageRoof())+" - "+formatNumber(arena.getMostRoof()));
            valueAverage.add(formatNumber(arena.getLeastVIP())+" - "+ formatNumber(arena.getAverageVIP())+" - "+formatNumber(arena.getMostVIP()));

            columnsAverage.populate(titleAverage, valueAverage);

        }
        return sv;
    }


}
