package com.chengyi.Android.content.mvc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.chengyi.Android.content.mvc.view.ViewModle;
import com.chengyi.Android.util.ScopeUtil;

/**
 * Created by Administrator on 2016/10/26.
 */

public class ViewContainer extends RelativeLayout {
    private Class<ViewModle> viewModle;
    private String data;
    private String return_;

    public ViewContainer(Context context) {
        super(context);
    }
    public ViewContainer(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void bind(Class viewModleClass, String data, final String return_){
        this.viewModle=viewModleClass;
        this.data=data;
        this.return_=return_;
        this.addView(ScopeUtil.bind(viewModleClass,data,return_).getView());
    }
    public void bind(Class viewModleClass, String data){
        this.viewModle=viewModleClass;
        this.data=data;
        this.addView(ScopeUtil.bind(viewModleClass,data).getView());
    }

}
