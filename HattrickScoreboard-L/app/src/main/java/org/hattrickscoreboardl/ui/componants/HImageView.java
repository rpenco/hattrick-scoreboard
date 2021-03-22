package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.hattrickscoreboardl.utils.Dimen;

/**
 * Created by romain on 25/10/2014.
 */
public class HImageView extends ImageView {

    public HImageView(Context context) {
        super(context);
    }

    public void setHeight(int dimen) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if(layoutParams != null) {
            layoutParams.height = Dimen.dimen(getContext(), dimen);
            setLayoutParams(layoutParams);
        }
    }

    public void setWidth(int dimen) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if(layoutParams != null) {
            layoutParams.width = Dimen.dimen(getContext(), dimen);
            setLayoutParams(layoutParams);
        }
    }

    public void setDimensions(int width, int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if(layoutParams != null) {
            layoutParams.width = Dimen.dimen(getContext(), width);
            layoutParams.height = Dimen.dimen(getContext(), height);
            setLayoutParams(layoutParams);
        }
    }
    /**
     * Direct values
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public void setMargins(int left, int top, int right, int bottom){
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getLayoutParams();
        lp.setMargins(left, top, right, bottom);
        setLayoutParams(lp);
    }

}
