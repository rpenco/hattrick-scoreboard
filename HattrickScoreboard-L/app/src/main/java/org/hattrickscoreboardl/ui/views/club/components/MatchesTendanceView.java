package org.hattrickscoreboardl.ui.views.club.components;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.matches.HMatch;

import java.util.List;

/**
 * Created by romain
 * on 23/11/2014.
 */
public class MatchesTendanceView {


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public View getTendance(final Context ctx, int teamID, List<HMatch> matches){

        int pC = (int) ctx.getResources().getDimension(R.dimen.matchCerclePadding);
        int p = (int) ctx.getResources().getDimension(R.dimen.contentPadding);
        int pS = (int) ctx.getResources().getDimension(R.dimen.contentPaddingSmall);
        int circleDim = (int) ctx.getResources().getDimension(R.dimen.circleDimen);
        float textCircleSize = ctx.getResources().getDimension(R.dimen.textCircleSize);


        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams paramsCircle =
                new LinearLayout.LayoutParams(circleDim, circleDim);

        LinearLayout llMatches = new LinearLayout(ctx);
        llMatches.setLayoutParams(params);
        llMatches.setPadding(0,p,0,p);
        llMatches.setOrientation(LinearLayout.HORIZONTAL);
        llMatches.setGravity(Gravity.CENTER);

        if(matches == null)
            return llMatches;

        for(int i = matches.size(); i > 0; i--) {


            final HMatch match = matches.get(i-1);

            ShapeDrawable smallerCircle= new ShapeDrawable( new OvalShape());
            smallerCircle.setIntrinsicHeight(p);
            smallerCircle.setIntrinsicWidth(p);
//            smallerCircle.setBounds(new Rect(0, p, 0, p));
            smallerCircle.setPadding(0,pC,0,pC);

            Drawable[] d = {smallerCircle};

            LayerDrawable composite1 = new LayerDrawable(d);

            //Match not null
            if(match.getHomeGoals() != match.getAwayGoals()) {
                //At Home
                if (match.getHomeTeamID() == teamID) {
                    if (match.getHomeGoals() > match.getAwayGoals()) {
                        smallerCircle.getPaint().setColor(ctx.getResources().getColor(R.color.green));
                    } else {
                        smallerCircle.getPaint().setColor(ctx.getResources().getColor(R.color.red));
                    }

                    //At Away
                } else {
                    if (match.getHomeGoals() < match.getAwayGoals()) {
                        smallerCircle.getPaint().setColor(ctx.getResources().getColor(R.color.green));
                    } else {
                        smallerCircle.getPaint().setColor(ctx.getResources().getColor(R.color.red));
                    }
                }
            }else {
                smallerCircle.getPaint().setColor(ctx.getResources().getColor(R.color.gray));
            }

            LinearLayout llMatch = new LinearLayout(ctx);
            paramsCircle.setMargins(pS,0,pS,0);
            llMatch.setLayoutParams(paramsCircle);
            llMatch.setOrientation(LinearLayout.VERTICAL);
            llMatch.setGravity(Gravity.CENTER);
            llMatch.setBackground(composite1);

            TextView tvMatch = new TextView(ctx);
            tvMatch.setText(match.getHomeGoals() +":"+ match.getAwayGoals());
            tvMatch.setTextSize(textCircleSize);
            tvMatch.setGravity(Gravity.CENTER);
            tvMatch.setTextColor(Color.WHITE);
            llMatch.addView(tvMatch);

            llMatches.addView(llMatch);

            llMatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ctx,match.getHomeTeamName()+" "+match.getHomeGoals()+":"+match.getAwayGoals()+" "+match.getAwayTeamName(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        return llMatches;
    }
}
