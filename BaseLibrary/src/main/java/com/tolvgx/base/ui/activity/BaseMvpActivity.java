package com.tolvgx.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tolvgx.base.common.BaseApplication;
import com.tolvgx.base.injection.component.ActivityComponent;
import com.tolvgx.base.injection.component.DaggerActivityComponent;
import com.tolvgx.base.injection.moudle.ActivityMoudle;
import com.tolvgx.base.injection.moudle.LifecycleProviderModule;
import com.tolvgx.base.presenter.BasePresenter;
import com.tolvgx.base.presenter.view.BaseView;
import com.tolvgx.base.utils.ToastUtils;
import com.tolvgx.base.widgets.LoadingDialog;
import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/20.
 *
 * Activity基类，业务相关
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    public T mPresenter;

    public LoadingDialog dialog;

    public ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityInjection();
        injectComponent();

        //初始加载框
        dialog = new LoadingDialog(this);
    }

    /*
        初始Activity级别Component
     */
    private void initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((BaseApplication)getApplication()).appComponent)
                .activityMoudle(new ActivityMoudle(this))
                .lifecycleProviderModule(new LifecycleProviderModule(this))
                .build();
    }

    /*
        组建级Dagger注册
     */
    protected abstract void injectComponent();

    /*
       显示加载框，默认实现
    */
    @Override
    public void showLoading() {
        dialog.show();
    }

    /*
        隐藏加载框，默认实现
     */
    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    /*
        错误信息提示，默认实现
     */
    @Override
    public void onError(String msg) {
        ToastUtils.showLong(msg);
    }
}
