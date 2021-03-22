package org.hattrickscoreboard.application.extended;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class BackgroundDrawable {

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static Drawable draw(Context ctx, ColorTheme theme, View view) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;

        Bitmap bg = BitmapFactory.decodeResource(ctx.getResources(),
                R.drawable.background, options).copy(Bitmap.Config.ARGB_8888,
                true);

        // Background color
        Bitmap.Config conf = Bitmap.Config.ARGB_8888;
        Bitmap bmp = Bitmap.createBitmap(bg.getWidth(), bg.getHeight(), conf);
        Canvas canvas = new Canvas(bmp);
        canvas.drawColor(theme.getRGB());
        canvas.drawBitmap(bg, 0, 0, null);
        Drawable d = new BitmapDrawable(ctx.getResources(), bmp);

        if (view != null) {
            // JellyBEAN
            if (VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(d);
            } else {
                view.setBackgroundDrawable(d);
            }
        }
        return d;
    }
}
