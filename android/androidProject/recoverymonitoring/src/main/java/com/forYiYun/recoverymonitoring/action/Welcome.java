package com.forYiYun.recoverymonitoring.action;

import android.app.Activity;
import android.os.Bundle;

import com.chengyi.android.angular.scope;
import com.chengyi.android.util.AppMethed;
import com.forYiYun.recoverymonitoring.R;
import com.forYiYun.recoverymonitoring.action.menu.Menu;

/**
 * Created by administrator on 2016-12-19.
 */

public class Welcome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope.init(this);
        AppMethed.alert("111111111111111111111");
        setContentView(R.layout.welcome);
        Menu.topAdd();

    }
}
