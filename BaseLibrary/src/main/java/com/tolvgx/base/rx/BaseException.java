package com.tolvgx.base.rx;

/**
 * Created by tolvgx on 2018/8/23.
 *
 * 定义通用异常
 */
public class BaseException extends Throwable{

    public int status;
    public String msg;

    public BaseException(int status, String msg){
        this.status = status;
        this.msg = msg;
    }
}
