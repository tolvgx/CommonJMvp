package com.tolvgx.base.injection.component;

import android.content.Context;
import com.tolvgx.base.injection.moudle.AppMoudle;
import javax.inject.Singleton;
import dagger.Component;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/27
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Application级别Component
 */

@Singleton
@Component(modules = AppMoudle.class)
public interface AppComponent {

    Context context();
}
