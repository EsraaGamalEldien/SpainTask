package com.vis.spaintask.view.activity.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.vis.spaintask.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BaseActivity extends AppCompatActivity implements BaseView {
    //    @BindView(R.id.viewstub)
    ViewStub viewStub;
    private ProgressDialog progressDialog;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
//        ButterKnife.bind(this);
        viewStub = (ViewStub) findViewById(R.id.viewstub);
        view = viewStub.inflate();

    }

    public void showLoading() {
        view.setVisibility(View.VISIBLE);
        progressDialog = ProgressDialog.show(this, getString(R.string.loading), getString(R.string.loading), false);

    }

    public void hideLoading() {
        view.setVisibility(View.GONE);
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
