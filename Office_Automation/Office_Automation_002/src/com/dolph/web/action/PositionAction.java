package com.dolph.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Res;
import com.dolph.model.Position;
import com.opensymphony.xwork2.ModelDriven;
@Controller("positionAction")
@Scope("prototype")
@Res(name="岗位操作",sn="position",orderNumber=4,parentSn="party")
public class PositionAction extends PartyAction implements ModelDriven {
	@Override
	public Object getModel() {
		if(model==null){
			model=new Position();
		}
		return model;
	}
}
