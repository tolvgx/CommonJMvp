package com.tolvgx.usercenter.injection.moudle;

import com.tolvgx.base.presenter.view.BaseView;
import com.tolvgx.usercenter.service.UserService;
import com.tolvgx.usercenter.service.impl.UserServiceImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tolvgx on 2018/8/27.
 */

@Module
public class UserMoudle {

//    private BaseView mView;
//
//    public UserMoudle(BaseView baseView){
//        this.mView = baseView;
//    }
//
//    @Provides
//    BaseView provideMView(){
//        return mView;
//    }

    @Provides
    UserService provideUserService(UserServiceImpl userService){
        return userService;
    }
}
