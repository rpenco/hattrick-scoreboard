package org.hattrickscoreboardl.ui.views.club;

import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HFlag;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.teams.HTrophy;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.views.club.components.FlagsView;
import org.hattrickscoreboardl.ui.views.club.components.TrophiesView;
import org.hattrickscoreboardl.ui.componants.HContentView;
import org.hattrickscoreboardl.ui.componants.HTextView;

import java.util.List;


public final class TrophyFragment extends HFragment {

    static final String TAG = (TrophyFragment.class).getSimpleName();
    HTeam team;

    //From DB
    List<HTrophy> trophies;
    List<HFlag> homeFlags;
    List<HFlag> awayflags;

    public static TrophyFragment newInstance(HTeam team) {
        TrophyFragment fragment = new TrophyFragment();
        fragment.team = team;
        return fragment;
    }


    @Override
    public boolean onPrepareData(){

        if(team != null) {
            trophies = HTrophy.find(HTrophy.class, "TEAM_ID = ?", String.valueOf(team.getTeamID()));
            homeFlags = HFlag.find(HFlag.class, "TEAM_ID = ? and FLAG_TYPE = 'home' ", String.valueOf(team.getTeamID()));
            awayflags = HFlag.find(HFlag.class, "TEAM_ID = ? and FLAG_TYPE = 'away'", String.valueOf(team.getTeamID()));

            return true;
        }

        return false;
    }

    @Override
    protected View onDisplayData() {

        int p = (int) getResources().getDimension(R.dimen.contentPadding);

        //////////////////////////////////////////
        //Container

        ScrollView sv = new ScrollView(getActivity());
        LinearLayout llContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        llContainer.setLayoutParams(params);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        sv.addView(llContainer);


        //////////////////////////////////////
        // Trophies

        LinearLayout llTrophies = new LinearLayout(getActivity());
        llTrophies.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        llTrophies.setLayoutParams(params);
        llTrophies.setPadding(p,p,p,p);
        llTrophies.setOrientation(LinearLayout.HORIZONTAL);
        llTrophies.setGravity(Gravity.CENTER);
        llContainer.addView(llTrophies);

        TrophiesView trophiesView  = new TrophiesView();
        GridLayout gvTrophies = trophiesView.getView(getActivity(), trophies);
        llTrophies.addView(gvTrophies);


        //////////////////////////////////////
        // Flags

        //Home awayflags

        HContentView llHomeFlag = new HContentView(getActivity());
        llHomeFlag.setOrientation(LinearLayout.VERTICAL);
        llHomeFlag.setGravity(Gravity.CENTER);
        llContainer.addView(llHomeFlag);
        llHomeFlag.lineSeparator();


        //Title
        HTextView tvTitleHomeFlag = new HTextView(getActivity());
        tvTitleHomeFlag.setText(getString(R.string.club_trophies_country_received, homeFlags.size()));
        llHomeFlag.addView(tvTitleHomeFlag);

        FlagsView flagsView  = new FlagsView();
        GridLayout gvFlags = flagsView.getView(getActivity(), homeFlags);
        llHomeFlag.addView(gvFlags);


        //Away awayflags
        HContentView llAwayFlag = new HContentView(getActivity());
        llAwayFlag.setOrientation(LinearLayout.VERTICAL);
        llAwayFlag.setGravity(Gravity.CENTER);
        llContainer.addView(llAwayFlag);

        //Title
        HTextView tvTitleAwayFlag = new HTextView(getActivity());
        tvTitleAwayFlag.setText(getString(R.string.club_trophies_country_visited, awayflags.size()));
        llAwayFlag.addView(tvTitleAwayFlag);

        FlagsView awayFlagsView  = new FlagsView();
        GridLayout gvAwayFlags = awayFlagsView.getView(getActivity(), awayflags);
        llAwayFlag.addView(gvAwayFlags);


        return sv;
    }

}
