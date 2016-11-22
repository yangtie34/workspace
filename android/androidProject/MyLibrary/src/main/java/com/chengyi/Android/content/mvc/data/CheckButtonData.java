package com.chengyi.Android.content.mvc.data;

import android.widget.Button;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.SysMethed;
import com.chengyi.Android.libraryUI.R;

/**
 * Created by Administrator on 2016/10/27.
 */

public class CheckButtonData extends DataParent{

    private boolean check=false;
    private String text;
    public CheckButtonData(){

    }
    public CheckButtonData(Boolean check,String text){
        this.check=check;
        this.text=text;
    }
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
        ((Button) SysMethed.getViewByIndex(this.getViewModle().getView(),0)).
                setBackground(check?CurrentActivity.activity.getResources().getDrawable(R.drawable.sharp_boder):null);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        ((Button) SysMethed.getViewByIndex(this.getViewModle().getView(),0)).setText(text);
    }

    @Override
    public void dataUpdate() {
        super.dataUpdate();
        setCheck(this.isCheck());
        setText(this.getText());
    }
}
