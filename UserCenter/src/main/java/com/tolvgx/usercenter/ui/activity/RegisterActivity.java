package com.tolvgx.usercenter.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tolvgx.base.ui.activity.BaseMvpActivity;
import com.tolvgx.base.utils.ToastUtils;
import com.tolvgx.usercenter.R;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.injection.component.DaggerUserComponent;
import com.tolvgx.usercenter.injection.moudle.UserMoudle;
import com.tolvgx.usercenter.presenter.RegisterPresenter;
import com.tolvgx.usercenter.presenter.view.RegisterView;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterView {

    private Button mRegisterBtn;
    private EditText mMobileEt;
    private EditText mVerifyCodeEt;
    private EditText mPwdEt;

    @Override
    protected void initData(Bundle savedInstanceState) {
        mRegisterBtn = (Button) findViewById(R.id.mRegisterBtn);
        mMobileEt = (EditText) findViewById(R.id.mMobileEt);
        mVerifyCodeEt = (EditText) findViewById(R.id.mVerifyCodeEt);
        mPwdEt = (EditText) findViewById(R.id.mPwdEt);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterReq req = new RegisterReq();
                req.setMobile(mMobileEt.getText().toString().trim());
                req.setPwd(mPwdEt.getText().toString().trim());
                req.setVerifyCode(mVerifyCodeEt.getText().toString().trim());

                mPresenter.register(req);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
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
    public void onRegisterResult(Boolean result) {
        if (result){
            ToastUtils.showLong("注册成功");
        }
    }
}
