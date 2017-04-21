package com.chengyi.ai.core.memory;
/**
 * AI存档数据
 * @author Administrator
 *
 */
public class Scope {
	private int id=0;
	private Scope daoYin;//形而上
	private Scope daoYang;
	private Scope parent;
	private Scope action;//做什么
	private Scope yin;//形而下
	private Scope yang;
	private int value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Scope getDaoYin() {
		return daoYin;
	}
	public void setDaoYin(Scope daoYin) {
		this.daoYin = daoYin;
	}
	public Scope getDaoYang() {
		return daoYang;
	}
	public void setDaoYang(Scope daoYang) {
		this.daoYang = daoYang;
	}
	public Scope getParent() {
		return parent;
	}
	public void setParent(Scope parent) {
		this.parent = parent;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Scope getAction() {
		return action;
	}
	public void setAction(Scope action) {
		this.action = action;
	}	
}
