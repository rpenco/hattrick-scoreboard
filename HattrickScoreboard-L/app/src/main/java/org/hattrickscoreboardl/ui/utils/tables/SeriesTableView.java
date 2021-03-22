package org.hattrickscoreboardl.ui.utils.tables;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.series.HSeries;
import org.hattrickscoreboardl.database.models.teams.HTeam;

import java.util.List;

/**
 * Created by romain
 * on 10/12/2014.
 */
public class SeriesTableView {

    Context ctx;
    TableLayout.LayoutParams tableParams;
    TableRow.LayoutParams rowParams;
    TableLayout tableLayout;

    int p;
    float s;

    public SeriesTableView(Context ctx) {
        this.ctx = ctx;

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
        tableLayout.setBackgroundResource(R.color.backgroundColor);
        return tableLayout;
    }


    private void createHeaders() {

        //Header

        TableRow tableRow = new TableRow(ctx);
        tableRow.setGravity(Gravity.CENTER);

        //Position
        TextView tvPos = new TextView(ctx);
        tvPos.setText("");
        tvPos.setLayoutParams(rowParams);
        tableRow.addView(tvPos);

        //Name
        TextView tvName = new TextView(ctx);
        tvName.setText("");
        tvName.setLayoutParams(rowParams);
        tableRow.addView(tvName);

        //Played
        TextView tvPl = new TextView(ctx);
        tvPl.setText(R.string.series_played);
        tvPl.setGravity(Gravity.CENTER);
        tvPl.setLayoutParams(rowParams);
        tableRow.addView(tvPl);

        //Goals
        TextView tvGoals = new TextView(ctx);
        tvGoals.setText(R.string.series_goals);
        tvGoals.setGravity(Gravity.CENTER);
        tvGoals.setLayoutParams(rowParams);
        tableRow.addView(tvGoals);

        //Pts
        TextView tvPts = new TextView(ctx);
        tvPts.setText(R.string.series_points);
        tvPts.setGravity(Gravity.CENTER);
        tvPts.setLayoutParams(rowParams);
        tableRow.addView(tvPts);

        //Add to table
        tableLayout.addView(tableRow);
    }

    public void createRows(List<HTeam> teams, HTeam team, HSeries series){

        createHeaders();

        if(teams == null)
            return;

        //Rows
        for(HTeam sTeam : teams) {

            TableRow tableSeriesRow = new TableRow(ctx);
            tableSeriesRow.setGravity(Gravity.CENTER);

            if(sTeam.getTeamID() == team.getTeamID()){
                tableSeriesRow.setBackgroundResource(R.color.graylight);
            }

            //Position
            TextView tvSeriesPos = new TextView(ctx);
            tvSeriesPos.setText(sTeam.getPosition()+"");
            tvSeriesPos.setTextSize(s);
            tvSeriesPos.setGravity(Gravity.CENTER);
            tvSeriesPos.setLayoutParams(rowParams);

            switch (sTeam.getPositionChange()){
                case 0: //No change
                    tvSeriesPos.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_position_equal, 0);
                    break;
                case 1: //Up
                    tvSeriesPos.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_position_up, 0);
                    break;
                case 2: //Down
                    tvSeriesPos.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_position_down, 0);
                    break;
            }

            tableSeriesRow.addView(tvSeriesPos);

            //Name
            TextView tvSeriesName = new TextView(ctx);
            tvSeriesName.setText(sTeam.getTeamName()+"");
            tvSeriesName.setLayoutParams(rowParams);
            tableSeriesRow.addView(tvSeriesName);

            //Played
            TextView tvSeriesPl = new TextView(ctx);
            tvSeriesPl.setText(series.getCurrentMatchRound()+"");
            tvSeriesPl.setLayoutParams(rowParams);
            tvSeriesPl.setGravity(Gravity.CENTER);
            tableSeriesRow.addView(tvSeriesPl);

            //Goals
            TextView tvSeriesGoals = new TextView(ctx);
            tvSeriesGoals.setText(sTeam.getGoalsFor()+":"+sTeam.getGoalsAgainst());
            tvSeriesGoals.setLayoutParams(rowParams);
            tvSeriesGoals.setGravity(Gravity.CENTER);
            tableSeriesRow.addView(tvSeriesGoals);

            //Pts
            TextView tvSeriesPts = new TextView(ctx);
            tvSeriesPts.setText(sTeam.getPoints()+"");
            tvSeriesPts.setLayoutParams(rowParams);
            tvSeriesPts.setGravity(Gravity.CENTER);
            tableSeriesRow.addView(tvSeriesPts);

            //Add to table
            tableLayout.addView(tableSeriesRow);

        }
    }
}
