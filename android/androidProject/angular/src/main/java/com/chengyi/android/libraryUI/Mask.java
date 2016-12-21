package com.chengyi.android.libraryUI;

import android.view.View;

import com.chengyi.android.util.AppMethed;


/**
 * Created by administrator on 2016-10-20.
 *
 */

public class Mask {
    private static Mask mask;
    private static long time=2000;
    private static int DELYED=5;
    private static float everyAlpha= (float) (0.3*DELYED/time);
    private static View view;
    private static float alpha;
    private static boolean show=true;
    private static MyThread showThread;
    private static MyThread hideThread;
    private Mask(){
        view= AppMethed.getRootView();
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
        if(hideThread!=null) {
            hideThread.exit = true;
            try {
                hideThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(showThread!=null) {
            showThread.exit = true;
            try {
                showThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        go();
    }
    public void hide(){
        show=false;
        if(hideThread!=null) {
            hideThread.exit = true;
            try {
                hideThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(showThread!=null) {
            showThread.exit = true;
            try {
                showThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        go();
    }
    public void go(){
        MyThread thread=new MyThread(false);
        if(show==true){
            showThread=thread;
        }else{
            hideThread=thread;
        }
        thread.start();
    }
    class MyThread extends Thread {
        public volatile boolean exit = false;
        public MyThread(boolean exit){
            this.exit=exit;
        }
        @SuppressWarnings("Range")
        @Override
        public void run() {
            try {
                alpha=view.getAlpha();
                if(exit==false&&alpha>=0.7f&&alpha<=1f){
                    float setAlpha=show==true?alpha-everyAlpha:alpha+everyAlpha;
                    if(setAlpha>1){
                        setAlpha=1;
                    }else if(setAlpha<0.7){
                        setAlpha=0.7f;
                    }
                    view.setAlpha(setAlpha);
                    sleep(DELYED);
                    run();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("exception...");
            }
        }
    };


}
