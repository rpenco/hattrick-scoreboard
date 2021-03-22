package org.khips.tools.locales;

import android.content.Context;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class LocaleSwitcher {

    Context context;
    ArrayList<String> locales;

    public LocaleSwitcher(Context context, String[] locales) {
        this.context = context;
        this.locales = new ArrayList<String>(Arrays.asList(locales));
    }

    public void change(String _locale) {
        Locale locale = new Locale(_locale);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources()
                .updateConfiguration(config, null);
    }

}
