package org.hattrickscoreboardl.ui.views.club;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.arena.HArena;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;
import org.hattrickscoreboardl.ui.views.club.components.DressUploader;
import org.hattrickscoreboardl.ui.views.club.components.LogoUploader;
import org.hattrickscoreboardl.ui.views.club.components.MatchesTendanceView;
import org.hattrickscoreboardl.ui.componants.HListButton;
import org.hattrickscoreboardl.ui.utils.CupDrawable;
import org.hattrickscoreboardl.utils.HattrickDate;

import java.util.List;


public final class ClubFragment extends HFragment {

    static final String TAG = (ClubFragment.class).getSimpleName();
    HTeam team;

    //From DB
    HArena arena;
    List<HMatch> matches;

    public static ClubFragment newInstance(HTeam team) {
        ClubFragment fragment = new ClubFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            arena = HArena.findOne(HArena.class, "ARENA_ID = ?", String.valueOf(team.getArenaID()));
            matches = HMatch.findSeries(team.getTeamID(), "STATUS = 'FINISHED'", "MATCH_DATE DESC", 5 );

            if(arena == null || matches == null){
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



        LinearLayout llBackground = new LinearLayout(getActivity());
        llBackground.setOrientation(LinearLayout.VERTICAL);
        llBackground.setLayoutParams(params);
        llBackground.setBackgroundColor(getResources().getColor(R.color.backgroundColor));
        llContainer.addView(llBackground);


        //////////////////////////////////////////
        //Supporter & teamID

        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(params);
        tv.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        tv.setText(team.getTeamID()+"");
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_supporter_diamond, 0);
        llBackground.addView(tv);


        //////////////////////////////////////////
        //LOGO

        ImageView ivLogo = new ImageView(getActivity());
        llBackground.addView(ivLogo);
        ivLogo.setImageResource(R.drawable.ic_team_logo);
        ivLogo.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ivLogo.getLayoutParams().height = (int) getResources().getDimension(R.dimen.teamLogoHeight);
        LogoUploader logoUploader = new LogoUploader();
        logoUploader.upload(getActivity(),ivLogo,team);


        //////////////////////////////////////////
        //Matches

        MatchesTendanceView matchesTendance = new MatchesTendanceView();
        LinearLayout llmatches = (LinearLayout) matchesTendance.getTendance(getActivity(),team.getTeamID(), matches);
        llmatches.setPadding(0,p,0,p);
        llBackground.addView(llmatches);


        //////////////////////////////////////////
        //Victories

        if(team.getNumberOfVictories() > 1 || team.getNumberOfUndefeated() > 1) {
            TextView tvVictories = new TextView(getActivity());
            tvVictories.setLayoutParams(params);

            if(team.getNumberOfVictories() > 1) {
                tvVictories.setText(getString(R.string.club_victories_undefeated, team.getNumberOfVictories(), team.getNumberOfUndefeated()));
            }else{
                tvVictories.setText(getString(R.string.club_undefeated, team.getNumberOfUndefeated()));
            }

            tvVictories.setGravity(Gravity.CENTER);
            tvVictories.setPadding(0, p, 0, p);
            llBackground.addView(tvVictories);
        }


        //////////////////////////////////////////
        //List Buttons
        LayoutInflater inflater = getLayoutInflater(getArguments());

        //Series
        HListButton lbSeries = new HListButton(getActivity(),inflater);
        lbSeries.setText(getString(R.string.club_team_position, team.getPosition(), team.getLeagueLevelUnitName()));
        lbSeries.setIcon(R.drawable.ic_match_series);
        lbSeries.setArrow(0);
        llContainer.addView(lbSeries.getView());

        //Cup
        if(team.isStillInCup()) {
            HListButton lbCup = new HListButton(getActivity(), inflater);
            lbCup.setText(getString(R.string.club_team_still_in_cup, team.getCupName(), team.getMatchRound(), (team.getMatchRoundsLeft()+team.getMatchRound() -1)));
            lbCup.setArrow(0);
            lbCup.setIcon(CupDrawable.getResource(team.getCupLeagueLevel(),team.getCupLevel(), team.getCupLevelIndex()));
            llContainer.addView(lbCup.getView());
        }



        //Manager
        HListButton lbManager = new HListButton(getActivity(),inflater);
        lbManager.setText(getString(R.string.club_team_since, HattrickDate.formatDate(getActivity(), team.getFoundedDate())));
        lbManager.setArrow(0);
        lbManager.setIcon(R.drawable.ic_menu_team);
        llContainer.addView(lbManager.getView());


        //Region
        HListButton lbRegion = new HListButton(getActivity(),inflater);
        lbRegion.setText(getString(R.string.club_team_country_region, team.getLeagueName(), team.getRegionName()));
        lbRegion.setArrow(0);
        lbRegion.setIcon(R.drawable.ic_location);
        llContainer.addView(lbRegion.getView());

        //Arena
        HListButton lbArena = new HListButton(getActivity(),inflater);
        lbArena.setText(getString(R.string.club_team_arena, arena.getArenaName(), formatNumber(arena.getCurrentTotal())));
        lbArena.setIcon(R.drawable.ic_menu_arena);
        lbArena.setArrow(0);
        llContainer.addView(lbArena.getView());

        //Fans
        HListButton lbFans = new HListButton(getActivity(),inflater);
        lbFans.setText(getString(R.string.club_team_fans, team.getFanclubName(), formatNumber(team.getFanclubSize())));
        lbFans.setIcon(R.drawable.ic_menu_supporters);
        lbFans.setArrow(0);
        llContainer.addView(lbFans.getView());


        //Fans
        HListButton lbRank = new HListButton(getActivity(),inflater);
        lbRank.setText(getString(R.string.club_team_rank, formatNumber(team.getTeamRank())));
        lbRank.setIcon(R.drawable.ic_ranking);
        lbRank.setArrow(0);
        llContainer.addView(lbRank.getView());

        //////////////////////////////////////////
        //Dress

        LinearLayout llDress = new LinearLayout(getActivity());
        llDress.setLayoutParams(params);
        llDress.setPadding(0, p, 0, p);
        llDress.setOrientation(LinearLayout.HORIZONTAL);
        llDress.setBackgroundResource(R.color.contentBackground);
        llContainer.addView(llDress);

        int h = (int) getResources().getDimension(R.dimen.dressHeight);

        //Home
        LinearLayout llHomeDress = new LinearLayout(getActivity());
        llHomeDress.setLayoutParams(params);
        llHomeDress.setOrientation(LinearLayout.VERTICAL);

        ImageView ivHomeDress = new ImageView(getActivity());
        ivHomeDress.setImageResource(R.drawable.ic_default_matchkit);
        llHomeDress.addView(ivHomeDress);
        ivHomeDress.getLayoutParams().height = h;

        DressUploader homeDressUploader = new DressUploader();
        homeDressUploader.upload(getActivity(),ivHomeDress,team.getDressURI(),team.getTeamID(), true);

        TextView tvHomeDress = new TextView(getActivity());
        tvHomeDress.setText(toUpperCase(R.string.team_home));
        tvHomeDress.setGravity(Gravity.CENTER);
        llHomeDress.addView(tvHomeDress);

        llDress.addView(llHomeDress);

        //Away
        LinearLayout llAwayDress = new LinearLayout(getActivity());
        llAwayDress.setLayoutParams(params);
        llAwayDress.setOrientation(LinearLayout.VERTICAL);

        ImageView ivAwayDress = new ImageView(getActivity());
        ivAwayDress.setImageResource(R.drawable.ic_default_matchkit);
        llAwayDress.addView(ivAwayDress);
        ivAwayDress.getLayoutParams().height = h;

        DressUploader awayDressUploader = new DressUploader();
        awayDressUploader.upload(getActivity(),ivAwayDress,team.getDressAlternateURI(),team.getTeamID(), false);

        TextView tvAwayDress = new TextView(getActivity());
        tvAwayDress.setText(toUpperCase(R.string.team_away));
        tvAwayDress.setGravity(Gravity.CENTER);
        llAwayDress.addView(tvAwayDress);

        llDress.addView(llAwayDress);

        return sv;
    }

}
