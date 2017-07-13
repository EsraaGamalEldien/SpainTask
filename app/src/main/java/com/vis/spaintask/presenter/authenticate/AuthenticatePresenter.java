package com.vis.spaintask.presenter.authenticate;

import android.app.Activity;

import com.vis.spaintask.model.LoginResponse;

/**
 * Created by Esraa on 7/7/2017.
 */

public interface AuthenticatePresenter {

    void sendLoginRequest(String msisdn, String pass);

    void navToDetailsActivity(Activity activity, LoginResponse loginResponse);

    void saveUserData(LoginResponse loginResponse);
}
