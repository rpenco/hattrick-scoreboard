package org.hattrickscoreboard.application.utils.graphics.statics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FileToImage {

    public static Bitmap fileToBitmap(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        return bitmap;
    }
}
