package org.hattrickscoreboardl.ui.componants;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboardl.R;

/**
 * Created by romain on 24/10/2014.
 * Custom button like Android Lollipop
 */
public class HListButton {

    LinearLayout lbSeries;
    TextView tv;
    ImageView iconleft;
    ImageView iconright;

    public HListButton(Context context, LayoutInflater inflater) {

        lbSeries = (LinearLayout) inflater.inflate(R.layout.listbutton, null);

        iconleft = (ImageView) lbSeries.findViewById(R.id.ivIcon);
        iconleft.setImageResource(R.drawable.ic_menu_series);

        tv = (TextView) lbSeries.findViewById(R.id.tvTitle);
        tv.setText("-");

        iconright = (ImageView) lbSeries.findViewById(R.id.ivArrow);
        iconright.setImageResource(R.drawable.ic_button_view);

    }

    public LinearLayout getView(){
        return lbSeries;
    }

    public void setText(String text){
        tv.setText(text);
    }

    public void setIcon(int resource){
        iconleft.setImageResource(resource);
    }

    public void setArrow(int resource){
        iconright.setImageResource(resource);
    }
}
