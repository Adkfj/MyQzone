package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.MainModule;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.MainActivity;

import dagger.Component;

/**
 * Created by pc on 2017/12/5.
 */
@UserScope
@Component(modules = MainModule.class,dependencies = NetComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
