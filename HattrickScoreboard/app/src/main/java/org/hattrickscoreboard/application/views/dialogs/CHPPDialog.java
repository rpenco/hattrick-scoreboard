package org.hattrickscoreboard.application.views.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;

public class CHPPDialog extends DialogFragment {

    public CHPPDialog() {
    }

    public static void show(Context context, ColorTheme colorTheme) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.chpp_dialog);

        Button dialogButton = (Button) dialog.findViewById(R.id.btnCHPPOK);

        // Set Colors

        ((TextView) dialog.findViewById(R.id.tvCHPPHeader))
                .setBackgroundColor(colorTheme.getColorDusky());
        ((LinearLayout) dialog.findViewById(R.id.llBackground))
                .setBackgroundColor(colorTheme.getRGB());
        ((LinearLayout) dialog.findViewById(R.id.llCHPPOK))
                .setBackgroundColor(colorTheme.getColorDusky());

        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
