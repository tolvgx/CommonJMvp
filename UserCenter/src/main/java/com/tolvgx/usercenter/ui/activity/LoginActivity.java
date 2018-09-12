package com.tolvgx.usercenter.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tolvgx.base.ui.activity.BaseMvpActivity;
import com.tolvgx.base.utils.ToastUtils;
import com.tolvgx.usercenter.R;
import com.tolvgx.usercenter.R2;
import com.tolvgx.usercenter.model.entity.LoginReq;
import com.tolvgx.usercenter.model.entity.UserInfo;
import com.tolvgx.usercenter.event.MessageEvent;
import com.tolvgx.usercenter.di.component.DaggerUserComponent;
import com.tolvgx.usercenter.presenter.LoginPresenter;
import com.tolvgx.usercenter.presenter.view.LoginView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import butterknife.BindView;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {

    @BindView(R2.id.mMobileEt)
    EditText mMobileEt;
    @BindView(R2.id.mPwdEt)
    EditText mPwdEt;
    @BindView(R2.id.mLoginBtn)
    Button mLoginBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);

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
                .build()
                .inject(this);
    }

    @Override
    public void onLoginResult(UserInfo userInfo) {
        ToastUtils.showLong("登录成功");
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDataReceived(MessageEvent msg){
        ToastUtils.showLong("接收到上个页面传来的数据："+msg.name);
    }
}
