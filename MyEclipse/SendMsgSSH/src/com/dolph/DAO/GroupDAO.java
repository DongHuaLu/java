package com.dolph.DAO;

import java.util.List;

import com.dolph.model.Group;

public interface GroupDAO {
	/**
	 * 返回所有组
	 * @return
	 */
	public List<Group> findAllGroup();
	public void saveGroup(Group g);

}
