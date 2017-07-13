package com.vis.spaintask.view.activity.userdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vis.spaintask.R;
import com.vis.spaintask.data.Constants;
import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.presenter.userdetails.UserDetailsPresenter;
import com.vis.spaintask.presenter.userdetails.UserDetailsPresenterImp;
import com.vis.spaintask.view.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetailsActivity extends BaseActivity implements UserDetailsView {
    @BindView(R.id.tv_userName)
    TextView tv_name;
    @BindView(R.id.tv_userType)
    TextView tv_type;
    private UserDetailsPresenter userDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);
        userDetailsPresenter = new UserDetailsPresenterImp(this);
        LoginResponse loginResponse = (LoginResponse) getIntent().getSerializableExtra(Constants.LOGIN_RESPONSE);
        setViewValues(loginResponse);
    }

    private void setViewValues(LoginResponse loginResponse) {
        tv_name.setText(getString(R.string.welcome) + " " + loginResponse.getFullName());
        if (loginResponse.getUserType().equals(Constants.POSTPAID)) {
            tv_type.setVisibility(View.VISIBLE);
            tv_type.setText(loginResponse.getUserType());
        }
    }

    @OnClick(R.id.b_products)
    public void navToProducts() {
        userDetailsPresenter.navToProducts(UserDetailsActivity.this);
    }


}
