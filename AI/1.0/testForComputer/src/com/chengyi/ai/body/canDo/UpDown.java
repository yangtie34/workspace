package com.chengyi.ai.body.canDo;

import com.chengyi.ai.body.drive.keyboard.KeyBoardEvent;
import com.chengyi.ai.body.drive.mouse.MouseLeft;
import com.chengyi.ai.body.drive.mouse.MouseRight;
import com.chengyi.ai.body.drive.mouse.MouseWheel;
import com.chengyi.ai.core.interfaces.Action;

public class UpDown implements Action{

	@Override
	public void action(int i) {
		if(i<=100){//按下按键
			KeyBoardEvent.mousePress(i);
		}else if(i<=200){//释放按键
			KeyBoardEvent.mouseRelease(i-100);
		}else if(i==201){//按左键
			MouseLeft.mousePress();
		}else if(i==202){//释放左键
			MouseLeft.mouseRelease();
		}else if(i==203){//按右键
			MouseRight.mousePress();
		}else if(i==204){//释放右键
			MouseRight.mouseRelease();
		}else if(i==205){//按下滚轴
			MouseWheel.wheelPress();
		}else if(i==206){//滚轴释放
			MouseWheel.wheelRelease();
		}else if(i==207){//滚动鼠标滚轴
			MouseWheel.mouseWheel();
		}
	}
	@Override
	public int getId() {
		return 103;
	}
}
