package com.chengyi.ai.core.awareness;

import com.chengyi.ai.core.memory.Scope;
import com.chengyi.ai.core.memory.SelfScopeStructure;

public class SelfAwareness {

	public static Scope scope;
	
	/**
	 * 初始化意识数据并调用意识运行
	 */
	public static void init() {
		scope=SelfScopeStructure.getAwareness();
		// TODO 初始化意识数据
		start();
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
