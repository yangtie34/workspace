package com.chengyi.ai.body.canDo;

import com.chengyi.ai.body.drive.mouse.MoveMouse;
import com.chengyi.ai.core.interfaces.Action;

public class Move implements Action{

	@Override
	public void action(int i) {
		MoveMouse.move(i);
	}
	@Override
	public int getId() {
		return 101;
	}
}
