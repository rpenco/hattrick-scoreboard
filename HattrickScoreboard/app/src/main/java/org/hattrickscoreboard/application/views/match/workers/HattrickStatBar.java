package org.hattrickscoreboard.application.views.match.workers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import org.hattrickscoreboard.application.utils.ColorTheme;

public class HattrickStatBar {

    static String TAG = (HattrickStatBar.class).getSimpleName();

    public static Bitmap MatchBar(Context ctx, ColorTheme theme, int valueHome,
                                  int valueAway) {
        return MatchBar(ctx, theme, valueHome, valueAway, 100, 100);
    }

    public static Bitmap MatchBar(Context ctx, ColorTheme theme, int valueHome,
                                  int valueAway, int maxHome, int maxAway) {

        int pWidth = 500;
        int pHeight = 150;


        // Create image
        Bitmap bm = Bitmap.createBitmap(pWidth, pHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);

        // Horizontal divider
        int dHeight = 15;
        Paint pDiv = new Paint();
        pDiv.setColor(Color.GRAY);
        canvas.drawRect(0, pHeight / 2, pWidth, pHeight / 2 + dHeight, pDiv);

        // Vertical divider
        int dWidth = 5;
        Paint pVDiv = new Paint();
        pVDiv.setColor(Color.WHITE);
        canvas.drawRect(pWidth / 2, 0, pWidth / 2 + dWidth, pHeight, pVDiv);

        // Some used value

        // Home stat
        Paint pHome = new Paint();
        pHome.setColor(theme.getColorDusky());

        // Top left point
        int val = (int) (((pWidth / 2) * valueHome) / 100);
        int leftPos = (pWidth / 2) - val;
        canvas.drawRect(leftPos, 0, pWidth / 2, pHeight, pHome);

        // Away stat
        Paint pAway = new Paint();
        pAway.setColor(theme.getRGB());

        // Top left point
        int val2 = (int) ((((pWidth / 2) - dWidth) * valueAway) / 100);
        int leftPos2 = (pWidth / 2 + dWidth) + val2;
        canvas.drawRect(pWidth / 2 + dWidth, 0, leftPos2, pHeight, pAway);
        return bm;
    }

}
