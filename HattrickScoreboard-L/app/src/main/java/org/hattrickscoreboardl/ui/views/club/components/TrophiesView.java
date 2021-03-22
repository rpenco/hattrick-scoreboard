package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HTrophy;

import java.util.List;

/**
 * Created by romain
 * on 23/11/2014.
 */
public class TrophiesView {



    public GridLayout getView(final Context ctx, final List<HTrophy> trophies){

        int tH = (int) ctx.getResources().getDimension(R.dimen.trophyHeight);
        int p = (int) ctx.getResources().getDimension(R.dimen.contentPaddingSmall);

        GridLayout gridLayout = new GridLayout(ctx);

        int total = trophies.size();
        int column = ctx.getResources().getInteger(R.integer.trophyColumn);
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
            final HTrophy trophy = trophies.get(i);

            //Trophy container
            LinearLayout llTrophy = new LinearLayout(ctx);
            llTrophy.setOrientation(LinearLayout.VERTICAL);
            llTrophy.setGravity(Gravity.CENTER);

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = tH;
            param.width = tH;
            param.rightMargin = p;
            param.topMargin = p;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);
            llTrophy.setLayoutParams(param);


            ImageView iv = new ImageView(ctx);
            iv.setLayoutParams(param);
            llTrophy.addView(iv);

            TrophyUploader trophyUploader = new TrophyUploader();
            trophyUploader.upload(ctx,iv,trophy);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

            llTrophy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ctx, trophy.getLeagueLevelUnitName()+" (Saison "+trophy.getTrophySeason()+")", Toast.LENGTH_SHORT).show();
                }
            });
            gridLayout.addView(llTrophy);
        }

        return gridLayout;
    }
}
