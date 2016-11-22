package com.chengyi.Android.content;

import android.app.Activity;
import android.view.View;

import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.data.ViewData;
import com.chengyi.Android.util.catche.LFUCache;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by administrator on 2016-10-21.
 */

public class Scope{
    private static int id=0;
    private static LFUCache<String, Object> dataMap = new LFUCache<String, Object>(20000, 0);
    private static LFUCache<String, View> viewMap = new LFUCache<String, View>(20000, 0);
    public static void init(Activity activity){
        CurrentActivity.init(activity);
    }

    public static void put(String key, Object value) {
        dataMap.put(key,value);
    }
    public static Object get(String key) {
        return dataMap.get(key);
    }

    public static Object get(int key) {
        return get(key+"");
    }

//绑定view id 与 viewData 数据
    public static void bind(int key, ViewData value){
        setView(key);
        value.setView(CurrentActivity.activity.findViewById(key));
        put(key+"",value);
    }
    public static void bind(View view, ViewData value){
        String key=getId()+"";
        viewMap.put(key,view);
        value.setView(view);
        put(key,value);
    }
    public static void bind(Map<View,ViewData> map){
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry<View,ViewData> entry1=(Map.Entry<View,ViewData>)i.next();
            bind(entry1.getKey(),entry1.getValue());
        }
    }
//绑定view id 与 viewData 数据

    public static void watch(String return_,DataFilter dataFilter){
        put(return_,dataFilter);
    }



    private static void setView(int id) {
        if(viewMap.get(id+"")==null)
            viewMap.put(id+"", CurrentActivity.activity.findViewById(id));
    }
    /**
     * 判断id是否为绑定状态
     */
    private static boolean isBind(String id){
        return viewMap.get(id)==null?false:true;
    }
    public static int getId(){
        id++;
        return id;
    }

}