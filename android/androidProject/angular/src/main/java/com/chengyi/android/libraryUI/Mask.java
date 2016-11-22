package com.chengyi.android.libraryUI;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

import static com.chengyi.android.angular.scope.activity;


/**
 * Created by administrator on 2016-10-20.
 *
 */

public class Mask {
    private static Mask mask=null;
    private RelativeLayout showLayout = null;
    private AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
    private AlphaAnimation disappearAnimation = new AlphaAnimation(1, 0);

    private Mask(){
        showLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams relLayoutParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        showLayout.setGravity(Gravity.CENTER);
        showLayout.setBackgroundColor(Color.parseColor("#86222222"));
        showLayout.setVisibility(View.GONE);
        activity.addContentView(showLayout, relLayoutParams);
    }
        //静态工厂方法
        public static Mask getInstance() {
            if (mask == null) {
                mask = new Mask();
            }
            return mask;
        }
    public void show(){
        appearAnimation.setDuration(800);
        Log.d("test","show="+(showLayout.getVisibility() == View.GONE));
        disappearAnimation.setDuration(800);
        if (showLayout.getVisibility() == View.GONE) {
            showLayout.startAnimation(appearAnimation);
            showLayout.setVisibility(View.VISIBLE);
        }
    }
    public void hide(){
        showLayout.startAnimation(disappearAnimation);
        disappearAnimation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                showLayout.setVisibility(View.GONE);
            }
        });
    }
    public void toggle(){
        if (showLayout.getVisibility() == View.GONE) {
            show();
        }else{
            hide();
        }
    }
    public RelativeLayout getShowLayout(){
        return this.showLayout;
    }

}
