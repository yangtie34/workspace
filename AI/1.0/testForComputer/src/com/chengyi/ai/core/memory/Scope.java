package com.chengyi.ai.core.memory;
/**
 * AI记忆
 * @author Administrator
 *
 */
public class Scope {
	private int id=0;
	private Scope pYin;
	private Scope pYang;
	private Scope yin;
	private Scope yang;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Scope getpYin() {
		return pYin;
	}
	public void setpYin(Scope pYin) {
		this.pYin = pYin;
	}
	public Scope getpYang() {
		return pYang;
	}
	public void setpYang(Scope pYang) {
		this.pYang = pYang;
	}
	public Scope getYin() {
		return yin;
	}
	public void setYin(Scope yin) {
		this.yin = yin;
	}
	public Scope getYang() {
		return yang;
	}
	public void setYang(Scope yang) {
		this.yang = yang;
	}
}
