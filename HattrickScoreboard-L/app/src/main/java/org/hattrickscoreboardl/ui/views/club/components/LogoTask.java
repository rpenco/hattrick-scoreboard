package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author Khips
 * @since 31 mars 2014
 */
public class LogoTask extends AsyncImageTask {

    private static final String TAG = (LogoTask.class).getSimpleName();

    public LogoTask(Context context, AsyncImageTaskListener listener) {
        super(context, listener);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        if (params[0] == null)
            return null;

        String url = params[0];
        String[] p = url.split("/");
        String filename = "logo_" + p[p.length - 1];

        Log.v(TAG, "url: " + url);
        Log.v(TAG, "filename: " + filename);

        // Set folder to logos...
        File dir = setUpCacheDir(LOGOS);

        // file from cache?
        Bitmap fileCache = fileExistInCache(dir, filename);
        if (fileCache != null) {
            return fileCache;
        }

        // Else download file....

        Bitmap bm = null;
        // Sinon telecharge
        try {
            Log.i(TAG, "Download file : " + filename);

            InputStream in = new java.net.URL("http:"+url).openStream();
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
