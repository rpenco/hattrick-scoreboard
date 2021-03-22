package org.hattrickscoreboard.application.views.match;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventHolder {

    TextView tvEvent;
    TextView tvTime;
    ImageView ivEvent;
    LinearLayout llTeamColor;

    Context context;
    Resources res;

    public EventHolder(Context context) {
        this.context = context;
        res = context.getResources();
    }

    public void setEventText(String text) {
        tvEvent.setText(Html.fromHtml(text.replaceAll("</?a[^>]*>", "")));
    }

    public void setEventTime(int time) {
        tvTime.setText(Integer.toString(time) + "'");
    }

    public void setTeamColor(int resourceID) {
        if (resourceID > 0)
            llTeamColor.setBackgroundResource(resourceID);
        else
            llTeamColor.setVisibility(View.INVISIBLE);
    }

    public void setEventIcon(int resourceID) {
        if (resourceID > 0)
            ivEvent.setImageResource(resourceID);
        else
            ivEvent.setVisibility(View.INVISIBLE);

    }
}