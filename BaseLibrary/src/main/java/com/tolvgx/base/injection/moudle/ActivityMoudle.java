package com.tolvgx.base.injection.moudle;

import android.app.Activity;
import com.tolvgx.base.injection.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tolvgx on 2018/8/27.
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
