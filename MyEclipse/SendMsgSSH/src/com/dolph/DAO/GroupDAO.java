package com.dolph.DAO;

import java.util.List;

import com.dolph.model.Group;

public interface GroupDAO {
	/**
	 * ����������
	 * @return
	 */
	public List<Group> findAllGroup();
	public void saveGroup(Group g);

}
