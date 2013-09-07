package com.dolph.service;

import java.util.List;

import com.dolph.model.ActionMethodOper;
import com.dolph.model.ActionResource;
import com.dolph.vo.PageVo;

public interface ResourceService {

	public void rebuildActionResource();
	public void addActionResource(ActionResource actionResource);
	/**
	 * 查找顶级ActionResource
	 */
	public List<ActionResource> findRootActionResources();
	public ActionResource findActionResourceById(int id);
	public void update(ActionResource actionResource);
	public void delete(int actionResourceId);
	/**
	 *添加ActionResourceOper 
	 */
	public void addActionResourceOper(int id, ActionMethodOper amoper);
	public void deleteActionResourceOper(int id, String operSn);
	public List<ActionResource> findAllActionResources();
	public ActionResource findActionResourceByClassName(String className);

}
