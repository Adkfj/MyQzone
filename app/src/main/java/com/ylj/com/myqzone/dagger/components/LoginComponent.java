package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.LoginModule;
import com.ylj.com.myqzone.dagger.modules.NetModules;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.LoginActivity;

import dagger.Component;
import dagger.Module;

/**
 * Created by pc on 2017/12/6.
 */
@UserScope
@Component(modules = LoginModule.class,dependencies = NetModules.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
