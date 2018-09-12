package com.tolvgx.base.presenter;

import android.content.Context;
import com.tolvgx.base.presenter.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;
import java.lang.ref.WeakReference;
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

public class BasePresenter<T extends BaseView> implements IPresenter<T>{

    private WeakReference<T> weakRef;

    @Inject
    public Context context;

    @Inject
    public LifecycleProvider<?> lifecycleProvider;

    /**
     * 获取view的引用
     */
    @Override
    public void attachView(T view) {
        if(weakRef == null){
            weakRef = new WeakReference<>(view);
        }
    }

    /**
     * 移除view的应用，并将view置空
     */
    @Override
    public void detachView() {
        if (weakRef != null){
            weakRef.clear();
            weakRef = null;
        }
    }

    /**
     * 获取view的实例
     */
    @Override
    public T getPView() {
        if (weakRef != null){
            return weakRef.get();
        }

        return null;
    }
}
