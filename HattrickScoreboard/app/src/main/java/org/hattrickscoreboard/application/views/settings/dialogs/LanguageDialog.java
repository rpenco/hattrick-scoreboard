package org.hattrickscoreboard.application.views.settings.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.Preferences;
import org.khips.tools.locales.LocaleSwitcher;

public class LanguageDialog {

    AlertDialog.Builder builder;
    String[] languages;
    String[] locales;
    OnClickListener onConfirmListener;

    public LanguageDialog(final Activity context) {

        languages = context.getResources().getStringArray(R.array.language);
        locales = context.getResources().getStringArray(R.array.locale);

        Preferences pref = new Preferences(context);
        String localeName = pref.getSelectedLocale(context);

        int locale = 0;
        for (int i = 0; i < locales.length; i++) {
            if (locales[i].equals(localeName))
                locale = i;
        }

        builder = new AlertDialog.Builder(context);
        builder.setSingleChoiceItems(languages, locale, null)

                .setPositiveButton(R.string.label_confirm, new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String newLocale = locales[((AlertDialog) dialog).getListView()
                                .getCheckedItemPosition()];

                        // Save locale
                        Preferences pref = new Preferences(context);
                        pref.setSelectedLocale(newLocale);


                        // Switch
                        LocaleSwitcher switcher = new LocaleSwitcher(context, locales);
                        switcher.change(newLocale);

                        // Redraw activity
                        context.recreate();

                    }
                });

    }

    public void setOnConfirmListener(OnClickListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
    }

    public void show() {
        builder.create().show();
    }

    public String[] getLocales() {
        return locales;
    }

}
