package org.hattrickscoreboard.application.views.settings.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.database.models.DWorld;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 15 aot 2014
 */
public class WorldDialog {

    AlertDialog.Builder builder;
    OnClickListener onConfirmListener;
    AlertDialog dialog;

    public WorldDialog(final Activity activity, ArrayList<DWorld> worlds,
                       DWorld selectedWorld) {

        builder = new AlertDialog.Builder(activity);
        WorldBaseAdapter adapter = new WorldBaseAdapter(activity, worlds,
                selectedWorld, new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get world
                WorldHolder worldH = (WorldHolder) v.getTag();
                DWorld w = worldH.world;

                // Save world prefered
                Preferences pref = new Preferences(activity);
                pref.setSelectedWorldID(w.getLeagueID());

                // Set new world
                ((HattrickApplication) activity.getApplication())
                        .setMyWorld(w);


                // Close view
                dialog.dismiss();

            }
        });

        builder.setAdapter(adapter, null).setNegativeButton(
                R.string.label_close, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();

    }

    public void setOnConfirmListener(OnClickListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
    }

    public void show() {
        dialog.show();
    }
}
