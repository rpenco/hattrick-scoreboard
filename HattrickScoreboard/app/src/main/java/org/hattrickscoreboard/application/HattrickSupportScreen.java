package org.hattrickscoreboard.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Khips
 */
public class HattrickSupportScreen {

    private static String TABLET = "tablet";
    private static String RIGHT_FRAGMENT = "rightFragment";

    private Bundle bundle;
    private Activity activity;

    public HattrickSupportScreen(Activity activity) {
        this.activity = activity;
        this.bundle = new Bundle();
    }

    public Bundle getSupportBundle() {
        return bundle;
    }

    public void putInt(String key, int value) {
        bundle.putInt(key, value);
    }

    /*
     * Is on tablet?
     */
    public void evalTablet(int contentRight) {
        if (activity == null)
            return;

        View v = activity.findViewById(contentRight);
        if (v == null)
            return;

        bundle.putBoolean(TABLET, true);

    }

    /**
     * Display fragment on right fragment
     *
     * @param b
     */
    public void setRightFragment(boolean b) {
        bundle.putBoolean(RIGHT_FRAGMENT, b);
    }
}
