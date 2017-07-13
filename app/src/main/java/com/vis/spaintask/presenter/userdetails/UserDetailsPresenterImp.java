package com.vis.spaintask.presenter.userdetails;

import android.app.Activity;
import android.content.Intent;

import com.vis.spaintask.view.activity.products.ProductsActivity;
import com.vis.spaintask.view.activity.userdetails.UserDetailsView;

/**
 * Created by Esraa on 7/8/2017.
 */

public class UserDetailsPresenterImp implements UserDetailsPresenter {
    private UserDetailsView userDetailsView;

    public UserDetailsPresenterImp(UserDetailsView userDetailsView) {
        this.userDetailsView = userDetailsView;

    }

    @Override
    public void navToProducts(Activity activity) {
        activity.startActivity(new Intent(activity, ProductsActivity.class));
    }
}
