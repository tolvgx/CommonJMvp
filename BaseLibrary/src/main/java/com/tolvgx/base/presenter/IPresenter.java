package com.tolvgx.base.presenter;

import com.tolvgx.base.presenter.view.BaseView;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/9/12
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * 要求框架中的每个Presenter都需要实现此类,以实现view的实例化和置空
 * @see BasePresenter
 */
public interface IPresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

    T getPView();
}
