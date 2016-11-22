package com.chengyi.Android.content.mvc.data;

import android.view.View;
import android.widget.TextView;

import com.chengyi.Android.content.mvc.DataFilter;

/**
 * Created by administrator on 2016-10-21.
 */

public class ViewData  {

    private String text="";
    private boolean check=false;
    private boolean show=true;

    private DataFilter dataFilter;

    private View view;

    public String getText() {
        if (this.getView() instanceof TextView) {
            return ((TextView) this.getView()).getText().toString();
        }
        return null;
    }

    public void setText(String text) {
        if (this.getView() instanceof TextView) {
           ((TextView)this.getView()).setText(text);
        }
        this.text = text;
    }

    public boolean getShow() {
        return this.getView().getVisibility()==View.GONE?false:true;
    }



    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
        view.setVisibility(show ==false?View.GONE:View.VISIBLE);
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view=view;
    }

    public DataFilter getDataFilter() {
        return dataFilter;
    }

    public void setDataFilter(DataFilter dataFilter) {
        this.dataFilter = dataFilter;
    }

    public boolean isCheck() {
        this.check= this.view.isSelected();
        return check;
    }

    public void setCheck(boolean check) {
        view.setSelected(check);
        this.check = check;
    }
}
