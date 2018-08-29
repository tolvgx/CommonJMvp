package com.tolvgx.base.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
 * Fragment基类，业务相关
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView{

    @Inject
    public T mPresenter;

    public LoadingDialog dialog;

    public ActivityComponent mActivityComponent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initActivityInjection();
        injectComponent();

        //初始加载框
        dialog = new LoadingDialog(getActivity());

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*
        初始Activity级别Component
     */
    private void initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(((BaseApplication)getActivity().getApplication()).appComponent)
                .activityMoudle(new ActivityMoudle(getActivity()))
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
