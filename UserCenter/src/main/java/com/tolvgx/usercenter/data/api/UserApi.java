package com.tolvgx.usercenter.data.api;

import com.tolvgx.base.data.protocol.BaseResp;
import com.tolvgx.usercenter.data.protocol.LoginReq;
import com.tolvgx.usercenter.data.protocol.RegisterReq;
import com.tolvgx.usercenter.data.protocol.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by tolvgx on 2018/8/23.
 */

public interface UserApi {

    @POST("userCenter/register")
    Observable<BaseResp<String>> register(@Body RegisterReq req);

    @POST("userCenter/login")
    Observable<BaseResp<UserInfo>> login(@Body LoginReq req);
}
