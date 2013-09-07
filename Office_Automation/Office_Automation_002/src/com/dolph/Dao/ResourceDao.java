package com.dolph.Dao;

import com.dolph.model.ActionResource;

public interface ResourceDao extends BaseDao {

	ActionResource findActionResourceBySn(String sn);

}
