package com.forYiYun.recoverymonitoring.action;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.chengyi.android.angular.scope;
import com.chengyi.android.util.AppMethed;
import com.chengyi.android.util.MyApplication;
import com.forYiYun.recoverymonitoring.R;
import com.forYiYun.recoverymonitoring.action.menu.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 2016-12-19.
 */

public class Welcome extends Activity {

    private List<View> viewState=new ArrayList<>();//本页面当前view状态 用于按返回键时调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope.init(this);
        AppMethed.alert("111111111111111111111");
        setContentView(R.layout.welcome);
        Menu.topAdd();

    }

    /**
     * view间互相跳转
     */
    public void viewJump(){

    }
    /**
     * 监听按键
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK//返回键
                && event.getRepeatCount() == 0) {
            Log.e("按了返回了", "但是不退出这个Activity");
            if(viewState.size()==0){
                MyApplication.getInstance().exit();
            }else{
                AppMethed.getRootView().removeView(viewState.get(viewState.size()-1));
                viewState.remove(viewState.size()-1);
            }

            return true;//返回true是吃掉，后面的监听就得不到这个事件了-。-
            //返回false就是不吃，后面的监听还可以再得到这个动作~继续舔~然后判断要不要吃掉...
        }else if (keyCode == KeyEvent.KEYCODE_MENU) {//菜单键
            // 在这里做你想做的事情


        return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
