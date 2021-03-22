package org.hattrickscoreboardl.ui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;

public class TrophyDrawable {

    public static Drawable getTrophy(Context context, String trophypath) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(
                    context.getAssets().open(
                            "Trophies/" + trophypath), "src");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drawable;
    }
}
