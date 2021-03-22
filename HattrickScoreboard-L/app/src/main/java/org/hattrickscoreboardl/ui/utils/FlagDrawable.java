package org.hattrickscoreboardl.ui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;

public class FlagDrawable {

    public static Drawable getFlag(Context context, int countryID) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(
                    context.getAssets().open(
                            "Flags/CountryID/24/" + countryID + ".png"), "src");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drawable;
    }

    public static Drawable getFlag(Context context, String countryCode) {
        Drawable drawable = null;
        try {
            drawable = Drawable.createFromStream(
                    context.getAssets().open(
                            "Flags/CountryCode/64/" + countryCode + ".png"), "src");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return drawable;
    }
}
