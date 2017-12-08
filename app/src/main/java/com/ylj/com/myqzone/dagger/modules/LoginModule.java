package com.ylj.com.myqzone.dagger.modules;

import com.ylj.com.myqzone.presenter.LoginContrct;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 2017/12/6.
 */
@Module
public class LoginModule {
    private final LoginContrct.View view;

    public LoginModule(LoginContrct.View view) {
        this.view = view;
    }
    @Provides
    public LoginContrct.View providesMainView(){
        return view;
    }
}
