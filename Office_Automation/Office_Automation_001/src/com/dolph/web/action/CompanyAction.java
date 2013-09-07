package com.dolph.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Company;
import com.dolph.service.PartyService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("companyAction")
@Scope("prototype")
public class CompanyAction extends PartyAction implements ModelDriven{
	
	
	public String company_Input(){	
		model=partyService.findRootCompany();
		return "company_input";
	}

	public String saveCompany(){
		partyService.saveorUpdateCompany((Company)model);
		return "success";
	}
	
	
	@Resource
	public void setPartyService(PartyService partyService) {
		this.partyService = partyService;
	}
	@Override
	public Object getModel() {
		if(model==null){
			model=new Company();
		}
		return model;
	}
}
