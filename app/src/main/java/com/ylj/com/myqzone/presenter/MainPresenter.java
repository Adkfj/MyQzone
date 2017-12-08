package com.ylj.com.myqzone.presenter;

import com.ylj.com.myqzone.model.api.ApiService;

/**
 * Created by pc on 2017/12/6.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private ApiService apiService;
    public MainPresenter(MainContract.View view, ApiService apiService) {
         this.view = view;
         this.apiService = apiService;
    }

    /**
     * 参数待定
     */
    @Override
    public void getDatas() {

    }
}
