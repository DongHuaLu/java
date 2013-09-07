package com.dolph.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.model.Position;
import com.opensymphony.xwork2.ModelDriven;
@Controller("positionAction")
@Scope("prototype")
public class PositionAction extends PartyAction implements ModelDriven {
	@Override
	public Object getModel() {
		if(model==null){
			model=new Position();
		}
		return model;
	}
}
