package org.hattrickscoreboardl.ui.utils.titles;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.utils.Dimen;

/**
 * Created by romain
 * on 12/12/2014.
 */
public class TitleView extends LinearLayout {

    TextView tvTitle;
    LinearLayout subline;

    public TitleView(Context context) {
        super(context);
        setInitAttributes();
    }

    private void setInitAttributes() {

        int p = (int) getContext().getResources().getDimension(R.dimen.contentPaddingSmall);

        LinearLayout.LayoutParams param
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        setLayoutParams(param);
        setOrientation(VERTICAL);
        setPadding(p,p,p,p);

        tvTitle = new TextView(getContext());
        tvTitle.setTextColor(getContext().getResources().getColor(R.color.textview));
        tvTitle.setTextSize(Dimen.dimen(getContext(), R.dimen.text_size_34));
        addView(tvTitle);

        subline = new LinearLayout(getContext());
        subline.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
        subline.setBackgroundColor(getContext().getResources().getColor(R.color.drawerTitleSeparator));
        addView(subline);
    }

    public void setText(String text){
        tvTitle.setText(text);
    }

    public void setText(int res){
        tvTitle.setText(res);
    }
}
