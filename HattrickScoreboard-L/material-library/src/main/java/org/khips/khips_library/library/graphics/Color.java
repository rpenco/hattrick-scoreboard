package org.khips.khips_library.library.graphics;

import android.content.Context;

/**
 * Created by romain
 * on 15/12/2014.
 */
public class Color {

    public int get(Context ctx, int res){
        return ctx.getResources().getColor(res);
    }

    public static int alpha(int color, float alpha){
        return android.graphics.Color.argb((int)(255*alpha),
                android.graphics.Color.red(color),
                android.graphics.Color.green(color),
                android.graphics.Color.blue(color));
    }

    public static boolean isLight(int color) {
        return Math.sqrt(
                android.graphics.Color.red(color) * android.graphics.Color.red(color) * .241 +
                        android.graphics.Color.green(color) * android.graphics.Color.green(color) * .691 +
                        android.graphics.Color.blue(color) * android.graphics.Color.blue(color) * .068) > 130;
    }

    public static int getBaseColor(int color) {
        if (isLight(color)) {
            return android.graphics.Color.BLACK;
        }
        return android.graphics.Color.WHITE;
    }
}
