package com.chengyi.Android.content.mvc.view;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.SysMethed;
import com.chengyi.Android.libraryUI.R;
import com.chengyi.Android.libraryUI.widget.OnWheelScrollListener;
import com.chengyi.Android.libraryUI.widget.ViewWheelAdapter;
import com.chengyi.Android.libraryUI.widget.WheelView;
import com.chengyi.Android.util.entity.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */

public class CurWheelView extends ViewParent  {
    private ViewFlipper viewfipper;
    private View mMenuView;
    private  int visible=5;
    public CurWheelView(){
                this.getView().setOrientation(LinearLayout.HORIZONTAL);
                 iniLayoutView();
    }
    public void fillView(TreeEntity treeEntity, int index){
        List<TreeEntity> treeEntities=treeEntity.getChildrenList();
        if(treeEntities.size()==0){
            return;
        }
        this.pushReturnData(treeEntity.getLevel(),treeEntities.get(0));
        //TextWheelAdapter textWheelAdapter=new TextWheelAdapter(treeEntities);

        List<View> views=new ArrayList<View>();
        for (int i = 0; i <treeEntities.size() ; i++) {
           /* TextView textview=new TextView(CurrentActivity.activity);
            textview.setText(treeEntities.get(i).getName());*/
            views.add((View) treeEntities.get(i).getContent());
            //views.add(textview);
        }
        ViewWheelAdapter textWheelAdapter =new ViewWheelAdapter(views);

        WheelView wheelView=null;
        if(mMenuView.findViewById(treeEntity.getLevel()+1)==null){
            wheelView=new WheelView(CurrentActivity.activity);
            LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1.0f);

            wheelView.setId(treeEntity.getLevel()+1);
            wheelView.setLayoutParams(relLayoutParams);
            ((LinearLayout)mMenuView).addView(wheelView);
        }else{
            wheelView=(WheelView)mMenuView.findViewById(treeEntity.getLevel()+1);
        }
        wheelView.setViewAdapter(textWheelAdapter);
        wheelView.setVisibleItems(visible);
        wheelView.setCurrentItem(index);
        wheelView.setScrollingListener(new Listener(treeEntity));
        fillView(treeEntities.get(index),0);
    }
    private void iniLayoutView(){
        mMenuView= SysMethed.getWrapLinearLayout();
        LinearLayout.LayoutParams relLayoutParams=new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
        mMenuView.setLayoutParams(relLayoutParams);
        ((LinearLayout)mMenuView).setGravity(Gravity.CENTER_HORIZONTAL);
        ((LinearLayout)mMenuView).setOrientation(LinearLayout.HORIZONTAL);
       // mMenuView.setBackgroundColor(Color.parseColor("#00FF00"));
        mMenuView.setId(R.id.mMenuView);
        setViewfipper(new ViewFlipper(CurrentActivity.activity));
        viewfipper.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,1));
        viewfipper.addView(mMenuView);
        viewfipper.setFlipInterval(6000000);
        this.getView().addView(viewfipper);
    }

    public ViewFlipper getViewfipper() {
        return viewfipper;
    }

    public void setViewfipper(ViewFlipper viewfipper) {
        this.viewfipper = viewfipper;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    class Listener implements OnWheelScrollListener{
        private TreeEntity treeEntity;
        public Listener(TreeEntity treeEntity){
            this.treeEntity=treeEntity;
        }
        @Override
        public void onScrollingStarted(WheelView wheel) {

        }

        @Override
        public void onScrollingFinished(WheelView wheel) {
            fillView(treeEntity.getChildrenList().get(wheel.getCurrentItem()),0);
            CurWheelView.this.pushReturnData(treeEntity.getLevel(),treeEntity.getChildrenList().get(wheel.getCurrentItem()));
        }
    }

}
