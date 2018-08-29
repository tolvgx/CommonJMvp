package com.tolvgx.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by tolvgx on 2018/8/20.
 *
 * Activity基类，业务无关
 */

public class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
