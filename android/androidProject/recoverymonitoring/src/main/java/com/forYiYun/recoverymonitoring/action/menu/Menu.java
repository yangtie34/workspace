package com.forYiYun.recoverymonitoring.action.menu;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.chengyi.android.MyAngular.TreeView;
import com.chengyi.android.angular.scope;
import com.chengyi.android.entity.TreeEntity;
import com.chengyi.android.libraryUI.WindowPop;
import com.chengyi.android.util.AppMethed;
import com.forYiYun.recoverymonitoring.R;

import java.util.Calendar;

/**
 * Created by administrator on 2016-12-19.
 */

public class Menu {
    public static void topAdd(){
        LinearLayout linearLayout =AppMethed.getRootView();
        View toolBar= LayoutInflater.from(scope.activity).inflate( R.layout.tool_bar,null);
        linearLayout.addView(toolBar,0);

        TreeView treeView=new TreeView("MenuData","MenuReturn");
        scope.put("MenuData",getTreeEntity());
        ScrollView scrollView=AppMethed.getScrollView();
        scrollView.addView(treeView);
        final WindowPop windowPopMenu=new WindowPop(scrollView,new Object[]{AppMethed.getRootView(), Gravity.LEFT,0,0});
        toolBar.findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowPopMenu.show();
            }
        });
        TreeView treeView1=new TreeView("optionData","optionReturn");
        scope.put("optionData",getTreeEntity1());
        final WindowPop windowPopOption=new WindowPop(treeView1,new Object[]{toolBar.findViewById(R.id.option)});
        toolBar.findViewById(R.id.option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowPopOption.showNoMask();
            }
        });
    }
    protected static TreeEntity getTreeEntity1(){
        TreeEntity treeEntity=new TreeEntity();
        String[] day={"今天","明天"};
        for (int i = 0; i < day.length; i++) {
            TreeEntity treeEntity1=new TreeEntity();
            String string=day[i];
            treeEntity1.setName(string);
            treeEntity.addChildren(treeEntity1);
        }
        return treeEntity;
    }
    protected static TreeEntity getTreeEntity(){
        TreeEntity treeEntity=new TreeEntity();
        int level=0;
        treeEntity.setName("root");
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
                if(jj+i==0){
                    TreeEntity treeEntity3=new TreeEntity();
                    treeEntity3.setLevel(level+3);
                    treeEntity2.addChildren(treeEntity3);
                    jj++;
                } /*else for (int k = 5; k <= 55; k+=5) {
                    TreeEntity treeEntity3=new TreeEntity();
                    treeEntity3.setLevel(level+3);
                    string=k+"分";
                    treeEntity3.setName(string);
                    treeEntity3.setId(string);
                    treeEntity2.addChildren(treeEntity3);

                }*/

                treeEntity1.addChildren(treeEntity2);

            }
            treeEntity.addChildren(treeEntity1);
        }
       return treeEntity;
    }
}
