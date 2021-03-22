package org.hattrickscoreboardl.ui.abstracts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by romain
 * on 22/11/2014.
 */
public class HFragment extends Fragment {

    RelativeLayout loadingView;
    IRequest request;


    public IRequest getRequest() {
        if(request == null){
            request = new HattrickRequest(getActivity(), ((HattrickApplication) getActivity().getApplication()).getCHPPToken(getActivity()));
        }
        return request;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        loadingView = (RelativeLayout) inflater.inflate(R.layout.loading, container, false);
        return loadingView;
    }


    @Override
    public void onStart() {
        super.onStart();

        new Thread(
        new Runnable() {
            @Override
            public void run() {

                //Get data from DB
                boolean isPrepared = onPrepareData();
                if(isPrepared){

                    final View v = onDisplayData();
                    if(v != null){
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                loadingView.removeAllViews();
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
                                loadingView.addView(v,params);
                            }
                        });
                    }
                }
            }
        }).start();

    }

    protected View onDisplayData() {
        return null;
    }

    protected boolean onPrepareData() {
        return false;
    }

    public String toUpperCase(String string){
        if (string != null)
            return string.toUpperCase(Locale.ENGLISH);
        return "";
    }

    public String toUpperCase(int resource){
        String s = getString(resource);
        if (s != null)
            return s.toUpperCase(Locale.ENGLISH);
        return "";
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

}
