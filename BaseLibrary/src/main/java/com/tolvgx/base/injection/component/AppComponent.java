package com.tolvgx.base.injection.component;

import android.content.Context;
import com.tolvgx.base.injection.moudle.AppMoudle;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by tolvgx on 2018/8/27.
 *
 * Application级别Component
 */

@Singleton
@Component(modules = AppMoudle.class)
public interface AppComponent {

    Context context();
}
