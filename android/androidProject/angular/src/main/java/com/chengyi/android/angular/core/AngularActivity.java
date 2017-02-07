package com.chengyi.android.angular.core;

import android.app.Activity;
import android.os.Bundle;

import com.chengyi.android.util.ActivityUtil;
import com.chengyi.android.util.AppContext;

/**
 * Created by administrator on 2016-12-26.
 */

public class AngularActivity extends Activity {

    public Scope scope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope = Scope.init(AppContext.getScope(), this);
        AppContext.addActivity(this);
    }
    /**
     * 监听Back键按下事件,方法1:
     * 注意:
     * super.onBackPressed()会自动调用finish()方法,关闭
     * 当前Activity.
     * 若要屏蔽Back键盘,注释该行代码即可
     */
    @Override
    public void onBackPressed() {
        if(AppContext.getInstance().isIndexActivity()){
            ActivityUtil.exitBy2Click(); //调用双击退出函数
        }else{
            AppContext.intentPrev();
        }
        //super.onBackPressed();
    }



}
