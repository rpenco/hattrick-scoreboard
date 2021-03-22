package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HFlag;
import org.hattrickscoreboardl.ui.utils.FlagDrawable;

import java.util.List;

/**
 * Created by romain
 * on 23/11/2014.
 */
public class FlagsView {



    public GridLayout getView(final Context ctx, final List<HFlag> flags){

        int fH = (int) ctx.getResources().getDimension(R.dimen.flagHeight);
        int p = (int) ctx.getResources().getDimension(R.dimen.contentPadding);

        GridLayout gridLayout = new GridLayout(ctx);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        gridLayout.setLayoutParams(params);

        int total = flags.size();
        int column = 6;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);

        for(int i =0, c = 0, r = 0; i < total; i++, c++)
        {
            if(c == column)
            {
                c = 0;
                r++;
            }

            //Get trophy
            final HFlag flag = flags.get(i);

            //Trophy container
            LinearLayout llTrophy = new LinearLayout(ctx);
            llTrophy.setOrientation(LinearLayout.VERTICAL);
            llTrophy.setGravity(Gravity.CENTER);

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = fH;
            param.width = fH;
            param.rightMargin = p;
            param.topMargin = p;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);
            llTrophy.setLayoutParams(param);


            ImageView iv = new ImageView(ctx);
            iv.setImageResource(R.drawable.ic_cup_national);
            Drawable d = FlagDrawable.getFlag(ctx, flag.getCountryCode());
            if (d != null) {
                iv.setImageDrawable(d);
            }

            llTrophy.addView(iv);
            iv.getLayoutParams().height = fH;

            llTrophy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ctx,flag.getLeagueName(),Toast.LENGTH_SHORT).show();
                }
            });
            gridLayout.addView(llTrophy);
        }

        return gridLayout;
    }
}


