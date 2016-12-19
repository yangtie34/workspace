package com.forYiYun.recoverymonitoring.action.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chengyi.android.angular.scope;
import com.chengyi.android.util.AppMethed;
import com.forYiYun.recoverymonitoring.R;

/**
 * Created by administrator on 2016-12-19.
 */

public class Menu {
    public static void topAdd(){
        LinearLayout linearLayout =AppMethed.getRootView();
        View toolBar= LayoutInflater.from(scope.activity).inflate( R.layout.tool_bar,null);
        linearLayout.addView(toolBar,0);
    }
}
