package com.tolvgx.base.presenter.view;

/**
 * Created by tolvgx on 2018/8/22.
 *
 * MVP中视图回调 基类
 */
public interface BaseView {
    void showLoading();
    void hideLoading();
    void onError(String msg);
}
