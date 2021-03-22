package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.utils.Dimen;

/**
 * Created by romain on 25/10/2014.
 */
public class HTextView extends TextView {

    public HTextView(Context context) {
        super(context);
        applyStyle(context);
    }

    public HTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyStyle(context);
    }

    public HTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyStyle(context);
    }


    private void applyStyle(Context context){
            setTextColor(context.getResources().getColor(R.color.textview));
            setTextSize(Dimen.dimen(context, R.dimen.textview));
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        text = (text != null)? text : "null";
        super.setText(text, type);

    }

    public void setTextUpper(CharSequence text, BufferType type)
    {
        text = (text != null)? text.toString().toUpperCase() : "NULL";
        super.setText(text, type);
    }
}
