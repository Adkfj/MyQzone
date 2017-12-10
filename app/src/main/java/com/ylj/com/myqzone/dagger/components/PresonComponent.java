package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.PresonModule;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.PresonActivity;

import dagger.Component;

/**
 * Created by pc on 2017/12/6.
 */
@UserScope
@Component(modules = PresonModule.class,dependencies = NetComponent.class)
public interface PresonComponent {
    void inject(PresonActivity presonActivity);
}
