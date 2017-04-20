package com.chengyi.ai.core.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ScopeUtil {
	/**
	 * 初始化记忆
	 * @return
	 */
	public static void init() {
		Scope scope=(Scope) readObjectFromFile();
		ScopeStructure.setScope(scope);
	}
	/**
	 * scope存档
	 * @param scope
	 */
	public static void archive() {
		writeObjectToFile(ScopeStructure.getScope());
	}
	private static String fullPath = "scope.dat";

	private static void writeObjectToFile(Object obj) {
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

	private static Object readObjectFromFile() {
		Object temp = null;
		File file = new File(fullPath);
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objIn = new ObjectInputStream(in);
			temp = objIn.readObject();
			objIn.close();
			System.out.println("read object success!");
		} catch (IOException e) {
			System.out.println("read object failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
