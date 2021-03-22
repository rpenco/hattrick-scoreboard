package org.hattrickscoreboardl.ui.views.club.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.File;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class AsyncImageTask extends AsyncTask<String, Void, Bitmap> {

    static final String TAG = (AsyncImageTask.class).getSimpleName();

    // Part of avatars
    public static String AVATARS_BUILDER = "Builder";

    // Full avatars
    public static String AVATARS = "Avatars";

    // Logo team
    public static String LOGOS = "Logos";

    // Dress team
    public static String DRESS = "Dress";

    // Trophies
    public static String TROPHIES = "Trophies";

    protected AsyncImageTaskListener listener;
    protected Context context;

    public AsyncImageTask(Context context, AsyncImageTaskListener listener) {
        this.listener = listener;
        this.context = context;
    }

    protected File setUpCacheDir(String subfolder) {

        if (context != null) {
            if (context.getCacheDir() != null) {
                File myDir = new File(context.getCacheDir(), subfolder);
                myDir.mkdir();
                return myDir;
            }
        }
        return null;
    }

    /**
     * Return bitmap from cache if exist
     *
     * @param dir
     * @param filename
     * @return
     */
    protected Bitmap fileExistInCache(File dir, String filename) {
        // S'il existe return
        File f = new File(dir, filename);
        if (f.exists()) {
            Log.v(TAG, "Return file \"" + filename + "\" from cache.");
            Bitmap bm = BitmapFactory.decodeFile(f.getAbsolutePath());
            return bm;
        }
        return null;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.onImageStart();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        listener.onImageResult(result);
    }

}
