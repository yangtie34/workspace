package com.chengyi.Android.content.mvc.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.mvc.data.CheckButtonData;
import com.chengyi.Android.libraryUI.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class CheckButtonView extends ViewParent  {

    private Button button;

    public CheckButtonView(){
        button= new Button(CurrentActivity.activity);
        button.setHeight( ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.getView().addView(button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CheckButtonData checkButtonData=((CheckButtonData)(CheckButtonView.this.getDataModle()));
                boolean check=!checkButtonData.isCheck();
                checkButtonData.setCheck(check);
                if(check){
                    button.setBackground(CurrentActivity.activity.getResources().getDrawable(R.drawable.sharp_boder));
                    CheckButtonView.this.pushReturnData(CheckButtonView.this.getDataModle());
                }else{
                    button.setBackground(null);
                    CheckButtonView.this.clearReturnData();
                }
            }
        } );
    }
}
