package org.khips.tools.networks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class KNetwork {

    public static boolean hasInternet(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

}