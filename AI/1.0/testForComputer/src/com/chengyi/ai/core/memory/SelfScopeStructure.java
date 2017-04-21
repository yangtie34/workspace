package com.chengyi.ai.core.memory;


/**
 * 当前一生的数据
 * @author Administrator
 *
 */
public class SelfScopeStructure {
	
	public static Scope scope=ScopeStructure.getScope();//今生今世
	/**
	 *获取今生今世
	 * @return
	 */
	public static Scope getLife() {
		return scope;
	}
	/**
	 * 获取身体
	 * @return
	 */
	public static Scope getBody() {
		return scope.getYin();
	}
	/**
	 * 获取今生的思维
	 * @return
	 */
	public static Scope getThinking() {
		return scope.getYang();
	}
}
