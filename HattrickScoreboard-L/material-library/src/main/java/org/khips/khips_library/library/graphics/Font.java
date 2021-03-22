package org.khips.khips_library.library.graphics;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by romain
 * on 15/12/2014.
 */
public class Font {

    static String FONTS = "fonts/";

    public static String ROBOTO_BLACK                   = "Roboto-Black.ttf";
    public static String ROBOTO_BLACK_ITALIC            = "Roboto-BlackItalic.ttf";
    public static String ROBOTO_BOLD                    = "Roboto-Bold.ttf";
    public static String ROBOTO_BOLD_ITALIC             = "Roboto-BoldItalic.ttf";
    public static String ROBOTO_ITALIC                  = "Roboto-Italic.ttf";
    public static String ROBOTO_LIGHT                   = "Roboto-Light.ttf";
    public static String ROBOTO_LIGHT_ITALIC            = "Roboto-Light_Italic.ttf";
    public static String ROBOTO_MEDIUM                  = "Roboto-Medium.ttf";
    public static String ROBOTO_MEDIUM_ITALIC           = "Roboto-MediumItalic.ttf";
    public static String ROBOTO_REGULAR                 = "Roboto-Regular.ttf";
    public static String ROBOTO_THIN                    = "Roboto-Thin.ttf";
    public static String ROBOTO_THIN_ITALIC             = "Roboto-ThinItalic.ttf";
    public static String ROBOTO_CONDENSED_BOLD          = "RobotoCondensed-Bold.ttf";
    public static String ROBOTO_CONDENSED_BOLD_ITALIC   = "RobotoCondensed-BoldItalic.ttf";
    public static String ROBOTO_CONDENSED_ITALIC        = "RobotoCondensed-Italic.ttf";
    public static String ROBOTO_CONDENSED_LIGHT         = "RobotoCondensed-Light.ttf";
    public static String ROBOTO_CONDENSED_LIGHT_ITALIC  = "RobotoCondensed-LightItalic.ttf";
    public static String ROBOTO_CONDENSED_REGULAR       = "RobotoCondensed-Regular.ttf";


    public static Typeface getTypeface(Context ctx, String font){
        return Typeface.createFromAsset(ctx.getAssets(),
                FONTS+font);
    }
}
