package org.hattrickscoreboard.application.views.settings;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.views.settings.dialogs.ColorDialog;
import org.hattrickscoreboard.application.views.settings.dialogs.LanguageDialog;
import org.hattrickscoreboard.application.views.settings.dialogs.LicensesDialog;
import org.hattrickscoreboard.application.views.settings.dialogs.WorldDialog;
import org.hattrickscoreboard.background.tasks.tables.WorldUpdate;
import org.hattrickscoreboard.database.models.DWorld;

import java.util.ArrayList;

public final class SettingsFragment extends HattrickFragment {

    static final String TAG = (SettingsFragment.class).getSimpleName();
    ArrayList<DWorld> worlds;

    public SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        SettingsTask task = new SettingsTask(getActivity(), this);
        task.execute();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        worlds = (ArrayList<DWorld>) result;
        if (worlds == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_settings);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

        View v = getFragmentView();

        if (!isAdded()) {
            return;
        }

        TextView tvTitle1 = (TextView) v.findViewById(R.id.tvTitleApp);
        TextView tvTitle2 = (TextView) v.findViewById(R.id.tvTitleApp2);
        TextView tvTitle3 = (TextView) v.findViewById(R.id.tvTitleApp3);

        tvTitle1.setText(toUpperCase(R.string.settings_title_application));
        tvTitle2.setText(toUpperCase(R.string.app_name));
        // tvTitle3.setText(toUpperCase(R.string.settings_title_data_storage));

        // Language
        Button btnLang = (Button) getFragmentView().findViewById(
                R.id.btnLanguage);
        btnLang.setOnClickListener(new OnClickListener() {

            private LanguageDialog ldialog;

            @Override
            public void onClick(View v) {
                ldialog = new LanguageDialog(getActivity());
                ldialog.show();
            }
        });

        // Theme
        Button btnColor = (Button) getFragmentView()
                .findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new OnClickListener() {

            private ColorDialog dialog;

            @Override
            public void onClick(View v) {

                FragmentManager fm = getFragmentManager();
                dialog = new ColorDialog();
                dialog.show(fm, "fragment");

            }
        });

        // World
        Button btnWorld = (Button) getFragmentView()
                .findViewById(R.id.btnWorld);
        btnWorld.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                WorldDialog dialog = new WorldDialog(getActivity(), worlds,
                        getWorld());
                dialog.show();

            }
        });

        // Timezone
       /*Button btnTZ = (Button) getFragmentView().findViewById(R.id.btnTZ);
        btnTZ.setOnClickListener(new OnClickListener() {

            private TimezoneDialog tzdialog;

            @Override
            public void onClick(View v) {
                tzdialog = new TimezoneDialog(getActivity());
                tzdialog.show();
            }
        });*/

        // Licenses
        Button btnLicenses = (Button) getFragmentView().findViewById(
                R.id.btnLicenses);
        btnLicenses.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                FragmentManager fm = getFragmentManager();
                LicensesDialog dialog = new LicensesDialog();
                dialog.show(fm, "framgent_licenses");

            }
        });

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(WorldUpdate.FROM)) {
            SettingsTask task = new SettingsTask(getActivity(), this);
            task.execute();
        }
    }

}
