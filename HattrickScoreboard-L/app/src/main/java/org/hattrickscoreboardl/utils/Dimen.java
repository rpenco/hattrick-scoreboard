package org.hattrickscoreboardl.utils;

import android.content.Context;

/**
 * Convert dimensions between code and XML or Pixel
 * Created by romain on 25/10/2014.
 */
public final class Dimen {


    /**
     * Convert dimen resource to value like used with XML
     * @param context
     * @param resdimen
     * @return
     */
    public static int dimen(Context context, int resdimen){
        float dimen = context.getResources().getDimension(resdimen);
        if(dimen > 0) {
            return (int) (dimen / context.getResources().getDisplayMetrics().density);
        }
        return 0;
    }
}
