package com.tolvgx.usercenter.data.protocol;

/**
 * Created by tolvgx on 2018/8/23.
 */

public class LoginReq {
    private String mobile;
    private String pwd;
    private String pushId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
