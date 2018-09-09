package com.tolvgx.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tolvgx.base.common.SPConstant;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/9/4
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class SPUtils {

    private static SharedPreferences sp;

    private SPUtils(){
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 字符串
     * Return the string value in sp.
     */
    public static String getString(String key) {
        return getString(key, "");
    }

    private static String getString(String key, String defValue) {
        return getSP().getString(key, defValue);
    }

    /**
     * 字符串
     * Put the string value in sp.
     */
    public static void putString(String key, String value) {
        getSP().edit().putString(key, value).apply();
    }

    /**
     * 布尔值
     * Return the boolean value in sp.
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    private static boolean getBoolean(String key, boolean defValue) {
        return getSP().getBoolean(key, defValue);
    }

    /**
     * 布尔值
     * Put the boolean value in sp.
     */
    public static void putBoolean(String key, boolean value) {
        getSP().edit().putBoolean(key, value).apply();
    }

    /**
     * int型
     * Return the int value in sp.
     */
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    private static int getInt(String key, int defValue) {
        return getSP().getInt(key, defValue);
    }

    /**
     * int型
     * Put the int value in sp.
     */
    public static void putInt(String key,  int value) {
        getSP().edit().putInt(key, value).apply();
    }

    /**
     * long型
     * Return the long value in sp.
     */
    public static long getLong(String key) {
        return getLong(key, 0);
    }

    private static long getLong(String key, long defValue) {
        return getSP().getLong(key, defValue);
    }

    /**
     * long型
     * Put the long value in sp.
     */
    public static void putLong(String key, long value) {
        getSP().edit().putLong(key, value).apply();
    }


    /**
     * float型
     * Return the float value in sp.
     */
    public static float getFloat(String key) {
        return getFloat(key, 0);
    }

    private static float getFloat(String key, float defValue) {
        return getSP().getFloat(key, defValue);
    }

    /**
     * float型
     * Put the float value in sp.
     */
    public static void putFloat(String key, float value) {
        getSP().edit().putFloat(key, value).apply();
    }

    /**
     * 删除key数据
     * Remove one preference in sp.
     */
    public static void remove(String key) {
        getSP().edit().remove(key).apply();
    }

    /**
     * 清空所有数据
     * Remove all preferences in sp.
     */
    public static void clear(){
        getSP().edit().clear().apply();
    }

    /**
     * 获取SharedPreferences实例
     */
    private static SharedPreferences getSP(){
        if (sp == null)
            sp = AppUtils.getContext().getSharedPreferences(SPConstant.TABLE_SP, Context.MODE_PRIVATE);
        return sp;
    }

}
