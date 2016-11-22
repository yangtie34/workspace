package com.chengyi.Android.content.mvc.data;

import android.view.View;

import com.chengyi.Android.content.Scope;
import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.view.FilpperView;
import com.chengyi.Android.content.mvc.view.PagerView;
import com.chengyi.Android.content.mvc.view.RepeatView;
import com.chengyi.Android.util.ScopeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by administrator on 2016-11-2.
 */

public class PagerData extends DataParent {
    private Map<View,View> map;
    public PagerData(Map<View,View> map){
        this.map=map;
    }
    public Map<View, View> getMap() {
        return map;
    }

    public void setMap(Map<View, View> map) {
        this.map = map;
        List<View> repeatDataList=new ArrayList<>();
        List<View> filpperDataList=new ArrayList<>();
        repeatDataList.addAll(map.keySet());
        filpperDataList.addAll(map.values());

        int id=Scope.getId();
        RepeatData repeatData=new RepeatData();
        String repeatDataId="repeatData"+id;
        String repeatDataIdR=repeatDataId+"R";
        Scope.put(repeatDataId,repeatData);
        ScopeUtil.bind(RepeatView.class,repeatDataId,repeatDataIdR);
        repeatData.setItems(repeatDataList);

        FilpperData filpperData=new FilpperData();
        final String filpperDataId="filpperData"+id;
        String filpperDataIdR=filpperDataId+"R";
        Scope.put(filpperDataId,filpperData);
        ScopeUtil.bind(FilpperView.class,filpperDataId,filpperDataIdR);
        filpperData.setItems(filpperDataList);

        ((PagerView)this.getViewModle()).init((RepeatView)repeatData.getViewModle(),(FilpperView)filpperData.getViewModle());
        Scope.watch(repeatDataIdR, new DataFilter() {
            @Override
            public void hasChange(List<Object> returnData) {
                PagerData.this.setReturnData(returnData);
            }
        });

        Scope.watch(filpperDataIdR, new DataFilter() {
            @Override
            public void hasChange(List<Object> returnData) {
                PagerData.this.setReturnData(returnData);
            }
        });
    }
    @Override
    public void dataUpdate() {
        setMap(this.map);
    }
}
