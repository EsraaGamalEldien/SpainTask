package com.vis.spaintask.data;

import android.app.Application;
import android.content.Context;

/**
 * Created by Esraa on 7/7/2017.
 */

public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.context;
    }
}
