package com.chengyi.convolutionAI.core;

import java.util.HashMap;
import java.util.Map;

public class Scope {
	private Object O;//对象本事
	private Map<ScopeRelation, Scope> mapRelation=new HashMap<ScopeRelation, Scope>();
	public Scope(Object O) {
		this.setO(O);
	}
	public void creatRelation(Relation relation,Scope scope) {
		ScopeRelation scopeRelation=new ScopeRelation(relation);
		mapRelation.put(scopeRelation, scope);
	}
	public void creatRelation(int value,Scope scope) {
		ScopeRelation scopeRelation=new ScopeRelation(value);
		mapRelation.put(scopeRelation, scope);
	}
	public Object getO() {
		return O;
	}


	public void setO(Object o) {
		O = o;
	}
	public Map<ScopeRelation, Scope> getMapRelation() {
		return mapRelation;
	}


	public void setMapRelation(Map<ScopeRelation, Scope> mapRelation) {
		this.mapRelation = mapRelation;
	}


	class ScopeRelation{
		private Relation relation;
		private int value=0;
		public ScopeRelation(Relation relation) {
			this.setRelation(relation);
		}
		public ScopeRelation(int value) {
			this.setRelation(Relation.ID);
			this.setValue(value);
		}
		public Relation getRelation() {
			return relation;
		}
		public void setRelation(Relation relation) {
			this.relation = relation;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
}
