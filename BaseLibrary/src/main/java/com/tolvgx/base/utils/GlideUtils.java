package com.tolvgx.base.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by tolvgx on 2018/8/21.
 *
 * Glide工具类
 */

public class GlideUtils {

    public static void loadImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url)
                .into(imageView);
    }

    public static void loadImage(Context context, String url, ImageView imageView, int placeholder){
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(placeholder);
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }

    public static void loadRoundImage(Context context, String url, ImageView imageView, int roundRadius){
        RequestOptions options = new RequestOptions().transform(new RoundedCorners(roundRadius));
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }

    public static void loadRoundImage(Context context, String url, ImageView imageView, int roundRadius, int placeholder){
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(placeholder)
                .transform(new RoundedCorners(roundRadius));
        Glide.with(context).load(url).apply(options)
                .into(imageView);
    }
}
