package com.ylj.com.myqzone.presenter;

import com.ylj.com.myqzone.model.api.ApiService;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pc on 2017/12/6.
 */

public class LoginPresenter implements LoginContrct.Presenter {
    private LoginContrct.View view;
    private ApiService apiService;
    @Inject
    public LoginPresenter(LoginContrct.View view, ApiService apiService) {
        this.view =  view;
        this.apiService  = apiService;
    }


    @Override
    public void login(String user, String password) {
        apiService.login(user,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {

            }
        });
    }
}
