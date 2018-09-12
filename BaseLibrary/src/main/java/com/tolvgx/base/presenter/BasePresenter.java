package com.tolvgx.base.presenter;

import android.content.Context;

import com.tolvgx.base.presenter.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import javax.inject.Inject;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/22
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * MVP中P层 基类
 */

public class BasePresenter<T extends BaseView>{

    public T mView;

    @Inject
    public Context context;

    @Inject
    public LifecycleProvider<?> lifecycleProvider;
}
