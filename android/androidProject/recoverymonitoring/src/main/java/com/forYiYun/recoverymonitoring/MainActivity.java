package com.forYiYun.recoverymonitoring;

import android.os.Bundle;

import com.chengyi.android.angular.core.AngularActivity;
import com.chengyi.android.util.AppContext;
import com.forYiYun.recoverymonitoring.action.Login;

public class MainActivity extends AngularActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* Intent intent = new Intent();
        intent.setClass(this, Login.class);
        startActivity(intent);*/
        AppContext.intent(Login.class);
    }
}
