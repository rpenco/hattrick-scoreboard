package org.hattrickscoreboard.background.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.hattrickscoreboard.application.extended.tasks.AsyncImageTask;
import org.hattrickscoreboard.application.extended.tasks.AsyncImageTaskListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Get dress image
 *
 * @author Khips
 * @since 31 march 2014
 */
public class DressTask extends AsyncImageTask {

    private static final String TAG = (DressTask.class).getSimpleName();

    public DressTask(Context context, AsyncImageTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        String url = params[0];
        String filename = params[1];

        Log.i(TAG, "url: " + url);
        Log.i(TAG, "filename: " + filename);

        // Set folder to logos...
        File dir = setUpCacheDir(DRESS);

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

            InputStream in = new java.net.URL(url).openStream();
            bm = BitmapFactory.decodeStream(in);

            File file = new File(dir, filename);
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            in.close();
            return bm;

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
