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
    private static float alphaEnd=0.2f;
    private static float everyAlpha= (float) (alphaEnd*DELYED/time);
    private static RelativeLayout view;
    private static float alpha;
    private static boolean show=true;
    private static MyThread thread;

    private Mask(){
        view = new RelativeLayout(Scope.activity);
        view.setLayoutParams(CSS.LayoutParams.matchAll());
        view.setBackgroundColor(Color.parseColor("#000000"));
        view.setAlpha(alphaStart);
        ActivityUtil.getRootView().addView(view);
    }
        //静态工厂方法
        public static Mask getInstance() {
            if (mask == null) {
                mask = new Mask();
            }
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
    synchronized private void go(){
        if(thread!=null) {
           // if(!thread.isAlive())
           thread.resume();

        }else{
            thread=new MyThread();
            thread.start();
        }
    }
    class MyThread  implements Runnable{
        public Thread t;
        boolean suspended=false;
        @SuppressWarnings("Range")
        @Override
        public void run() {

                try {
                    alpha = alphaStart;
                    while (true) {
                        if ((show==false&&alpha > alphaStart) ||(show==true&&alpha < alphaEnd) ) {
                            alpha = show == true ? alpha + everyAlpha : alpha - everyAlpha;
                            if (alpha > alphaEnd) {
                                alpha = alphaEnd;
                            } else if (alpha < alphaStart) {
                                alpha = alphaStart;
                            }
                            //view.getAlpha();
                            view.setAlpha(alpha);
                            Thread.sleep(DELYED);
                        } else {
                        this.suspend();
                        }
                        synchronized(this) {
                            while(suspended) {
                                wait();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("exception...");
                }

        }
        /**
         * 开始
         */
        public void start(){
            if(t==null){
                t=new Thread(this);
                t.start();
            }
        }
        /**
         * 暂停
         */
        void suspend(){
            suspended = true;
        }

        /**
         * 继续
         */
        synchronized void resume(){
            suspended = false;
            notify();
        }
    };


}
