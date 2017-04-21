package com.chengyi.ai.core.body;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengyi.ai.core.interfaces.Get;
import com.chengyi.ai.core.thinking.Think;
import com.chengyi.ai.util.ClassUtil;

@SuppressWarnings("rawtypes")
public class Gets {
	static Map<Integer, Get> gets=new HashMap<Integer, Get>();
	static Map<Integer, Thread> threads=new HashMap<Integer, Thread>();
	static Map<Integer, Get> dataListeners=new HashMap<Integer, Get>();
	static{
		List<Class> classes = ClassUtil.getAllClassByInterface(Get.class);
		for (Class clas : classes) {
			try {
				Get get;
				if(Think.class==clas){
					get=Think.newInstance();
				}else{
					get=(Get) clas.newInstance();
				}
				gets.put(get.getId(),get );
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
		for(int id:threads.keySet()){
			try {
				threads.get(id).wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 恢复获取信息
	 */
	public static void recover() {
		for(int id:threads.keySet()){
			threads.get(id).notify();
		}
	}
}
