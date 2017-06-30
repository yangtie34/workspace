package com.chengyi.convolutionAI.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Robot {
	private static List<Scope> scopes= new ArrayList<Scope>();//基础记忆
	private static Action action=new Action(null);//要做什么
	static{
		 Set<String> sets=Data.getSelfData();
		 Iterator<String> it=sets.iterator();
         while(it.hasNext()){
             Object o=it.next();
             scopes.add(new Scope(o));
             System.out.println(o);
         }
		
	}
	public void run(){//运行
		
	};
}
