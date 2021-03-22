package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.teams.HTeam;

/**
 * @author Khips
 * @since 7 aout 2014
 */
public class LogoUploader {

    static final String TAG = (LogoUploader.class).getSimpleName();

    public void upload(Context context, final ImageView imageView, final HTeam team) {

        int botResourceID = R.drawable.ic_bot_team_logo;

        if (team == null)
            return;

        // Logo bot
        if (team.isBot()) {
            Log.v(TAG, "team '" + team.getTeamID() + "' is bot.");
            if (imageView != null) {
                imageView.setImageResource(botResourceID);
            } else {
                Log.v(TAG, "team '" + team.getTeamID() + "' imageview is null.");
            }
            return;
        }

        // No logo
        if (team.getLogoURL() == null) {

            Log.v(TAG, "team '" + team.getTeamID() + "' logo url is null.");

            return;
        }

        LogoTask logoTask = new LogoTask(context, new AsyncImageTaskListener() {

            @Override
            public void onImageStart() {

                Log.v(TAG, "team '" + team.getTeamID()
                        + "' starting download logo...");
            }

            @Override
            public void onImageResult(Bitmap image) {

                if (imageView != null) {
                    Log.v(TAG, "team '" + team.getTeamID() + "' set image.");
                    imageView.setImageBitmap(image);
                } else {
                    Log.v(TAG, "team '" + team.getTeamID()
                            + "' imageview is null [2].");
                }

            }
        });

        logoTask.execute(team.getLogoURL());

    }

}
