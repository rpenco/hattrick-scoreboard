package org.hattrickscoreboardl.ui.utils;

import android.graphics.Color;

/**
 * @author Khips
 * @since 19 mars 2014
 */
public class ColorTheme {

    // Original color
    int red;
    int green;
    int blue;
    int rgb;

    //700
    ColorTheme color700;

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

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public ColorTheme get700(){
        int r = red - 20;
        int g = green - 20;
        int b = blue- 20;
        return new ColorTheme(r,g,b);
    }
}
