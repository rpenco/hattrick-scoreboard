package org.hattrickscoreboardl.ui.views.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.hattrickscoreboardl.R;
import org.khips.khips_library.library.widgets.edittexts.EditText;
import org.khips.khips_library.library.widgets.buttons.Button;
import org.khips.khips_library.library.widgets.buttons.ButtonFlat;
import org.khips.khips_library.library.widgets.buttons.ButtonState;
import org.khips.khips_library.library.views.layouts.FrameRippleLayout;
import org.khips.khips_library.library.views.layouts.ListControl;
import org.khips.khips_library.library.widgets.textviews.CaptionView;
import org.khips.khips_library.library.widgets.textviews.Display1View;
import org.khips.khips_library.library.widgets.textviews.SubheadView;
import org.khips.khips_library.library.widgets.textviews.TextBodyView;
import org.khips.khips_library.library.widgets.textviews.TitleView;

/**
 * Created by romain
 * on 14/12/2014.
 */
public class MaterialDemo extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo);

        LinearLayout layout = (LinearLayout) findViewById(R.id.llLayout);
        if(layout == null)
            return;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layout.setLayoutParams(params);

        FrameRippleLayout rlRipple = new FrameRippleLayout(this);
        rlRipple.setPadding(10, 10, 10, 10);
        layout.addView(rlRipple);
        SubheadView tv = new SubheadView(this);
        tv.setText("You can click on me!");
        rlRipple.addView(tv);



        /**************************/
        /** Textviews **/

        /*Display4View display4View = new Display4View(this);
        display4View.setText("Display 4");
        layout.addView(display4View);

        Display3View display3View = new Display3View(this);
        display3View.setText("Display 3");
        layout.addView(display3View);

        Display2View display2View = new Display2View(this);
        display2View.setText("Display 2");
        layout.addView(display2View);*/

        Display1View display1View = new Display1View(this);
        display1View.setText("Display");
        layout.addView(display1View);

        /*HeadlineView headlineView = new HeadlineView(this);
        headlineView.setText("Headline");
        layout.addView(headlineView);*/

        TitleView titleView = new TitleView(this);
        titleView.setText("Title");
        layout.addView(titleView);

        SubheadView subheadView = new SubheadView(this);
        subheadView.setText("Subhead");
        layout.addView(subheadView);

        TextBodyView textBodyView = new TextBodyView(this);
        textBodyView.setText("Body");
        layout.addView(textBodyView);

        CaptionView captionView = new CaptionView(this);
        captionView.setText("Caption");
        layout.addView(captionView);

        /**************************/
        /** Buttons **/

        //Horizontal view
        LinearLayout llHoriz = new LinearLayout(this);
        llHoriz.setLayoutParams(params);
        llHoriz.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(llHoriz);

        //Default button
        Button button = new Button(this);
        button.setText("CONFIRM");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SENDED!",Toast.LENGTH_SHORT).show();
            }
        });
        llHoriz.addView(button);

        //Alternative button
        Button buttonWhite = new Button(this);
        buttonWhite.setText("SHARE");
        buttonWhite.setBackgroundColor(getResources().getColor(R.color.material_gray_400));
        buttonWhite.setRippleColor(getResources().getColor(R.color.material_black));
        buttonWhite.setTextColor(getResources().getColor(R.color.material_text_black_87));
        llHoriz.addView(buttonWhite);


        //Flat button
        ButtonFlat buttonFlat = new ButtonFlat(this);
        buttonFlat.setText("CANCEL");
        llHoriz.addView(buttonFlat);

        /**************************/
        /** Progress bars **/

        //Horizontal view
        LinearLayout llHorizProg = new LinearLayout(this);
        llHorizProg.setLayoutParams(params);
        llHorizProg.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(llHorizProg);

        final ButtonState buttonStateLoad = new ButtonState(this);
        buttonStateLoad.setText("SEND");
        buttonStateLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStateLoad.setOnLoadState();
            }
        });

        llHorizProg.addView(buttonStateLoad);

        final ButtonState buttonStateLoaded = new ButtonState(this);
        buttonStateLoaded.setText("OK");
        buttonStateLoaded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStateLoad.setOnSuccessState();
            }
        });

        llHorizProg.addView(buttonStateLoaded);

        final ButtonState buttonStateError = new ButtonState(this);
        buttonStateError.setText("KO");
        buttonStateError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStateLoad.setOnErrorState();
            }
        });

        llHorizProg.addView(buttonStateError);

        EditText editText = new EditText(this);
        editText.setHint("Hint text");
        editText.setDescription("Username or Password");
        editText.setCounterMax(10);
        layout.addView(editText);

        EditText editText2 = new EditText(this);
        editText2.setHint("Hint text");
        editText2.setCounterEnable(false);
        layout.addView(editText2);

        //
        ListControl listControl = new ListControl(this) {
            @Override
            public View getLeftView() {
                TextView tv = new TextView(getContext());
                tv.setText("LEFT");
                return tv;
            }

            @Override
            public View getMiddleView() {
                TextView tv = new TextView(getContext());
                tv.setText("MIDDLE VIEW");
                return tv;
            }

            @Override
            public View getRightView() {
                TextView tv = new TextView(getContext());
                tv.setText("RIGHT");
                return tv;
            }
        };
        layout.addView(listControl);
    }
}
