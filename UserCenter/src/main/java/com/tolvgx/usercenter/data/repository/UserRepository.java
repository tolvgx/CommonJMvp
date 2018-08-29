package com.tolvgx.usercenter.data.repository;

import com.tolvgx.base.data.net.RetrofitFactory;
import com.tolvgx.base.data.protocol.BaseResp;
import com.tolvgx.usercenter.data.api.UserApi;
import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import javax.inject.Inject;
import io.reactivex.Observable;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class UserRepository {

    @Inject
    public UserRepository(){}

    public Observable<BaseResp<String>> register(RegisterReq req){
        return RetrofitFactory.getInstance().create(UserApi.class).register(req);
    }

    public Observable<BaseResp<UserInfo>> login(LoginReq req){
        return RetrofitFactory.getInstance().create(UserApi.class).login(req);
    }
}
