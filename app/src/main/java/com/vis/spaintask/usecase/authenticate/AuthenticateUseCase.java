package com.vis.spaintask.usecase.authenticate;

import com.vis.spaintask.model.LoginResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Esraa on 7/7/2017.
 */

public class AuthenticateUseCase {

    private AuthenticateRepository authenticateRepository = new AuthenticateRepository();

    public Observable<LoginResponse> login(String msisdn, String pass) throws Throwable {
        Observable<LoginResponse> loginResponseObservable = authenticateRepository.login(msisdn, pass);
        return loginResponseObservable.map(new Func1<LoginResponse, LoginResponse>() {
            @Override
            public LoginResponse call(LoginResponse loginResponse) {
                loginResponse.setFullName(loginResponse.getGivenName() + loginResponse.getSurName());
                return loginResponse;
            }


        });
    }
}
