package org.hattrickscoreboard.application.utils.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import org.hattrickscoreboard.application.extended.tasks.AsyncImageTask;
import org.khips.tools.storage.CStorage;

import java.io.File;
import java.util.List;

/**
 * @author Khips
 * @since 11 agust 2014
 */
public class LogoBadgeUploader {

    static final String TAG = (LogoBadgeUploader.class).getSimpleName();

    public static void upload(Context context, final ImageView imageView,
                              final int teamID) {

        if (teamID == 0)
            return;

        // Create filename
        String filename = "logo_" + teamID;

        // Set folder cache
        File director = setUpCacheDir(context, AsyncImageTask.LOGOS);

        // Find logo
        List<File> files = CStorage.cacheListFiles(context, director, filename);

        if (files.size() > 0) {

            Bitmap bm = BitmapFactory
                    .decodeFile(files.get(0).getAbsolutePath());
            imageView.setImageBitmap(bm);
        }

    }

    private static File setUpCacheDir(Context context, String subfolder) {

        if (context != null) {
            if (context.getCacheDir() != null) {
                File myDir = new File(context.getCacheDir(), subfolder);
                myDir.mkdir();
                return myDir;
            }
        }
        return null;
    }
}
