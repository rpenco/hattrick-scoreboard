package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboardl.R;

import java.util.List;

/**
 * Created by romain on 25/10/2014.
 */
public class HColumnsView extends LinearLayout {


    public HColumnsView(Context context) {
        super(context);
        applyStyle(context);
    }

    public HColumnsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyStyle(context);
    }


    //Custom style
    private void applyStyle(Context context){
        setBackgroundColor(context.getResources().getColor(R.color.contentBackground));
        int padding = (int) context.getResources().getDimension(R.dimen.contentPadding);
        setPadding(padding,padding,padding,padding);
        setOrientation(LinearLayout.VERTICAL);
    }


    public void populate(List<String> titles, List<String> values){

        int p = (int) getContext().getResources().getDimension(R.dimen.contentPadding);

        for(int i = 0; i < titles.size(); i++){

            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, 1f);

            LinearLayout layout = new LinearLayout(getContext());
            layout.setLayoutParams(params);
            layout.setPadding(p,p,p,p);
            layout.setOrientation(LinearLayout.HORIZONTAL);

            TextView tvTitle = new TextView(getContext());
            tvTitle.setLayoutParams(params);
            tvTitle.setText(titles.get(i)+"");
            layout.addView(tvTitle);

            TextView tvValue = new TextView(getContext());
            tvValue.setLayoutParams(params);
            tvValue.setText(values.get(i) + "");
            tvValue.setGravity(Gravity.END);
            layout.addView(tvValue);

            addView(layout);
        }
    }

    //Add 1dp margin bottom for next view
    public void separatorBottom(){

        LayoutParams llparams = (LayoutParams) getLayoutParams();
        int sepHeight = (int) getContext().getResources().getDimension(R.dimen.line_1);
        llparams.setMargins(0, 0, 0, sepHeight);
        setLayoutParams(llparams);
    }


}
