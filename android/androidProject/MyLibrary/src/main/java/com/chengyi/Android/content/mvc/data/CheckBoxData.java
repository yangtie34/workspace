package com.chengyi.Android.content.mvc.data;

import android.widget.CheckBox;

import com.chengyi.Android.content.SysMethed;

/**
 * Created by Administrator on 2016/10/27.
 */

public class CheckBoxData extends DataParent{

    private boolean check=false;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
        ((CheckBox) SysMethed.getViewByIndex(this.getViewModle().getView(),0)).setSelected(check);
    }


    @Override
    public void dataUpdate() {
        super.dataUpdate();
        setCheck(this.isCheck());
    }
}
