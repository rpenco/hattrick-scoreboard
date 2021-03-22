package org.hattrickscoreboardl.ui.views.club.components;

import android.graphics.Bitmap;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public interface AsyncImageTaskListener {

    void onImageStart();

    void onImageResult(Bitmap image);
}
