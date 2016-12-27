package com.chengyi.android;

import android.app.Activity;
import android.view.View;

import com.chengyi.android.angular.DataListener;
import com.chengyi.android.angular.ViewData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.id;
import static android.R.attr.key;
import static java.io.FileDescriptor.in;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Scope {
    public static Activity activity;
    public static int staticId = 0;
    public int id;
    private View view;
    private Object value;
    private Object oldValue;
    private List<DataListener> dataListeners=new ArrayList<>();
    private Map<String,Scope> scopes=new HashMap<>();
    private int listSize=0;//当scope为数组使用时

    private Scope(){}
    public static Scope init(Object obj){
        Scope scope=new Scope();
        if(obj instanceof Activity){
            scope.activity= (Activity) obj;
            scope.view=((Activity) obj).findViewById(android.R.id.content);
        }else if(obj instanceof View){
            scope.view=(View) obj;
        }
        scope.id=scope.getId();
        return scope;
    }

    public Scope key(String key){
        if(scopes.get(key)==null){
            scopes.put(key,Scope.init(null));
        }
        return scopes.get(key);
    }
    public Scope key(int index){
        return key(String.valueOf(index));
    }

    public void val(Object value){
        if(value==this.oldValue)return;
        this.oldValue=this.value;
        this.value=value;
        for (int i = 0; i <dataListeners.size() ; i++) {
            dataListeners.get(i).hasChange(value);
        }
    }
    public Object val(){
        return this.value;
    }

    public void watch(DataListener listener){
        dataListeners.add(listener);
    }
    public void push(Object value){
        Scope scope=Scope.init(null);
        scope.val(value);
        scopes.put(String.valueOf(listSize),scope);
        listSize++;

    }
    //绑定view id 与 viewData 数据
    public static void bind(int viewid, ViewData value){
        value.setView(activity.findViewById(viewid));
    }
    public static void bind(View view, ViewData value){
        value.setView(view);
    }

    public int getId(){
        staticId++;
        return staticId;
    }
}

