package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.hattrick.constants.Hattrick;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Get dress image
 *
 * @author Khips
 * @since 31 mars 2014
 */
public class TrophyTask extends AsyncImageTask {

    private static final String TAG = (TrophyTask.class).getSimpleName();

    public TrophyTask(Context context, AsyncImageTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        String url = params[0];
        String filename = params[1];

        Log.i(TAG, "url: " + url);
        Log.i(TAG, "filename: " + filename);

        // Set folder to logos...
        File dir = setUpCacheDir(TROPHIES);

        // file from cache?
        Bitmap fileCache = fileExistInCache(dir, filename);
        if (fileCache != null) {
            return fileCache;
        }

        // Else download file....

        Bitmap bm = null;
        // Sinon telecharge
        try {
            Log.i(TAG, "Download dress cache : " + filename);

            InputStream in = new java.net.URL(Hattrick.URL+url).openStream();
            bm = BitmapFactory.decodeStream(in);

            File file = new File(dir, filename);
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            in.close();
            return bm;

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            //e.printStackTrace();
            return null;
        }
    }
}
