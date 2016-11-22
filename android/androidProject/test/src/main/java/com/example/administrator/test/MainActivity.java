package com.example.administrator.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengyi.android.angular.scope;
import com.chengyi.android.entity.TreeEntity;
import com.example.administrator.test.util.GetView;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scope.init(this);
        setContentView(R.layout.activity_main);
        List<View> items=new LinkedList<>();
        for(int i=0;i<11;i++){
            TextView textView=new TextView(scope.activity);
            textView.setText(i+"123");
            textView.setLayoutParams(new LinearLayout.LayoutParams
                    (300, ViewGroup.LayoutParams.WRAP_CONTENT));
            items.add(textView);
        }

        scope.put("text",items);
        scope.put("clickid",0);

        TreeEntity treeEntity=new TreeEntity();
        int level=0;
        treeEntity.setLevel(level);
        String[] day={"今天","明天"};
        String[] hour={"立即发货"};
        String[] min={};
        for (int i = 0; i < day.length; i++) {
            TreeEntity treeEntity1=new TreeEntity();
            treeEntity1.setLevel(level+1);
            String string=i+"_level1";
            treeEntity1.setName(string);
            treeEntity1.setId(string);
            treeEntity1.setContent(GetView.getTextView(day[i]));
            int mHour=0;int ehour=19;
            if(i==0){
                long time=System.currentTimeMillis();
                final Calendar mCalendar=Calendar.getInstance();
                mCalendar.setTimeInMillis(time);
                mHour=mCalendar.get(Calendar.HOUR_OF_DAY)+1;
                ehour=24;
            }
            int jj=0;
            for (int j = mHour; j < ehour; j++) {
                TreeEntity treeEntity2=new TreeEntity();
                treeEntity2.setLevel(level+2);
                string=j+"点";
                if(i==0&&jj==0){
                    string="立即发货";
                    j--;
                }
                treeEntity2.setName(string);
                treeEntity2.setId(string);
                treeEntity2.setContent(GetView.getTextView(string));
                if(jj+i==0){
                    TreeEntity treeEntity3=new TreeEntity();
                    treeEntity3.setLevel(level+3);
                    treeEntity3.setContent(GetView.getTextView(""));
                    treeEntity2.addChildren(treeEntity3);
                    jj++;
                } else for (int k = 5; k <= 55; k+=5) {
                    TreeEntity treeEntity3=new TreeEntity();
                    treeEntity3.setLevel(level+3);
                    string=k+"分";
                    treeEntity3.setName(string);
                    treeEntity3.setId(string);
                    treeEntity3.setContent(GetView.getTextView(string));
                    treeEntity2.addChildren(treeEntity3);

                }

                treeEntity1.addChildren(treeEntity2);

            }
            treeEntity.addChildren(treeEntity1);
        }
        scope.put("vc01",  treeEntity);
        Map<View,View> map=new LinkedHashMap<>();
        for(int i=0;i<10;i++){
            map.put(GetView.getTextView("123"+i),GetView.getTextView("1239"+i));
        }
        scope.put("Pager",map);



    }
}
