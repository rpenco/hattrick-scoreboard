package org.hattrickscoreboard.application.extended.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.params.HattrickParams;

import java.io.File;

/**
 * @author Khips
 * @since 6 august 2014
 */
public class AsyncImageTask extends AsyncTask<String, Void, Bitmap> {

    static final String TAG = (AsyncImageTask.class).getSimpleName();

    // Part of avatars
    public static String AVATARS_BUILDER = "Builder";

    // Full avatars
    public static String AVATARS = "Avatars";

    // Logo team
    public static String LOGOS = "logos";

    // Dress team
    public static String DRESS = "dresses";

    // Trophies
    public static String TROPHIES = "Trophies";

    protected AsyncImageTaskListener listener;
    protected Context context;

    protected HattrickRequest request;
    protected HattrickParams param;

    public AsyncImageTask(Context context, AsyncImageTaskListener listener) {
        this.listener = listener;
        this.context = context;

        request = new HattrickRequest();
        request.init(context);
        param = new HattrickParams();
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
     * Return bitmap from cache if exists
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
