package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import org.hattrickscoreboardl.database.models.teams.HTrophy;
import org.hattrickscoreboardl.ui.utils.TrophyDrawable;

public class TrophyUploader {

    public void upload(final Context context, final ImageView imageView, HTrophy trophy) {

        //if url exist
        if(trophy.getImageUrl() != null){

            int l = trophy.getImageUrl().lastIndexOf('/');
            String name = trophy.getImageUrl().substring(l+1);

            TrophyTask trophyTask = new TrophyTask(context, new AsyncImageTaskListener() {

                @Override
                public void onImageStart() {
                }

                @Override
                public void onImageResult(Bitmap image) {
                    if (imageView != null) {
                        imageView.setImageBitmap(image);
                    }else {
                        imageView.setImageDrawable(TrophyDrawable.getTrophy(context, "tournament_2.png"));
                    }
                }
            });
            trophyTask.execute(trophy.getImageUrl(), "trophy_" + name);
        }
        else {

            imageView.setImageDrawable(TrophyDrawable.getTrophy(context, "tournament_1.png"));
        }


    }

}
