package com.chengyi.ai.core.memory;


//scope:今生
//	 daoYin:前世（如同末那识）
//	 daoYang:阿赖耶识（以备超越多个生命的调度）
//yin:身体（外设）
// 	yin:actions
// 	yang:gets
//yang:哲思因果（如同意识）
//	yin:()
//	yang:
public class ScopeStructure {
	
	private static Scope scope;//天道
	/**
	 * 获取阿赖耶识
	 * @return
	 */
	public static Scope getGod() {
		return scope.getDaoYang();
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
