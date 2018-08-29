package com.tolvgx.base.injection.component;

import android.app.Activity;
import android.content.Context;
import com.tolvgx.base.injection.ActivityScope;
import com.tolvgx.base.injection.moudle.ActivityMoudle;
import com.tolvgx.base.injection.moudle.LifecycleProviderModule;
import com.trello.rxlifecycle2.LifecycleProvider;

import dagger.Component;

/**
 * Created by tolvgx on 2018/8/27.
 *
 * Activity级别Component
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityMoudle.class, LifecycleProviderModule.class})
public interface ActivityComponent {

    Activity activity();
    Context context();
    LifecycleProvider<?> lifecycleProvider();
}
