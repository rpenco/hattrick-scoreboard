package org.hattrickscoreboard.application.views.player.workers;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;

public class HattrickPlayerStars {

    public static View draw(Context ctx, double stars) {
        LinearLayout layout = new LinearLayout(ctx);

        for (int i = 0; i < Math.floor(stars); i++) {
            ImageView ivStarsOn = new ImageView(ctx);
            ivStarsOn.setImageResource(R.drawable.ic_start_on);
            layout.addView(ivStarsOn);
        }

        if ((stars - Math.floor(stars)) != 0) {
            ImageView ivStarsOff = new ImageView(ctx);
            ivStarsOff.setImageResource(R.drawable.ic_start_half);
            layout.addView(ivStarsOff);
        }

        return layout;
    }
}
