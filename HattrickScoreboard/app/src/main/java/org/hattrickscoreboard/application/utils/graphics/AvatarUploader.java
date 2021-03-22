package org.hattrickscoreboard.application.utils.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import org.hattrickscoreboard.application.extended.tasks.AsyncImageTaskListener;
import org.hattrickscoreboard.background.tasks.AvatarTask;

/**
 * @author Khips
 * @since 7 agust 2014
 */
public class AvatarUploader {

    static final String TAG = (AvatarUploader.class).getSimpleName();

    public void upload(Context context, final ImageView imageView,
                       final int teamID, final int playerID) {

        AvatarTask avatarTask = new AvatarTask(context,
                new AsyncImageTaskListener() {

                    @Override
                    public void onImageStart() {

                        Log.v(TAG, "player '" + playerID
                                + "' starting download avatar...");
                    }

                    @Override
                    public void onImageResult(Bitmap image) {

                        if (imageView != null) {
                            Log.v(TAG, "player '" + playerID + "' set image.");
                            imageView.setImageBitmap(image);
                        } else {
                            Log.v(TAG, "player '" + playerID
                                    + "' imageview is null [2].");
                        }

                    }
                });

        avatarTask
                .execute(Integer.toString(teamID), Integer.toString(playerID));

    }

}
