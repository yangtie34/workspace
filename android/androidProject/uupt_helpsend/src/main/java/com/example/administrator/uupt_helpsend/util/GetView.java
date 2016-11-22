package com.example.administrator.uupt_helpsend.util;

import android.view.Gravity;
import android.widget.TextView;

import com.chengyi.Android.content.CurrentActivity;

/**
 * Created by Administrator on 2016/10/29.
 */

public class GetView {
    public static TextView getTextView(String text){
        TextView textView=new TextView(CurrentActivity.activity);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
       // textView.setPadding(5,20,5,20);
        textView.setHeight(60);
        textView.setTextSize(20);
        return  textView;
    };

}
