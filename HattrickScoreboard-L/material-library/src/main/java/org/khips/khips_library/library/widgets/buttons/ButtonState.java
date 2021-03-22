package org.khips.khips_library.library.widgets.buttons;

import android.content.Context;

import org.khips.khips_library.R;
import org.khips.khips_library.library.graphics.Color;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class ButtonState extends Button {

    int state;

    int backgroundColorLoad;
    int backgroundColorSuccess;
    int backgroundColorError;

    int textColorLoad;
    int textColorSuccess;
    int textColorError;

    String loadingText = "LOADING...";
    String successText = "SUCCESS";
    String errorText = "FAILED";
    String defaultText;

    public ButtonState(Context context) {
        super(context);
    }


    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override
    protected void setInitAttributs() {
        super.setInitAttributs();

        //Default style
        backgroundColorLoad = Color.alpha(backgroundColor, 0.26f);
        backgroundColorSuccess = Color.alpha(getResources().getColor(R.color.material_green_500), 0.26f);
        backgroundColorError = Color.alpha(getResources().getColor(R.color.material_red_500), 0.26f);

        textColorLoad = textColor;
        textColorSuccess = textColor;
        textColorError = textColor;

        defaultText = textview.getText().toString();
    }

    public void setOnDefaultState(){

        setTextColor(textColor);
        textview.setText(defaultText);
        setEnabled(true);
        setBackgroundColor(backgroundColor);
    }

    public void setOnLoadState(){

        setTextColor(textColorLoad);
        textview.setText(loadingText);
        setEnabled(false);
        setBackgroundColor(backgroundColorLoad);
    }

    public void setOnSuccessState(){
        setTextColor(textColorSuccess);
        textview.setText(successText);
        setEnabled(false);
        setBackgroundColor(backgroundColorSuccess);

    }

    public void setOnErrorState(){
        setTextColor(textColorError);
        textview.setText(errorText);
        setEnabled(false);
        setBackgroundColor(backgroundColorError);

    }
}

