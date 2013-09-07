package com.dolph.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dolph.annotations.Oper;
import com.dolph.annotations.Res;
import com.dolph.model.ActionMethodOper;
import com.dolph.model.ActionResource;
import com.dolph.service.ResourceService;
import com.dolph.utils.JSONUtils;
import com.dolph.vo.ActionResourceTreeVO;
import com.dolph.vo.PageVo;
import com.opensymphony.xwork2.ModelDriven;

@Controller("resourceAction")
@Scope("prototype")
@Res(name="资源操作",sn="resource",orderNumber=64,parentSn="security")
public class ResourceAction implements ModelDriven{

	protected ResourceService resourceService;

	//操作的属性
	private String operSn;
	private int operIndex;
	private String methodName;
	private String operName;
	
	protected ActionResource model;
	@Override
	public Object getModel() {
		if(model==null){
			model=new ActionResource();
		}
		return model;
	}
	@Oper
	public String execute(){
		return "index";
	}
	
	public void tree(){
		List<ActionResource> resources=resourceService.findRootActionResources();
		List<ActionResourceTreeVO> vos=new ArrayList<ActionResourceTreeVO>();
		for(ActionResource a:resources){
			ActionResourceTreeVO vo=new ActionResourceTreeVO(a);
			vos.add(vo);
		}		
		JSONUtils.toJSON(vos);
	}
	@Oper
	public String updateInput(){
		model=resourceService.findActionResourceById(model.getId());		
		return "update_input";
	}
	@Oper
	public String update(){
		if(model.getParent().getId()==0){
			model.setParent(null);
		}
		resourceService.update(model);
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
		resourceService.addActionResource(model);
		return "success";
	}
	@Oper
	public String del(){
		resourceService.delete(model.getId());
		return "success";
	}
	
	public String addOperInput(){
		return "add_oper_input";
	}
	
	public String addOper(){
		ActionMethodOper amoper=new ActionMethodOper();
		amoper.setMethodName(methodName);
		amoper.setOperIndex(operIndex);
		amoper.setOperName(operName);
		amoper.setOperSn(operSn);
		resourceService.addActionResourceOper(model.getId(),amoper);
		return "success";
	}
	
	public void delOper(){
		resourceService.deleteActionResourceOper(model.getId(),operSn);
	}
	
	
	@Resource
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	public String getOperSn() {
		return operSn;
	}
	public void setOperSn(String operSn) {
		this.operSn = operSn;
	}
	public int getOperIndex() {
		return operIndex;
	}
	public void setOperIndex(int operIndex) {
		this.operIndex = operIndex;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	

}
