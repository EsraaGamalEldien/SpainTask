package com.vis.spaintask.presenter.userproducts;


import android.util.Log;

import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.model.UserItemsList;
import com.vis.spaintask.presenter.base.BasePresenterImp;
import com.vis.spaintask.usecase.authenticate.AuthenticateUseCase;
import com.vis.spaintask.usecase.getproducts.GetProductsUseCase;
import com.vis.spaintask.view.activity.products.ProductsView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Esraa on 7/8/2017.
 */

public class UserProductsPresenterImp extends BasePresenterImp implements UserProductsPresenter {
    private ProductsView productsView;
    private static final String TAG = UserProductsPresenterImp.class.getSimpleName();

    public UserProductsPresenterImp(ProductsView productsView) {
        this.productsView = productsView;

    }

    @Override
    public void getUserProducts(String token) {
        try {
            GetProductsUseCase getProductsUseCase = new GetProductsUseCase();
            productsView.showLoading();
            getProductsUseCase.getProducts(token).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<UserItemsList>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "<<<<< error in getproducts" + e);
                            productsView.hideLoading();
                            handleErrorResponse(e);
                        }

                        @Override
                        public void onNext(UserItemsList userItemsList) {
                            productsView.hideLoading();
                            productsView.onGetProductsSuccess(userItemsList.getItems());

                        }

                    });

        } catch (Throwable throwable) {
            Log.d(TAG, "error is get user products = " + throwable.getMessage());
            productsView.hideLoading();
        }

    }
}
