package com.tolvgx.usercenter.service.impl;

import com.tolvgx.base.rx.BaseFunc;
import com.tolvgx.base.rx.BaseFuncBoolean;
import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import com.tolvgx.usercenter.data.repository.UserRepository;
import com.tolvgx.usercenter.service.UserService;
import javax.inject.Inject;
import io.reactivex.Observable;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class UserServiceImpl implements UserService {

    @Inject
    public UserRepository userRepository;

    @Inject
    public UserServiceImpl(){}

    @Override
    public Observable<Boolean> register(RegisterReq req) {
        return userRepository.register(req).flatMap(new BaseFuncBoolean<String>());
    }

    @Override
    public Observable<UserInfo> login(LoginReq req) {
        return userRepository.login(req).flatMap(new BaseFunc<UserInfo>());
    }
}
