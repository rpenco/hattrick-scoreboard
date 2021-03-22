package org.khips.khips_library.library.widgets.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.khips.khips_library.R;
import org.khips.khips_library.library.graphics.Color;
import org.khips.khips_library.library.graphics.Font;
import org.khips.khips_library.library.drawables.RoundedDrawable;
import org.khips.khips_library.library.utils.Utils;
import org.khips.khips_library.library.views.layouts.FrameRippleLayout;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class Button extends FrameRippleLayout {

    TextView textview;

    int backgroundColor;
    int textColor;

    int disabledBackgroundColor;
    int disabledTextColor;

    public Button(Context context) {
        super(context);
        setInitAttributs();
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInitAttributs();
    }

    protected void setInitAttributs(){

        //Set params framelayout
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);

        //Set text view
        LayoutParams lp = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
        lp.gravity = Gravity.CENTER;

        textview = new TextView(getContext());
        textview.setGravity(Gravity.CENTER);
        textview.setTextSize(Utils.dimen(getContext(), R.dimen.button_text_size));
        textview.setTypeface(Font.getTypeface(getContext(), Font.ROBOTO_MEDIUM));
        textColor = getResources().getColor(R.color.material_text_white_87);
        textview.setTextColor(textColor);
        addView(textview, lp);

        //Set button style
        int p = (int) getResources().getDimension(R.dimen.spacing_8);
        setPadding(p,p,p,p);

        setMinimumWidth((int)getResources().getDimension(R.dimen.button_min_width));
        setMinimumHeight((int)getResources().getDimension(R.dimen.button_height));

        //Disabled
        disabledBackgroundColor = Color.alpha(getResources().getColor(R.color.material_black), 0.12f);
        disabledTextColor = Color.alpha(getResources().getColor(R.color.material_black), 0.26f);

        //Set ripple effect
        backgroundColor = getResources().getColor(R.color.material_blue_500);
        setRippleBackground(backgroundColor);

        setRippleColor(0);
        setRippleAlpha((int) 0.2f);
        setRippleHover(true);

    }

    public void setText(CharSequence text){
        textview.setText(text);
    }
    public void setText(int text){
        textview.setText(text);
    }

    public CharSequence getText(){
        return textview.getText();
    }

    public void setTextColor(int color){
        textColor = color;
        textview.setTextColor(color);
    }


    @Override
    public void setRippleBackground(int color) {

        rippleBackground = new RoundedDrawable(color, (int) getResources().getDimension(R.dimen.button_radius));
        rippleBackground.setBounds(bounds);
        invalidate();
    }

    @Override
    public void setBackgroundColor(int color) {
        backgroundColor = color;
        setRippleBackground(color);
    }

    @Override
    public void setRippleColor(int rippleColor) {
        int color = (rippleColor != 0)? rippleColor : backgroundColor ;
        super.setRippleColor(color);
    }

    @Override
    public void setEnabled(boolean enabled) {

        if(enabled){
            setBackgroundColor(backgroundColor);
            setTextColor(textColor);
        }else{
            setBackgroundColor(disabledBackgroundColor);
            setTextColor(disabledTextColor);
        }

        super.setEnabled(enabled);
    }

}

