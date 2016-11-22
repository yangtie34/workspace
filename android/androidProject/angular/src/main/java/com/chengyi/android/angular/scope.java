package com.chengyi.android.angular;

import android.app.Activity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/2.
 */

public class scope {
    private static boolean syncLock=false;
    public static Activity activity;
    public static Activity preActivity;
    private static int id = 0;
    private static String THIS_ACTIVITY="THIS_ACTIVITY";
    private static String PRE_ACTIVITY="PRE_ACTIVITY";

    private static Map<String,Object> application_ =new HashMap<String,Object>();//整个程序运行期间
    private static Map<String,Object> activity_ = new HashMap<String,Object>();//activity运行期间
    private static Map<Integer,Map<String,Object>> angular_ = new HashMap<Integer,Map<String,Object>>();//angularView运行期间 <viewid,<k,v>>
    private static String ANGULAR_VIEW="ANGULAR_VIEW";
    private static Map<String, DataListener> dataListener = new HashMap<String, DataListener>();//监听数据

    static {
        application_.put(THIS_ACTIVITY,null);
        application_.put(PRE_ACTIVITY,null);
    }

    public static void init(Object obj){
        if(obj instanceof Activity){
            application_.put(PRE_ACTIVITY,application_.get(THIS_ACTIVITY));
            preActivity=(Activity) application_.get(PRE_ACTIVITY);
            application_.put(THIS_ACTIVITY,obj);
            activity=(Activity) application_.get(THIS_ACTIVITY);
            destroy();
        }else if(obj instanceof AnglularView){
            ((AnglularView) obj).setId(getId());
        }
    }
    //绑定view id 与 viewData 数据
    public static void bind(int viewid, ViewData value){
        value.setView(activity.findViewById(viewid));
    }
    public static void bind(View view, ViewData value){
        value.setView(view);
    }
    public static void watch(String key, DataListener listener){
        if(key!=null)dataListener.put(key,listener);
    }
    public static void put(String key,Object obj){
        putActivity(key,obj);
    }
    public static void putApplication(String key,Object obj){
        application_.put(key,obj);
        runListener(key,obj);
    }
    public static void putActivity(String key,Object obj){
        activity_.put(key,obj);
        runListener(key,obj);
    }
    protected static void putAngular(int viewid, String key, Object obj){
        angular_.get(viewid).put(key,obj);
        runListener(viewid+key,obj);
    }
    private static void runListener(String key,Object obj){
        if(dataListener.containsKey(key)&&syncLock==false){
            dataListener.get(key).hasChange(obj);
        }
    }
    protected static void destroy(){
                activity_.clear();
                angular_.clear();
                dataListener.clear();
    }
    public static int getId(){
        id++;
        return id;
    }
    public static void lockSync(){
        syncLock=true;
    }
    public static void openSync(){
        syncLock=false;
    }
}

