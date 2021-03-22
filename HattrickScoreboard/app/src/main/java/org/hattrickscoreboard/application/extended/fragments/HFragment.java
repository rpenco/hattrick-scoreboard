package org.hattrickscoreboard.application.extended.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.database.models.DWorld;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Khips
 * @since 13 august 2014
 */
public class HFragment extends Fragment {

    static final String TAG = (HFragment.class).getSimpleName();

    /**
     * Return user world
     *
     * @return
     */
    protected DWorld getWorld() {

        Activity activity = getActivity();
        if (activity != null) {

            HattrickApplication app = (HattrickApplication) activity
                    .getApplication();
            if (app != null) {
                return app.getMyWorld();
            }
        }
        return null;
    }

    /**
     * UpperCase string resource
     *
     * @param resource
     * @return
     */
    protected String toUpperCase(int resource) {
        return toUpperCase(getString(resource));
    }

    /**
     * UpperCase string
     *
     * @param string
     * @return
     */
    protected String toUpperCase(String string) {
        if (string != null)
            return string.toUpperCase(Locale.ENGLISH);
        return "";
    }

    /**
     * Uppercase textview
     *
     * @param tv
     */
    protected void upperCaseTextView(View v, int resourceID) {

        TextView tv = (TextView) v.findViewById(resourceID);
        if (tv != null)
            tv.setText(toUpperCase(tv.getText().toString()));

    }

    /**
     * Convert number to currency relative to world
     *
     * @param currency
     * @return
     */
    protected String formatCurrency(double number) {

        DecimalFormatSymbols format = new DecimalFormatSymbols();
        format.setGroupingSeparator(' ');
        format.setDecimalSeparator(',');
        DecimalFormat value = new DecimalFormat("#,###", format);
        String currency = value.format(number / getWorld().getCurrencyRate());

        return currency + " " + getWorld().getCurrencyName();

    }

    /**
     * Format number
     *
     * @param number
     * @return
     */
    protected String formatNumber(double number) {

        DecimalFormatSymbols format = new DecimalFormatSymbols();
        format.setGroupingSeparator(' ');
        format.setDecimalSeparator(',');
        DecimalFormat value = new DecimalFormat("#,###", format);
        return value.format(number);

    }

    @SuppressLint("SimpleDateFormat")
    protected String formatDate(String date) {

        if (date == null)
            return getString(R.string.label_unavailable);

        // String to date
        Date d;
        try {
            d = HattrickDate.StringToDate(date);
            SimpleDateFormat formatter = new SimpleDateFormat(getWorld()
                    .getDateFormat());
            return formatter.format(d);

        } catch (ParseException e) {
            return getString(R.string.label_unavailable);
        }

    }

    @SuppressLint("SimpleDateFormat")
    protected String formatTime(String date) {
        if (date == null)
            return getString(R.string.label_unavailable);
        // String to date
        Date d;
        try {
            d = HattrickDate.StringToDate(date);
            SimpleDateFormat formatter = new SimpleDateFormat(getWorld()
                    .getTimeFormat());
            return formatter.format(d);
        } catch (ParseException e) {
            return getString(R.string.label_unavailable);
        }

    }

    @SuppressLint("SimpleDateFormat")
    protected String formatDateTime(String date) {

        if (date == null)
            return getString(R.string.label_unavailable);

        // String to date
        Date d;
        try {
            d = HattrickDate.StringToDate(date);
            String format = getWorld().getDateFormat().replace("yyyy", "yy")
                    + " " + getWorld().getTimeFormat();
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(d);
        } catch (ParseException e) {
            return getString(R.string.label_unavailable);
        }

    }

    protected void applyMarginLayout(LayoutParams layoutParams) {

        layoutParams.setMargins(
                getResources().getDimensionPixelSize(R.dimen.margin_layout),
                getResources().getDimensionPixelSize(R.dimen.margin_layout),
                getResources().getDimensionPixelSize(R.dimen.margin_layout),
                getResources().getDimensionPixelSize(R.dimen.margin_layout));
    }
}
