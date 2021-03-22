package org.khips.tools;

import android.content.Context;
import android.util.TypedValue;

public class KResource {

    public static int getResDrawable(Context ctx, String drawable) {
        int resourceId = ctx.getResources().getIdentifier(drawable, "drawable",
                ctx.getPackageName());
        if (resourceId == 0) {
            return -1;
        } else {
            return resourceId;
        }
    }
}
