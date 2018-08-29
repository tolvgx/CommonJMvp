package com.tolvgx.base.injection.moudle;

import com.trello.rxlifecycle2.LifecycleProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tolvgx on 2018/8/27.
 *
 * Rx生命周期管理能用Module
 */
@Module
public class LifecycleProviderModule {

    private LifecycleProvider<?> lifecycleProvider;

    public LifecycleProviderModule(LifecycleProvider<?> lifecycleProvider){
        this.lifecycleProvider = lifecycleProvider;
    }

    @Provides
    LifecycleProvider<?> provideLifecycleProvider(){
        return lifecycleProvider;
    }
}
