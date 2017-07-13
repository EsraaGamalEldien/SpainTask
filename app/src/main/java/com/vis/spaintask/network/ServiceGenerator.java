package com.vis.spaintask.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vis.spaintask.R;
import com.vis.spaintask.data.App;
import com.vis.spaintask.util.NetworkUtil;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static NetworkAPI getServiceAPI() throws Throwable {
        if (NetworkUtil.isNetworkConnected()) {
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(loggingInterceptor);
//            okHttpClient.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS);
//            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

            return new Retrofit.Builder()
                    .baseUrl(NetworkConfig.BASE_URL)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
                    .create(NetworkAPI.class);
        } else {
            throw new Exception(App.getAppContext().getString(R.string.no_internet_connection));
        }
    }
}
