package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;

import org.hattrickscoreboardl.R;
import org.khips.khips_library.library.widgets.buttons.Button;

/**
 * Created by romain on 24/10/2014.
 * Custom button like Android Lollipop
 */
public class HButton extends Button {

    public HButton(Context context) {
        super(context);
    }

    public HButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HButton(Context context, AttributeSet attrs, int defStyle) {
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

        setTextColor(getResources().getColor(R.color.material_white));
        setBackgroundColor(getResources().getColor(R.color.appTheme));
    }

    //Custom text
    private CharSequence toUpper(CharSequence text){
        return text.toString().toUpperCase();
    }
}
