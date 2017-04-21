package com.chengyi.ai.body.canDo;

import com.chengyi.ai.core.interfaces.Action;

/**
 * 视线焦点
 * @author Administrator
 *
 */
public class Focus implements Action{
	
	public static int postion=0;
	@Override
	public void action(int i) {
		postion=i;
	}
	@Override
	public int getId() {
		return 104;
	}
}
