package com.chengyi.Android.content.mvc.data;

import com.chengyi.Android.content.mvc.view.CurWheelView;
import com.chengyi.Android.util.entity.TreeEntity;

/**
 * Created by Administrator on 2016/10/29.
 */

public class CurWheelData extends DataParent{
    private TreeEntity treeEntity=new TreeEntity();
    private int visible=5;
    public CurWheelData(){};
    public CurWheelData(TreeEntity treeEntity){
       this.treeEntity=treeEntity;
    };
    public CurWheelData(TreeEntity treeEntity,int visible){
        this.treeEntity=treeEntity;
        this.visible=visible;
    };
    public TreeEntity getTreeEntity() {
        return treeEntity;
    }


    public void setTreeEntity(TreeEntity treeEntity) {
        this.treeEntity = treeEntity;
        ((CurWheelView)this.getViewModle()).fillView(treeEntity,0);
        ((CurWheelView)this.getViewModle()).getViewfipper().startFlipping();
    }
    @Override
    public void dataUpdate() {
        super.dataUpdate();
        setVisible(this.getVisible());
        setTreeEntity(this.getTreeEntity());

    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
        ((CurWheelView)this.getViewModle()).setVisible(visible);
    }
}
