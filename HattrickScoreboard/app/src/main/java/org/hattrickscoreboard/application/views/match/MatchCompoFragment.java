package org.hattrickscoreboard.application.views.match;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.hattrick.constants.HMatchRoleID;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.views.match.workers.HattrickCompo;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatch;

import java.util.ArrayList;

public class MatchCompoFragment extends HattrickFragment {

    static final String TAG = (MatchCompoFragment.class).getSimpleName();

    int matchID;
    String sourceSystem;

    private RMatch matchRes;

    public final MatchCompoFragment newInstance(int matchID, String sourceSystem) {
        MatchCompoFragment f = new MatchCompoFragment();
        f.matchID = matchID;
        f.sourceSystem = sourceSystem;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        MatchTask task = new MatchTask(getActivity(), this);
        task.execute(matchID, sourceSystem);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        matchRes = (RMatch) result;

        if (matchRes == null)
            return;

        setStubLayout(R.layout.fragment_compo);

        // Populate all
        onPopulateView();
    }

    @Override
    protected void onPopulateView() {
        super.onPopulateView();

        Match match = matchRes.getMatch();
        DTeam homeTeam = matchRes.getHomeTeam();
        DTeam awayTeam = matchRes.getAwayTeam();
        ArrayList<LineUp> homeLineUp = matchRes.getHomeLineup();
        ArrayList<LineUp> awayLineUp = matchRes.getAwayLineup();

        LinearLayout rlCompo = (LinearLayout) getFragmentView().findViewById(
                R.id.rlCompo);

        if (rlCompo == null)
            return;

        Preferences pref = new Preferences(getActivity());
        ColorTheme theme = new ColorTheme(pref.getRGBColor());

        // Create composition
        HattrickCompo.Compo(getActivity(), theme, rlCompo, match, homeLineUp,
                awayLineUp);

        // Home team name
        TextView tvHomeTeam = (TextView) getFragmentView().findViewById(
                R.id.tvHomeTeam);
        tvHomeTeam.setText(match.getHomeFormation() + " - "
                + toUpperCase(homeTeam.getTeamName()));

        // Away team name
        TextView tvAwayTeam = (TextView) getFragmentView().findViewById(
                R.id.tvAwayTeam);
        tvAwayTeam.setText(match.getAwayFormation() + " - "
                + toUpperCase(awayTeam.getTeamName()));

        // Substitutions

        LinearLayout llHomeSubs = (LinearLayout) getFragmentView()
                .findViewById(R.id.llHomeSubs);

        LinearLayout llAwaySubs = (LinearLayout) getFragmentView()
                .findViewById(R.id.llAwaySubs);

        if (homeLineUp != null) {

            // Clear all
            llHomeSubs.removeAllViews();

            for (LineUp lineUp : homeLineUp) {
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_KEEPER, llHomeSubs,
                        R.string.match_subsitution_keeper);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_DEFENDER,
                        llHomeSubs, R.string.match_subsitution_defender);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_INNER_MIDFIELD,
                        llHomeSubs, R.string.match_subsitution_midflied);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_FORWARD,
                        llHomeSubs, R.string.match_subsitution_forward);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_WINGER, llHomeSubs,
                        R.string.match_subsitution_winger);
            }
        }

        if (awayLineUp != null) {

            // Clear all
            llAwaySubs.removeAllViews();

            for (LineUp lineUp : awayLineUp) {
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_KEEPER, llAwaySubs,
                        R.string.match_subsitution_keeper);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_DEFENDER,
                        llAwaySubs, R.string.match_subsitution_defender);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_INNER_MIDFIELD,
                        llAwaySubs, R.string.match_subsitution_midflied);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_FORWARD,
                        llAwaySubs, R.string.match_subsitution_forward);
                addplayer(lineUp, HMatchRoleID.SUBSTITUTION_WINGER, llAwaySubs,
                        R.string.match_subsitution_winger);
            }
        }
    }

    public void createLineSubstitution(LinearLayout parent, LineUp player,
                                       String roleName) {

        RelativeLayout llSub = (RelativeLayout) getActivity()
                .getLayoutInflater().inflate(R.layout.row_compo_substitution,
                        null);

        parent.addView(llSub);

        TextView tvRoleName = (TextView) llSub.findViewById(R.id.tvRole);
        TextView tvName = (TextView) llSub.findViewById(R.id.tvPlayerName);
        TextView tvStars = (TextView) llSub.findViewById(R.id.tvStars);
        ImageView ivSubs = (ImageView) llSub.findViewById(R.id.ivSubstitution);

        tvRoleName.setText(roleName);
        tvName.setText(player.getFirstName() + " " + player.getLastName());

        if (player.getRatingStarsEndOfMatch() > 0) {
            tvStars.setText(player.getRatingStarsEndOfMatch() + "");
        } else {
            tvStars.setVisibility(View.GONE);
            ivSubs.setVisibility(View.GONE);
        }

    }

    private void addplayer(LineUp player, int roleID, LinearLayout parent,
                           int roleName) {
        addplayer(player, roleID, parent, toUpperCase(roleName));
    }

    private void addplayer(LineUp player, int roleID, LinearLayout parent,
                           String roleName) {
        if (player.getRoleID() == roleID) {
            createLineSubstitution(parent, player, roleName);
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)
                || from.equals(LineUpUpdate.FROM)
                || from.equals(LiveUpdate.FROM)) {

            MatchTask task = new MatchTask(getActivity(), this);
            task.execute(matchID, sourceSystem);
        }
    }
}