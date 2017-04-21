package com.chengyi.ai.core.body;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengyi.ai.core.interfaces.Action;
import com.chengyi.ai.core.thinking.Think;
import com.chengyi.ai.util.ClassUtil;

@SuppressWarnings("rawtypes")
public class Actions {
	private static Map<Integer, Action> map=new HashMap<Integer, Action>();
	
	static{
		List<Class> classes = ClassUtil.getAllClassByInterface(Action.class);
		for (Class clas : classes) {
			try {
				Action action;
				if(Think.class==clas){
					action=Think.newInstance();
				}else{
					action=(Action) clas.newInstance();
				}
				map.put(action.getId(), (Action) clas.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
//	public static void doByName(String name,int i) {
//		map.get(name).action(i);
//	}
}
