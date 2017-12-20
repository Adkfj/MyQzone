package com.ylj.com.myqzone.model.api;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pc on 2017/12/6.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("api/user/register")
    Observable<ResponseBody> register(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("api/user/login")
    Observable<ResponseBody> login(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("api/user/updatePassword")
    Observable<ResponseBody> updatePassword(@Field("username") String username,@Field("password") String password);
}
