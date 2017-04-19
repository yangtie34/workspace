package com.chengyi.ai.drive.mouse;

import java.awt.MouseInfo;
import java.awt.Point;

import com.chengyi.ai.drive.MyRobot;

public class MoveMouse {
	
	private static Point point;
	/**
	 * 根据偏移量移动鼠标
	 */
	public static void move(int x,int y) {
		getPoint();
		MyRobot.print("鼠标移动");
		MyRobot.robot.mouseMove(point.x+x, point.y+y);
	}
	  /**
	   * 获取鼠标坐标
	   */
	  public static void getPoint() {
		   point = MouseInfo.getPointerInfo().getLocation();
	}
}
