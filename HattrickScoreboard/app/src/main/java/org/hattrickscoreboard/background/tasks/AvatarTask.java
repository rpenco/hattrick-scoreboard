package org.hattrickscoreboard.background.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import org.hattrickscoreboard.application.extended.tasks.AsyncImageTask;
import org.hattrickscoreboard.application.extended.tasks.AsyncImageTaskListener;

import java.io.File;

public class AvatarTask extends AsyncImageTask {

    static final String TAG = (AvatarTask.class).getSimpleName();

    Bitmap returnBm;

    public AvatarTask(Context context, AsyncImageTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        int teamID = Integer.parseInt(params[0]);
        int playerID = Integer.parseInt(params[1]);

        String filename = "avatar_" + teamID + "_" + playerID + ".png";

        Log.i(TAG, "filename: " + filename);

        // Set folder for final avatars...
        File dir = setUpCacheDir(AVATARS);

        // file from cache?
        Bitmap fileCache = fileExistInCache(dir, filename);
        if (fileCache != null) {
            Log.i(TAG, "avatar '" + filename + "' exist! return from cache.");
            return fileCache;
        }

        // Else download files and generate all avatars one time for all....
        // /////////////////////////////////////////////////////////////////

        return returnBm;

    }
}
