package com.vis.spaintask.view.activity.authenticate;

import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.view.activity.base.BaseView;

/**
 * Created by Esraa on 7/7/2017.
 */

public interface AuthenticateView extends BaseView {

    void onLoginSuccess(LoginResponse loginResponse);
}
