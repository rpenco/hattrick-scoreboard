package org.hattrickscoreboard.application.views.settings.dialogs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.ColorPicker.OnColorChangedListener;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;

import java.util.Locale;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class ColorDialog extends DialogFragment implements
        OnColorChangedListener {

    static String TAG = (ColorDialog.class).getSimpleName();

    int color;
    LinearLayout llBackground;
    LinearLayout llFooter;

    RelativeLayout rlDefault;
    RelativeLayout rlDusky;

    TextView titleColor;
    RelativeLayout rlPredef1;
    RelativeLayout rlPredef2;
    RelativeLayout rlPredef3;
    RelativeLayout rlPredef4;
    ColorPicker picker;
    RelativeLayout rlBack;
    OnClickListener onConfirmListener;

    public void setOnConfirmListener(OnClickListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
    }

    public int getColor() {
        return picker.getColor();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.color_dialog, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Close dialog
        Preferences pref = new Preferences(getActivity());
        ColorTheme theme = new ColorTheme(pref.getRGBColor());

        // Theme color
        llFooter = (LinearLayout) view.findViewById(R.id.llOK);
        llFooter.setBackgroundColor(theme.getColorDusky());

        // Background color
        llBackground = (LinearLayout) view.findViewById(R.id.llBackground);
        llBackground.setBackgroundColor(theme.getRGB());

        // Titles
        TextView tvPreview = (TextView) view.findViewById(R.id.tvTitlePreview);
        TextView tvPredefined = (TextView) view.findViewById(R.id.tvTitleColor);
        tvPreview.setText(getString(R.string.colorpicker_title_preview)
                .toUpperCase(Locale.US));
        tvPredefined.setText(getString(R.string.colorpicker_title_predefined)
                .toUpperCase(Locale.US));

        rlDefault = (RelativeLayout) view.findViewById(R.id.rlDefault);
        rlDusky = (RelativeLayout) view.findViewById(R.id.rlDusky);
        rlBack = (RelativeLayout) view.findViewById(R.id.rlBack);

        // Color picker
        picker = (ColorPicker) view.findViewById(R.id.picker);
        picker.setOnColorChangedListener(this);

        // Bars
        SaturationBar saturationBar = (SaturationBar) view
                .findViewById(R.id.saturationbar);
        ValueBar valueBar = (ValueBar) view.findViewById(R.id.valuebar);

        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);

        // Set previous color
        picker.setOldCenterColor(pref.getRGBColor());
        picker.setColor(pref.getRGBColor());

        // Predefined color
        rlPredef1 = (RelativeLayout) view.findViewById(R.id.rlPredef1);
        rlPredef1.setBackgroundColor(new ColorTheme(70, 130, 76).getRGB());
        rlPredef1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                picker.setColor(((ColorDrawable) v.getBackground()).getColor());
            }
        });

        rlPredef2 = (RelativeLayout) view.findViewById(R.id.rlPredef2);
        rlPredef2.setBackgroundColor(new ColorTheme(70, 130, 165).getRGB());
        rlPredef2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                picker.setColor(((ColorDrawable) v.getBackground()).getColor());
            }
        });

        rlPredef3 = (RelativeLayout) view.findViewById(R.id.rlPredef3);
        rlPredef3.setBackgroundColor(new ColorTheme(217, 121, 110).getRGB());
        rlPredef3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                picker.setColor(((ColorDrawable) v.getBackground()).getColor());
            }
        });
        rlPredef4 = (RelativeLayout) view.findViewById(R.id.rlPredef4);
        rlPredef4.setBackgroundColor(new ColorTheme(220, 202, 108).getRGB());
        rlPredef4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                picker.setColor(((ColorDrawable) v.getBackground()).getColor());
            }
        });

        Button btnOK = (Button) view.findViewById(R.id.btnOK);

        // Quit
        btnOK.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                // Close dialog
                Preferences pref = new Preferences(getActivity());
                pref.setRGBColor(color);
                dismiss();

                // Redraw activity
                getActivity().recreate();

            }
        });

        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        // Quit
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dismiss();
            }
        });

        return view;

    }

    @Override
    public void onColorChanged(int color) {
        this.color = color;

        ColorTheme theme = new ColorTheme(color);
        if (rlDefault != null)
            rlDefault.setBackgroundColor(theme.getRGB());

        if (rlDusky != null)
            rlDusky.setBackgroundColor(theme.getColorDusky());

        if (rlBack != null)
            rlBack.setBackgroundColor(theme.getRGB());
    }

}
