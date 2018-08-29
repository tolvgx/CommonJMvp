package com.tolvgx.base.injection.moudle;

import android.content.Context;

import com.tolvgx.base.common.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tolvgx on 2018/8/27.
 *
 * Application级别Module
 */
@Module
public class AppMoudle {

    private BaseApplication mContext;

    public AppMoudle(BaseApplication context){
        this.mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mContext;
    }

}
