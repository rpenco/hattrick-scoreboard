package org.khips.extensions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

public class KDialog {

    public static Dialog progress(Context context, String message, String title) {
        return ProgressDialog.show(context, title, message, true);
    }

    public static Dialog progress(Context context, String message) {
        return progress(context, message, "");
    }

}
