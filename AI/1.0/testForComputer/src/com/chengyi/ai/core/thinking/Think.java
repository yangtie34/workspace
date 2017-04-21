package com.chengyi.ai.core.thinking;

import com.chengyi.ai.core.interfaces.Action;
import com.chengyi.ai.core.interfaces.DataListener;
import com.chengyi.ai.core.interfaces.Get;
import com.chengyi.ai.core.memory.Scope;
import com.chengyi.ai.core.memory.SelfScopeStructure;

/**
 * 想蕴 具有思考 模拟功能
 * @author Administrator
 *
 */
public class Think implements Get,Action{
	private static Think think =new Think();
	private Think() {}
	// 静态方法返回该类的实例
    public static Think newInstance() {  
        return think;  
    }  
	public static Scope scope;
	
	/**
	 * 初始化思维数据
	 */
	public static void init() {
		scope=SelfScopeStructure.getThinking();
		// TODO 初始化思维
	}
	
	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void setDataListener(DataListener<Integer> dataListner) {
		// TODO Auto-generated method stub
		
	}
	//TODO 如何思考

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}
