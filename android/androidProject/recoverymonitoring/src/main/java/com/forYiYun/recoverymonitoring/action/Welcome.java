package com.forYiYun.recoverymonitoring.action;

import android.os.Bundle;

import com.chengyi.android.angular.core.AngularActivity;
import com.chengyi.android.util.ActivityUtil;
import com.forYiYun.recoverymonitoring.R;
import com.forYiYun.recoverymonitoring.action.menu.Menu;

/**
 * Created by administrator on 2016-12-19.
 */

public class Welcome extends AngularActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUtil.alert("111111111111111111111");
        setContentView(R.layout.welcome);
        Menu.topAdd();

    }
}
