package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.hattrickscoreboardl.R;

/**
 * Created by romain on 25/10/2014.
 */
public class HContentView extends LinearLayout {

    public HContentView(Context context) {
        super(context);
        applyStyle(context);
    }

    public HContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyStyle(context);
    }

    public HContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyStyle(context);
    }

    //Custom style
    private void applyStyle(Context context){
        setBackgroundColor(context.getResources().getColor(R.color.contentBackground));
        int padding = (int) context.getResources().getDimension(R.dimen.contentPadding);
        setPadding(padding,padding,padding,padding);
        setOrientation(LinearLayout.VERTICAL);
    }


    //Split in two
    public LinearLayout splitViewVertical(){

        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        addView(layout);
        return layout;
    }

    //Split in two
    public LinearLayout splitViewHorizontal(){

        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);
        addView(layout);
        return layout;
    }
    //Add 1dp margin bottom for next view
    public void lineSeparator(){
        LayoutParams llparams = (LayoutParams) getLayoutParams();
        llparams.setMargins(0, 0, 0, 2);
        setLayoutParams(llparams);
    }


}
