package com.ylj.com.myqzone.dagger.modules;

import com.ylj.com.myqzone.presenter.PresonContrct;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 2017/12/6.
 */
@Module
public class PresonModule {
    private final PresonContrct.View view;

    public PresonModule(PresonContrct.View view) {
        this.view = view;
    }
    @Provides
    public PresonContrct.View providePresonView(){
        return view;
    }
}
