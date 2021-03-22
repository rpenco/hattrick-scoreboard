package org.hattrickscoreboard.application.views.settings.dialogs;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.khips.tools.storage.IStorage;

/**
 * @author Khips
 * @since 15 aot 2014
 */
public class LicensesDialog extends DialogFragment {

    public LicensesDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Set view
        View view = inflater.inflate(R.layout.licenses_dialog, container);

        // Remove header bar
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        // Set colors
        Preferences pref = new Preferences(getActivity());

        // Set color
        TextView llHeader = (TextView) view.findViewById(R.id.tvHeader);

        LinearLayout llBackground = (LinearLayout) view
                .findViewById(R.id.llBackground);
        LinearLayout llFooter = (LinearLayout) view.findViewById(R.id.llOK);
        llHeader.setBackgroundColor(pref.getRGBColor());
        llBackground.setBackgroundColor(pref.getRGBColor());
        llFooter.setBackgroundColor(pref.getRGBColor());

        // Set titles
        TextView tvApp = (TextView) view.findViewById(R.id.tvTitleApp);
        TextView tvContributors = (TextView) view
                .findViewById(R.id.tvTitleContributors);
        TextView tvLicences = (TextView) view
                .findViewById(R.id.tvTitleLicenses);

        tvApp.setText(tvApp.getText().toString().toUpperCase());
        tvContributors.setText(tvContributors.getText().toString()
                .toUpperCase());
        tvLicences.setText(tvLicences.getText().toString().toUpperCase());

        Button btnClose = (Button) view.findViewById(R.id.btnOK);
        btnClose.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // Set version
        TextView tvVersion = (TextView) view.findViewById(R.id.tvVersion);
        tvVersion.setText(getVersion());

        // Set contributors
        LinearLayout llContributors = (LinearLayout) view
                .findViewById(R.id.llContributors);

        KTableView kTable = new KTableView();

        kTable.createTableView(getActivity(), pref.getRGBColor(),
                llContributors);

        kTable.addRow("Developper");
        kTable.addRow("Khips (#4593312)");

        kTable.addRow("Testers");
        kTable.addRow("lesommer35_HTA (#9480210)");

        kTable.addRow("Translaters");
        kTable.addRowColored("CAT-Gratonell (#6687221)", "Catalan");
        kTable.addRowColored("H-art (#3871186)", "Italian");
        kTable.addRowColored("tommi619 (#4410680)", "German");

        // Set licenses
        WebView wview = (WebView) view.findViewById(R.id.webView);
        wview.loadData(IStorage.readRawFile(getActivity(), R.raw.licence),
                "text/html", "utf-8");

        return view;

    }

    private CharSequence getVersion() {

        PackageInfo pInfo;
        try {
            pInfo = getActivity().getPackageManager().getPackageInfo(
                    getActivity().getPackageName(), 0);
            return getString(R.string.settings_licenses_version,
                    pInfo.versionName);

        } catch (NameNotFoundException e) {

            return getString(R.string.settings_licenses_version,
                    getString(R.string.label_unavailable));
        }

    }
}
