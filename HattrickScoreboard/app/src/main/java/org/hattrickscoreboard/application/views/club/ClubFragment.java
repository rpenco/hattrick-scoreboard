package org.hattrickscoreboard.application.views.club;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.TextViewColored;
import org.hattrickscoreboard.application.utils.graphics.DressUploader;
import org.hattrickscoreboard.application.utils.graphics.LogoUploader;
import org.hattrickscoreboard.application.utils.graphics.statics.CupTypeDrawable;
import org.hattrickscoreboard.background.tasks.tables.ArenaUpdate;
import org.hattrickscoreboard.background.tasks.tables.SeriesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.background.tasks.tables.WorldUpdate;
import org.hattrickscoreboard.database.models.DArena;
import org.hattrickscoreboard.database.models.DSeries;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.relations.RClub;

public final class ClubFragment extends HattrickFragment {

    static final String TAG = (ClubFragment.class).getSimpleName();

    // selected team
    int teamID;

    // Result from task
    private RClub rteam;

    public ClubFragment newInstance(int teamID) {
        ClubFragment fragment = new ClubFragment();
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
        setStubLayout(R.layout.club_home_fragment);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        DTeam team = rteam.getTeam();
        DArena arena = rteam.getArena();
        DWorld world = rteam.getWorld();
        DSeries league = rteam.getLeague();

        View v = getFragmentView();
        if (v == null || getActivity() == null || team == null)
            return;

        // Get preferences
        Preferences pref = new Preferences(getActivity());
        int prefColor = pref.getRGBColor();

        // ///////////////////////////////////////////////////

        // Uppercase some title
        upperCaseTextView(v, R.id.tvTitleInfos);
        upperCaseTextView(v, R.id.tvTitleDress);
        upperCaseTextView(v, R.id.tvLabelHome);
        upperCaseTextView(v, R.id.tvLabelAway);

        // Team name
        TextView tvTeamName = (TextView) v.findViewById(R.id.tvTeamName);
        tvTeamName.setText(toUpperCase(team.getTeamName()));

        // Division
        TextViewColored tvDivision = new TextViewColored(
                v.findViewById(R.id.tvDivision), prefColor);
        tvDivision.addText(
                getString(R.string.club_label_position, league.getPosition(),
                        team.getLeagueLevelUnitName())).setText();

        // National Cup
        TextViewColored tvCup = new TextViewColored(v.findViewById(R.id.tvCup),
                prefColor);
        if (team.isStillInCup()) {
            tvCup.addText(
                    getString(R.string.club_label_stillcup, team.getCupName()))
                    .addText2(
                            "(" + team.getCupMatchRound() + "/"
                                    + team.getCupMatchRoundsLeft() + ")")
                    .setText();

            // Custom icon cup
            TextView tCup = tvCup.getTextView();
            tCup.setCompoundDrawablesWithIntrinsicBounds(
                    CupTypeDrawable.getDrawable(getActivity(), team), null,
                    null, null);
        } else {
            tvCup.setVisibility(View.GONE);
        }

        // Team Id
        TextView tvTeamID = (TextView) v.findViewById(R.id.tvTeamID);
        tvTeamID.setText("(" + team.getTeamID() + ")");

        // Team region
        TextViewColored tvRegion = new TextViewColored(
                v.findViewById(R.id.tvRegion), prefColor);
        tvRegion.addLabel(getString(R.string.club_label_place))
                .addValue(world.getCountryName() + ", " + team.getRegionName())
                .setText();

        // Team supporters
        TextViewColored tvSupporters = new TextViewColored(
                v.findViewById(R.id.tvSupporters), prefColor);
        tvSupporters
                .addLabel(getString(R.string.club_label_fanclub))
                .addValue(
                        getString(R.string.club_value_fanclub,
                                formatNumber(team.getFanclubSize()))).setText();

        // Team arena
        TextViewColored tvArena = new TextViewColored(
                v.findViewById(R.id.tvArena), prefColor);
        tvArena.addLabel(getString(R.string.club_label_arena))
                .addValue(arena.getArenaName())
                .addText2(
                        "("
                                + getString(R.string.arena_seats,
                                formatNumber(arena.getCurrentTotal()))
                                + ")").setText();

        // Team rank
        TextViewColored tvRank = new TextViewColored(
                v.findViewById(R.id.tvRank), prefColor);
        tvRank.addLabel(getString(R.string.club_label_rank))
                .addValue(
                        getString(R.string.club_value_rank,
                                formatNumber(team.getTeamRank()))).setText();

        // Team undefeated and victories
        TextView tvInfos = (TextView) v.findViewById(R.id.tvInfos);
        if (team.getNumberOfUndefeated() > 1 && team.getNumberOfVictories() > 1) {
            tvInfos.setText(getString(R.string.club_label_victories,
                    team.getNumberOfUndefeated(), team.getNumberOfVictories()));
        } else if (team.getNumberOfUndefeated() > 1) {
            tvInfos.setText(getString(R.string.club_label_undefeated,
                    team.getNumberOfUndefeated()));
        } else {
            tvInfos.setVisibility(View.GONE);
        }

        // Logo team
        ImageView ivLogo = (ImageView) v.findViewById(R.id.ivLogo);

        LogoUploader logoUp = new LogoUploader();
        logoUp.upload(getActivity(), ivLogo, team);

        // Dress home
        ImageView ivHomeDress = (ImageView) v.findViewById(R.id.ivDressHome);
        DressUploader homeDress = new DressUploader();
        homeDress.upload(getActivity(), ivHomeDress, team.getDressURI(),
                team.getTeamID(), true);

        // Dress away
        ImageView ivAwayDress = (ImageView) v.findViewById(R.id.ivDressAway);
        DressUploader awayDress = new DressUploader();
        awayDress.upload(getActivity(), ivAwayDress,
                team.getDressAlternateURI(), team.getTeamID(), false);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(ArenaUpdate.FROM)
                || from.equals(SeriesUpdate.FROM)
                || from.equals(WorldUpdate.FROM)) {

            ClubTask task = new ClubTask(getActivity(), this);
            task.execute(teamID);
        }
    }

}
