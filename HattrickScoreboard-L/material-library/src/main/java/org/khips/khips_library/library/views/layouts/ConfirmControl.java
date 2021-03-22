package org.khips.khips_library.library.views.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import org.khips.khips_library.R;
import org.khips.khips_library.library.utils.Utils;
import org.khips.khips_library.library.widgets.buttons.ButtonFlat;
import org.khips.khips_library.library.widgets.buttons.ButtonState;

/**
 * Created by romain
 * on 15/12/2014.
 * http://www.google.com/design/spec/components/list-controls.html#list-controls-types-of-list-controls
 */
public class ConfirmControl extends LinearLayout {

    ButtonState btnConfirm;
    ButtonFlat btnCancel;

    OnClickListener onClickListenerConfirm;

    OnClickListener onClickListenerCancel;

    public ConfirmControl(Context context) {
        super(context);
        setInitAttributs();
    }

    public ConfirmControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInitAttributs();
    }

    public ConfirmControl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setInitAttributs();
    }

    private void setInitAttributs() {

        //Parent layout
        LayoutParams params = new LayoutParams( LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.layout_height));
        setOrientation(VERTICAL);
        setLayoutParams(params);


        //Line divider
        LinearLayout llDivider = new LinearLayout(getContext());
        llDivider.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, (int) getResources().getDimension(R.dimen.line_1)));
        llDivider.setBackgroundColor(getResources().getColor(R.color.material_gray_400));
//        llDivider.setPadding(Utils.dimen(getContext(), R.dimen.spacing_16), 0, Utils.dimen(getContext(), R.dimen.spacing_16), 0);
        addView(llDivider);

        //Buttons
        LinearLayout llConfirm = new LinearLayout(getContext());
        llConfirm.setOrientation(HORIZONTAL);
        llConfirm.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        llConfirm.setBackgroundColor(getResources().getColor(R.color.material_white));
        llConfirm.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        llConfirm.setPadding(Utils.dimen(getContext(), R.dimen.spacing_16), 0, Utils.dimen(getContext(), R.dimen.spacing_16), 0);
        addView(llConfirm);

        btnCancel = new ButtonFlat(getContext());
        btnCancel.setText("Annuler");
        llConfirm.addView(btnCancel);


        btnConfirm = new ButtonState(getContext());
        btnConfirm.setText("Confirmer");
        llConfirm.addView(btnConfirm);
    }


    public void setOnClickListenerConfirm(OnClickListener l) {
        btnConfirm.setOnClickListener(l);
    }

    public void setOnClickListenerCancel(OnClickListener l) {
        btnCancel.setOnClickListener(l);
    }

    public ButtonState getButtonConfirm(){
        return btnConfirm;
    }

    public ButtonFlat getButtonCancel(){
        return btnCancel;
    }
}
