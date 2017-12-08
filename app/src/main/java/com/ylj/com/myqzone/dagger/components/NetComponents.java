package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.NetModules;
import com.ylj.com.myqzone.model.api.ApiService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by pc on 2017/12/6.
 */
@Component(modules = NetModules.class)
@Singleton
public interface NetComponents {
    ApiService getApiService();
    OkHttpClient getOkHttp();
    Retrofit getRetrofit();
}
