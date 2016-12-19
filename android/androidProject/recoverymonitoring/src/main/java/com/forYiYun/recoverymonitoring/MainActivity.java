package com.forYiYun.recoverymonitoring;

import android.app.Activity;
import android.os.Bundle;

import com.chengyi.android.angular.scope;
import com.chengyi.android.util.AppMethed;
import com.forYiYun.recoverymonitoring.action.Login;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope.init(this);
        AppMethed.intent(Login.class);
    }
}
