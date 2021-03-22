/*
 * Copyright (C) 2014 Romain PENCO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hattrickscoreboardl.ui.views.chpp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.google.analytics.tracking.android.EasyTracker;

import org.hattrick.constants.Hattrick;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.SplashscreenActivity;
import org.hattrickscoreboardl.ui.abstracts.activity.BaseActivity;
import org.hattrickscoreboardl.ui.componants.HButtonFlat;
import org.hattrickscoreboardl.ui.componants.HContentView;
import org.hattrickscoreboardl.ui.componants.HEditText;
import org.hattrickscoreboardl.ui.componants.HImageView;
import org.hattrickscoreboardl.utils.Dimen;
import org.hattrickscoreboardl.utils.gtracker.GTracker;
import org.hattrickscoreboardl.utils.gtracker.HTracker;
import org.khips.khips_library.library.widgets.buttons.ButtonFlat;
import org.khips.khips_library.library.widgets.buttons.ButtonState;
import org.khips.khips_library.library.views.layouts.ConfirmControl;
import org.khips.khips_library.library.widgets.textviews.TextBodyView;


public class CHPPActivity extends BaseActivity {
    static String TAG = (CHPPActivity.class).getSimpleName();

    HEditText etLogin;
    HEditText etPassword;
    ButtonState btnConfirm;
    ButtonFlat btnCancel;

    @Override
    protected int setContentView() {
        //Activity with action bar
        return R.layout.activity_home;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_empty, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Suppress menu button && progress bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setProgressBar((NumberProgressBar) findViewById(R.id.progress_bar));

        FrameLayout fContainer = (FrameLayout) findViewById(R.id.fContainer);

        LinearLayout llContainer = new LinearLayout(this);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        fContainer.addView(llContainer);

        //////////////////////////////////////////////////////////////////////////////////////////
        /// DESIGN ///


        //Hattrick Logo
        HImageView ivHattrick = new HImageView(this);
        ivHattrick.setImageResource(R.drawable.ic_hattrick_logo);
        llContainer.addView(ivHattrick);
        ivHattrick.setHeight(R.dimen.hattrickHeightLogo);
        ivHattrick.setMargins(0,
                Dimen.dimen(this, R.dimen.spacing_16),
                0,
                Dimen.dimen(this, R.dimen.hattrickMarginVertical));


        //Hattrick Text Restriction
        TextBodyView tvHattrick  = new TextBodyView(this);
        tvHattrick.setText(R.string.chpp_hattrick_text);
        tvHattrick.setGravity(Gravity.CENTER);
        llContainer.addView(tvHattrick);
        tvHattrick.setPadding( Dimen.dimen(this, R.dimen.spacing_16), 0,  Dimen.dimen(this, R.dimen.spacing_16), Dimen.dimen(this, R.dimen.spacing_24));

        //Hattrick Button
        HButtonFlat btnHattrick  = new HButtonFlat(this);
        btnHattrick.setText(R.string.chpp_hattrick_button);
        btnHattrick.widthMatchParent();
        llContainer.addView(btnHattrick);

        ///////////////////////////////////
        ///// CHPP content

        HContentView hContentCHPP = new HContentView(this);
        llContainer.addView(hContentCHPP);
        LinearLayout vCHPP = hContentCHPP.splitViewHorizontal();

        //CHPP Image
        HImageView ivCHPP = new HImageView(this);
        ivCHPP.setImageResource(R.drawable.ic_chpp);
        vCHPP.addView(ivCHPP);
        ivCHPP.setDimensions(R.dimen.chppWidthLogo, R.dimen.chppWidthLogo);

        //CHPP Text
        ViewGroup.LayoutParams llparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TextBodyView tvCHPP = new TextBodyView(this);
        tvCHPP.setLayoutParams(llparams);
        tvCHPP.setGravity(Gravity.CENTER_VERTICAL);
        tvCHPP.setText(R.string.chpp_chpp_text);
        tvCHPP.setPadding(Dimen.dimen(this, R.dimen.spacing_16),0, 0, 0);
        vCHPP.addView(tvCHPP);

        //Button permission details
        HButtonFlat btnPermissions = new HButtonFlat(this);
        btnPermissions.widthMatchParent();
        btnPermissions.setText(R.string.chpp_permission_text);
        hContentCHPP.addView(btnPermissions);

        //Separator
        hContentCHPP.lineSeparator();

        ///// Login content /////
        HContentView hContentLogin = new HContentView(this);
        llContainer.addView(hContentLogin);

        //Login edit text
        etLogin = new HEditText(this);
        etLogin.setHint(getString(R.string.chpp_login_text));
        etLogin.setCounterEnable(false);
        hContentLogin.addView(etLogin);

        //Password edit text
        etPassword = new HEditText(this);
        etPassword.setHint(getString(R.string.chpp_password_text));
        etPassword.setCounterEnable(false);
        etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        hContentLogin.addView(etPassword);

        ///// Login content /////
        ConfirmControl confirmControl = new ConfirmControl(this);
        llContainer.addView(confirmControl);
        btnConfirm = confirmControl.getButtonConfirm();
        btnConfirm.setText(getString(R.string.chpp_connexion_text));
        btnConfirm.setRippleBackground(getResources().getColor(R.color.appTheme));
        btnConfirm.setTextColor(getResources().getColor(R.color.material_white));

        btnCancel = confirmControl.getButtonCancel();
        btnCancel.setText(getString(R.string.chpp_alternative_connexion_text));
        btnCancel.setTextColor(getResources().getColor(R.color.appTheme));
                etLogin.setNextFocusDownId(etPassword.getId());
        etPassword.setNextFocusDownId(btnConfirm.getId());

        //////////////////////////////////////////////////////////////////////////////////////////
        /// EVENTS ///

        //Show Hattrick
        btnHattrick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*                GTracker.TrackEvent(getApplicationContext(),
                        HTracker.CATEGORY_CHPP, HTracker.ACTION_READ,
                        HTracker.LABEL_PERMISSION);*/

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(Hattrick.URL));
                startActivity(i);
            }
        });

        //Show permissions
        btnPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*                GTracker.TrackEvent(getApplicationContext(),
                        HTracker.CATEGORY_CHPP, HTracker.ACTION_READ,
                        HTracker.LABEL_PERMISSION);*/
                CHPPDialog.show(CHPPActivity.this);
            }
        });


        confirmControl.setOnClickListenerCancel(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(Hattrick.URL));
                startActivity(i);
            }
        });

        confirmControl.setOnClickListenerConfirm(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Quick validation
                if (etLogin.getText().toString().equals("")
                        || etPassword.getText().toString().equals("")) {

                    Toast.makeText(CHPPActivity.this, "Connexion refusée.",
                            Toast.LENGTH_SHORT).show();

                    return;
                }else {

                    btnConfirm.setOnLoadState();

                    // Launch auto CHPP - connection
                    CHPPAuthorizationTask chppRequestAuth = new CHPPAuthorizationTask(getApplicationContext(),
                            new CHPPAuthorizationListener() {

                                @Override
                                public void onError() {
                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            btnConfirm.setOnDefaultState();
                                            Toast.makeText(
                                                    getBaseContext(),
                                                    "chpp_label_authentication_refused",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    });

                                }

                                @Override
                                public void onAuthenticationSuccess() {

                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            btnConfirm.setOnSuccessState();
                                        }
                                    });

                                    startActivity(new Intent(CHPPActivity.this,
                                            SplashscreenActivity.class));
                                    finish();

                                }

                                @Override
                                public void onAuthenticationError() {
                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {

                                            btnConfirm.setOnDefaultState();

                                            Toast.makeText(
                                                    getBaseContext(), "chpp_label_authentication_refused",
                                                    Toast.LENGTH_SHORT).show();

                                            // Track failed connexion
                                            GTracker.TrackEvent(getApplicationContext(),
                                                    HTracker.CATEGORY_CHPP,
                                                    HTracker.ACTION_LOGIN,
                                                    HTracker.LABEL_FAILED);

                                        }
                                    });
                                }
                            });

                    chppRequestAuth.execute(etLogin.getText().toString(), etPassword
                            .getText().toString());
                }
            }
        });
    }

    @Override
    protected void onProgressFinish() {

    }


    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this); // Add this method.
    }

}
