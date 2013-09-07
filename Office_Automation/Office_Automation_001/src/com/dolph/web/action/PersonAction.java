package com.dolph.web.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Person;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.PageVo;
import com.opensymphony.xwork2.ModelDriven;
@Controller("personAction")
@Scope("prototype")
public class PersonAction extends PartyAction implements ModelDriven {
	
	private String sSearch;

	@Override
	public Object getModel() {
		if(model==null){
			model=new Person();
		}
		return model;
	}
	
	public String execute(){
		return "person_list";
	}
	
	
	public void list(){
		int parentId=model.getId();
		PageVo vo=partyService.findPerson(parentId,sSearch);
		Map map=new HashMap();
		map.put("aaData", vo.getDatas());
		map.put("iTotalRecords", vo.getTotal());
		map.put("iTotalDisplayRecords", vo.getTotal());
		JSONUtils.toJSON(map);
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String sSearch) {
		this.sSearch = sSearch;
	}
}
