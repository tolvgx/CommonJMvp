package com.tolvgx.base.di.moudle;

import android.content.Context;
import com.tolvgx.base.common.BaseApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/27
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
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
