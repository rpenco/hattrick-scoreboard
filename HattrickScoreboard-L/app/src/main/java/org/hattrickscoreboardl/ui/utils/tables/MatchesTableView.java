package org.hattrickscoreboardl.ui.utils.tables;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.hattrick.constants.match.HMatchStatus;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.matches.HMatch;
import org.hattrickscoreboardl.database.models.series.HSeries;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.utils.MatchTypeDrawable;
import org.hattrickscoreboardl.utils.HattrickDate;
import org.hattrickscoreboardl.utils.HattrickUtils;
import org.hattrickscoreboardl.utils.Preferences;

import java.util.List;

/**
 * Created by romain
 * on 10/12/2014.
 */
public class MatchesTableView {

    Context ctx;
    TableLayout.LayoutParams tableParams;
    TableRow.LayoutParams rowParams;
    TableLayout tableLayout;
    int userTeamID;
    int p;
    float s;

    public MatchesTableView(Context ctx) {
        this.ctx = ctx;

        Preferences pref = new Preferences(ctx);
        userTeamID = pref.get(Preferences.SELECTED_TEAM_ID,0);

        //Get dimensions
        p = (int) ctx.getResources().getDimension(R.dimen.contentPaddingSmall);
        s = ctx.getResources().getDimension(R.dimen.textviewHigh);

        tableParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        tableParams.setMargins(p, p, p, p);

        rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        rowParams.setMargins(p, p, p, p);
        rowParams.weight = 1;
    }

    public TableLayout createTableLayout() {

        tableLayout = new TableLayout(ctx);
        return tableLayout;
    }


    private void createHeaders() {

        //Header

        TableRow tableRow = new TableRow(ctx);
        tableRow.setGravity(Gravity.CENTER);

        //Icon
        ImageView ivMatch = new ImageView(ctx);
        ivMatch.setLayoutParams(rowParams);
        tableRow.addView(ivMatch);

        //Hometeam
        TextView tvHomeTeam = new TextView(ctx);
        tvHomeTeam.setText("");
        tvHomeTeam.setLayoutParams(rowParams);
        tableRow.addView(tvHomeTeam);

        //Score / match date
        TextView tvScore = new TextView(ctx);
        tvScore.setText("");
        tvScore.setGravity(Gravity.CENTER);
        tvScore.setLayoutParams(rowParams);
        tableRow.addView(tvScore);

        //Away team
        TextView tvGoals = new TextView(ctx);
        tvGoals.setText("");
        tvGoals.setGravity(Gravity.CENTER);
        tvGoals.setLayoutParams(rowParams);
        tableRow.addView(tvGoals);

        //Icon
        ImageView ivCompo = new ImageView(ctx);
        ivCompo.setLayoutParams(rowParams);
        tableRow.addView(ivCompo);


        //Icon
        ImageView ivLive = new ImageView(ctx);
        ivLive.setLayoutParams(rowParams);
        tableRow.addView(ivLive);

        //Add to table
        tableLayout.addView(tableRow);
    }

    public void createRows(List<HMatch> matches, HTeam team, HSeries series){


        createHeaders();

        if(matches == null)
            return;

        //Rows
        for(HMatch match : matches) {

            TableRow tableRow = new TableRow(ctx);
            tableRow.setGravity(Gravity.CENTER);

            //Icon
            ImageView ivMatch = new ImageView(ctx);
            ivMatch.setImageResource(MatchTypeDrawable.getResource(match));
            ivMatch.setLayoutParams(rowParams);
            tableRow.addView(ivMatch);

            //Hometeam
            TextView tvHomeTeam = new TextView(ctx);
            tvHomeTeam.setText(HattrickUtils.Truncate(match.getHomeTeamName(), 12));
            if(match.getHomeTeamID() == team.getTeamID()){
                tvHomeTeam.setTypeface(null, Typeface.BOLD);
            }
            tvHomeTeam.setLayoutParams(rowParams);
            tableRow.addView(tvHomeTeam);

            //Score / match date
            TextView tvScore = new TextView(ctx);

            if(match.getStatus().equals(HMatchStatus.FINISHED)) {
                tvScore.setText(match.getHomeGoals() + ":" + match.getAwayGoals());
                tvScore.setTypeface(null, Typeface.BOLD);
            }else{
                if(match.getStatus().equals(HMatchStatus.ONGOING)){
                    tvScore.setText(R.string.match_ongoing);
                    tvScore.setTypeface(null, Typeface.BOLD);
                }else{
                    tvScore.setText(HattrickDate.formatDateTimeSmall(ctx, match.getMatchDate()));
                }
            }

            if( team.getTeamID() == match.getHomeTeamID() || team.getTeamID() == match.getAwayTeamID()) {

                //At home
                if(team.getTeamID() == match.getHomeTeamID()) {
                    if(match.getHomeGoals() > match.getAwayGoals()){
                        tvScore.setTextColor(ctx.getResources().getColor(R.color.green));
                    }else{
                        if(match.getHomeGoals() < match.getAwayGoals()){
                            tvScore.setTextColor(ctx.getResources().getColor(R.color.red));
                        }
                    }
                }else{
                    if(match.getHomeGoals() < match.getAwayGoals()){
                        tvScore.setTextColor(ctx.getResources().getColor(R.color.green));
                    }else{
                        if(match.getHomeGoals() > match.getAwayGoals()){
                            tvScore.setTextColor(ctx.getResources().getColor(R.color.red));
                        }
                    }
                }
            }

            tvScore.setGravity(Gravity.CENTER);
            tvScore.setLayoutParams(rowParams);
            tableRow.addView(tvScore);

            //Away team
            TextView tvAwayTeam = new TextView(ctx);
            tvAwayTeam.setText(HattrickUtils.Truncate(match.getAwayTeamName(), 12));
            if(match.getAwayTeamID() == team.getTeamID()){
                tvAwayTeam.setTypeface(null, Typeface.BOLD);
            }
            tvAwayTeam.setGravity(Gravity.CENTER);
            tvAwayTeam.setLayoutParams(rowParams);
            tableRow.addView(tvAwayTeam);

            //Icon
            ImageView ivCompo = new ImageView(ctx);
            if(match.getStatus().equals(HMatchStatus.UPCOMING)) {
                //User team
                if (userTeamID == match.getHomeTeamID() || userTeamID == match.getAwayTeamID()) {
                    if (match.isOrdersGiven()) {
                        ivCompo.setImageResource(R.drawable.ic_matchorder_checked);
                    } else {
                        ivCompo.setImageResource(R.drawable.ic_matchorder);
                    }
                }
            }
            ivCompo.setLayoutParams(rowParams);
            tableRow.addView(ivCompo);


            //Icon
            ImageView ivLive = new ImageView(ctx);
            if(match.getStatus().equals(HMatchStatus.UPCOMING) || match.getStatus().equals(HMatchStatus.ONGOING)) {
                ivLive.setImageResource(R.drawable.ic_live);
            }
            ivLive.setLayoutParams(rowParams);
            tableRow.addView(ivLive);

            //Add to table
            tableLayout.addView(tableRow);

        }
    }
}
