package com.ylj.com.myqzone.app;

import android.app.Application;
import android.content.Context;

import com.ylj.com.myqzone.dagger.components.DaggerNetComponent;
import com.ylj.com.myqzone.dagger.components.NetComponent;
import com.ylj.com.myqzone.dagger.modules.NetModule;


/**
 * Created by pc on 2017/12/5.
 */

public class MyQzoneApplication extends Application {

    private NetComponent netComponent;
     private static MyQzoneApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initPresenter();
    }

    private void initPresenter() {
        netComponent = DaggerNetComponent.builder().netModule(new NetModule()).build();
    }
    public NetComponent getNetComponent() {
        return netComponent;
    }
    public static MyQzoneApplication getInstance() {
        return instance;
    }
    public static MyQzoneApplication get(Context context){

       return (MyQzoneApplication)context.getApplicationContext();
    }
}
