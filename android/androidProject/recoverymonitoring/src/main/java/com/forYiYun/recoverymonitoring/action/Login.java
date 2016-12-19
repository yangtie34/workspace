package com.forYiYun.recoverymonitoring.action;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.chengyi.android.angular.scope;
import com.chengyi.android.util.AppMethed;
import com.forYiYun.recoverymonitoring.R;

/**
 * Created by administrator on 2016-12-19.
 */

public class Login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope.init(this);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppMethed.intent(Welcome.class);
            }
        });
    }
}
