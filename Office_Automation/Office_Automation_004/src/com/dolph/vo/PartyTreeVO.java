package com.dolph.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dolph.model.Party;

public class PartyTreeVO {
	private String data;
	private Map attr =new HashMap();
	private List<PartyTreeVO> children=null;
	
	public PartyTreeVO(Party party){
		this.data=party.getName();
		this.attr.put("id",party.getId());
		this.attr.put("partyType", party.getClass().getSimpleName().toLowerCase());
		Set<Party> partys=party.getChilds();
		if( partys!=null && partys.size()>0){
			this.children=new ArrayList<PartyTreeVO>();
			for(Party p:partys){
				this.children.add(new PartyTreeVO(p));
			}
		}
	}
	
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Map getAttr() {
		return attr;
	}
	public void setAttr(Map attr) {
		this.attr = attr;
	}
	public List<PartyTreeVO> getChildren() {
		return children;
	}
	public void setChildren(List<PartyTreeVO> children) {
		this.children = children;
	}
	

}
