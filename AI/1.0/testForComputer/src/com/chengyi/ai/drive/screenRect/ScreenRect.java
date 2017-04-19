package com.chengyi.ai.drive.screenRect;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import com.chengyi.ai.drive.MyRobot;

public class ScreenRect {
	
	public static BufferedImage getScreen(){
		//获取屏幕分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(d);
        //截图
        BufferedImage bufferedImage =       MyRobot.robot.createScreenCapture(screenRect);
		MyRobot.print("获取屏幕");
		return bufferedImage;
	}
}
