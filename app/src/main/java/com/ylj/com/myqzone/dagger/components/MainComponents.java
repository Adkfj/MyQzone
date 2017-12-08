package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.MainModules;
import com.ylj.com.myqzone.dagger.modules.NetModules;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.MainActivity;

import dagger.Component;

/**
 * Created by pc on 2017/12/5.
 */
@UserScope
@Component(modules = MainModules.class,dependencies = NetComponents.class)
public interface MainComponents {
    void inject(MainActivity mainActivity);
}
