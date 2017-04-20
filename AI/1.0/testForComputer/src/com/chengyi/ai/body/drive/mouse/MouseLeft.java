package com.chengyi.ai.body.drive.mouse;

import java.awt.event.InputEvent;

import com.chengyi.ai.body.drive.MyRobot;

public class MouseLeft {
	 /**
     * 按下触发
     */
    public static void mousePress() {
    	MyRobot.print("左键按下");
    	MyRobot.robot.mousePress(InputEvent.BUTTON1_MASK);
	}
    /**
     * 释放触发
     */
    public static void mouseRelease() {
    	MyRobot.print("左键释放");
    	MyRobot.robot.mouseRelease(InputEvent.BUTTON1_MASK);
   	}
}
