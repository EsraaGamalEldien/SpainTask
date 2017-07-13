package com.vis.spaintask.view.activity.authenticate;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.vis.spaintask.R;
import com.vis.spaintask.data.Preferences;
import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.presenter.authenticate.AuthenticatePresenter;
import com.vis.spaintask.presenter.authenticate.AuthenticatePresenterImp;
import com.vis.spaintask.view.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthenticateActivity extends BaseActivity implements AuthenticateView {

    @BindView(R.id.edt_msisdn)
    EditText edt_msisdn;
    @BindView(R.id.edt_pass)
    EditText edt_pass;
    private AuthenticatePresenter authenticatePresenter;
    private static final String TAG = AuthenticateActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        ButterKnife.bind(this);
        authenticatePresenter = new AuthenticatePresenterImp(this);
        if (Preferences.getUserDataObj() != null) {
            authenticatePresenter.navToDetailsActivity(this, Preferences.getUserDataObj());
        }
    }

    @OnClick(R.id.b_login)
    public void login() {
        authenticatePresenter.sendLoginRequest(edt_msisdn.getText().toString(), edt_pass.getText().toString());

    }


    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        if (loginResponse != null) {
            authenticatePresenter.saveUserData(loginResponse);
            authenticatePresenter.navToDetailsActivity(AuthenticateActivity.this, loginResponse);
        } else
            Log.d(TAG, "<<<<<< Login response is null");

    }


}
