package com.dolph.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Res;
import com.dolph.model.Department;
import com.opensymphony.xwork2.ModelDriven;
@Controller("departmentAction")
@Scope("prototype")
@Res(name="部门操作",sn="department",orderNumber=3,parentSn="party")
public class DepartmentAction extends PartyAction implements ModelDriven {

	@Override
	public Object getModel() {
		if(model==null){
			model=new Department();
		}
		return model;
	}
}
