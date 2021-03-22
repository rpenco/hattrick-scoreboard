package org.hattrickscoreboardl.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.hattrickscoreboardl.R;


public class HattrickPlayerStars {

    static String TAG = (HattrickPlayerStars.class).getSimpleName();

    public static View draw(Context ctx, double starsStart,  double starsEnd) {


        

        int iconHeight = (int) ctx.getResources().getDimension(R.dimen.iconStars);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iconHeight, iconHeight);

        
        //Start stars
        int nbStart = (int) starsStart; //5
        boolean starsHalfStart = ((starsStart*10) % 2 != 0); //True


        //End of game stars
        int nbEnd = (int) starsEnd; //3
        boolean starsHalfEnd = ((starsEnd*10) % 2 != 0); //True
        int nb5End = (int) Math.floor(starsEnd / 5); //1


        LinearLayout layout = new LinearLayout(ctx);
        //Draw stars

        for (int i = 0; i < nb5End; i++) {
            ImageView ivStars5On = new ImageView(ctx);
            ivStars5On.setImageResource(R.drawable.ic_start_5_on);
            layout.addView(ivStars5On);
            ivStars5On.setLayoutParams(layoutParams);
//            ivStars5On.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            ivStars5On.getLayoutParams().height = iconHeight;

        }

        for (int i = 0; i < (nbEnd - nb5End*5); i++) {
            ImageView ivStarsOn = new ImageView(ctx);
            ivStarsOn.setImageResource(R.drawable.ic_event_41_best_player);
            layout.addView(ivStarsOn);
            ivStarsOn.setLayoutParams(layoutParams);
//            ivStarsOn.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            ivStarsOn.getLayoutParams().height = iconHeight;
        }

        if(starsHalfEnd) {
            if (nbStart == nbEnd) {
                ImageView ivStarsOff = new ImageView(ctx);
                ivStarsOff.setImageResource(R.drawable.ic_start_half_on);
                layout.addView(ivStarsOff);
                ivStarsOff.setLayoutParams(layoutParams);
//                ivStarsOff.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                ivStarsOff.getLayoutParams().height = iconHeight;
            }else {
                ImageView ivStarsOff = new ImageView(ctx);
                ivStarsOff.setImageResource(R.drawable.ic_start_half);
                layout.addView(ivStarsOff);
                ivStarsOff.setLayoutParams(layoutParams);
//                ivStarsOff.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                ivStarsOff.getLayoutParams().height = iconHeight;
            }
        }

        for (int i = 0; i < (nbStart - (nbEnd + ((starsHalfEnd)? 1: 0))); i++) {
            ImageView ivStarsOn = new ImageView(ctx);
            ivStarsOn.setImageResource(R.drawable.ic_event_42_worst_player);
            layout.addView(ivStarsOn);
            ivStarsOn.setLayoutParams(layoutParams);
//            ivStarsOn.getLayoutParams().height = iconHeight;
//            ivStarsOn.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        if(starsHalfStart && starsStart != starsEnd) {
            ImageView ivStarsOff = new ImageView(ctx);
            ivStarsOff.setImageResource(R.drawable.ic_start_half_off);
            layout.addView(ivStarsOff);
            ivStarsOff.setLayoutParams(layoutParams);
//            ivStarsOff.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            ivStarsOff.getLayoutParams().height = iconHeight;
        }
        return layout;
    }
}
