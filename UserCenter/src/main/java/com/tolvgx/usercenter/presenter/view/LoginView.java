package com.tolvgx.usercenter.presenter.view;

import com.tolvgx.base.presenter.view.BaseView;
import com.tolvgx.usercenter.model.entity.UserInfo;

/**
 * Created by tolvgx on 2018/8/23.
 */

public interface LoginView extends BaseView{
    void onLoginResult(UserInfo userInfo);
}
