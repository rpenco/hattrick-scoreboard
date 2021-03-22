package org.hattrickscoreboardl.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class HattrickSkillBar {

    static String TAG = (HattrickSkillBar.class).getSimpleName();

    public static Bitmap StatBar(Context ctx, int color, int value) {
        return StatBar(ctx, color, value, 20);
    }

    public static Bitmap StatBar(Context ctx, int color, int value,
                                 int max) {

        // Image (HD)
        int pWidth = 1000;
        int pHeight = 300;

        // Blank block size
        int blanckBlocsWidth = 1000 / max;

        // Bloc width size
        int lineSpace = 5;
        int blockWidth = blanckBlocsWidth - lineSpace;

        // Create image
        Bitmap bm = Bitmap.createBitmap(pWidth, pHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);

        // Background blocs
        int leftX = 0, rightX = 0;
        for (int i = 1; i < max + 1; i++) {

            // Draw first bloc
            Paint pVDiv = new Paint();
            pVDiv.setColor(Color.parseColor("#EEEEEE"));
            canvas.drawRect(leftX, 0, rightX, pHeight, pVDiv);

            // Set position for next block
            leftX = (i * blanckBlocsWidth) + blanckBlocsWidth;
            rightX = leftX + blockWidth;
        }

        // Skill blocs
        leftX = 0;
        rightX = 0;

        /**
         * Start at 1 to not draw if skill value = 0
         */
        for (int i = 1; i <= value + 1; i++) {

            // Draw first bloc
            Paint pVDiv = new Paint();
            pVDiv.setColor(color);
            canvas.drawRect(leftX, 0, rightX, pHeight, pVDiv);

            // Set position for next block
            leftX = (i * blanckBlocsWidth) + blanckBlocsWidth;
            rightX = leftX + blockWidth;
        }
        return bm;
    }

}
