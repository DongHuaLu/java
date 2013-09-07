package com.dolph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.DAO.GroupDAO;
import com.dolph.model.Group;
import com.dolph.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	private GroupDAO groupDAO;
	@Resource(name="groupDAO")
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	@Override
	public List<Group> findAllGroup() {
		return groupDAO.findAllGroup();
	}
	@Override
	public void add(Group g) {
		groupDAO.saveGroup(g);
	}
	
	

}
