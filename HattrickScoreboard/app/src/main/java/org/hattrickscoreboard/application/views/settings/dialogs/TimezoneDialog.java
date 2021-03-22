package org.hattrickscoreboard.application.views.settings.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.Preferences;
import org.khips.tools.time.KTimeZone;

public class TimezoneDialog {
    static String TAG = (TimezoneDialog.class).getSimpleName();

    AlertDialog.Builder builder;
    String[] TZ;
    String[] locales;
    OnClickListener onConfirmListener;

    public TimezoneDialog(final Activity context) {

        TZ = KTimeZone.timezoneNames();

        Preferences pref = new Preferences(context);
        String timezoneID = pref.getSelectedTimeZone(context);

        int TZPos = 0;
        for (int i = 0; i < TZ.length; i++) {
            if (TZ[i].equals(timezoneID))
                TZPos = i;
        }

        Log.e(TAG, "Pref TimeZone ID: " + timezoneID);
        Log.e(TAG, "TimeZone Pos: " + TZPos);

        builder = new AlertDialog.Builder(context);
        builder.setSingleChoiceItems(TZ, TZPos, null)

                .setPositiveButton(R.string.label_confirm, new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String newTZ = TZ[((AlertDialog) dialog).getListView()
                                .getCheckedItemPosition()];

                        Log.e(TAG, "Selected TZ ID: " + newTZ);

                        // Save locale
                        Preferences pref = new Preferences(context);
                        // pref.setSelectedLocale(newLocale);

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
