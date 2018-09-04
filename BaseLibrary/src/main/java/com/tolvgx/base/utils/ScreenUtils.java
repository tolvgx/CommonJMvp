package com.tolvgx.base.utils;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/18
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Reference from：https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 * 感谢今日头条提供的核心方案
 *
 * 1.在取消屏幕适配时，我们需要记录原始的density、scaledDensity、densityDpi，并且在系统字体大小变化时需要进行监听，稳重注释部分(1)为手动保存的方案
 *   if (sNonCompatDensity == 0) {
 *       //原本的density
 *       sNonCompatDensity = appDisplayMetrics.density;
 *       //原本的scaledDensity
 *       sNonCompatScaledDensity = appDisplayMetrics.scaledDensity;
 *       //原本的densityDpi
 *       sNonCompatDensityDpi = appDisplayMetrics.densityDpi;
 *       application.registerComponentCallbacks(new ComponentCallbacks() {
 *          @Override
 *          public void onConfigurationChanged(Configuration newConfig) {
 *              if (newConfig != null && newConfig.fontScale > 0) {
 *              sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
 *
 *              Log.e("setCustomDensity-change", sNonCompatScaledDensity+"");
 *          }
 *       }
 *       @Override
 *       public void onLowMemory() {}
 *       });
 *   }
 * 2.查资料发现，Resources.getSystem()是用来获取系统的Resources，Resources.getSystem().getDisplayMetrics()获取的始终都是原始数据，
 * 并且在字体改变时scaledDensity也会相应的改变，所以省去手动记录原始值的步骤，也不需要监听字体变化了，所以最终的源码简洁很多。
 */
public class ScreenUtils {

    /**
     * adapt the screen default with screen portrait.
     *
     * @param activity The activity.
     * @param sizeInPx sizeInPx
     */
    public static void adaptScreen(Activity activity, int sizeInPx) {
        adaptScreen(activity, sizeInPx, true);
    }

    /**
     * adapt the screen.
     *
     * @param activity The activity.
     * @param sizeInPx sizeInPx
     * @param isVerticalSlide  {@code true}: portrait {@code false}: landscape
     */
    private static void adaptScreen(Activity activity, int sizeInPx, final boolean isVerticalSlide) {
        final DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        final DisplayMetrics appDm = AppUtils.getApp().getResources().getDisplayMetrics();
        final DisplayMetrics activityDm = activity.getResources().getDisplayMetrics();

        if (isVerticalSlide) {
            activityDm.density = activityDm.widthPixels / (float) sizeInPx;
        } else {
            activityDm.density = activityDm.heightPixels / (float) sizeInPx;
        }
        activityDm.scaledDensity = activityDm.density * (systemDm.scaledDensity / systemDm.density);
        activityDm.densityDpi = (int) (160 * activityDm.density);

        appDm.density = activityDm.density;
        appDm.scaledDensity = activityDm.scaledDensity;
        appDm.densityDpi = activityDm.densityDpi;

        Log.d("adaptScreen-app", appDm.density+ "-" +appDm.scaledDensity+ "-" +appDm.densityDpi);
        Log.d("adaptScreen-system", systemDm.density+ "-" +systemDm.scaledDensity+ "-" +systemDm.densityDpi);
    }

    /**
     * Cancel adapt the screen.
     *
     * @param activity The activity.
     */
    public static void cancelAdaptScreen(Activity activity) {
        final DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        final DisplayMetrics appDm = AppUtils.getApp().getResources().getDisplayMetrics();
        final DisplayMetrics activityDm = activity.getResources().getDisplayMetrics();
        activityDm.density = systemDm.density;
        activityDm.scaledDensity = systemDm.scaledDensity;
        activityDm.densityDpi = systemDm.densityDpi;
        appDm.density = systemDm.density;
        appDm.scaledDensity = systemDm.scaledDensity;
        appDm.densityDpi = systemDm.densityDpi;
    }

    /**
     * Return whether adapt screen.
     *
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isAdaptScreen() {
        DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics appDm = AppUtils.getApp().getResources().getDisplayMetrics();
        return systemDm.density != appDm.density;
    }
}
