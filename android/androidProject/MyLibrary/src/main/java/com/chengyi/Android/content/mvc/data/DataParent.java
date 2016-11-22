package com.chengyi.Android.content.mvc.data;

import android.view.View;

import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.view.ViewModle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class DataParent implements DataModle {

    private DataFilter dataFilter;

    private ViewModle viewModle;
    private List<Object> returnData=new ArrayList<Object>();
    private  boolean show=true;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
        viewModle.getView().setVisibility(show ==false?View.GONE:View.VISIBLE);
        dataFilterRun();
    }

    public ViewModle getViewModle() {
        return this.viewModle;
    }

    public void setViewModle(ViewModle viewModle) {
        this.viewModle=viewModle;
    }

    public DataFilter getDataFilter() {
        return dataFilter;
    }

    public void setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
    }

    @Override
    public void dataUpdate() {

    }

    public void dataFilterRun(){
        this.getViewModle().flush();
        if(this.dataFilter!=null){
            this.dataFilter.hasChange(this.getReturnData());
        }
    }

    public List<Object> getReturnData() {
        return returnData;
    }

    public void setReturnData(List<Object> returnData) {
        this.returnData = returnData;
        dataFilterRun();
    }
}
