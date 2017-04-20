package com.chengyi.ai.body.drive.mouse;

import java.awt.MouseInfo;
import java.awt.Point;

import com.chengyi.ai.body.drive.MyRobot;

public class MoveMouse {
	
	private static Point point;
	 /**
	 * 根据数值移动鼠标
	 */
	public static void move(int i) {
		int forx=1;
		int fory=1;		
		switch (i%4) {//0-3左上 右上 右下 左下
		case 0:
			forx=-1;
			break;
		case 1:
			 fory=-1;	
			break;
		case 2:
			fory=-1;
			break;
		case 3:
			forx=-1;
			break;
		}
		double xbl=i%11*0.1;//x轴比例
		int x= (int)(i*xbl);
		int y=i-x;
		move(x*forx,y*fory);
	}
	
	/**
	 * 根据偏移量移动鼠标
	 */
	private static void move(int x,int y) {
		getPoint();
		//MyRobot.print("鼠标移动");
		MyRobot.robot.mouseMove(point.x+x, point.y+y);
	}
	  /**
	   * 获取鼠标坐标
	   */
	  private static void getPoint() {
		   point = MouseInfo.getPointerInfo().getLocation();
	}
	  
	   
}
