package com.tolvgx.base.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Created by tolvgx on 2018/8/22.
 *
 * Activity管理器
 */

public class AppManager {
    /*
        单例（静态内部类）
     */
    private AppManager(){}
    private static class SingletonHolder{
        private final static AppManager instance = new AppManager();
    }
    public static AppManager getInstance(){
        return SingletonHolder.instance;
    }


    private Stack<Activity> activityStack = new Stack<>();

    /*
        Activity入栈
     */
    private void addActivity(Activity activity){
        activityStack.add(activity);
    }

    /*
        Activity出栈
     */
    private void finishActivity(Activity activity){
        activity.finish();
        activityStack.remove(activity);
    }

    /*
        获取当前栈顶
     */
    private Activity currentActivity(){
        return activityStack.lastElement();
    }

    /*
        清理栈
     */
    private void finishAllActivity(){
        for (Activity activity : activityStack){
            activity.finish();
        }
        activityStack.clear();
    }

    /*
        退出应用程序
     */
    @SuppressLint("MissingPermission")
    private void exitApp(Context context){
        finishAllActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager!=null){
            activityManager.killBackgroundProcesses(context.getPackageName());
        }
        System.exit(0);
    }
}
