package com.chengyi.ai.core.difference;
/**
 * 分别心
 * @author Administrator
 *
 */
public class Difference {
	public static int aTob(int a,int b) {
		int result=a-b;
		return result>0?1:result==0?0:-1;
	}
}
