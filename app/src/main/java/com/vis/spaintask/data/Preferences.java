package com.vis.spaintask.data;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.vis.spaintask.model.LoginResponse;


public class Preferences {

    public static void saveString(String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        preferences.edit().putString(key, value).commit();
    }

    public static String getString(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        return preferences.getString(key, "");
    }

    public static void saveBoolean(String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        preferences.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        return preferences.getBoolean(key, true);
    }


    public static void saveUserDataObj(LoginResponse loginResponse) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        SharedPreferences.Editor prefsEditor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(loginResponse);
        prefsEditor.putString(Constants.USER_DATA, json);
        prefsEditor.commit();
    }

    public static LoginResponse getUserDataObj() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getAppContext());
        Gson gson = new Gson();
        String json = preferences.getString(Constants.USER_DATA, "");
        LoginResponse loginResponse = gson.fromJson(json, LoginResponse.class);
        return loginResponse;
    }
}
