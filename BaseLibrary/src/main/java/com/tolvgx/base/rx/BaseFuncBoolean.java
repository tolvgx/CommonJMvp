package com.tolvgx.base.rx;

import com.tolvgx.base.common.ResultCode;
import com.tolvgx.base.model.entity.BaseResp;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by tolvgx on 2018/8/23.
 *
 * Boolean类型转换封装
 */
public class BaseFuncBoolean<T> implements Function<BaseResp<T>, Observable<Boolean>> {

    @Override
    public Observable<Boolean> apply(BaseResp<T> t) throws Exception {
        if (t.getStatus() != ResultCode.SUCCESS) {
            return Observable.error(new BaseException(t.getStatus(), t.getMessage()));
        }

        return Observable.just(true);
    }
}
