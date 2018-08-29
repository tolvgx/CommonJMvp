package com.tolvgx.base.utils;

import android.content.DialogInterface;
import com.tolvgx.base.presenter.view.BaseView;
import com.tolvgx.base.rx.BaseObserver;
import com.tolvgx.base.ui.activity.BaseMvpActivity;
import com.tolvgx.base.ui.fragment.BaseMvpFragment;
import com.tolvgx.base.widgets.LoadingDialog;
import com.trello.rxlifecycle2.LifecycleProvider;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tolvgx on 2018/8/28.
 *
 * 放置便于使用 RxJava 的一些工具方法
 */
public class RxUtils {

    public static void excute(Observable<?> observable, BaseObserver subscriber, final BaseView mView, LifecycleProvider<?> lifecycleProvider){
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        /**
                         * 显示加载框
                         */
                        mView.showLoading();

                        /**
                         * 区别是BaseMvpActivity或者BaseMvpFragment
                         * 并调用相应LoadingDialog的CancelListener实现取消请求
                         */
                        if (mView instanceof BaseMvpActivity){
                            setCancelListener(((BaseMvpActivity)mView).dialog, disposable);
                        } else if (mView instanceof BaseMvpFragment){
                            setCancelListener(((BaseMvpFragment)mView).dialog, disposable);
                        }
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())//指定doOnSubscribe线程(此处为在主线程渲染UI)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycleProvider.bindToLifecycle())
                .subscribe(subscriber);
    }

    /**
     * 设置请求加载框的OnCancelListener
     */
    private static void setCancelListener(LoadingDialog dialog, final Disposable disposable){
        if (dialog!=null){
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    disposable.dispose();
                }
            });
        }
    }
}
