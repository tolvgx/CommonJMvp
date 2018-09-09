package com.tolvgx.base.injection.moudle;

import android.app.Activity;
import com.tolvgx.base.injection.ActivityScope;
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
 * Activity级别Module
 */
@Module
public class ActivityMoudle {

    private Activity mActivity;

    public ActivityMoudle(Activity activity){
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity(){
        return mActivity;
    }

}
