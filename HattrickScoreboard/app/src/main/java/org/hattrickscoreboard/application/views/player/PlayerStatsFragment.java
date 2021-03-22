package org.hattrickscoreboard.application.views.player;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.application.views.player.workers.HattrickPlayerStars;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.relations.RPlayer;

public class PlayerStatsFragment extends HattrickFragment {

    static final String TAG = (PlayerStatsFragment.class).getSimpleName();

    int playerID;

    private RPlayer rPlayer;

    public final PlayerStatsFragment newInstance(int playerID) {
        PlayerStatsFragment f = new PlayerStatsFragment();
        f.playerID = playerID;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        PlayerTask task = new PlayerTask(getActivity(), this);
        task.execute(playerID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        rPlayer = (RPlayer) result;

        if (rPlayer == null)
            return;

        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    protected void onPopulateView() {
        super.onPopulateView();

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        DPlayer player = rPlayer.getPlayer();

        Preferences pref = new Preferences(getActivity());

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
        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);

        tb.addTitle(toUpperCase(R.string.player_title_career));

        tb.addRowColored(R.string.player_label_stats_career_goals,
                player.getCareerGoals() + "");
        tb.addRowColored(R.string.player_label_stats_career_hattrick,
                player.getCareerHattricks() + "");
        tb.addRowColored(R.string.player_label_stats_cup_goals,
                player.getCupgoals() + "");
        tb.addRowColored(R.string.player_label_stats_league_goals,
                player.getLeaguegoals() + "");
        tb.addRowColored(R.string.player_label_stats_friendlies_goals,
                player.getFriendliesGoals() + "");

        // National stats
        if (player.getNationalteamId() > 0) {
            tb.addTitle(toUpperCase(R.string.player_title_international_career));
            tb.addRowColored(R.string.player_label_stats_caps_national,
                    player.getCaps() + "");
            tb.addRowColored(R.string.player_label_stats_caps_national_u20,
                    player.getCapsU20() + "");
        }

        // Create background container (last match)
        LayoutInflater inflater2 = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout llContainerLastMatch = (LinearLayout) inflater.inflate(
                R.layout.view_container, null);

        llContainer.addView(llContainerLastMatch, layoutParams);

        if (player.getLastMatchPositionCode() > 0) {
            // Add last match row
            // Create background container (last match)
            LayoutInflater infl = (LayoutInflater) getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            RelativeLayout vlastMatch = (RelativeLayout) infl.inflate(
                    R.layout.row_player_rating, null);

            llContainerLastMatch.addView(vlastMatch, layoutParams);

            // Add last match info
            TextView tvMatch = (TextView) vlastMatch.findViewById(R.id.tvMatch);
            TextView tvMatchDate = (TextView) vlastMatch
                    .findViewById(R.id.tvMatchDate);
            TextView tvMatchPos = (TextView) vlastMatch
                    .findViewById(R.id.tvMatchPos);
            TextView tvMatchMinute = (TextView) vlastMatch
                    .findViewById(R.id.tvValue);
            LinearLayout llMatchStars = (LinearLayout) vlastMatch
                    .findViewById(R.id.llStars);

            tvMatch.setText(R.string.player_label_last_game);
            tvMatchDate.setText(formatDate(player.getLastMatchDate()));
            // tvMatchPos.setText(HMatchRoleID.getPosition(getActivity(),
            // player.getLastMatchPositionCode()));
            tvMatchMinute.setText(player.getLastMatchPlayedMinutes() + "'");

            View v = HattrickPlayerStars.draw(getActivity(),
                    player.getLastMatchRating());
            llMatchStars.addView(v);
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)
                || from.equals(LineUpUpdate.FROM)
                || from.equals(LiveUpdate.FROM)
                || from.equals(PlayersUpdate.FROM)) {

            // Launch task
            PlayerTask task = new PlayerTask(getActivity(), this);
            task.execute(playerID);
        }
    }
}