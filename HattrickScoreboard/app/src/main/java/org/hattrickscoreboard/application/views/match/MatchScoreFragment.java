package org.hattrickscoreboard.application.views.match;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrick.constants.HMatchStatus;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.graphics.LogoUploader;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatch;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MatchScoreFragment extends HattrickFragment {

    static final String TAG = (MatchScoreFragment.class).getSimpleName();

    int matchID;
    String sourceSystem;

    private RMatch matchRes;

    private Match match;

    private DLive live;

    private TextView tvTime;

    private TextView tvScore;

    public final MatchScoreFragment newInstance(int matchID, String sourceSystem) {
        MatchScoreFragment f = new MatchScoreFragment();
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

        setStubLayout(R.layout.fragment_score);

        // Populate all
        onPopulateView();
    }

    @Override
    protected void onPopulateView() {
        super.onPopulateView();

        match = matchRes.getMatch();
        DTeam homeTeam = matchRes.getHomeTeam();
        DTeam awayTeam = matchRes.getAwayTeam();
        live = matchRes.getLive();

        // Prevent back action which close view
        if (getFragmentView() == null)
            return;

        // Get resources
        tvScore = (TextView) getFragmentView().findViewById(R.id.tvMatchScore);
        tvTime = (TextView) getFragmentView().findViewById(R.id.tvTime);

        TextView tvHomeName = (TextView) getFragmentView().findViewById(
                R.id.tvHomeTeam);
        TextView tvAwayName = (TextView) getFragmentView().findViewById(
                R.id.tvAwayTeam);

        ImageView ivHomeLogo = (ImageView) getFragmentView().findViewById(
                R.id.ivHomeLogo);
        ImageView ivAwayLogo = (ImageView) getFragmentView().findViewById(
                R.id.ivAwayLogo);

        // Set values
        if (match.getStatus() != null) {
            if (match.getStatus().equals(HMatchStatus.FINISHED)) {
                tvScore.setText(match.getHomeGoals() + ":"
                        + match.getAwayGoals());
                tvTime.setText(R.string.match_score_finished);
            } else if (match.getStatus().equals(HMatchStatus.ONGOING)) {

                if (live != null) {

                    ScheduledExecutorService scheduleTaskExecutor = Executors
                            .newScheduledThreadPool(5);

					/* This schedules a runnable task every second */
                    scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
                        public void run() {
                            getActivity().runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    int currentSeconds = (HattrickDate
                                            .getMatchCurrentSecond(match
                                                    .getMatchDate()));

                                    int minute = currentSeconds / 60;
                                    int second = currentSeconds % 60;

                                    tvScore.setText(live.getHomeGoals() + ":"
                                            + live.getAwayGoals());
                                    tvTime.setText(minute + "'" + second);
                                }
                            });
                        }
                    }, 0, 1, TimeUnit.SECONDS);

                } else {
                    tvScore.setText(match.getHomeGoals() + ":"
                            + match.getAwayGoals());
                    tvTime.setText(45 + "'");
                }
            } else {
                tvTime.setText("");
            }
        } else {
            try {
                Date finishedDate = HattrickDate.StringToDate(match
                        .getMatchFinishedDate());
                if (finishedDate.before(HattrickDate.StringToDate(HattrickDate
                        .getDateTime()))) {
                    tvScore.setText(match.getHomeGoals() + ":"
                            + match.getAwayGoals());
                    tvTime.setText(R.string.match_score_finished);
                }
            } catch (ParseException e) {
                tvScore.setText("- : -");
                tvTime.setText(R.string.label_unavailable);
            }
        }

        // Update title
        getActivity().setTitle(
                homeTeam.getTeamName() + " - " + awayTeam.getTeamName());
        tvHomeName.setText(homeTeam.getTeamName());
        tvAwayName.setText(awayTeam.getTeamName());

        // Logos
        LogoUploader logoUp = new LogoUploader();
        logoUp.upload(getActivity(), ivHomeLogo, homeTeam);

        LogoUploader logoUp2 = new LogoUploader();
        logoUp2.upload(getActivity(), ivAwayLogo, awayTeam);

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