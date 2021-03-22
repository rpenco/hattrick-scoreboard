package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.hattrickscoreboardl.R;
import org.khips.khips_library.library.widgets.buttons.ButtonFlat;

/**
 * Created by romain on 24/10/2014.
 * Custom button like Android Lollipop
 */
public class HButtonFlat extends ButtonFlat {

    public HButtonFlat(Context context) {
        super(context);
    }

    public HButtonFlat(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HButtonFlat(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setText(CharSequence text) {
        super.setText(toUpper(text));
    }

    @Override
    public void setText(int text) {
        super.setText(toUpper(getResources().getString(text)));
    }

    @Override
    protected void setInitAttributs() {
        super.setInitAttributs();

        setTextColor(getResources().getColor(R.color.appTheme));
        setRippleColor(getResources().getColor(R.color.material_gray_400));
    }


    //Custom text
    private CharSequence toUpper(CharSequence text){
        return text.toString().toUpperCase();
    }

    public void widthMatchParent() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        setLayoutParams(lp);
    }
}
