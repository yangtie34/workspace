package com.chengyi.Android.content.mvc.data;

import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.view.ViewModle;

import java.util.List;

/**
 * Created by administrator on 2016-10-21.
 */

public interface DataModle {

    public ViewModle getViewModle() ;

    public void setViewModle(ViewModle viewModle) ;

    public DataFilter getDataFilter();

    public void setDataFilter(DataFilter dataFilter);

    public List<Object> getReturnData();

    public void setReturnData(List<Object> returnData);

    public void dataUpdate();
    public void dataFilterRun();

}
