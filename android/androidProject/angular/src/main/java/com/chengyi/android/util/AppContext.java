package com.chengyi.android.util;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.view.Gravity;

import com.chengyi.android.angular.R;
import com.chengyi.android.angular.core.Scope;

import java.util.LinkedList;
import java.util.List;

public class AppContext extends Application {
    private static List<Activity> activitys = null;
    private static List<Activity> activityList = null;
    private static AppContext instance;
    private static Scope scope;
    public static Scope getScope(){
        return scope;
    }
    private AppContext() {
        activitys = new LinkedList();
        activityList = new LinkedList();
        instance= this;
        scope=Scope.init(null,instance);
    }

    /**
     * 单例模式中获取唯一的AppContext实例
     * @return
     */

    public static AppContext getInstance() {
        return instance;
    }

    // 添加Activity到容器中
    public static void addActivity(Activity activity) {
        if (activitys == null){
            new AppContext();
        }
        if (activitys.size() > 0) {
            if(!activitys.contains(activity)){
                activitys.add(activity);
                activityList.add(activity);
            }
        }else{
            activitys.add(activity);
        }
    }
    // 添加Activity到容器中
    public static void removeLast() {
        activityList.remove(activityList.size()-1);
    }
    public boolean isIndexActivity(){
        return activityList.size()==2;
    }
    /**
     * 在当前Activity下跳转至cla Activity
     * @param cla
     */
    public static void intent(Class cla){
        intent(cla,0);
    }
    public static void intentPrev(){
        removeLast();
        intent(activityList.get(activityList.size()-1).getClass(),0);
    }
    /**
     * 在当前Activity下跳转至cla Activity
     * @param cla
     * @param gravity 切换效果 Gravity.BOTTOM...
     */
    public static void intent(Class cla,int gravity){
        Intent intent = new Intent();
        intent.setClass(scope.activity, cla);
        scope.activity.startActivity(intent);
        if(gravity== Gravity.BOTTOM){
            scope.activity.overridePendingTransition(R.anim.in_from_bottom, R.anim.out_to_top);
        }else if(gravity== Gravity.TOP){
            scope.activity.overridePendingTransition(R.anim.in_from_top, R.anim.out_to_bottom);
        }else if(gravity== Gravity.LEFT){
            scope.activity.overridePendingTransition(R.anim.in_from_left,R.anim.out_to_right);
        }else if(gravity== Gravity.RIGHT){
            scope.activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }else{

        }
    }
    // 遍历所有Activity并finish
    public void exit() {
        super.onTerminate();
        if (activitys != null && activitys.size() > 0) {
            for (Activity activity : activitys) {
                activity.finish();
            }
        }
        System.exit(0);
    }

}