package com.chengyi.ai.drive;

import java.awt.AWTException;
import java.awt.Robot;

public class MyRobot {
	
	public static  Robot robot;
	
	static{
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public static void print(String str) {
		 System.out.println(str);
	}
}
