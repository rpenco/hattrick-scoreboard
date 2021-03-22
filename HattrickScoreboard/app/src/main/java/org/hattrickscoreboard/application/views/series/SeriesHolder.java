package org.hattrickscoreboard.application.views.series;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.graphics.LogoBadgeUploader;

public class SeriesHolder {

    int teamID;
    int consultedTeamID;
    TextView tvPos;
    TextView tvName;
    TextView tvMatches;
    TextView tvGoals;
    TextView tvDiff;
    TextView tvPts;

    ImageView ivPos;
    ImageView ivLogo;

    Context context;
    Resources res;

    public SeriesHolder(Context context) {
        this.context = context;
        res = context.getResources();
    }

    public void setPos(int position, int positionChange) {
        if (teamID == consultedTeamID)
            tvPos.setText(Html.fromHtml("<b>" + position + "</b>"));
        else
            tvPos.setText("" + position);

        // 0 No change
        // 1 Moving up
        // 2 Moving down

        // Position icon
        if (positionChange == 0) {
            ivPos.setImageResource(R.drawable.ic_equal);
        } else {
            if (positionChange == 1) {
                ivPos.setImageResource(R.drawable.ic_up);
            } else {
                ivPos.setImageResource(R.drawable.ic_down);
            }
        }
    }

    public void setName(String name) {

        if (teamID == consultedTeamID)
            tvName.setText(Html.fromHtml("<b>" + name + "</b>"));
        else
            tvName.setText(name);
    }

    public void setMatches(int matches) {
        tvMatches.setText("" + matches);
    }

    public void setGoals(int goalfor, int goalagainst) {
        tvGoals.setText(goalfor + ":" + goalagainst);
    }

    public void setDiff(int goalfor, int goalagainst) {
        tvDiff.setText("" + (goalfor - goalagainst));
    }

    public void setPts(int pts) {
        tvPts.setText("" + pts);
    }

    public void consultedTeamID(int consultedTeamID) {
        this.consultedTeamID = consultedTeamID;
    }

    public void setLogo(int teamID) {
        LogoBadgeUploader.upload(context, ivLogo, teamID);
    }

}