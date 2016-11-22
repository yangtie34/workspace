package com.chengyi.Android.libraryUI;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.MResource;

/**
 * showAsDropDown(anchor);
 showAsDropDown(anchor, xoff, yoff);
 showAtLocation(parent, gravity, x, y);
 */
public class WindowPop extends PopupWindow {

    public static String BOTTOM="Bottom";
    public static String TOP="Top";
    private View view;

    public WindowPop(int loyout,Object[] args) {
        init(loyout);
        showMode(args);
    }
    public WindowPop(int loyout,int mode) {
            init(loyout);
            showMode(new Object[]{view, mode, 0, 0});
    }
    public WindowPop(int loyout) {
            init(loyout);
            showMode(new Object[]{view, Gravity.BOTTOM, 0, 0});
    }
    private void init(int loyout){
        this.view = LayoutInflater.from(CurrentActivity.activity).inflate(loyout, null);

      // backLayout.addView(view);
        // 设置外部可点击
        //this.setOutsideTouchable(true);
        this.setFocusable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框


    /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                Mask.getInstance().hide();
            }
        });
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        String styleName="windowPop";
        this.setAnimationStyle(MResource.getstyleIdByName(styleName));

    }
    private void showMode(Object[] args){
        Mask.getInstance().show();
       if(args.length==3){
           showAsDropDown((View) args[0], (Integer) args[2], (Integer) args[3]);
       }else if(args.length==4){
           showAtLocation((View) args[0], (Integer) args[1], (Integer) args[2], (Integer) args[3]);
       }else{
           showAsDropDown((View) args[0]);
       }
    }
 // 取消按钮
    public void cancelClick(){
        // 销毁弹出框
        dismiss();
    }

}