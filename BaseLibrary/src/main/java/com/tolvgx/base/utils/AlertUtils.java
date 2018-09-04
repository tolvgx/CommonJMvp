package com.tolvgx.base.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import com.tolvgx.base.R;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/31
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * AlertDialog封装类
 */
public class AlertUtils {

    private AlertUtils(){
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static AlertDialog.Builder create(Context context){
        return new AlertDialog.Builder(context, R.style.shrinkAlertDialog);
    }

    public static AlertDialog.Builder createDefault(Context context){
        return new AlertDialog.Builder(context);
    }
}
