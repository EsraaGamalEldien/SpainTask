package com.vis.spaintask.usecase.getproducts;

import com.vis.spaintask.model.UserItemsList;

import rx.Observable;

/**
 * Created by Esraa on 7/9/2017.
 */

public class GetProductsUseCase {
    private GetProductsRepository getProductsRepository = new GetProductsRepository();

    public Observable<UserItemsList> getProducts(String token) throws Throwable {
        return getProductsRepository.getProducts(token);
    }
}
