package com.tolvgx.usercenter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tolvgx.base.ui.activity.BaseMvpActivity;
import com.tolvgx.base.utils.ToastUtils;
import com.tolvgx.usercenter.R;
import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import com.tolvgx.usercenter.injection.component.DaggerUserComponent;
import com.tolvgx.usercenter.injection.moudle.UserMoudle;
import com.tolvgx.usercenter.presenter.LoginPresenter;
import com.tolvgx.usercenter.presenter.view.LoginView;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {

    private Button mLoginBtn;
    private EditText mMobileEt;
    private EditText mPwdEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    /*
        初始化View
     */
    private void initView() {
        mMobileEt = (EditText) findViewById(R.id.mMobileEt);
        mPwdEt = (EditText) findViewById(R.id.mPwdEt);

        mLoginBtn = (Button) findViewById(R.id.mLoginBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginReq req = new LoginReq();
                req.setMobile(mMobileEt.getText().toString().trim());
                req.setPwd(mPwdEt.getText().toString().trim());
                req.setPushId("");

                mPresenter.login(req);
            }
        });
    }

    /*
        Dagger注册
     */
    @Override
    protected void injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .userMoudle(new UserMoudle())
                .build()
                .inject(this);
        mPresenter.mView = this;
    }

    @Override
    public void onLoginResult(UserInfo userInfo) {
        ToastUtils.showLong("登录成功");
    }
}
