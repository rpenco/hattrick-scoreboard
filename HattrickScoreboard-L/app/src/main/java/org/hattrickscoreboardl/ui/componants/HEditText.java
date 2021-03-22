package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.hattrickscoreboardl.R;
import org.khips.khips_library.library.widgets.edittexts.EditText;

/**
 * Created by romain on 25/10/2014.
 */
public class HEditText extends EditText {

    public HEditText(Context context) {
        super(context);
    }

    public HEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void setInitAttributs() {
        super.setInitAttributs();

        setHintColor(getContext().getResources().getColor(R.color.appTheme));
        clearFocus();
        setSingleLine();
    }



    /**
     * Direct values
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    public void setMargins(int left, int top, int right, int bottom){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(left, top, right, bottom);
        setLayoutParams(lp);
    }


    public void setMatchParent(){
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }
}
