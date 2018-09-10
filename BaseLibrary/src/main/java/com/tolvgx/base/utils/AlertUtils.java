package com.tolvgx.base.utils;

import android.content.Context;
import android.content.DialogInterface;
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

    /**
     * 显示内容
     * @param context Context
     * @param msg String
     */
    public static void show(Context context, String msg){
        if (msg!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.shrinkAlertDialog)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
            builder.show();
        }
    }

    /**
     * 显示内容，确认点击事件
     * @param context Context
     * @param msg String
     * @param onPositiveListener OnClickListener
     */
    public static void show(Context context, String msg,
                            DialogInterface.OnClickListener onPositiveListener){
        if (msg!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.shrinkAlertDialog)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setPositiveButton("确认", onPositiveListener);
            builder.show();
        }
    }

    /**
     * 显示内容，确认点击事件，取消点击事件
     * @param context Context
     * @param msg String
     * @param onPositiveListener OnClickListener
     * @param onNegativeListener OnClickListener
     */
    public static void show(Context context, String msg,
                            DialogInterface.OnClickListener onPositiveListener,
                            DialogInterface.OnClickListener onNegativeListener){
        if (msg!=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.shrinkAlertDialog)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setPositiveButton("确认", onPositiveListener)
                    .setNegativeButton("取消", onNegativeListener);
            builder.show();
        }
    }
}
