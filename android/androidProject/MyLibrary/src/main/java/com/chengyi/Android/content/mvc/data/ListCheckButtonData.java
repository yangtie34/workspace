package com.chengyi.Android.content.mvc.data;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.chengyi.Android.content.Scope;
import com.chengyi.Android.content.SysMethed;
import com.chengyi.Android.content.mvc.DataFilter;
import com.chengyi.Android.content.mvc.view.CheckButtonView;
import com.chengyi.Android.util.ScopeUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */

public class ListCheckButtonData extends DataParent {
    private List<CheckButtonData> list;
public ListCheckButtonData(List<CheckButtonData> list){
    this.list=list;
}
    public List<CheckButtonData> getList() {
        return list;
    }

    public void setList(List<CheckButtonData> list) {
        this.list = list;
        ScrollView scrollView=SysMethed.getScrollView();
        LinearLayout listView0= SysMethed.getWrapLinearLayout();
        listView0.setWeightSum(0.5f);
        LinearLayout listView1= SysMethed.getWrapLinearLayout();
        listView1.setWeightSum(0.5f);
       // scrollView.addView(listView0); scrollView.addView(listView1);
        this.getViewModle().getView().setOrientation(LinearLayout.HORIZONTAL);
        this.getViewModle().getView().addView(listView0);
        this.getViewModle().getView().addView(listView1);
        for (int i = 0; i <list.size() ; i++) {
            CheckButtonData checkButtonData=list.get(i);
            final String id=Scope.getId()+"";
            String idr=Scope.getId()+"";
            Scope.put(id,checkButtonData);
            ScopeUtil.bind(CheckButtonView.class,id,idr);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5,5,5,5);
            View view=ScopeUtil.getBindView(id);
            view.setLayoutParams(lp);
            if(i%2==0){
                listView0.addView(view);
            }else{
                listView1.addView(view);
            }
            final int ii=i;
            Scope.watch(idr,new DataFilter() {
                @Override
                public void hasChange(List<Object> returnData) {
                    if(returnData.size()==0)return;
                    if (((CheckButtonData)returnData.get(0)).isCheck()&&!ListCheckButtonData.this.getReturnData().contains(returnData.get(0))){
                        ListCheckButtonData.this.getReturnData().add(returnData.get(0));
                    }else{
                        ListCheckButtonData.this.getReturnData().remove(returnData.get(0));

                               // .getViewModle().pushReturnData(ii,null);
                    }
                }
            });
        }
    }

    @Override
    public void dataUpdate() {
        super.dataUpdate();
        setList(this.getList());
    }
}
