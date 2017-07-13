package com.vis.spaintask.usecase.getproducts;

import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.model.UserItemsList;
import com.vis.spaintask.network.NetworkAPI;
import com.vis.spaintask.network.ServiceGenerator;

import rx.Observable;

/**
 * Created by Esraa on 7/8/2017.
 */

public class GetProductsRepository {
    private NetworkAPI networkAPI;

    public Observable<UserItemsList> getProducts(String token ) throws Throwable {
        networkAPI = ServiceGenerator.getServiceAPI();
        return networkAPI.getProducts(token);
    }
}
