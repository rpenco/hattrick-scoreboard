package org.khips.khips_library.library.widgets.textviews;


import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.khips.khips_library.R;

public class Spinner extends LinearLayout {

    android.widget.Spinner spinner;
    LinearLayout llSep;

    int defaultColor;
    int hintColor;
    int errorColor;


    public Spinner(Context context) {
        super(context);
        setInitAttributs();
    }

    public Spinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    public Spinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInitAttributs();
    }


    private void setInitAttributs() {

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);

        int p = (int) getResources().getDimension(R.dimen.spacing_8);
        int p16 = (int) getResources().getDimension(R.dimen.spacing_16);
        setPadding(p,p16,p,0);

        defaultColor = getResources().getColor(R.color.material_gray_500);
        hintColor = getResources().getColor(R.color.material_blue_500);
        errorColor = getResources().getColor(R.color.material_red_500);

        //Line 2: Edit text
        spinner = new android.widget.Spinner(getContext());
        spinner.setBackgroundColor(0);
        spinner.setPadding(0, p, 0, p);
        addView(spinner);

        //Line 3: Separator
        llSep  = new LinearLayout(getContext());
        llSep.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.line_1)));
        llSep.setBackgroundColor(defaultColor);
        addView(llSep);

        //Line 4: Descp + counter
        LinearLayout llBottom  = new LinearLayout(getContext());
        llBottom.setLayoutParams(params);
        llBottom.setOrientation(HORIZONTAL);
        addView(llBottom);

        //Events
        spinner.setOnFocusChangeListener(OnFocusChangeListener);
    }


    OnFocusChangeListener OnFocusChangeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            setColors(hasFocus);
        }
    };

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        setColors(gainFocus);
    }

    void setColors(boolean gainFocus){

        llSep.setBackgroundColor(defaultColor);

        if(gainFocus) {
            llSep.setBackgroundColor(hintColor);
        }
    }

    public void setErrorMode(boolean errorMode) {
        if(errorMode)
            llSep.setBackgroundColor(errorColor);
        else
            setColors(false);

    }

}