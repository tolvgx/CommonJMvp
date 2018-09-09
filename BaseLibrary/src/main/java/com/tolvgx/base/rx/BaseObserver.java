package com.tolvgx.base.rx;

import android.content.Context;
import com.tolvgx.base.presenter.view.BaseView;
import com.tolvgx.base.utils.NetWorkUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/23
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Rx订阅者默认实现(参考DefaultObserver实现)
 */

public class BaseObserver<T> implements Observer<T> {

    private BaseView mView;
    private Context mContext;

    private Disposable s;

    public BaseObserver(BaseView baseView, Context context) {
        this.mView = baseView;
        mContext = context;
    }

    @Override
    public void onError(Throwable e) {
        mView.hideLoading();
        if (e instanceof BaseException){
            mView.onError(((BaseException) e).msg);
        } else {
            mView.onError("请求失败");
        }
    }

    @Override
    public void onComplete() {
        mView.hideLoading();
    }

    @Override
    public void onNext(T t) {}

    @Override
    public void onSubscribe(Disposable d) {
        if (EndConsumerHelper.validate(this.s, d, getClass())) {
            this.s = d;
            onStart();
        }
    }

    /**
     *  Called once the subscription has been set on this observer; override this
     *  to perform initialization.
     */
    protected void onStart() {

        if (!NetWorkUtils.isNetWorkAvailable(mContext)){
            mView.onError("网络不可用");

            //解除绑定
            cancel();
        }
    }

    /**
     *  Cancels the upstream's disposable.
     */
    protected final void cancel() {
        Disposable s = this.s;
        this.s = DisposableHelper.DISPOSED;
        s.dispose();
    }
}
