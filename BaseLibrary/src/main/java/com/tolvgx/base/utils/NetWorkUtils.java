package com.tolvgx.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by tolvgx on 2018/8/21.
 *
 * 网络工具类
 */

public class NetWorkUtils {
    /*
        判断网络可用
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
