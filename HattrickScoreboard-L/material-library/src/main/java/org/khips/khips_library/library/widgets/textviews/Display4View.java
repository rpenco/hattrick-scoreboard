package org.khips.khips_library.library.widgets.textviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import org.khips.khips_library.R;
import org.khips.khips_library.library.graphics.Font;
import org.khips.khips_library.library.utils.Utils;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class Display4View extends TextView {

    public Display4View(Context context) {
        super(context);
        setInitAttributs();
    }

    public Display4View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    private void setInitAttributs() {
        setTextSize(Utils.dimen(getContext(), R.dimen.text_size_112));
        setTypeface(Font.getTypeface(getContext(),Font.ROBOTO_LIGHT));
        setTextColor(getResources().getColor(R.color.material_text_black_54));
    }
}
