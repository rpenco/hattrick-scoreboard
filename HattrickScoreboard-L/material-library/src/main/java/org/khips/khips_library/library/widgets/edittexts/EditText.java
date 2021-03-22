package org.khips.khips_library.library.widgets.edittexts;


import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.khips.khips_library.R;
import org.khips.khips_library.library.utils.Utils;
import org.khips.khips_library.library.widgets.textviews.CaptionView;

public class EditText extends LinearLayout {

    CaptionView tvHint;
    CaptionView tvCounter;
    CaptionView tvDescription;

    android.widget.EditText editText;
    LinearLayout llSep;

    int counterMax = 50;
    int counter = 0;

    int defaultColor;
    int hintColor;
    int errorColor;

    boolean isCounterEnabled = true;

    public EditText(Context context) {
        super(context);
        setInitAttributs();
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInitAttributs();
    }


    protected void setInitAttributs() {

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);

        int p = (int) getResources().getDimension(R.dimen.spacing_8);
        int p16 = (int) getResources().getDimension(R.dimen.spacing_16);
        setPadding(p,p16,p,0);

        defaultColor = getResources().getColor(R.color.material_gray_500);
        hintColor = getResources().getColor(R.color.material_blue_500);
        errorColor = getResources().getColor(R.color.material_red_500);

        //line 1: Hint text
        tvHint = new CaptionView(getContext());
        tvHint.setVisibility(INVISIBLE);
        addView(tvHint);

        //Line 2: Edit text
        editText = new android.widget.EditText(getContext());
        editText.setBackgroundColor(0);
        editText.setPadding(0, p, 0, p);
        editText.setTextSize(Utils.dimen(getContext(), R.dimen.text_size_15));
        editText.setTextColor(getResources().getColor(R.color.material_text_black_87));
        addView(editText);

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

        tvDescription = new CaptionView(getContext());
        tvDescription.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        tvDescription.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        llBottom.addView(tvDescription);

        tvCounter = new CaptionView(getContext());
        tvCounter.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        tvCounter.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        llBottom.addView(tvCounter);

        //Events
        editText.addTextChangedListener(fieldValidatorTextWatcher);
        editText.setOnFocusChangeListener(OnFocusChangeListener);
        setTextCount();
    }

    TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setTextCount();
            setColors(true);
        }
    };

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

    void setTextCount(){

        if (editText.getText() != null) {
            counter = editText.getText().length();
        } else {
            counter = 0;
        }

        if(isCounterEnabled) {
            tvCounter.setText(counter + " / " + counterMax);
        }else{
            tvCounter.setVisibility(View.INVISIBLE);
        }
    }

    void setColors(boolean gainFocus){

        llSep.setBackgroundColor(defaultColor);
        tvHint.setTextColorDefault();
        tvCounter.setTextColorDefault();

        if(gainFocus) {
            llSep.setBackgroundColor(hintColor);
            tvHint.setTextColor(hintColor);
        }

        if(isCounterEnabled) {
            if (counter > counterMax) {
                llSep.setBackgroundColor(errorColor);
                tvCounter.setTextColor(errorColor);
            }
        }

        if(counter > 0){
            tvHint.setVisibility(VISIBLE);
        }else{
            tvHint.setVisibility(INVISIBLE);
        }
    }

    public void setText(String text){
        editText.setText(text);
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    public void setCounterMax(int counterMax) {
        this.counterMax = counterMax;
    }

    public void setHint(String hint){
        editText.setHint(hint);
        tvHint.setText(hint);
    }

    public void setCounterEnable(boolean counterEnable) {
        this.isCounterEnabled = counterEnable;
        if(counterEnable){
            tvCounter.setVisibility(VISIBLE);
        }else{
            tvCounter.setVisibility(INVISIBLE);
        }
    }

    public Editable getText() {
        return editText.getText();
    }


    public void setDefaultColor(int color){
        defaultColor = color;
        invalidate();
    }

    public void setHintColor(int color){
        hintColor = color;
        invalidate();
    }

    public void setErrorColor(int color){
        errorColor = color;
        invalidate();
    }

    public void setInputType(int inputType) {
        editText.setInputType(inputType);
    }

    public void setSingleLine(){
        editText.setSingleLine();
    }

    public void setNextFocusDownId(int next){
        editText.setNextFocusDownId(next);
    }
}