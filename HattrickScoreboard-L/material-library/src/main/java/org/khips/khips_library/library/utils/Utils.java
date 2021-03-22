package org.khips.khips_library.library.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by romain
 * on 15/12/2014.
 */
public class Utils {


    /**
     * Convert Dp to Pixel
     */
    public static int dpToPx(float dp, Resources resources){
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

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
