package com.tolvgx.usercenter.presenter;

import com.tolvgx.base.presenter.BasePresenter;
import com.tolvgx.base.rx.BaseObserver;
import com.tolvgx.base.utils.RxUtils;
import com.tolvgx.usercenter.model.entity.LoginReq;
import com.tolvgx.usercenter.model.entity.UserInfo;
import com.tolvgx.usercenter.model.repository.UserRepository;
import com.tolvgx.usercenter.presenter.view.LoginView;
import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class LoginPresenter extends BasePresenter<LoginView>{

    @Inject
    public UserRepository userRepository;

    @Inject
    public LoginPresenter(){}

    /*
        业务逻辑
     */
    public void login(LoginReq req){

        RxUtils.excute(userRepository.login(req), new BaseObserver<UserInfo>(getPView(), context){
            @Override
            public void onNext(UserInfo userInfo) {
                getPView().onLoginResult(userInfo);
            }
        }, getPView(), lifecycleProvider);
    }
}
