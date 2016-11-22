package com.chengyi.Android.content.mvc.view;

import android.view.View;
import android.widget.CheckBox;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.mvc.data.CheckBoxData;

/**
 * Created by Administrator on 2016/10/27.
 */

public class CheckBoxView extends ViewParent  {

    private CheckBox checkBox;

    public CheckBoxView(){
        checkBox= new CheckBox(CurrentActivity.activity);
        this.getView().addView(checkBox);
        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckBoxData checkBoxData=((CheckBoxData)(CheckBoxView.this.getDataModle()));
                checkBoxData.setCheck(v.isSelected());
                if(v.isSelected()){
                    CheckBoxView.this.pushReturnData(0,CheckBoxView.this.getDataModle());
                }else{
                    CheckBoxView.this.clearReturnData();
                }

            }
        } );
    }
}
