package com.tolvgx.usercenter.model.api;

import com.tolvgx.base.model.entity.BaseResp;
import com.tolvgx.usercenter.model.entity.LoginReq;
import com.tolvgx.usercenter.model.entity.RegisterReq;
import com.tolvgx.usercenter.model.entity.UserInfo;
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
