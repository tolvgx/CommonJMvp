package com.tolvgx.base.data.protocol;

/**
 * Created by tolvgx on 2018/8/22.
 *
 * 能用响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */

public class BaseResp<T> {
    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
