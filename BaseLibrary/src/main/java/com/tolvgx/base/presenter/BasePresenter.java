package com.tolvgx.base.presenter;

import android.content.Context;

import com.tolvgx.base.presenter.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

/**
 * Created by tolvgx on 2018/8/22.
 *
 * MVP中P层 基类
 */
public class BasePresenter<T extends BaseView>{

    public T mView;

    @Inject
    public Context context;

    @Inject
    public LifecycleProvider<?> lifecycleProvider;

//    @Inject
//    public BasePresenter(T baseView){
//        this.mView = baseView;
//    }
}
