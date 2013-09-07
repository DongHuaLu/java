package com.dolph.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.DAO.GroupDAO;
import com.dolph.model.Group;

@Repository("groupDAO")
public class GroupDAOImpl extends BaseDAO implements GroupDAO{

	@Override
	public List<Group> findAllGroup() {
	
		return (List<Group>)getSession().createQuery("from Group")
							.list();
	}

	@Override
	public void saveGroup(Group g) {
		getSession().save(g);
	}

}
