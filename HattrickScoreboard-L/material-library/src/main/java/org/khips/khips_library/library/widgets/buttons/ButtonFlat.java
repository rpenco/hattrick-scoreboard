package org.khips.khips_library.library.widgets.buttons;

import android.content.Context;
import android.util.AttributeSet;

import org.khips.khips_library.R;
import org.khips.khips_library.library.graphics.Color;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class ButtonFlat extends Button {


    public ButtonFlat(Context context) {
        super(context);
    }

    public ButtonFlat(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonFlat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void setInitAttributs() {
        super.setInitAttributs();

        setTextColor(getResources().getColor(R.color.material_blue_500));

        //Disabled color
        disabledBackgroundColor = 0;

        //Set ripple effect
        setRippleBackground(0);
        setRippleColor(getResources().getColor(R.color.material_blue_700));

    }

    @Override
    public void setEnabled(boolean enabled) {

        if(enabled){
            setTextColor(textColor);
        }else{
            setTextColor(Color.alpha(getResources().getColor(R.color.material_black), 0.26f));
        }

        super.setEnabled(enabled);
    }
}

