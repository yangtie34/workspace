package com.chengyi.android.angular;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/10/26.
 */

public class ViewParent extends LinearLayout implements AnglularView {
    private int id;
    private String Data;

    private String params;

    private String state1;
    private String state2;
    private String state3;
    private String state4;
    private String state5;
    private String state6;

    private String Return;

    public ViewParent(){
        super(scope.activity);
        RelativeLayout.LayoutParams relLayoutParams=new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(relLayoutParams);
        this.setOrientation(LinearLayout.VERTICAL);
    }

    public ViewParent(Context context, AttributeSet attr) {
        super(context, attr);
        scope.init(this);
        //获取属性
        TypedArray typedArray = context.obtainStyledAttributes(attr, R.styleable.ViewParent);//TypedArray是一个数组容器

        setData(typedArray.getString(R.styleable.ViewParent_Data));
        setParams(typedArray.getString(R.styleable.ViewParent_params));
        setState1(typedArray.getString(R.styleable.ViewParent_state1));
        setState2(typedArray.getString(R.styleable.ViewParent_state2));
        setState3(typedArray.getString(R.styleable.ViewParent_state3));
        setState4(typedArray.getString(R.styleable.ViewParent_state4));
        setState5(typedArray.getString(R.styleable.ViewParent_state5));
        setState6(typedArray.getString(R.styleable.ViewParent_state6));
        setReturn(typedArray.getString(R.styleable.ViewParent_Return));
        typedArray.recycle();//回收资源
    }
    protected void init(){

    }
    protected void setReturn(Object obj) {
        scope.put(getReturn(),obj);
    }
    protected void watch(String key, DataListener listener){
        scope.watch(this.getId() +key,listener);
    }
    protected void put(String key,Object obj){
        scope.putAngular(this.getId(),key,obj);
    }
    protected void clear(){
       ((ViewGroup) this).removeAllViews();
    }
    public void setData(String data) {
        if(data==null)return;
        Data = data;
        scope.put(getData(),new Object());
    }

    public void setState1(String state1) {
        if(state1==null)return;
        this.state1 = state1;
        scope.put(state1,new Object());
    }

    public void setState2(String state2) {
        if(state2==null)return;
        this.state2 = state2;
        scope.put(state2,new Object());
    }

    public void setState3(String state3) {
        if(state3==null)return;
        this.state3 = state3;
        scope.put(state3,new Object());
    }

    public void setState4(String state4) {
        if(state4==null)return;
        this.state4 = state4;
        scope.put(state4,new Object());
    }

    public void setState5(String state5) {
        if(state5==null)return;
        this.state5 = state5;
        scope.put(state5,new Object());
    }

    public void setState6(String state6) {
        if(state6==null)return;
        this.state6 = state6;
        scope.put(state6,new Object());
    }

    public void setReturn(String aReturn) {
        if(aReturn==null)return;
        Return = aReturn;
        scope.put(aReturn,new Object());
    }

    public void setParams(String params) {
        if(params==null)return;
        this.params = params;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getData() {
        return Data;
    }

    public String getParams() {
        return params;
    }

    public String getState1() {
        return state1;
    }

    public String getState2() {
        return state2;
    }

    public String getState3() {
        return state3;
    }

    public String getState4() {
        return state4;
    }

    public String getState5() {
        return state5;
    }

    public String getState6() {
        return state6;
    }

    public String getReturn() {
        return Return;
    }

    public void show(){
        this.setVisibility(View.VISIBLE);
    }
    public void hide(){
        this.setVisibility(View.GONE);
    }
}
