package com.ylj.com.myqzone.dagger.components;

import com.ylj.com.myqzone.dagger.modules.NetModules;
import com.ylj.com.myqzone.dagger.modules.PresonModule;
import com.ylj.com.myqzone.dagger.scopes.UserScope;
import com.ylj.com.myqzone.view.PresonActivity;

import dagger.Component;
import dagger.Module;

/**
 * Created by pc on 2017/12/6.
 */
@UserScope
@Component(modules = PresonModule.class,dependencies = NetModules.class)
public interface PresonComponent {
    void inject(PresonActivity presonActivity);
}
