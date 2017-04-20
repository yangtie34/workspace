package com.chengyi.ai.core.body;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengyi.ai.core.interfaces.Get;
import com.chengyi.ai.util.ClassUtil;

@SuppressWarnings("rawtypes")
public class Gets {
	static Map<String, Get> gets=new HashMap<String, Get>();
	static Map<String, Thread> threads=new HashMap<String, Thread>();
	static Map<String, Get> dataListeners=new HashMap<String, Get>();
	static{
		List<Class> classes = ClassUtil.getAllClassByInterface(Get.class);
		for (Class clas : classes) {
			try {
				gets.put(clas.getSimpleName(), (Get) clas.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Get getGetByName(String name) {
		return gets.get(name);
	}
	/**
	 * 暂停获取信息
	 */
	public static void pause() {
		for(String str:threads.keySet()){
			try {
				threads.get(str).wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 恢复获取信息
	 */
	public static void recover() {
		for(String str:threads.keySet()){
			threads.get(str).notify();
		}
	}
}
