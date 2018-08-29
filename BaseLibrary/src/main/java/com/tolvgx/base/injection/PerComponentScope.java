package com.tolvgx.base.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by tolvgx on 2018/8/27.
 *
 * 组件级别 作用域
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerComponentScope {}
