package org.hattrickscoreboard.application.views.match;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.modules.HatStats;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.application.views.match.workers.HattrickStatBar;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatch;

public class MatchStatsFragment extends HattrickFragment {

    static final String TAG = (MatchStatsFragment.class).getSimpleName();

    int matchID;
    String sourceSystem;

    RMatch matchRes;

    private String[] matchRating;

    public final MatchStatsFragment newInstance(int matchID, String sourceSystem) {
        MatchStatsFragment f = new MatchStatsFragment();
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

        setStubLayout(R.layout.fragment_match_stats);

        // Populate all
        onPopulateView();
    }

    protected void onPopulateView() {
        super.onPopulateView();

        Match match = matchRes.getMatch();

        matchRating = getActivity().getResources().getStringArray(
                R.array.hattrick_match_rating);

        View v = getFragmentView();
        LinearLayout llStatLayout = (LinearLayout) v
                .findViewById(R.id.llStatsLayout);
        llStatLayout.removeAllViews();

        Preferences pref = new Preferences(getActivity());
        ColorTheme theme = new ColorTheme(pref.getRGBColor());

        // First half
        TextView tvPossHomeFirstHalf = (TextView) v
                .findViewById(R.id.tvPossHomeFirstHalf);
        TextView tvPossAwayFirstHalf = (TextView) v
                .findViewById(R.id.tvPossAwayFirstHalf);
        ImageView ivPossAwayFirstHalf = (ImageView) getFragmentView()
                .findViewById(R.id.ivPossFirstHalf);

        tvPossHomeFirstHalf.setText(match.getPossessionFirstHalfHome() + "%");
        tvPossAwayFirstHalf.setText(match.getPossessionFirstHalfAway() + "%");

        Bitmap progressFirst = HattrickStatBar.MatchBar(getActivity(), theme,
                match.getPossessionFirstHalfHome(),
                match.getPossessionFirstHalfAway());
        ivPossAwayFirstHalf.setImageBitmap(progressFirst);

        // Second half
        TextView tvPossHomeSecHalf = (TextView) v
                .findViewById(R.id.tvPossHomeSecHalf);
        TextView tvPossAwaySecHalf = (TextView) v
                .findViewById(R.id.tvPossAwaySecHalf);
        ImageView ivPossAwaySecHalf = (ImageView) getFragmentView()
                .findViewById(R.id.ivPossSecHalf);

        tvPossHomeSecHalf.setText(match.getPossessionSecondHalfHome() + "%");
        tvPossAwaySecHalf.setText(match.getPossessionSecondHalfAway() + "%");

        Bitmap progressSec = HattrickStatBar.MatchBar(getActivity(), theme,
                match.getPossessionFirstHalfHome(),
                match.getPossessionFirstHalfAway());
        ivPossAwaySecHalf.setImageBitmap(progressSec);

        // Match
        TextView tvPossHomeMatch = (TextView) v
                .findViewById(R.id.tvPossHomeMatch);
        TextView tvPossAwayMatch = (TextView) v
                .findViewById(R.id.tvPossAwayMatch);
        ImageView ivPossAwayMatch = (ImageView) getFragmentView().findViewById(
                R.id.ivPossMatch);

        int possHome = (int) (match.getPossessionFirstHalfHome() + match
                .getPossessionSecondHalfHome()) / 2;

        tvPossHomeMatch.setText(possHome + "%");
        tvPossAwayMatch.setText((100 - possHome) + "%");

        Bitmap progressMatch = HattrickStatBar.MatchBar(getActivity(), theme,
                possHome, 100 - possHome);
        ivPossAwayMatch.setImageBitmap(progressMatch);

        // others stats

        createStatBar(llStatLayout, theme, R.string.match_statistics_def_left,
                match.getHomeRatingLeftDef(), match.getAwayRatingLeftDef());

        createStatBar(llStatLayout, theme,
                R.string.match_statistics_def_center,
                match.getHomeRatingMidDef(), match.getAwayRatingMidDef());

        createStatBar(llStatLayout, theme, R.string.match_statistics_def_right,
                match.getHomeRatingRightDef(), match.getAwayRatingRightDef());

        createStatBar(llStatLayout, theme, R.string.match_statistics_middle,
                match.getHomeRatingMidfield(), match.getAwayRatingMidfield());

        createStatBar(llStatLayout, theme,
                R.string.match_statistics_forward_left,
                match.getHomeRatingLeftAtt(), match.getAwayRatingLeftAtt());

        createStatBar(llStatLayout, theme,
                R.string.match_statistics_forward_center,
                match.getHomeRatingMidAtt(), match.getAwayRatingMidAtt());

        createStatBar(llStatLayout, theme,
                R.string.match_statistics_forward_right,
                match.getHomeRatingRightAtt(), match.getAwayRatingRightAtt());

        // HatStats
        LinearLayout llHatStats = (LinearLayout) v
                .findViewById(R.id.llHatStats);

        llHatStats.removeAllViews();

        HatStats stats = new HatStats(match);

        KTableView kTableView = new KTableView();
        kTableView.createTableView(getActivity(), theme.getRGB(), llHatStats);
        kTableView.addTitle("HATSTATS");

        kTableView.addRow(R.string.match_hatstat_defense,
                stats.getHomeDefense() + " - " + stats.getAwayDefense());
        kTableView.addRow(R.string.match_hatstat_middle, stats.getHomeMiddle()
                + " - " + stats.getAwayMiddle());
        kTableView.addRow(R.string.match_hatstat_forward, stats.getHomeAttack()
                + " - " + stats.getAwayAttack());
        kTableView.addRow(R.string.label_total, stats.getHomeTotal() + " - "
                + stats.getAwayTotal());

    }

    ;

    private void createStatBar(LinearLayout parent, ColorTheme theme,
                               int resourceID, int homeValue, int awayValue) {

        RelativeLayout llStat = (RelativeLayout) getActivity()
                .getLayoutInflater().inflate(R.layout.row_match_stat, null);
        parent.addView(llStat);

        TextView tvTitle = (TextView) llStat.findViewById(R.id.tvTitle);
        TextView tvAwayLevel = (TextView) llStat.findViewById(R.id.tvAwayLevel);
        TextView tvHomeLevel = (TextView) llStat.findViewById(R.id.tvHomeLevel);
        ImageView ivProgress = (ImageView) llStat.findViewById(R.id.ivProgress);

        // Set values
        tvTitle.setText(resourceID);
        tvHomeLevel.setText(matchRating[homeValue]);
        tvAwayLevel.setText(matchRating[awayValue]);

        // Calc %
        int homeVal = (int) (100 * homeValue) / matchRating.length; // Match
        // rating
        // has 80
        // values
        int awayVal = (int) (100 * awayValue) / matchRating.length;

        // Get bitmap
        Bitmap progress = HattrickStatBar.MatchBar(getActivity(), theme,
                homeVal, awayVal);
        ivProgress.setImageBitmap(progress);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)) {

            MatchTask task = new MatchTask(getActivity(), this);
            task.execute(matchID, sourceSystem);
        }
    }

}