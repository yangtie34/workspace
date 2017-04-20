package com.chengyi.ai.core.body;

import com.chengyi.ai.core.memory.Scope;
import com.chengyi.ai.core.memory.SelfScopeStructure;

public class BodyPCI {
	public static Scope scope;
	/**
	 * 初始化身体数据并调用身体运行
	 */
	public static void init() {
		scope=SelfScopeStructure.getBody();
		// TODO  初始化身体数据
		start();
	}

	/**
	 * 启动身体运行
	 */
	public static void start() {
		// TODO 启动身体运行
		
	}
	/**
	 * 暂停身体运行
	 */
	public static void pause() {
		// TODO 暂停身体运行
		
	}
	/**
	 * 停止身体运行
	 */
	public static void destory() {
		// TODO 停止身体运行
		
	}
}
