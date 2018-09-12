package com.tolvgx.usercenter.presenter;

import com.tolvgx.base.presenter.BasePresenter;
import com.tolvgx.base.rx.BaseObserver;
import com.tolvgx.base.utils.RxUtils;
import com.tolvgx.usercenter.model.entity.RegisterReq;
import com.tolvgx.usercenter.model.repository.UserRepository;
import com.tolvgx.usercenter.presenter.view.RegisterView;
import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class RegisterPresenter extends BasePresenter<RegisterView>{

    @Inject
    public UserRepository userRepository;

    @Inject
    public RegisterPresenter(){}

    /*
        业务逻辑
     */
    public void register(RegisterReq req){

        RxUtils.excute(userRepository.register(req), new BaseObserver<Boolean>(getPView(), context){
            @Override
            public void onNext(Boolean t) {
                if (t)
                    getPView().onRegisterResult(true);
            }
        }, getPView(), lifecycleProvider);
    }
}
