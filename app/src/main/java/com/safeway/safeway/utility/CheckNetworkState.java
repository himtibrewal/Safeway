package com.safeway.safeway.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * Created by Himanshu on 12/1/18.
 */

public class CheckNetworkState {
    private Context context;

    public CheckNetworkState(Context context) {
        this.context = context;
    }

    public boolean isNetworkAvailable() {
        boolean isNetworkAvailable = false;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        }
        return isNetworkAvailable;
    }
}
