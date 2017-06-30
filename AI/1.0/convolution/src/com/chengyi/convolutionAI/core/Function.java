package com.chengyi.convolutionAI.core;
/**
 * 基本的功能
 * 对象的输入与输出
 * @author Administrator
 *
 */
public class Function {
	private Scope inScope;//输入
	private Scope stateScope;//状态函数
	private Scope outScope;//输出
	public Scope getInScope() {
		return inScope;
	}
	public void setInScope(Scope inScope) {
		this.inScope = inScope;
	}
	public Scope getOutScope() {
		return outScope;
	}
	public void setOutScope(Scope outScope) {
		this.outScope = outScope;
	}
	public Scope getStateScope() {
		return stateScope;
	}
	public void setStateScope(Scope stateScope) {
		this.stateScope = stateScope;
	}
}
