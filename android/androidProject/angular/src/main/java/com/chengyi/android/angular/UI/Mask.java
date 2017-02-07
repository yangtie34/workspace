package com.chengyi.android.angular.UI;

import android.graphics.Color;
import android.widget.RelativeLayout;

import com.chengyi.android.angular.core.Scope;
import com.chengyi.android.util.ActivityUtil;
import com.chengyi.android.util.CSS;


/**
 * Created by administrator on 2016-10-20.
 *
 */

public class Mask {
    private static Mask mask;
    private static long time= CSS.effect.duration;
    private static int DELYED=5;//每几毫秒执行一次
    private static float alphaStart=0f;
    private static float alphaEnd=0.3f;
    private static float everyAlpha= (float) (alphaEnd*DELYED/time);
    private static RelativeLayout view;
    private static float alpha;
    private static boolean show=true;
    private static MyThread thread;

    private Mask(){
    }
        //静态工厂方法
        public static Mask getInstance() {
            if (mask == null) {
                mask = new Mask();
            }
            view = new RelativeLayout(Scope.activity);
            view.setLayoutParams(CSS.LayoutParams.matchAll());
            view.setBackgroundColor(Color.parseColor("#000000"));
            view.setAlpha(alphaStart);
            ActivityUtil.getRootView().addView(view);
            return mask;
        }
    public void show(){
        show=true;
        go();
    }
    public void hide(){
        show=false;
        go();
    }
    private void go(){
        if(thread!=null) {
            if(!thread.isAlive())
                synchronized (thread) {thread.notify();}
        }else{
            thread=new MyThread();
            thread.start();
        }
    }
    class MyThread extends Thread {


        @SuppressWarnings("Range")
        @Override
        public void run() {
            synchronized (this) {
                try {
                    while (true) {
                        alpha = view.getAlpha();
                        if ((show==false&&alpha > alphaStart) ||(show==true&&alpha < alphaEnd) ) {
                            float setAlpha = show == true ? alpha + everyAlpha : alpha - everyAlpha;
                            if (setAlpha > alphaEnd) {
                                setAlpha = alphaEnd;
                            } else if (setAlpha < alphaStart) {
                                setAlpha = alphaStart;
                            }
                            view.setAlpha(setAlpha);
                            sleep(DELYED);
                        } else {
                            MyThread.this.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("exception...");
                }
            }
        }
    };


}
