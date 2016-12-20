package com.chengyi.android.libraryUI;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.chengyi.android.util.AppMethed;


/**
 * Created by administrator on 2016-10-20.
 *
 */

public class Mask {
    private static Mask mask;
    private static long time=200;
    private static View view;
    private static AlphaAnimation appearAnimation = new AlphaAnimation(1f, 0.7f);
    private static AlphaAnimation disappearAnimation = new AlphaAnimation(0.7f, 1f);

    private Mask(){
        view= AppMethed.getRootView();
        appearAnimation.setDuration(time);
        appearAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setAlpha(0.7f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        disappearAnimation.setDuration(time);
        disappearAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setAlpha(1f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
        //静态工厂方法
        public static Mask getInstance() {
            if (mask == null) {
                mask = new Mask();
            }
            return mask;
        }
    public void show(){
        view.setAlpha(0.7f);
        //view.startAnimation(appearAnimation);
    }
    public void hide(){
        view.setAlpha(1f);
        //view.startAnimation(disappearAnimation);
    }


}
