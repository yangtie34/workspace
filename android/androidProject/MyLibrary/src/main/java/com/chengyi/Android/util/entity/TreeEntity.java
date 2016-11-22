package com.chengyi.Android.util.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */

public class TreeEntity {
    private String id;
    private String name;
    private Object content;
    private int level;
    private List<TreeEntity> childrenList=new ArrayList<TreeEntity>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<TreeEntity> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<TreeEntity> childrenList) {
        this.childrenList = childrenList;
    }

    public void addChildren(TreeEntity treeEntity1) {
        this.childrenList.add(treeEntity1);
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
