package com.vis.spaintask.network;

import com.vis.spaintask.model.LoginResponse;
import com.vis.spaintask.model.UserItemsList;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Esraa on 7/7/2017.
 */

public interface NetworkAPI {
    @GET(NetworkConfig.AUTHENTICATE)
    Observable<LoginResponse> login(@Query("msisdn") String msisdn, @Query("password") String password);

    @GET(NetworkConfig.GET_PRODUCTS)
    Observable<UserItemsList> getProducts(@Query("token") String token);
}
