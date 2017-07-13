package com.vis.spaintask.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.vis.spaintask.data.App;


public class NetworkUtil {

    public static boolean isNetworkConnected() {
        boolean isAvailable = false;

        ConnectivityManager manager = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }

        return isAvailable;
    }

}
