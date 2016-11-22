package com.chengyi.Android.content.mvc.data;

import android.view.View;

import com.chengyi.Android.content.mvc.view.RepeatView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class RepeatData extends DataParent{

private List<View> items=new ArrayList<>();
    public RepeatData(){

    }
    @Override
    public void dataUpdate() {
        setItems(this.items);
    }

    public List<View> getItems() {
        return items;
    }

    public void setItems(List<View> items) {
        this.items = items;
        ((RepeatView)this.getViewModle()).init(items);
    }
}
