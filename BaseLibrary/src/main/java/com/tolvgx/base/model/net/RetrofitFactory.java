package com.tolvgx.base.model.net;

import com.tolvgx.base.common.BaseConstant;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tolvgx on 2018/8/22.
 */

/*
    Retrofit工厂，单例
 */
public class RetrofitFactory {
    /*
        单例（静态内部类）
     */
    private RetrofitFactory(){
        init();
    }
    private static class SingletonHolder{
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }

    public static RetrofitFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private Retrofit retrofit;
    private Interceptor interceptor;

    //初始化
    private void init(){
        //通用拦截
        interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException{

                Request request = chain.request().newBuilder()
                        .addHeader("Content_Type", "application/json")
                        .addHeader("Accept", "application/json")
                        .addHeader("charset", "UTF-8")
                        .build();

                return chain.proceed(request);
            }
        };

        //Retrofit实例化
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build();
    }

    /*
        OKHttp创建
     */
    private OkHttpClient initClient() {
        return new OkHttpClient().newBuilder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(interceptor)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    /*
        日志拦截器
     */
    private Interceptor initLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    /*
        具体服务实例化
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }
}
