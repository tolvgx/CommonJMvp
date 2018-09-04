package com.tolvgx.base.common;

import android.app.Application;
import android.content.Context;

import com.tolvgx.base.injection.component.AppComponent;
import com.tolvgx.base.injection.component.DaggerAppComponent;
import com.tolvgx.base.injection.moudle.AppMoudle;

/**
 * Created by tolvgx on 2018/8/22.
 *
 * Application 基类
 */

public class BaseApplication extends Application {

    public AppComponent appComponent;

    public static Context context;
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        context = getApplicationContext();

        initAppInjection();
    }

    private void initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appMoudle(new AppMoudle(this))
                .build();
    }
}
