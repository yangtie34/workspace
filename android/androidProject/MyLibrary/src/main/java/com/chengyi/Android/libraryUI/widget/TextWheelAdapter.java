package com.chengyi.Android.libraryUI.widget;

import com.chengyi.Android.content.CurrentActivity;
import com.chengyi.Android.util.entity.TreeEntity;

import java.util.ArrayList;
import java.util.List;

public class TextWheelAdapter extends AbstractWheelTextAdapter {

	private List<TreeEntity> list=new ArrayList<TreeEntity>();


	public TextWheelAdapter(List<TreeEntity> list) {
		super(CurrentActivity.activity);
		this.list=list;
	}

	public TextWheelAdapter(int minValue, int maxValue) {
		super(CurrentActivity.activity);
		for (int i = minValue; i <=maxValue ; i++) {
			TreeEntity treeEntity=new TreeEntity();
			String value=Integer
					.toString(i);
			treeEntity.setId(value);
			treeEntity.setName(value);
			list.add(treeEntity);
		}
	}

	@Override
	public CharSequence getItemText(int index) {
		if (index >= 0 && index < getItemsCount()) {
			return list.get(index).getName();
		}
		return null;
	}

	public int getItemsCount() {
		return list.size();
	}
}