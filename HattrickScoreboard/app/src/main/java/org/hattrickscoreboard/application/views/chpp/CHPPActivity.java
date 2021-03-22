package org.hattrickscoreboard.application.views.chpp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.HattrickActivity;
import org.hattrickscoreboard.application.extended.BackgroundDrawable;
import org.hattrickscoreboard.application.views.activities.SplashscreenActivity;
import org.hattrickscoreboard.application.views.dialogs.CHPPDialog;
import org.khips.extensions.KDialog;
import org.khips.tools.storage.IStorage;

/**
 * @author Khips
 * @since 14 august 2014
 */
public class CHPPActivity extends HattrickActivity {

    static final String TAG = (CHPPActivity.class).getSimpleName();

    EditText etLogin;

    EditText etPassword;

    TextView tvPermissions;

    Button bnValidate;

    RelativeLayout rlBackground;

    ProgressDialog progressDialog;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chpp_activity);

        context = this;
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvPermissions = (TextView) findViewById(R.id.tvPermissions);
        bnValidate = (Button) findViewById(R.id.bnValidate);
        rlBackground = (RelativeLayout) findViewById(R.id.rlBackground);

        BackgroundDrawable.draw(this, colorTheme, rlBackground);

        // Transfrom password field
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        // Show CHPP Dialog
        tvPermissions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // Track show CHPP Permission

                CHPPDialog.show(CHPPActivity.this, colorTheme);

            }
        });

        // Submit
        bnValidate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Submit();
            }
        });

        // Delete Internal Storage
        new Thread(new Runnable() {

            @Override
            public void run() {
                IStorage.deleteInternalStorage(context);
            }
        }).run();

    }

    // Send CHPP login/password
    void Submit() {

        // Quick validation
        if (etLogin.getText().toString().equals("")
                || etPassword.getText().toString().equals("")) {
            Toast.makeText(this, R.string.label_connexion_refused,
                    Toast.LENGTH_SHORT).show();


            return;
        }

        // Show progress dialog
        progressDialog = (ProgressDialog) KDialog.progress(this,
                getString(R.string.chpp_label_authentication_progress));
        progressDialog.show();

        // Launch auto CHPP - connection
        CHPPAuthorizationTask chppRequestAuth = new CHPPAuthorizationTask(this,
                new CHPPAuthorizationListener() {

                    @Override
                    public void onError() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                progressDialog.hide();
                                Toast.makeText(
                                        getBaseContext(),
                                        R.string.chpp_label_authentication_refused,
                                        Toast.LENGTH_SHORT).show();


                            }
                        });

                    }

                    @Override
                    public void onAuthenticationSuccess() {

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                Toast.makeText(
                                        getBaseContext(),
                                        R.string.chpp_label_authentication_accepted,
                                        Toast.LENGTH_SHORT).show();


                            }
                        });

                        progressDialog.hide();

                        startActivity(new Intent(CHPPActivity.this,
                                SplashscreenActivity.class));
                        finish();

                    }

                    @Override
                    public void onAuthenticationError() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                progressDialog.hide();
                                Toast.makeText(
                                        getBaseContext(),
                                        R.string.chpp_label_authentication_refused,
                                        Toast.LENGTH_SHORT).show();


                            }
                        });
                    }
                });

        chppRequestAuth.execute(etLogin.getText().toString(), etPassword
                .getText().toString());
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
