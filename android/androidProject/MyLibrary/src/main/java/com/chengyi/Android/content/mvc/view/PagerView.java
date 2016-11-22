package com.chengyi.Android.content.mvc.view;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.libraryUI.R;

import java.util.List;

/**
 * Created by administrator on 2016-11-2.
 */

public class PagerView extends ViewParent {
    private RepeatView repeatView;
    private FilpperView filpperView;
    public PagerView(){

    }
    public void init(final RepeatView repeatView, final FilpperView filpperView){
        this.getView().setBackground(CurrentActivity.activity.getResources().getDrawable(R.drawable.sharp_boder));
        this.getView().addView(repeatView.getView());
        this.getView().addView(filpperView.getView());
      this.getDataModle().setDataFilter(new DataFilter() {
          @Override
          public void hasChange(List<Object> returnData) {
              repeatView.itemClick((Integer) returnData.get(0));
              filpperView.showByIndex((Integer) returnData.get(0));
          }
      });
    }
}
