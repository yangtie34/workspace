package com.chengyi.ai.core;

import com.chengyi.ai.core.awareness.SelfAwareness;
import com.chengyi.ai.core.body.BodyPCI;
import com.chengyi.ai.core.memory.ScopeUtil;
/**
 * ai总入口
 * @author Administrator
 *
 */
public class AI {
	/**
	 * 系统开机
	 */
	public static void run() {
		System.out.println("初始化系统开始");
		init();
		System.out.println("初始化系统完成");
	}
	/**
	 * 初始化数据
	 */
	private static void init(){
		System.out.println("1.初始化scope数据开始");
		ScopeUtil.init();
		System.out.println("1.初始化scope数据完成");
		
		System.out.println("2.初始化身体开始");
		BodyPCI.init();
		System.out.println("2.初始化身体完成");

		System.out.println("3.初始化意识开始");
		SelfAwareness.init();
		System.out.println("3.初始化意识完成");
		
	}
	/**
	 * 系统暂停
	 */
	public static void pause() {
		System.out.println("1.暂停意识。。。");
		SelfAwareness.pause();
		System.out.println("1.暂停意识完成");
		
		System.out.println("2.暂停身体开始。。。");
		BodyPCI.pause();
		System.out.println("2.暂停身体完成");
	}
	/**
	 * 系统恢复运行
	 */
	public static void recover() {
		
		System.out.println("1.恢复身体开始。。。");
		BodyPCI.start();
		System.out.println("1.恢复身体完成");
		
		System.out.println("2.恢复意识。。。");
		SelfAwareness.start();
		System.out.println("2.恢复意识完成");
	}
	/**
	 * 系统关机
	 */
	public static void destroy () {
		System.err.println("停止意识。。。");
		SelfAwareness.destory();
		System.err.println("停止身体。。。");
		BodyPCI.destory();
		System.out.println("AI存档中。。。");
		ScopeUtil.archive();
		System.out.println("AI存档完成");
		System.err.println("退出系统！");
		System.exit(0); //退出系统
	}
}
