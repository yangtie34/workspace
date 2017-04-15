package com.yiyun.chengyi.eyun_db_lib.util;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/2.
 */

public class Scope {
    public static Activity activity;
    public static Scope inflateScope;
    private static int staticId = 0;
    public int id;
    public Scope parent;
    private View view;
    private Object value;
    private static boolean syncLock=false;
    private List<DataListener> dataListeners=new ArrayList<>();
    protected Map<String,Scope> scopes=new HashMap<>();
    private int listSize=0;//当scope为数组使用时

    public Scope(){}

    /**
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public Scope key(String key){
        if(key==null)return new Scope();
        String[] keys=keyParse(key);
        Scope thisScope=this;
        for (int i = 0; i <keys.length ; i++) {
            String k=keys[i];
           if(thisScope.scopes.get(k)==null){
               if(isNumeric(k)){
                   thisScope.push(Integer.parseInt(k),null);
               }else{
                   thisScope.scopes.put(k,new Scope());
               }
            }
            thisScope=thisScope.scopes.get(k);
        }

        return thisScope;
    }
    public Scope key(int index){
        return this.key(String.valueOf(index));
    }

    public void val(Object value){
        this.value=value;
        if(syncLock==false&&value!=null){
            for (int i = 0; i <dataListeners.size() ; i++) {
                dataListeners.get(i).hasChange(value);
            }
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
        return scopes.keySet().toArray(new String[]{});
    }

    public void watch(DataListener listener){
        dataListeners.clear();
        addWatch(listener);
    }
    public void addWatch(DataListener listener){
        dataListeners.add(listener);
        if(value!=null){
            listener.hasChange(value);
        }
    }

    /**
     * 索引为index的地方放入值value
     * @param index
     * @param value
     */
    public void push(int index,Object value){
        if(this.value==null){
            this.value=new ArrayList<>();
        }
        for (int i = 0; i <index-listSize ; i=0) {
            ((List)this.value).add(listSize,null);
            scopes.put(String.valueOf(listSize),new Scope());
            listSize++;
        }
        Scope scope=new Scope();
        scope.val(value);
        scopes.put(String.valueOf(index),scope);
        ((List)this.value).add(index,value);
        this.val(this.value);
        listSize++;
    }

    /**
     * list 放入值
     * @param value
     */
    public void push(Object value){
        push(listSize,value);
    }

    /**
     * list长度
     * @return
     */
    public int size(){
        return listSize;
    }

    /**
     * 解析复杂key
     * @return
     */
    public static String[] keyParse(String key){
        key=key.replaceAll("\\[",".");
        key=key.replaceAll("]","");
        String[] keys=key.split("\\.");
        return keys;
    }

    public static int getId(){
        staticId++;
        return staticId;
    }
    public  void clear(){
        this.dataListeners.clear();
        this.scopes.clear();
        listSize=0;
    }
    public  void clear(String key){
        this.scopes.remove(key);
    }
    public  void clear(int key){
        this.scopes.remove(key);
    }


    public void forThread(final CallBack callBackThread, final DataListener dataListenerUI){
        final int threadId=Scope.getId();
        this.key(threadId).watch(new DataListener() {
            @Override
            public void hasChange(final Object o) {
                Scope.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dataListenerUI.hasChange(o);
                        Scope.this.clear(threadId);
                    }
                });
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Scope.this.key(threadId).val(callBackThread.run());
            }
        }).start();

    }
}

