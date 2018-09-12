package com.tolvgx.usercenter.model.repository;

import com.tolvgx.base.data.net.RetrofitFactory;
import com.tolvgx.base.rx.BaseFunc;
import com.tolvgx.base.rx.BaseFuncBoolean;
import com.tolvgx.usercenter.model.api.UserApi;
import com.tolvgx.usercenter.model.entity.LoginReq;
import com.tolvgx.usercenter.model.entity.RegisterReq;
import com.tolvgx.usercenter.model.entity.UserInfo;
import javax.inject.Inject;
import io.reactivex.Observable;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class UserRepository {

    @Inject
    public UserRepository(){}

    public Observable<Boolean> register(RegisterReq req){
        return RetrofitFactory.getInstance().create(UserApi.class).register(req).flatMap(new BaseFuncBoolean<String>());
    }

    public Observable<UserInfo> login(LoginReq req){
        return RetrofitFactory.getInstance().create(UserApi.class).login(req).flatMap(new BaseFunc<UserInfo>());
    }
}
