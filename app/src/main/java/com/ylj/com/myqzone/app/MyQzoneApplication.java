package com.ylj.com.myqzone.app;

import android.app.Application;
import android.content.Context;

import com.ylj.com.myqzone.dagger.components.DaggerNetComponents;
import com.ylj.com.myqzone.dagger.components.NetComponents;
import com.ylj.com.myqzone.dagger.modules.NetModules;


/**
 * Created by pc on 2017/12/5.
 */

public class MyQzoneApplication extends Application {

    private NetComponents netComponent;
     private static MyQzoneApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initPresenter();
    }

    private void initPresenter() {
        netComponent = DaggerNetComponents.builder().netModules(new NetModules()).build();
    }
    public NetComponents getNetComponent() {
        return netComponent;
    }
    public static MyQzoneApplication getInstance() {
        return instance;
    }
    public static MyQzoneApplication get(Context context){

       return (MyQzoneApplication)context.getApplicationContext();
    }
}
