package com.chengyi.convolutionAI;

import com.chengyi.convolutionAI.core.Robot;
import com.chengyi.convolutionAI.core.RobotUtil;

public class Main {
	private static Robot robot;
	
	public static void main(String[] args) {
		
		robot=(Robot)RobotUtil.readObjectFromFile();
		if(robot==null){
			robot=new Robot();
		}
		robot.run();
	}

}
