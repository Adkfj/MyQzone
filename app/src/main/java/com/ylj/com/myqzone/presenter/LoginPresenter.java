package com.ylj.com.myqzone.presenter;

import com.ylj.com.myqzone.model.api.ApiService;

/**
 * Created by pc on 2017/12/6.
 */

public class LoginPresenter implements LoginContrct.Presenter {
    private LoginContrct.View view;
    private ApiService apiService;
    public LoginPresenter(LoginContrct.View view, ApiService apiService) {
        this.view =  view;
        this.apiService  = apiService;
    }


    @Override
    public void login(String user, String password) {

    }
}
