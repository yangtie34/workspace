package com.chengyi.ai.body.drive.mouse;

import java.awt.event.InputEvent;

import com.chengyi.ai.body.drive.MyRobot;

public class MouseWheel {
    /**
     * 按下触发
     */
    public static void wheelPress() {
    	MyRobot.print("滚轴按下");
    	MyRobot.robot.mousePress(InputEvent.BUTTON2_MASK);
	}
    /**
     * 释放触发
     */
    public static void wheelRelease() {
    	MyRobot.print("滚轴释放");
    	MyRobot.robot.mouseRelease(InputEvent.BUTTON2_MASK);
   	}
    /**
     * 滚动鼠标滚轴
     */
    public static void mouseWheel() {
    	//滚动鼠标滚轴
    	MyRobot.print("滚动滚轴");
        MyRobot.robot.mouseWheel(5);
   	}
}
