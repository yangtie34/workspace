package com.chengyi.Android.content.mvc.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.libraryUI.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2016-11-2.
 */

public class FilpperView extends ViewParent implements android.view.GestureDetector.OnGestureListener{
    private ViewFlipper viewFlipper = null;
    public GestureDetector gestureDetector = null;
    private int index=0;
    private List<View> items=new ArrayList<>();
    public FilpperView(){
        viewFlipper=new ViewFlipper(CurrentActivity.activity);
        LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,1);
        gestureDetector = new GestureDetector(this);    // 声明检测手势事件
        viewFlipper.setLongClickable(true);
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewFlipper.stopFlipping();             // 点击事件后，停止自动播放
                viewFlipper.setAutoStart(false);
                return gestureDetector.onTouchEvent(event);         // 注册手势事件
            }
        });
        this.getView().addView(viewFlipper);
    }

    public void init(List<View> items){
        this.items=items;
        for (int i = 0; i < items.size(); i++) {          // 添加图片源
            viewFlipper.addView(items.get(i));
        }
        viewFlipper.setAutoStart(false);         // 设置自动播放功能（点击事件，前自动播放）
        //viewFlipper.setFlipInterval(3000);
        if(viewFlipper.isAutoStart() && !viewFlipper.isFlipping()){
            viewFlipper.startFlipping();
        }
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }
    public void showPrevious(){
        viewFlipper.showPrevious();
        if(index>0) {
            index--;
            this.clearReturnData();
            this.pushReturnData(index);
        }
    }
    public void showNext(){
        viewFlipper.showPrevious();
        if(index<items.size()-1){
            index++;
            this.clearReturnData();
            this.pushReturnData(index);
        }
    }
    public void showByIndex(int i){
        while (index!=i){
            if(index<i){
                viewFlipper.showPrevious();
                    index--;
            }else if(index>i){
                viewFlipper.showPrevious();
                    index++;
            }
        }
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e2.getX() - e1.getX() > 120) {            // 从左向右滑动（左进右出）
            Animation rInAnim = AnimationUtils.loadAnimation(CurrentActivity.activity, R.anim.push_right_in);  // 向右滑动左侧进入的渐变效果（alpha  0.1 -> 1.0）
            Animation rOutAnim = AnimationUtils.loadAnimation(CurrentActivity.activity, R.anim.push_right_out); // 向右滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            viewFlipper.setInAnimation(rInAnim);
            viewFlipper.setOutAnimation(rOutAnim);
            showPrevious();
            return true;
        } else if (e2.getX() - e1.getX() < -120) {        // 从右向左滑动（右进左出）
            Animation lInAnim = AnimationUtils.loadAnimation(CurrentActivity.activity, R.anim.push_left_in);       // 向左滑动左侧进入的渐变效果（alpha 0.1  -> 1.0）
            Animation lOutAnim = AnimationUtils.loadAnimation(CurrentActivity.activity, R.anim.push_left_out);     // 向左滑动右侧滑出的渐变效果（alpha 1.0  -> 0.1）

            viewFlipper.setInAnimation(lInAnim);
            viewFlipper.setOutAnimation(lOutAnim);
            showNext();
            return true;
        }
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
}
