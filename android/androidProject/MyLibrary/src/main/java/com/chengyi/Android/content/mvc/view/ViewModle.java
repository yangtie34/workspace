package com.chengyi.Android.content.mvc.view;

import android.widget.LinearLayout;

import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.data.DataModle;

/**
 * Created by Administrator on 2016/10/26.
 */

public interface ViewModle {
    public LinearLayout getView();
    public void setDataModle(DataModle dataModle);
    public void pushReturnData(int index,Object object);
    public void pushReturnData(Object object);
    public void clearReturnData();
    public void removeReturnData(int index);
    public void watch(DataFilter dataFilter);
    public void flush();
}
