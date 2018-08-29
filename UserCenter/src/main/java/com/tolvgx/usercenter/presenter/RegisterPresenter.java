package com.tolvgx.usercenter.presenter;

import com.tolvgx.base.presenter.BasePresenter;
import com.tolvgx.base.rx.BaseObserver;
import com.tolvgx.base.utils.RxUtils;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.presenter.view.RegisterView;
import com.tolvgx.usercenter.service.UserService;
import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class RegisterPresenter extends BasePresenter<RegisterView>{

    @Inject
    public UserService userService;

    @Inject
    public RegisterPresenter(){}

//    @Inject
//    public RegisterPresenter(RegisterView registerView){
//        super(registerView);
//    }

    /*
        业务逻辑
     */
    public void register(RegisterReq req){

        RxUtils.excute(userService.register(req), new BaseObserver<Boolean>(mView, context){
            @Override
            public void onNext(Boolean t) {
                if (t)
                    mView.onRegisterResult(true);
            }
        }, mView, lifecycleProvider);
    }
}
