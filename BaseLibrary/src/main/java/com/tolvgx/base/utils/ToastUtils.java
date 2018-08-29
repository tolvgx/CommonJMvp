package com.tolvgx.base.utils;

import android.text.TextUtils;
import android.widget.Toast;
import com.tolvgx.base.common.BaseApplication;

/**
 * Created by tolvgx on 2018/8/28.
 *
 * Toast工具类
 */
public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示短信息、字符串
     */
    public static void showShort(String text) {
        if (TextUtils.isEmpty(text)) return;

        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }

    /**
     * 显示短信息、ID
     */
    public static void showShort(int rId) {
        if (TextUtils.isEmpty(BaseApplication.context.getResources().getText(rId).toString()))
            return;
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.context, rId, Toast.LENGTH_SHORT);
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
            mToast = Toast.makeText(BaseApplication.context, text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
        }
        mToast.show();

    }

    /**
     * 显示长信息、ID
     */
    public static void showLong(int rId) {
        if (TextUtils.isEmpty(BaseApplication.context.getResources().getText(rId).toString()))
            return;
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.context, rId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(rId);
        }
        mToast.show();
    }
}
