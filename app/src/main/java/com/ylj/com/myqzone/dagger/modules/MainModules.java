package com.ylj.com.myqzone.dagger.modules;

import com.ylj.com.myqzone.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 2017/12/5.
 */
@Module
public class MainModules {
    private final MainContract.View view;

    public MainModules(MainContract.View view) {
        this.view = view;
    }
    @Provides
    public MainContract.View providesMainView(){
     return view;
    }
}
