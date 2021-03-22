package org.hattrickscoreboard.application.utils;

import android.graphics.Color;

/**
 * @author Khips
 * @since 19 march 2014
 */
public class ColorTheme {

    // Various
    int moreDark = -20;

    // RGB
    int red;
    int green;
    int blue;

    // RGB
    int rgb;

    public ColorTheme(int rgb) {
        this.rgb = rgb;
        this.red = Color.red(rgb);
        this.green = Color.green(rgb);
        this.blue = Color.blue(rgb);

    }

    public ColorTheme(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.rgb = Color.rgb(red, green, blue);

    }

    public int getRGB() {
        return rgb;
    }


    public int getColorDusky() {
        return Color.rgb(red + moreDark, green + moreDark, blue + moreDark);
    }
}
