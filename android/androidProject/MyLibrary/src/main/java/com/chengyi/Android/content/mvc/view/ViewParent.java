package com.chengyi.Android.content.mvc.view;

import android.widget.LinearLayout;

import com.chengyi.Android.content.SysMethed;
import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.data.DataModle;

/**
 * Created by Administrator on 2016/10/26.
 */

public class ViewParent implements ViewModle {

    private LinearLayout view= SysMethed.getWrapLinearLayout();

    private DataModle dataModle;

    public LinearLayout getView() {
        return view;
    }

    public void init(){};

    public DataModle getDataModle() {
        return dataModle;
    }

    public void setDataModle(DataModle dataModle) {
        this.dataModle = dataModle;
    }

    @Override
    public void pushReturnData(int index,Object obj) {
        for (int i = this.dataModle.getReturnData().size(); i <=index ; i++) {
            this.dataModle.getReturnData().add(null);
        }
        this.dataModle.getReturnData().set(index,obj);
        this.dataModle.dataFilterRun();
    }
    @Override
    public void pushReturnData(Object object) {
        this.dataModle.getReturnData().add(object);
        this.dataModle.dataFilterRun();
    }

    @Override
    public void clearReturnData() {
        this.dataModle.getReturnData().clear();
        //this.dataModle.dataFilterRun();
    }

    @Override
    public void removeReturnData(int index) {
        if(this.dataModle.getReturnData().size()<index+1){
            return;
        }
        this.dataModle.getReturnData().remove(index);
        this.dataModle.dataFilterRun();
    }
    public void watch(DataFilter dataFilter){
        dataModle.setDataFilter(dataFilter);
    }
    @Override
    public void flush(){

    }
}
