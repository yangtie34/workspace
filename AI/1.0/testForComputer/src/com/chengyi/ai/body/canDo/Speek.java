package com.chengyi.ai.body.canDo;

import com.chengyi.ai.body.drive.sound.SoundOut;
import com.chengyi.ai.core.interfaces.Action;

public class Speek implements Action{

	@Override
	public void action(int i) {
		SoundOut.play(i);
	}
	@Override
	public int getId() {
		return 102;
	}
}
