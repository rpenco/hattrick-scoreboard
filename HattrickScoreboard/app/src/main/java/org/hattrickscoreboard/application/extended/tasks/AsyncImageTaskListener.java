package org.hattrickscoreboard.application.extended.tasks;

import android.graphics.Bitmap;

/**
 * @author Khips
 * @since 6 august 2014
 */
public interface AsyncImageTaskListener {

    void onImageStart();

    void onImageResult(Bitmap image);
}
