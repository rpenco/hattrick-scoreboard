package org.hattrickscoreboardl.ui.views.chpp;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.componants.HButtonFlat;
import org.khips.khips_library.library.widgets.textviews.TextBodyView;
import org.khips.khips_library.library.widgets.textviews.TitleView;


public class CHPPDialog extends DialogFragment {

    private static Dialog dialog;

    public CHPPDialog() {
    }

    public static void show(Context ctx) {

        dialog = new Dialog(ctx);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        ScrollView sv = new ScrollView(ctx);
        sv.setLayoutParams(params);

        dialog.setContentView(sv);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int p48  = (int) ctx.getResources().getDimension(R.dimen.spacing_48);
        int p8  = (int) ctx.getResources().getDimension(R.dimen.spacing_8);
        int p16  = (int) ctx.getResources().getDimension(R.dimen.spacing_16);

        LinearLayout llLayout = new LinearLayout(ctx);
        llLayout.setOrientation(LinearLayout.VERTICAL);
        llLayout.setLayoutParams(params);
        llLayout.setPadding(p16,0,p16,0);
        sv.addView(llLayout);

        TitleView titleView = new TitleView(ctx);
        titleView.setText("Détail des permissions");
        titleView.setPadding(0,0,0,p16);
        llLayout.addView(titleView);

        TextBodyView tvDescription = new TextBodyView(ctx);
        tvDescription.setText("Votre nom d'utilisateur et votre mot de passe sont uniquement utilisés pour valider l'autorisation. Ils ne sont jamais utilisés ni enregistrés.");
        tvDescription.setPadding(0,0,0,p16);
        llLayout.addView(tvDescription);

        TextBodyView tvDescription2 = new TextBodyView(ctx);
        tvDescription2.setText("Hattrick Scoreboard voudrais se connecter à votre compte Hattrick avec les permissions suivantes:");
        llLayout.addView(tvDescription2);

        TextBodyView tvPerm01 = new TextBodyView(ctx);
        tvPerm01.setText("- Accès en lecture");
        tvPerm01.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm01);

        TextBodyView tvPerm02 = new TextBodyView(ctx);
        tvPerm02.setText("- Gérer les défis (prochainement)");
        tvPerm02.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm02);

        TextBodyView tvPerm03 = new TextBodyView(ctx);
        tvPerm03.setText("- Gestion des jeunes (prochainement)");
        tvPerm03.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm03);

        TextBodyView tvPerm04 = new TextBodyView(ctx);
        tvPerm04.setText("- Placer une enchère (prochainement)");
        tvPerm04.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm04);

        TextBodyView tvPerm05 = new TextBodyView(ctx);
        tvPerm05.setText("- Envoi des ordres de match (prochainement)");
        tvPerm05.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm05);

        TextBodyView tvPerm06 = new TextBodyView(ctx);
        tvPerm06.setText("- Définir l'entraînement (prochainement)");
        tvPerm06.setPadding(p48,p8,p8,p8);
        llLayout.addView(tvPerm06);

        LinearLayout llConfirm = new LinearLayout(ctx);
        llConfirm.setLayoutParams(params);
        llConfirm.setOrientation(LinearLayout.HORIZONTAL);
        llConfirm.setGravity(Gravity.RIGHT);
        llLayout.addView(llConfirm);

        HButtonFlat btnClose = new HButtonFlat(ctx);
        btnClose.setText("Fermer");
        llConfirm.addView(btnClose);




        btnClose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
