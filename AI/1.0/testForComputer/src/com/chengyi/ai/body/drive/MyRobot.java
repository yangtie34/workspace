package com.chengyi.ai.body.drive;

import java.awt.AWTException;
import java.awt.Robot;

public class MyRobot {
	
	public static  Robot robot;
	
	static{
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}		
	}
	public static void print(String str) {
		 System.out.println(str);
	}
}
