package com.vis.spaintask.usecase.authenticate;

import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.network.NetworkAPI;
import com.vis.spaintask.network.ServiceGenerator;

import rx.Observable;

/**
 * Created by Esraa on 7/7/2017.
 */

public class AuthenticateRepository {

    private NetworkAPI networkAPI;

    public Observable <LoginResponse> login(String msisdn, String pass) throws Throwable {
        networkAPI = ServiceGenerator.getServiceAPI();
        return networkAPI.login(msisdn, pass);
    }
}
