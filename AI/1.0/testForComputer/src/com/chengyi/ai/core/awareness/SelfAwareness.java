package com.chengyi.ai.core.awareness;


import com.chengyi.ai.core.thinking.Think;

/**
 * 意识具有分别功能
 * @author Administrator
 *
 */
public class SelfAwareness {
	//思维
	private static Think think;
	/**
	 * 初始化意识
	 */
	public static void init() {
		think=Think.newInstance();
		// TODO 初始化意识
		
	}
	/**
	 * 运行
	 */
	public static void start() {
		// TODO 启动意识
	}
	/**
	 * 暂停意识
	 */
	public static void pause() {
		// TODO 暂停意识
	}
	/**
	 * 停止
	 */
	public static void destory() {
		// TODO 停止意识
	}

	
}
