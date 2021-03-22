package org.hattrickscoreboardl.ui.componants;

import android.content.Context;

import org.hattrickscoreboardl.R;
import org.khips.khips_library.library.widgets.buttons.ButtonState;

/**
 * Created by romain on 24/10/2014.
 * Custom button like Android Lollipop
 */
public class HButtonState extends ButtonState {

    public HButtonState(Context context) {
        super(context);
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
        setRippleColor(getResources().getColor(R.color.appTheme));
        setBackgroundColor(getResources().getColor(R.color.appTheme));
    }

    //Custom text
    private CharSequence toUpper(CharSequence text){
        return text.toString().toUpperCase();
    }
}
