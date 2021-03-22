package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * @author Khips
 * @since 7 aout 2014
 */
public class DressUploader {

    public void upload(Context context, final ImageView imageView,
                       String dressURI, int teamID, boolean isHomeDress) {

        DressTask dressTask = new DressTask(context, new AsyncImageTaskListener() {

            @Override
            public void onImageStart() {
            }

            @Override
            public void onImageResult(Bitmap image) {
                if (imageView != null)
                    imageView.setImageBitmap(image);
            }
        });
        if (isHomeDress) {
            dressTask.execute(dressURI, "dress_" + teamID + "_home.png");
        } else {
            dressTask.execute(dressURI, "dress_" + teamID + "_away.png");
        }
    }
}
