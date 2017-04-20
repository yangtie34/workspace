package com.chengyi.ai.core.memory;

import com.chengyi.ai.core.AI;

//yin:生命
//yin:今生
//   yin:身体（外设）
//	  	yin:actions
//	  	yang:gets
//	 yang:哲思因果（如同意识）
//	 	yin:()
//	 	yang:
//yang:前世（如同末那识）
//	 yin:
//	 yang:
//yang:阿赖耶识（以备超越多个生命的调度）
public class ScopeStructure {
	
	private static Scope scope;//天道
	/**
	 * 获取阿赖耶识
	 * @return
	 */
	public static Scope getGod() {
		return scope.getYang();
	}
	/**
	 * 获取某生的身体
	 * @param scope 某一生
	 * @return
	 */
	public static Scope getBody(Scope scope) {
		return scope.getYin();
	}
	/**
	 * 获取某生的意识
	 * @param scope 某一生
	 * @return
	 */
	public static Scope getAwareness(Scope scope) {
		return scope.getYang();
	}
	public static Scope getScope() {
		return scope;
	}
	public static void setScope(Scope scope) {
		if(scope!=null){
			ScopeStructure.scope = scope;
		}else{
			initScope();
		}
	}
	private static void initScope() {
		// TODO 初始化根Scope结构
	}
}
