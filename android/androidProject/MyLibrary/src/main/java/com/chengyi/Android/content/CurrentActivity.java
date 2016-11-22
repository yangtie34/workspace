package com.chengyi.Android.content;

import android.app.Activity;

/**
 * Created by administrator on 2016-10-25.
 */

public class CurrentActivity {
    public static Activity activity;
    public static Activity preActivity;

    protected static void init(Activity activ) {
        preActivity=activity;
        activity=activ;
    }
}
