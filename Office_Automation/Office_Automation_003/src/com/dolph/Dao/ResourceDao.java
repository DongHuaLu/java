package com.dolph.Dao;

import java.util.List;

import com.dolph.model.ActionResource;
import com.dolph.vo.PageVo;

public interface ResourceDao extends BaseDao {

	ActionResource findActionResourceBySn(String sn);

	List<ActionResource> findRootActionResources();
	
	public void update(ActionResource ar);

	List<ActionResource> findAll();


}
