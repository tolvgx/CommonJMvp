package com.tolvgx.usercenter.presenter;

import com.tolvgx.base.presenter.BasePresenter;
import com.tolvgx.base.rx.BaseObserver;
import com.tolvgx.base.utils.RxUtils;
import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import com.tolvgx.usercenter.presenter.view.LoginView;
import com.tolvgx.usercenter.service.UserService;
import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class LoginPresenter extends BasePresenter<LoginView>{

    @Inject
    public UserService userService;

    @Inject
    public LoginPresenter(){}

//    public LoginPresenter(LoginView loginView){
//        super(loginView);
//    }

    /*
        业务逻辑
     */
    public void login(LoginReq req){

        RxUtils.excute(userService.login(req), new BaseObserver<UserInfo>(mView, context){
            @Override
            public void onNext(UserInfo userInfo) {
                mView.onLoginResult(userInfo);
            }
        }, mView, lifecycleProvider);

//        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//
//            }
//        });
//
//        Observable.just("111")
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Exception {
//                        return s+"222";
//                    }
//                }).subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//
//                    }
//                });
    }
}
