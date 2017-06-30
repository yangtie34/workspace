package com.chengyi.convolutionAI.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Data {
	public static Set<String> getSelfData() {//获取基础数据
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		str+="α β γ δ ε δ ε ζ η θ ι κ λ μ ν π ξ ζ ηψ ωΑΒΓΓΔΕΖΘΗΚ∧ΜΝΞΟ∏Ρ∑ΤΥΦΦΧ";
		str+="./,;'[]`/*-+!@#$%^&*()_+-={}:|<>?\"\\";
		str+="0123456789";
		Map<String,String> map=new HashMap<String,String>();
		int length=str.length();
		for(int i=0;i<length;i++){
			map.put(str.charAt(i)+"",null);	
		}
		return map.keySet();
	}
}
