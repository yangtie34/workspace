package com.chengyi.convolutionAI.core;
/**
 * 要做什么
 * @author Administrator
 *
 */
public class Action {
	private static Action thisAction;//当前目标
	private Action parentAction;//父级目标
	private Action nextAction;//前置目标
	private Function function=new Function();
	public Action(Action parentAction) {
		this.parentAction=parentAction;
		parentAction.nextAction=this;
		Action.thisAction=this;
	}
	public Scope doing() {
		
		return null;
	}
}
