package com.tolvgx.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * ================================================
 * Created by Tolvgx on 2018/08/21
 * <a href="tolvgx@163.com">Contact me</a>
 * <a href="https://github.com/tolvgx">Follow me</a>
 * ================================================
 *
 * 网络工具类
 */

public class NetWorkUtils {

    private NetWorkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 判断网络是否连接
     * @param context
     * @return true/false
     */
    public static boolean isNetWorkAvailable(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null){
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }

        return false;
    }
}
