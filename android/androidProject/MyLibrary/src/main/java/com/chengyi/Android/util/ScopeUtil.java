package com.chengyi.Android.util;

import android.view.View;

import com.chengyi.Android.content.Scope;
import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.data.DataModle;
import com.chengyi.Android.content.mvc.view.ViewModle;

import java.util.List;

/**
 * Created by administrator on 2016-10-28.
 */

public class ScopeUtil {
    public static ViewModle bind(Class viewModleClass, String data, final String return_){
       /* List<DataModle> retrunData=new ArrayList<DataModle>();
        Scope.put(return_,retrunData);*/
        DataModle dataModle=(DataModle)Scope.get(data);
        ViewModle viewModle=null;
        try {
            viewModle= (ViewModle) viewModleClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Scope.put(return_, new DataFilter() {
            @Override
            public void hasChange(List<Object> returnData) {
                return;
            }
        });
        dataModle.setDataFilter(new DataFilter() {
            @Override
            public void hasChange(List<Object> returnData) {
                ((DataFilter)Scope.get(return_)).hasChange(returnData);
            }
        });
        dataModle.setViewModle(viewModle);
        viewModle.setDataModle(dataModle);
        dataModle.dataUpdate();
        return viewModle;
    }
    public static ViewModle bind(Class viewModleClass, String data){
       // List<DataModle> retrunData=new ArrayList<DataModle>();
        DataModle dataModle=(DataModle)Scope.get(data);
        ViewModle viewModle=null;
        try {
            viewModle= (ViewModle) viewModleClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        dataModle.setDataFilter(new DataFilter() {
            @Override
            public void hasChange(List<Object> returnData) {
                return;
            }
        });
        dataModle.setViewModle(viewModle);
        viewModle.setDataModle(dataModle);
        dataModle.dataUpdate();
        return viewModle;
    }
    public static View getBindView(String id){
        return ((DataModle)Scope.get(id)).getViewModle().getView();
    }

}
