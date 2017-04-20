package com.chengyi.ai.core.body;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengyi.ai.core.interfaces.Action;
import com.chengyi.ai.util.ClassUtil;

@SuppressWarnings("rawtypes")
public class Actions {
	private static Map<String, Action> map=new HashMap<String, Action>();
	
	static{
		List<Class> classes = ClassUtil.getAllClassByInterface(Action.class);
		for (Class clas : classes) {
			try {
				map.put(clas.getSimpleName(), (Action) clas.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
//	public static void doByName(String name,int i) {
//		map.get(name).action(i);
//	}
}
