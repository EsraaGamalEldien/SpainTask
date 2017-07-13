package com.vis.spaintask.presenter.authenticate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vis.spaintask.data.Constants;
import com.vis.spaintask.data.Preferences;
import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.presenter.base.BasePresenterImp;
import com.vis.spaintask.usecase.authenticate.AuthenticateUseCase;
import com.vis.spaintask.view.activity.authenticate.AuthenticateView;
import com.vis.spaintask.view.activity.userdetails.UserDetailsActivity;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Esraa on 7/7/2017.
 */

public class AuthenticatePresenterImp extends BasePresenterImp implements AuthenticatePresenter {
    private AuthenticateView authenticateView;
    private static final String TAG = AuthenticatePresenterImp.class.getSimpleName();

    public AuthenticatePresenterImp(AuthenticateView authenticateView) {
        this.authenticateView = authenticateView;
    }

    @Override
    public void sendLoginRequest(String msisdn, String pass) {
        authenticateView.showLoading();
        try {
            final AuthenticateUseCase authenticateUseCase = new AuthenticateUseCase();

            authenticateUseCase.login(msisdn, pass).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<LoginResponse>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
//                            authenticateView.hideLoading();
                            Log.d(TAG, "<<<<< error in authenticate" + e);
                            handleErrorResponse(e);

                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
//                            authenticateView.hideLoading();
                            authenticateView.onLoginSuccess(loginResponse);

                        }

                    });


        } catch (Throwable throwable) {
            Log.d(TAG,"<<<<<error in authenticate =" + throwable.getMessage());
//            authenticateView.hideLoading();
        }

    }

    @Override
    public void navToDetailsActivity(Activity activity, LoginResponse loginResponse) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.LOGIN_RESPONSE, loginResponse);
        Intent intent = new Intent(activity, UserDetailsActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public void saveUserData(LoginResponse loginResponse) {
        Preferences.saveUserDataObj(loginResponse);
    }


}
