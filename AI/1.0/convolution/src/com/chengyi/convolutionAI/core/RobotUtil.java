package com.chengyi.convolutionAI.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RobotUtil {

	private static String fullPath = "Robot.dat";

	public static void writeObjectToFile(Object obj) {
		File file = new File(fullPath);
		try {
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(obj);
			objOut.flush();
			objOut.close();
			System.out.println("write object success!");
		} catch (IOException e) {
			System.out.println("write object failed");
			e.printStackTrace();
		}
	}

	public static Object readObjectFromFile() {
		Object temp = null;
		File file = new File(fullPath);
		 if (!file.exists()) {
			 System.err.println("无此文件！"+fullPath); 
		 }else
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			temp = objIn.readObject();
			objIn.close();
			System.out.println("read object success!");
		} catch (FileNotFoundException e) {
			System.out.println("read object failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
