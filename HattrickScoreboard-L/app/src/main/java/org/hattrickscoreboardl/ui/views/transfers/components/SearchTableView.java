package org.hattrickscoreboardl.ui.views.transfers.components;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.utils.Dimen;
import org.hattrickscoreboardl.utils.Preferences;

/**
 * Created by romain
 * on 10/12/2014.
 */
public class SearchTableView {

    Context ctx;
    TableLayout.LayoutParams tableParams;
    TableRow.LayoutParams rowParams;
    TableLayout tableLayout;
    int userTeamID;
    int p;
    float s;

    public SearchTableView(Context ctx) {
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


    public void createHeaders() {

        //Header
        TableRow tableRow = new TableRow(ctx);
        tableRow.setGravity(Gravity.CENTER);

        //Hometeam
        TextView tvLabel = new TextView(ctx);
        tvLabel.setText("Rechercher un transfert");
        tvLabel.setLayoutParams(rowParams);
        tvLabel.setTextColor(ctx.getResources().getColor(R.color.textview));
        tvLabel.setTextSize(Dimen.dimen(ctx, R.dimen.textviewHigh));
        tvLabel.setPadding(0,p,0,p);
        tableRow.addView(tvLabel);

        //Score / match date
        TextView tvValue = new TextView(ctx);
        tvValue.setText("min");
        tvValue.setGravity(Gravity.CENTER);
        tvValue.setLayoutParams(rowParams);
        tableRow.addView(tvValue);

        //Score / match date
        TextView tvMax = new TextView(ctx);
        tvMax.setText("max");
        tvMax.setGravity(Gravity.CENTER);
        tvMax.setLayoutParams(rowParams);
        tableRow.addView(tvMax);

        //Add to table
        tableLayout.addView(tableRow);
    }

    public void createRowOneInput(String label, String value){


        TableRow tableRow = new TableRow(ctx);
        tableRow.setGravity(Gravity.CENTER);

        //Label
        TextView tvLabel = new TextView(ctx);
        tvLabel.setText(label);
        tvLabel.setLayoutParams(rowParams);
        tableRow.addView(tvLabel);

        //Value

        TextView tvValue = new TextView(ctx);
        tvValue.setText(value);
        tvValue.setGravity(Gravity.RIGHT);
        tvValue.setLayoutParams(rowParams);
        tableRow.addView(tvValue);

        //Add to table
        tableLayout.addView(tableRow);

    }
}
