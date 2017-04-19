package com.chengyi.ai.drive.mouse;

import com.chengyi.ai.drive.MyRobot;

public class MouseWheel {
	
    public static void mouseWheel() {
    	//滚动鼠标滚轴
    	MyRobot.print("滚轴");
        MyRobot.robot.mouseWheel(5);
   	}
}
