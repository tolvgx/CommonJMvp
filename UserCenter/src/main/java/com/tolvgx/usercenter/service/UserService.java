package com.tolvgx.usercenter.service;

import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import io.reactivex.Observable;

/**
 * Created by tolvgx on 2018/8/23.
 */

public interface UserService {

    /*
        注册
     */
    Observable<Boolean> register(RegisterReq req);

    /*
        登录
     */
    Observable<UserInfo> login(LoginReq req);
}
