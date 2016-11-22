package com.chengyi.Android.content;

import android.content.Context;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.chengyi.Android.util.PubInterface;

import static com.chengyi.Android.content.CurrentActivity.activity;

/**
 * Created by administrator on 2016-10-20.
 */

public class SysMethed {
    public static ScrollView getScrollView(){
        ScrollView scrollView = new ScrollView(activity);
        RelativeLayout.LayoutParams relLayoutParams=new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        scrollView.setLayoutParams(relLayoutParams);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        return scrollView;
    }
    public static RelativeLayout getWrapRelativeLayout(){
        RelativeLayout showLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams relLayoutParams=new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        showLayout.setLayoutParams(relLayoutParams);
        showLayout.setGravity(Gravity.CENTER);
        return showLayout;
    }
    public static LinearLayout getWrapLinearLayout(){
        LinearLayout showLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        showLayout.setLayoutParams(relLayoutParams);
        showLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        showLayout.setOrientation(LinearLayout.VERTICAL);
        return showLayout;
    }
    public static View getRootView()
    {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }
    //点击EditText文本框之外任何地方隐藏键盘的解决办法
    public static boolean dispatchTouchEvent(MotionEvent ev,PubInterface pubInterface) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = activity.getCurrentFocus();
            if (SysMethed.isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return (Boolean) pubInterface.run();
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (activity.getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return activity.onTouchEvent(ev);

    }
    public static  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
    //点击的是否为当前view
    public static boolean isViewArea(View v, MotionEvent event){
        if (v != null) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是View区域
                return true;
            } else {
                return false;
            }
        }
        return false;

    }
    public static View getViewByIndex(View view,int i) {
        ViewGroup group= (ViewGroup) view;
        return group.getChildAt(i);
    }
}
