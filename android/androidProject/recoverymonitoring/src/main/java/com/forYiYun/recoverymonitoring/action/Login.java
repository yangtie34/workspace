package com.forYiYun.recoverymonitoring.action;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.chengyi.android.angular.core.AngularActivity;
import com.chengyi.android.util.AppContext;
import com.forYiYun.recoverymonitoring.R;

/**
 * Created by administrator on 2016-12-19.
 */

public class Login extends AngularActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AppContext.intent(Welcome.class, Gravity.RIGHT);
            }
        });
    }
}
