package com.tolvgx.base.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tolvgx.base.common.BaseApplication;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/9/4
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * 系统App级Utils
 *
 * getApp                            : 获取Application
 * getContext                        : 获取App级Contex
 * getAppVersionName                 : 获取 App 版本号
 * getAppVersionCode                 : 获取 App 版本码
 */
public class AppUtils {
    private AppUtils(){
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取Application
     *
     * @return Application
     */
    public static Application getApp(){
        return BaseApplication.application;
    }

    /**
     * 获取App级Context
     *
     * @return Context
     */
    public static Context getContext(){
        return BaseApplication.context;
    }

    /**
     * Return the application's version name.
     *
     * @return String
     */
    public static String getAppVersionName() {
        return getAppVersionName(AppUtils.getApp().getPackageName());
    }

    /**
     * Return the application's version name.
     *
     * @param packageName The name of the package.
     * @return the application's version name
     */
    public static String getAppVersionName(final String packageName) {
        if (isSpace(packageName)) return "";
        try {
            PackageManager pm = AppUtils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? null : pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Return the application's version code.
     *
     * @return the application's version code
     */
    public static int getAppVersionCode() {
        return getAppVersionCode(AppUtils.getApp().getPackageName());
    }

    /**
     * Return the application's version code.
     *
     * @param packageName The name of the package.
     * @return the application's version code
     */
    public static int getAppVersionCode(final String packageName) {
        if (isSpace(packageName)) return -1;
        try {
            PackageManager pm = AppUtils.getApp().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi == null ? -1 : pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static boolean isSpace(final String s) {
        if (s == null) return true;
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
