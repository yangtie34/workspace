package com.chengyi.android.util;

import android.app.Activity;
import android.app.Application;

import com.chengyi.android.angular.core.Scope;

import java.util.LinkedList;
import java.util.List;

public class AppContext extends Application {
    private List<Activity> activitys = null;
    private static AppContext instance;
    public static Scope scope;

    private AppContext() {
        activitys = new LinkedList();
    }

    /**
     * 单例模式中获取唯一的AppContext实例
     * @return
     */

    public static AppContext getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        scope=Scope.init(null,instance);
        instance= this;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        if (activitys != null && activitys.size() > 0) {
            if(!activitys.contains(activity)){
                activitys.add(activity);
            }
        }else{
            activitys.add(activity);
        }

    }

    // 遍历所有Activity并finish
    public void exit() {
        if (activitys != null && activitys.size() > 0) {
            for (Activity activity : activitys) {
                activity.finish();
            }
        }
        System.exit(0);
    }

}