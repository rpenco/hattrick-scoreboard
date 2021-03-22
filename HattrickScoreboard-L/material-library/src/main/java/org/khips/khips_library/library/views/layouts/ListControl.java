package org.khips.khips_library.library.views.layouts;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.khips.khips_library.R;
import org.khips.khips_library.library.utils.Utils;

/**
 * Created by romain
 * on 15/12/2014.
 * http://www.google.com/design/spec/components/list-controls.html#list-controls-types-of-list-controls
 */
public abstract class ListControl extends FrameRippleLayout {

    View leftView;
    View middleView;
    View rightView;
    private LinearLayout layout;

    public ListControl(Context context) {
        super(context);

        setInitAttributs();
    }

    public ListControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    public ListControl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setInitAttributs();
    }

    private void setInitAttributs() {

        LayoutParams params = new LayoutParams( LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.layout_height), 1);

        layout = new LinearLayout(getContext());
        layout.setLayoutParams(params);
        layout.setBackgroundColor(Color.GREEN);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        addView(layout);

        //Set ripple effect
        setRippleBackground(getResources().getColor(R.color.material_blue_500));
        setRippleColor(getResources().getColor(R.color.material_blue_800));
        setRippleAlpha((int) 0.2f);
        setRippleHover(true);


        int p16 = Utils.dimen(getContext(), R.dimen.spacing_16);

        leftView = getLeftView();
        LayoutParams paramsViewLeft = new LayoutParams((int) getResources().getDimension(R.dimen.spacing_72), (int) getResources().getDimension(R.dimen.layout_height), 1);
        leftView.setLayoutParams(paramsViewLeft);
        leftView.setBackgroundColor(Color.BLUE);
        leftView.setPadding(p16,0,0,0);
        layout.addView(leftView);

        middleView = getMiddleView();
        LayoutParams paramsViewMiddle = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.layout_height), 1);
        middleView.setLayoutParams(paramsViewMiddle);
        middleView.setPadding(0,0,0,0);
        middleView.setBackgroundColor(Color.YELLOW);
        layout.addView(middleView);

        rightView = getRightView();
        LayoutParams paramsViewRight = new LayoutParams((int) getResources().getDimension(R.dimen.spacing_72), (int) getResources().getDimension(R.dimen.layout_height), 1);
        rightView.setLayoutParams(paramsViewRight);
        rightView.setPadding(0,0,p16,0);
        rightView.setBackgroundColor(Color.RED);
        layout.addView(rightView);

    }

    public abstract View getLeftView( );

    public abstract View getMiddleView();

    public abstract View getRightView();
}
