package org.hattrickscoreboard.application.views.matches;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

import org.hattrick.constants.HMatchStatus;
import org.hattrick.providers.params.HLiveQuery;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.graphics.statics.MatchTypeDrawable;
import org.hattrickscoreboard.application.views.match.MatchActivity;
import org.hattrickscoreboard.application.views.matches.live.LiveTask;
import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.relations.RMatches;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * @author Khips
 * @since 14 august 2014
 */
public class MatchesCalendar {

    private Activity act;
    private int teamID;
    private ArrayList<DLive> lives;
    private DWorld world;

    public MatchesCalendar(Activity activity, DWorld world) {
        this.act = activity;
        this.world = world;
    }

    public void create(LinearLayout llContainer, RMatches rMatches,
                       int selectedTeamID) {

        if (llContainer == null || rMatches == null)
            return;

        teamID = selectedTeamID;
        lives = rMatches.getLives();

        DTeam team = rMatches.getTeam();

        // Clear layout
        llContainer.removeAllViews();

        // Current matches group
        LinearLayout llMatchContainer = null;

        // CURRENT DATE
        int week = 0;
        for (final Match match : rMatches.getMatchList()) {
            if (match == null) {
                Log.e("MatchesCalendar", "mATCH NULL");
                continue;
            }
            try {
                Date matchDate = HattrickDate
                        .StringToDate(match.getMatchDate());
                int weekOfYear = HattrickDate.getWeekOfYear(matchDate);

                // new card
                if (llMatchContainer == null || weekOfYear != week) {

                    LayoutInflater infl = act.getLayoutInflater();
                    if (act.getLayoutInflater() == null)
                        continue;
                    llMatchContainer = (LinearLayout) infl.inflate(
                            R.layout.matches_row, null);

                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);

                    layoutParams.setMargins(
                            act.getResources().getDimensionPixelSize(
                                    R.dimen.margin_layout),
                            act.getResources().getDimensionPixelSize(
                                    R.dimen.margin_layout),
                            act.getResources().getDimensionPixelSize(
                                    R.dimen.margin_layout),
                            act.getResources().getDimensionPixelSize(
                                    R.dimen.margin_layout));

                    llContainer.addView(llMatchContainer, layoutParams);

                    TextView tvDate = (TextView) llMatchContainer
                            .findViewById(R.id.tvMatchDate);

                    week = weekOfYear;
                    tvDate.setText((act.getString(R.string.matches_week, week))
                            .toUpperCase(Locale.US));

                }

                LinearLayout matchRow = createMatchRow(match, team);
                llMatchContainer.addView(matchRow);
            } catch (ParseException e) {
            }

        }
    }

    private LinearLayout createMatchRow(final Match match, DTeam team) {

        boolean isHomeTeam = (match.getHomeTeamID() == teamID);

        // Inflate match layout
        LinearLayout mLayout = (LinearLayout) act.getLayoutInflater().inflate(
                R.layout.match_row, null);

        TextView tvDate = (TextView) mLayout.findViewById(R.id.tvMatchDate);
        TextView tvHomeTeam = (TextView) mLayout.findViewById(R.id.tvHomeTeam);
        TextView tvAwayTeam = (TextView) mLayout.findViewById(R.id.tvAwayTeam);
        TextView tvScore = (TextView) mLayout.findViewById(R.id.tvGoals);

        ImageView ivType = (ImageView) mLayout.findViewById(R.id.ivMatchType);
        ImageView ivLive = (ImageView) mLayout.findViewById(R.id.ivLive);

        Button btOverflow = (Button) mLayout.findViewById(R.id.btOverflow);

        LinearLayout llLive = (LinearLayout) mLayout
                .findViewById(R.id.llOngoing);
        llLive.setVisibility(View.GONE);

        // Set tag
        mLayout.setTag(match.getMatchID() + "-" + match.getSourceSystem());

        // Set date
        tvDate.setText(formatDateTime(match.getMatchDate(), world));

        // Set icon
        ivType.setImageDrawable(MatchTypeDrawable.getDrawable(act, team,
                match.getMatchType()));

        // Set team names
        if (team != null) {
            if (isHomeTeam) {
                tvHomeTeam.setText(Html.fromHtml("<b>"
                        + match.getHomeTeamName() + "</b>"));
                tvAwayTeam.setText(match.getAwayTeamName());
            } else {
                tvHomeTeam.setText(match.getHomeTeamName());
                tvAwayTeam.setText(Html.fromHtml("<b>"
                        + match.getAwayTeamName() + "</b>"));
            }
        } else {
            tvHomeTeam.setText(match.getHomeTeamName());
            tvAwayTeam.setText(match.getAwayTeamName());
        }

        // If is on HT-Live tracker
        DLive live = isOnLive(match);

        // If on tracker display icon
        if (live != null) {
            ivLive.setImageDrawable(act.getResources().getDrawable(
                    R.drawable.ic_match_htlive_off));

            // Overflow menu
            btOverflow.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(act, view);

                    popupMenu
                            .getMenu()
                            .add(act.getString(R.string.matches_overflow_menu_remove_live));
                    popupMenu
                            .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                                @Override
                                public boolean onMenuItemClick(MenuItem arg0) {


                                    HLiveQuery query = new HLiveQuery();
                                    query.setActionType(HLiveQuery.DEL_MATCH);
                                    query.setMatchID(match.getMatchID());
                                    query.setSourceSystem(match
                                            .getSourceSystem());

                                    // Create task
                                    LiveTask liveTask = new LiveTask(act, null);
                                    liveTask.execute(query);
                                    return false;
                                }
                            });

                    popupMenu.show();

                }
            });

        } else {

            // Overflow menu
            btOverflow.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(act, view);

                    popupMenu
                            .getMenu()
                            .add(act.getString(R.string.matches_overflow_menu_add_live));
                    popupMenu
                            .setOnMenuItemClickListener(new OnMenuItemClickListener() {

                                @Override
                                public boolean onMenuItemClick(MenuItem arg0) {


                                    HLiveQuery query = new HLiveQuery();
                                    query.setActionType(HLiveQuery.ADD_MATCH);
                                    query.setMatchID(match.getMatchID());
                                    query.setSourceSystem(match
                                            .getSourceSystem());

                                    // Create task
                                    LiveTask liveTask = new LiveTask(act, null);
                                    liveTask.execute(query);
                                    return false;
                                }
                            });

                    popupMenu.show();

                }
            });
        }

        if (HMatchStatus.FINISHED.equals(match.getStatus())) {

            // Set score
            tvScore.setText(match.getHomeGoals() + ":" + match.getAwayGoals());

            if (team != null) {
                int color = 0;
                if (isHomeTeam) {
                    if (match.getHomeGoals() > match.getAwayGoals()) {
                        color = R.color.default_green;
                    } else if (match.getHomeGoals() < match.getAwayGoals()) {
                        color = R.color.default_red;
                    }
                } else {
                    if (match.getHomeGoals() < match.getAwayGoals()) {
                        color = R.color.default_green;
                    } else if (match.getHomeGoals() > match.getAwayGoals()) {
                        color = R.color.default_red;
                    }
                }

                // Set score color
                if (color > 0) {
                    tvScore.setTextColor(act.getResources().getColor(color));
                }
            }

            // Hide overflow menu if not tracker
            if (live == null) {
                btOverflow.setVisibility(View.GONE);
            }
            // On playing
        } else if (HMatchStatus.ONGOING.equals(match.getStatus())) {

            // Show notification ongoing match
            llLive.setVisibility(View.VISIBLE);

            // Set text
            tvScore.setText(match.getHomeGoals() + ":" + match.getAwayGoals());

            // Show HT-LIVE icon
            if (live != null) {
                tvScore.setText(live.getHomeGoals() + ":" + live.getAwayGoals());
                ivLive.setImageDrawable(act.getResources().getDrawable(
                        R.drawable.ic_match_htlive));
            }

        }

        // On click event
        mLayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, MatchActivity.class);

                intent.putExtra(MatchActivity.MATCH, (String) v.getTag());
                act.startActivity(intent);

            }
        });

        return mLayout;

    }

    @SuppressLint("SimpleDateFormat")
    private String formatDateTime(String date, DWorld world) {

        try {
            // String to date
            Date d = HattrickDate.StringToDate(date);

            String format = world.getDateFormat().replace("yyyy", "yy") + " "
                    + world.getTimeFormat();
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(d);
        } catch (ParseException e) {
            return act.getString(R.string.label_unavailable);
        }
    }

    private DLive isOnLive(Match match) {
        if (lives != null)
            for (DLive live : lives) {
                if (live.getMatchID() == match.getMatchID()
                        && live.getSourceSystem().equals(
                        match.getSourceSystem())) {
                    return live;
                }
            }

        return null;
    }
}