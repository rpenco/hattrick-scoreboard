package org.hattrickscoreboard.application;

import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.ServiceUpdateCallbacks;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.services.BackgroundService;
import org.khips.tools.locales.LocaleSwitcher;

public class HattrickActivity extends Activity implements
        ServiceUpdateCallbacks {

    static final String TAG = (HattrickActivity.class).getSimpleName();

    protected ColorTheme colorTheme;
    protected Preferences pref;
    protected ServiceUpdateCallbacks updateCallbacks;
    /**
     * Broadcast receiver from intent service
     */
    BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null) {
                if (intent.getExtras() != null) {

                    if (updateCallbacks != null) {

                        // Get Code
                        int code = intent.getExtras().getInt(
                                BackgroundService.RESULT);

                        // Get process from
                        String from = intent.getExtras().getString(
                                BackgroundService.FROM);

                        // Notify
                        if (code == Background.RESULT_START) {
                            updateCallbacks.onServiceStartUpdate(code, from);
                        } else {
                            updateCallbacks.onServiceUpdated(code, from);
                        }
                    }
                }
            }

        }
    };

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateCallbacks = this;

        // Set default values
        pref = new Preferences(this);
        colorTheme = new ColorTheme(pref.getRGBColor());

        // Get local from preferences
        LocaleSwitcher switcher = new LocaleSwitcher(this,
                getResources().getStringArray(R.array.locale));
        switcher.change(pref.getSelectedLocale(this));
    }

    @Override
    public void onResume() {
        super.onResume();

        if (receiver != null) {
            registerReceiver(receiver, new IntentFilter(
                    BackgroundService.INTENT));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    protected void unregisterServiceReceiver() {
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Set action bar style
        ActionBar actionBar = getActionBar();

        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(
                    R.drawable.th_background_actionbar));
        }
        return true;
    }

    @Override
    public void onServiceStartUpdate(int code, String from) {

    }

    @Override
    public void onServiceUpdated(int code, String from) {

    }
}
