package com.tolvgx.base.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/21
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Glide工具类
 */

public class GlideUtils {

    private GlideUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 加载显示ImageView
     * @param context Context
     * @param url String
     * @param imageView ImageView
     */
    public static void loadImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url)
                .into(imageView);
    }

    /**
     * 加载显示ImageView
     * 包括默认的占位图，错误图
     * @param context Context
     * @param url String
     * @param imageView ImageView
     * @param placeholder int
     */
    public static void loadImage(Context context, String url, ImageView imageView, int placeholder){
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(placeholder);
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }

    /**
     * 加载显示圆角ImageView
     * @param context Context
     * @param url String
     * @param imageView ImageView
     * @param roundRadius int
     */
    public static void loadRoundImage(Context context, String url, ImageView imageView, int roundRadius){
        RequestOptions options = new RequestOptions().transform(new RoundedCorners(roundRadius));
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }

    /**
     * 加载显示圆角ImageView
     * 包括默认的占位图，错误图
     * @param context Context
     * @param url String
     * @param imageView ImageView
     * @param roundRadius int
     * @param placeholder int
     */
    public static void loadRoundImage(Context context, String url, ImageView imageView, int roundRadius, int placeholder){
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(placeholder)
                .transform(new RoundedCorners(roundRadius));
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }
}
