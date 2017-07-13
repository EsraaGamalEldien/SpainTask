package com.vis.spaintask.presenter.base;

import android.content.Intent;

import com.vis.spaintask.data.App;
import com.vis.spaintask.network.ErrorConstants;
import com.vis.spaintask.view.activity.authenticate.AuthenticateActivity;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Esraa on 7/10/2017.
 */

public class BasePresenterImp {


    public static void handleErrorResponse(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException exception = (HttpException) throwable;
            switch (exception.code()) {
                case ErrorConstants.STATUS_CODE:
                    break;
                case ErrorConstants.UNAUTHORIZED:
                    navToLoginScreen();
                    break;
                default:
                    break;
            }
        }

    }

    private static void navToLoginScreen() {
        Intent intent = new Intent(App.getAppContext(), AuthenticateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getAppContext().startActivity(intent);

    }
}
