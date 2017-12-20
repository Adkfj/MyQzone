package com.ylj.com.myqzone.presenter;

import android.util.Log;

import com.ylj.com.myqzone.model.api.ApiService;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.Result;
import rx.android.schedulers.AndroidSchedulers;
import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by pc on 2017/12/6.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private ApiService apiService;
    @Inject
    public MainPresenter(MainContract.View view, ApiService apiService) {
         this.view = view;
         this.apiService = apiService;
    }

    /**
     * 参数待定
     */
    @Override
    public void getDatas(String username,String password) {
        apiService.login(username,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                Log.e("test","成功");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("test",e.toString());
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                Log.e("test","jinlai");
                try{
                    String test = responseBody.string();
                    Log.e("test",test);
                }catch (Exception e){

                }

            }
        });
    }
}
