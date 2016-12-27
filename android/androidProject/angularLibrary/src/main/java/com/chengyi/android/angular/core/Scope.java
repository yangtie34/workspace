package com.chengyi.android.angular.core;

import android.app.Application;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Scope {
    public static AngularActivity activity;
    private static int staticId = 0;
    public int id;
    public Scope parent;
    private View view;
    private Object value;
    private static boolean syncLock=false;
    private List<DataListener> dataListeners=new ArrayList<>();
    private Map<String,Scope> scopes=new HashMap<>();
    private int listSize=0;//当scope为数组使用时

    private Scope(){}

    public static Scope init(Scope parent,Object obj){
        Scope scope=new Scope();
        scope.parent=parent;
        if(obj instanceof View){
            scope.view=(View) obj;
        }else if(obj instanceof AngularActivity){
            scope.activity= (AngularActivity) obj;
            scope.view=((AngularActivity) obj).findViewById(android.R.id.content);
        }else if(obj instanceof Application){
            scope.parent=scope;
        }

        scope.id=scope.getId();
        return scope;
    }

    public Scope key(String key){
        String[] keys=keyParse(key);
        Scope thisScope=this;
        for (int i = 0; i <keys.length ; i++) {
            String k=keys[i];
            if(thisScope.scopes.get(k)==null){
                thisScope.scopes.put(k,new Scope());
            }
            thisScope=thisScope.scopes.get(key);
        }

        return thisScope;
    }
    public Scope key(int index){
        return scopes.get(String.valueOf(index));
    }
    public List<Object> list(){
        return ScopeTool.toList(this);
    }
    public Map<String,Object> map(){
        return ScopeTool.toMap(this);
    }
    /**
     * 更改当前value
     * @param value
     */
    public void val(Object value){
        this.value=value;
        if(syncLock==false)
        for (int i = 0; i <dataListeners.size() ; i++) {
            dataListeners.get(i).hasChange(value);
        }
    }
    public static void lockSync(){
        syncLock=true;
    }
    public static void openSync(){
        syncLock=false;
    }
    /**
     * 获取当前value
     * @return
     */
    public Object val(){
        return this.value;
    }
    public String[] keyArray() {
        return (String[])scopes.keySet().toArray();
    }

    public void watch(DataListener listener){
        dataListeners.add(listener);
    }

    /**
     * 索引为index的地方放入值value
     * @param index
     * @param value
     */
    public void push(int index,Object value){
        for (int i = 0; i <index+1-listSize ; i++) {
            scopes.put(String.valueOf(listSize),new Scope());
            listSize++;
        }
        Scope scope=new Scope();
        scope.val(value);
        scopes.put(String.valueOf(index),scope);
    }

    /**
     * list 放入值
     * @param value
     */
    public void push(Object value){
        Scope scope=new Scope();
        scope.val(value);
        scopes.put(String.valueOf(listSize),scope);
        listSize++;
    }

    /**
     * list长度
     * @return
     */
    public int size(){
        return listSize;
    }
    //绑定view id 与 viewData 数据
    public static void bind(int viewid, ViewData value){
        value.setView(activity.findViewById(viewid));
    }
    public static void bind(View view, ViewData value){
        value.setView(view);
    }

    /**
     * 解析复杂key
     * @return
     */
    public static String[] keyParse(String key){
        key=key.replaceAll("\\[",".");
        key=key.replaceAll("]",".");
        String[] keys=key.split(".");
        return keys;
    }
    public int getId(){
        staticId++;
        return staticId;
    }
}

