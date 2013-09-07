package com.dolph.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;
import com.dolph.model.Company;
import com.dolph.model.Party;
import com.dolph.service.PartyService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.PartyTreeVO;
import com.opensymphony.xwork2.ModelDriven;

@Controller("partyAction")
@Scope("prototype")
@Res(name="组织机构操作",sn="party",orderNumber=1)
public class PartyAction extends BaseAction implements ModelDriven{

	protected PartyService partyService;

	
	protected Party model;
	@Override
	public Object getModel() {
		return null;
	}
	@Oper
	public String execute(){
		return "index";
	}
	
	public void tree(){
		Company c=partyService.findRootCompany();
		PartyTreeVO vo=new PartyTreeVO(c);
		JSONUtils.toJSON(vo);
	}
	@Oper
	public String updateInput(){
		model=partyService.findParty(model.getClass(),model.getId());		
		return "update_input";
	}
	@Oper
	public String update(){
		if(model.getParent().getId()==0){
			model.setParent(null);
		}
		partyService.update(model);
		return "success";
	}
	@Oper
	public String addInput(){
		int parentId=model.getParent().getId();
		if(parentId==0){
			throw new RuntimeException("未知父节点");
		}
		return "add_input";
	}
	
	@Oper
	public String add(){
		partyService.addParty(model);
		return "success";
	}
	@Oper
	public String del(){
		partyService.delete(model.getId());
		return "success";
	}
	
	
	@Resource
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}



}
