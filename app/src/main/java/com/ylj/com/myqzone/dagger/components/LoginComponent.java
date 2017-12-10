package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.LoginModule;
import com.ylj.com.myqzone.dagger.modules.NetModule;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.LoginActivity;

import dagger.Component;

/**
 * Created by pc on 2017/12/6.
 */
@UserScope
@Component(modules = LoginModule.class,dependencies = NetComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
