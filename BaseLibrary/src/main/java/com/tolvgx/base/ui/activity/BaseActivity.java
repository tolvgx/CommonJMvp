package com.tolvgx.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by tolvgx on 2018/8/20.
 *
 * Activity基类，业务无关
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutResID = getLayoutId();
        //如果initView返回0,框架则不会调用setContentView(),当然也不会 Bind ButterKnife
        if (layoutResID != 0) {
            setContentView(layoutResID);
            //绑定到butterknife
            mUnbinder = ButterKnife.bind(this);
        }

        initView();
        initData(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected void initView(){}

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mUnbinder !=null)
            mUnbinder.unbind();
    }
}
