package org.hattrickscoreboardl.utils;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Switch application language
 *
 */
public final class LocaleSwitcher {

    public static void change(Context context, String _locale) {

        //Create local from String locale
        Locale locale = new Locale(_locale);
        Locale.setDefault(locale);

        //Apply config
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources()
                .updateConfiguration(config, null);
    }

}
