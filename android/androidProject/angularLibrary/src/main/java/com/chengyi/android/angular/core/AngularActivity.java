package com.chengyi.android.angular.core;

import android.app.Activity;
import android.os.Bundle;

import com.chengyi.android.util.AppContext;

/**
 * Created by administrator on 2016-12-26.
 */

public class AngularActivity extends Activity {

    public Scope scope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope=Scope.init(AppContext.getInstance().scope, this);
    }

    }
