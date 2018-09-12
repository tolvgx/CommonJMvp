package com.tolvgx.usercenter.di.component;

import com.tolvgx.base.injection.PerComponentScope;
import com.tolvgx.base.injection.component.ActivityComponent;
import com.tolvgx.usercenter.ui.activity.LoginActivity;
import com.tolvgx.usercenter.ui.activity.RegisterActivity;
import dagger.Component;

/**
 * Created by tolvgx on 2018/8/27.
 */

@PerComponentScope
@Component(dependencies = ActivityComponent.class)
public interface UserComponent {
    void inject(RegisterActivity activity);
    void inject(LoginActivity activity);
}
