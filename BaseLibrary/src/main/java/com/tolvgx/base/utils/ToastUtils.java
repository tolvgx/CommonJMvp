package com.tolvgx.base.utils;

import android.text.TextUtils;
import android.widget.Toast;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/28
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Toast工具类
 */

public class ToastUtils {

    private static Toast mToast;

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 显示短信息、字符串
     */
    public static void showShort(String text) {
        if (TextUtils.isEmpty(text)) return;

        if (mToast == null) {
            mToast = Toast.makeText(AppUtils.getContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    /**
     * 显示短信息、ID
     */
    public static void showShort(int rId) {
        if (TextUtils.isEmpty(AppUtils.getContext().getResources().getText(rId).toString()))
            return;
        if (mToast == null) {
            mToast = Toast.makeText(AppUtils.getContext(), rId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(rId);
        }
        mToast.show();

    }

    /**
     * 显示长信息、字符串
     */
    public static void showLong(String text) {
        if (TextUtils.isEmpty(text)) return;

        if (mToast == null) {
            mToast = Toast.makeText(AppUtils.getContext(), text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
        }
        mToast.show();

    }

    /**
     * 显示长信息、ID
     */
    public static void showLong(int rId) {
        if (TextUtils.isEmpty(AppUtils.getContext().getResources().getText(rId).toString()))
            return;
        if (mToast == null) {
            mToast = Toast.makeText(AppUtils.getContext(), rId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(rId);
        }
        mToast.show();
    }
}
